package com.example.raiza.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ALUNO = 1;
    public static final String ALUNO_NOME = "nome aluno";
    public static final String ALUNO_MATRICULA = "matricula aluno";
    private static final int REQUEST_SERVIDOR = 2;
    public static String SERVIDOR_NOME = "nome servidor";
    public static final String SERVIDOR_SIAPE = "siape servidor";
    private static final int REQUEST_EXTERNO = 3;
    public static final String EXTERNO_NOME = "nome externo";
    public static final String EXTERNO_EMAIL = "email externo";
    private TextView txtMensagem;
    private Button btnAluno, btnServidor, btnExterno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMensagem = (TextView)findViewById(R.id.txt_mensagem);

        btnAluno = findViewById(R.id.btn_aluno);
        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlunoActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_ALUNO);
            }
        });

        btnServidor = findViewById(R.id.btn_servidor);
        btnServidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServidorActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_SERVIDOR);
            }
        });

        btnExterno = findViewById(R.id.btn_externo);
        btnExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExternoActivity.class);
                startActivityForResult(intent, MainActivity.REQUEST_EXTERNO);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MainActivity.REQUEST_ALUNO && resultCode == Activity.RESULT_OK && data != null) {
            Bundle bundleResultado = data.getExtras();
            String nome = bundleResultado.getString(MainActivity.ALUNO_NOME);
            String matricula = bundleResultado.getString(MainActivity.ALUNO_MATRICULA);
            txtMensagem.setText("Olá " + nome + " de matrícula: " + matricula);
        }

        else if(requestCode == MainActivity.REQUEST_SERVIDOR && resultCode == Activity.RESULT_OK && data != null) {
            Bundle bundleResultado = data.getExtras();
            String nome = bundleResultado.getString(MainActivity.SERVIDOR_NOME);
            String siape = bundleResultado.getString(MainActivity.SERVIDOR_SIAPE);
            txtMensagem.setText("Olá " + nome + " de siape: " + siape);
        }

        else if(requestCode == MainActivity.REQUEST_EXTERNO && resultCode == Activity.RESULT_OK && data != null) {
            Bundle bundleResultado = data.getExtras();
            String nome = bundleResultado.getString(MainActivity.EXTERNO_NOME);
            String email = bundleResultado.getString(MainActivity.EXTERNO_EMAIL);
            txtMensagem.setText("Olá " + nome + " de e-mail: " + email);
        }

    }





}
