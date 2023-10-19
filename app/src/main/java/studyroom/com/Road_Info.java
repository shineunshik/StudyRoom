package studyroom.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Road_Info extends AppCompatActivity {

    WebView homepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_info);

        homepage=(WebView)findViewById(R.id.homepage);
        WebSettings mWebSettings;
        mWebSettings = homepage.getSettings(); //세부 세팅 등록
        mWebSettings.setSupportMultipleWindows(true); // 새창 띄우기 허용 여부
        mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        homepage.setWebViewClient(new WebViewClient());
        homepage.setWebChromeClient(new WebChromeClient());
        homepage.loadUrl(getIntent().getStringExtra("url"));


    }
}