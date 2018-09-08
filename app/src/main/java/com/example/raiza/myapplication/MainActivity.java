package com.example.raiza.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String PESSOA_NOME = "nome";
    private static final int REQUEST_SIAPE = 1;
    public static final String PROF_SIAPE = "siape";
    private Button btnProfessor;
    private EditText edtNome;
    private TextView txtMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMensagem = (TextView)findViewById(R.id.txt_mensagem);
        edtNome = (EditText) findViewById(R.id.edt_nome);

        btnProfessor = findViewById(R.id.btn_professor);
        btnProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlunoActivity.class);
                intent.putExtra(PESSOA_NOME, edtNome.getText().toString());
                startActivityForResult(intent, MainActivity.REQUEST_SIAPE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MainActivity.REQUEST_SIAPE && resultCode == Activity.RESULT_OK && data != null) {
            Bundle bundleResultado = data.getExtras();
            String siape = bundleResultado.getString(MainActivity.PROF_SIAPE);
            txtMensagem.setText("Olá professor de SIAPE: " + siape);
        }
    }
}
