package com.example.qrreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int BARCODE_READER_ACTIVITY_REQUEST = 1208;
    Button qrCode;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrCode = findViewById(R.id.QrCode);
        result = findViewById(R.id.Result);

        ((View) qrCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = new Intent(MainActivity.this, QrCodeScannerActivity.class);
                startActivityForResult(launchIntent, BARCODE_READER_ACTIVITY_REQUEST);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == this.RESULT_OK && null != data) {
            switch (requestCode) {

                case BARCODE_READER_ACTIVITY_REQUEST: {
                    result.setText(data.getStringExtra("SCANNER_RESULT"));
                }
                break;

            }

        }

    }
}
