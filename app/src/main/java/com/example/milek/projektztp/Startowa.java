package com.example.milek.projektztp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Startowa extends AppCompatActivity {

    private ImageView mLogo;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startowa);

        mLogo = (ImageView) findViewById(R.id.imageView12);
        layout = (RelativeLayout) findViewById(R.id.activity_start);
        addListenerOnButtonStart();
    }

    public void addListenerOnButtonStart() {
        final Context context = this;
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
