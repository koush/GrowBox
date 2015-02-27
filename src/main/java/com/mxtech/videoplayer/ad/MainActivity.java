package com.mxtech.videoplayer.ad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {
    public static final java.lang.String EXTRA_ITEM_HTTP_HEADERS = "android.media.intent.extra.HTTP_HEADERS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null && getIntent().getData() != null) {
            Intent intent = getIntent();
            intent.setComponent(null);
            intent.setPackage(null);
            String[] headers = intent.getStringArrayExtra("headers");
            if (headers != null) {
                Bundle bundle = new Bundle();
                for (int i = 0; i < headers.length / 2; i++) {
                    String header = headers[i];
                    String value = headers[i + 1];
                    bundle.putString(header, value);
                }
                intent.putExtra(EXTRA_ITEM_HTTP_HEADERS, bundle);
            }
            startActivity(intent);
            finish();
        }
    }
}
