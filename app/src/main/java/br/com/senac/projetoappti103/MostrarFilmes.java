package br.com.senac.projetoappti103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostrarFilmes extends AppCompatActivity {


    //Declarando as variáveis

    ImageView imgFilmes;
    TextView txtTitulo, txtAno, txtClassificacao, txtNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_filmes_layout);

        imgFilmes = findViewById(R.id.imgMostrarFilmes);
        txtTitulo = findViewById(R.id.txtTituloMostrarFilmes);
        txtAno = findViewById(R.id.txtAnoMostrarFilmes);
        txtClassificacao = findViewById(R.id.txtMostrarClassificacaoFilmes);
        txtNota = findViewById(R.id.txtMostrarNotas);

        Intent intent = getIntent();

        String titulo = intent.getStringExtra("titulo");
        String ano = intent.getStringExtra("ano");
        String classificacao = intent.getStringExtra("classificacao");
        String nota = intent.getStringExtra("nota");
        int imagem = intent.getIntExtra("ImagemFilme", 0);

        txtTitulo.setText(titulo);
        txtAno.setText(ano);
        txtClassificacao.setText(classificacao);
        txtNota.setText(nota);
        imgFilmes.setImageResource(imagem);
    }
}