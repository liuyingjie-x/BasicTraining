package com.example.retrofit

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class WebViewActivity : AppCompatActivity() {
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        initView()
    }

    fun initView() {
        webView = findViewById(R.id.webview)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true; //支持通过JS打开新窗口

        webView.settings
        webView.loadUrl("https://testadmin.yinsfinance.com:5880/app/h5/#/InformationDetails?articleId=103537&ip=123.12.12.1&longitude=120.153576&latitude=30.287459")

        webView.webChromeClient = WebChromeClient()



    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (webView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {//点击返回按钮的时候判断有没有上一页
//            webView.goBack(); // goBack()表示返回webView的上一页面
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
        if (event!!.keyCode === KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                //获取webView的浏览记录
                val mWebBackForwardList = webView.copyBackForwardList()
                //这里的判断是为了让页面在有上一个页面的情况下，跳转到上一个html页面，而不是退出当前activity
                if (mWebBackForwardList.currentIndex > 0) {
                    val historyUrl =
                        mWebBackForwardList.getItemAtIndex(mWebBackForwardList.currentIndex - 1).url
                    if (historyUrl != webView.url) {
                        webView.goBack()
                        return true
                    }
                }
            } else {
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}