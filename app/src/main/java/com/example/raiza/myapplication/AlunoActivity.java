package com.example.raiza.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlunoActivity extends AppCompatActivity {

    private EditText edtNome, edtMatricula;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        edtNome = (EditText)findViewById(R.id.edt_aluno_nome);
        edtMatricula = (EditText)findViewById(R.id.edt_aluno_matricula);
        btnOk = (Button)findViewById(R.id.btn_aluno_ok);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultado = new Intent();
                resultado.putExtra(MainActivity.ALUNO_NOME, edtNome.getText().toString());
                resultado.putExtra(MainActivity.ALUNO_MATRICULA, edtMatricula.getText().toString());
                setResult(Activity.RESULT_OK, resultado);
                finish();
            }
        });
    }
}
