package com.example.raiza.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExternoActivity extends AppCompatActivity {

    private EditText edtNome, edtEmail;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externo);

        edtNome = (EditText)findViewById(R.id.edt_externo_nome);
        edtEmail = (EditText)findViewById(R.id.edt_externo_email);
        btnOk = (Button)findViewById(R.id.btn_externo_ok);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultado = new Intent();
                resultado.putExtra(MainActivity.EXTERNO_NOME, edtNome.getText().toString());
                resultado.putExtra(MainActivity.EXTERNO_EMAIL, edtEmail.getText().toString());
                setResult(Activity.RESULT_OK, resultado);
                finish();
            }
        });
    }
}
