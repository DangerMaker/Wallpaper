package com.lyjq.wallpaper.ui.screens.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.support.v4.toast
import android.webkit.WebView
import com.lyjq.wallpaper.R
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener




/**
 * Created by liuxiaoyu on 2017/5/24.
 */
class WebViewFragment : Fragment() {

    lateinit var webView: WebView
    lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_webview, container, false)

        swipeRefresh = rootView.findViewById(R.id.swipe_contain) as SwipeRefreshLayout
        swipeRefresh.setOnRefreshListener{ webView.loadUrl(webView.url)}

        //首次启动刷新页面
        swipeRefresh.post(Runnable {
            swipeRefresh.isRefreshing = true
            webView.loadUrl(webView.getUrl())
        })

        //WebView
        webView = rootView.findViewById(R.id.web_show) as WebView
        webView.loadUrl("http://m.55156.com/")
        //添加javaScript支持
        webView.settings.javaScriptEnabled = true
        //取消滚动条
        webView.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        //触摸焦点起作用
        webView.requestFocus()
        //点击链接继续在当前browser中响应
        webView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        })

        //设置进度条
        webView.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                if (newProgress == 100) {
                    //隐藏进度条
                    swipeRefresh.isRefreshing = false
                } else if (!swipeRefresh.isRefreshing) {
                    swipeRefresh.isRefreshing = true
                }
            }
        })

        return rootView
    }
}