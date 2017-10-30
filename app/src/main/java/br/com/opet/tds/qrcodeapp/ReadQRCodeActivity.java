package br.com.opet.tds.qrcodeapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class ReadQRCodeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_qrcode);

        if(getIntent().hasExtra("RESULTADO")){
            TextView textResult = (TextView) findViewById(R.id.textResult);
            textResult.setText(getIntent().getStringExtra("RESULTADO"));
        }
    }

}
