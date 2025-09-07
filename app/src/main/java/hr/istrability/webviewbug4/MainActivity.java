package hr.istrability.webviewbug4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate rafa");
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true); // false for edge-to-edge

        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webView);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadData(
            "<html style=\"background: yellow; position: fixed; max-height: 200px;\">" +
                "<body style=\"margin: 0; position: absolute; background: red; top: env(safe-area-inset-top); bottom: env(safe-area-inset-bottom);\">" +
                "Hello" +
                "<input type=\"text\" />" +
                "</body></html>",
            "text/html",
            "UTF-8"
        );


    /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      // Get the insets specifically for the IME (Input Method Editor - keyboard)
      Insets imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime());

      // Get the insets for the system bars (status bar + navigation bar)
      Insets systemBarInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());

      // Check if the IME (keyboard) is currently visible
      boolean isImeVisible = insets.isVisible(WindowInsetsCompat.Type.ime());

      System.out.println(systemBarInsets.left + " " + systemBarInsets.top + " " + systemBarInsets.right + " " + systemBarInsets.bottom + " " + imeInsets.bottom);
      v.setPadding(systemBarInsets.left, systemBarInsets.top, systemBarInsets.right, imeInsets.bottom);
      return insets;
    });*/
    }
}