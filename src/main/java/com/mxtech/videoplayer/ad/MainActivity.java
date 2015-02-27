package com.mxtech.videoplayer.ad;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null && getIntent().getData() != null) {
            getIntent().setComponent(null);
            getIntent().setPackage(null);
            startActivity(getIntent());
            finish();
        }
    }
}
