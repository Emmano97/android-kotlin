package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView;

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val  webView = WebView(this)

        webView.settings.javaScriptEnabled = true

        setContentView(webView)

        webView.loadUrl("https://flutter.dev/")
    }
}