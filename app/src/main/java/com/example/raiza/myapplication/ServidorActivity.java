package com.example.raiza.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ServidorActivity extends AppCompatActivity {

    private EditText edtNome, edtSiape;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servidor);

        edtNome = (EditText)findViewById(R.id.edt_servidor_nome);
        edtSiape = (EditText)findViewById(R.id.edt_servidor_siape);
        btnOk = (Button)findViewById(R.id.btn_servidor_ok);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultado = new Intent();
                resultado.putExtra(MainActivity.SERVIDOR_NOME, edtNome.getText().toString());
                resultado.putExtra(MainActivity.SERVIDOR_SIAPE, edtSiape.getText().toString());
                setResult(Activity.RESULT_OK, resultado);
                finish();
            }
        });
    }
}
