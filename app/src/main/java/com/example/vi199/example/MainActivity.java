package com.example.vi199.example;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    EditText editText;
    ImageButton imageButton;
    GifData data;
    private final String API_KEY = "qbbn9xmSHvbUYaH2L6JnndaAvDZpcwqP";
    private Call<GifData> request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request = Controller.getTrendingApi().getModel(API_KEY);

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        editText = (EditText) findViewById(R.id.edit_text);
        imageButton = (ImageButton) findViewById(R.id.image_button);
        imageButton.setOnClickListener(this);
        onRequest();
    }

    public void onRequest() {

        final Context context = this;

        request.enqueue(new Callback<GifData>() {
            @Override
            public void onResponse(Call<GifData> call, Response<GifData> response) {
                data = response.body();

                InputStream stream = null;
                try {
                    stream = getAssets().open("");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                PostsAdapter adapter = new PostsAdapter(data, context, stream);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GifData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

}

    @Override
    public void onClick(View view) {
        if(!editText.getText().toString().isEmpty()){
            request = Controller.getSearchApi().getModel(editText.getText().toString(),API_KEY);
            onRequest();
        }
        else {
            request = Controller.getTrendingApi().getModel(API_KEY);
            onRequest();
        }
    }
}
