package com.ollie.ratbuilder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvCode = findViewById(R.id.tvCode);
        Button btnGenerate = findViewById(R.id.btnGenerate);
        Button btnScan = findViewById(R.id.btnScan);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int code = 100000 + r.nextInt(900000);
                tvCode.setText(String.valueOf(code));
            }
        });
    }
}
