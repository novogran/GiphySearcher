package com.example.vi199.example;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.InputStream;


class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private final Context context;
    private final InputStream stream;
    private GifData data;

    PostsAdapter(GifData data, Context context, InputStream stream) {
        this.data = data;
        this.context = context;
        this.stream = stream;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Data poster = data.getData().get(position);
        holder.webView.loadUrl("https://i.giphy.com/"
                + Parser.getGif(poster.getImages().getFixedHeightDownsampled().getWebp()) + ".gif");
        holder.webView.setWebViewClient(new MyWebViewClient());
        holder.webView.getSettings().setJavaScriptEnabled(true);
        GifWebView view = new GifWebView(context, stream);
        holder.webView.addView(view);
    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        return data.getPagination().getCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private WebView webView;

        ViewHolder(View itemView) {
            super(itemView);
            webView = itemView.findViewById(R.id.postitem_post);

        }
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
