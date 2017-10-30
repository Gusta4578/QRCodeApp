package br.com.opet.tds.qrcodeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirIntent(View v){
        switch (v.getId()){
            case R.id.btnGerarCodigo:
                gerarIntent(GenerateQRCodeActivity.class);
                break;
            case R.id.btnLerCodigo:
                new IntentIntegrator(this).initiateScan();
                break;
        }
    }

    private void gerarIntent(Class classe){
        Intent novaTela = new Intent(MainActivity.this,classe);
        startActivity(novaTela);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("MainActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("MainActivity", "Scanned");
                Intent novaTela = new Intent(MainActivity.this,ReadQRCodeActivity.class);
                novaTela.putExtra("RESULTADO", result.getContents());
                startActivity(novaTela);
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
