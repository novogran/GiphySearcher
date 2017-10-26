package com.example.vi199.gifsearcher;

class Parser {
    static String getGif(String gifurl){
        String[] arr = gifurl.split("/");
        return arr[4];}
}
