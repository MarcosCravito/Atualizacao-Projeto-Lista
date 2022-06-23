package br.com.senac.projetoappti103;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaração das variáveis globais


    ListView lstFilmes;

    //Criando os dados para a lista

    String titulo[] = {
            "The Contractor",
            "Wrath Of Man",
            "Moonfall",
            "Shrek 2",
            "Ghostbuster: Afterlife",
            "Jumanji",
            "Shrek",
            "Spider-Man: Far From Home",
            "Joker",
            "Me Before You"
    };

    String ano[] = {
            "2022",
            "2021",
            "2022",
            "2016",
            "2004",
            "2021",
            "2020",
            "2001",
            "2019",
            "2016",
    };

    String classificacao[] = {
            "18 anos ou mais",
            "18 anos ou mais",
            "13 anos ou mais",
            "7 anos ou mais",
            "13 anos ou mais",
            "13 anos ou mais",
            "7 anos ou mais",
            "13 anos ou mais",
            "18 anos ou mais",
            "13 anos ou mais",
    };

    int imgFilmes[] = {
            R.drawable.contractor,
            R.drawable.man,
            R.drawable.moonfall,
            R.drawable.shrekdois,
            R.drawable.ghost,
            R.drawable.jumanji,
            R.drawable.shrek,
            R.drawable.spider,
            R.drawable.joker,
            R.drawable.me};

    String notas[] = {
            "12",
            "846",
            "420",
            "754",
            "1.527",
            "845",
            "9.237",
            "1.527",
            "43",
            "18.834",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstFilmes = findViewById(R.id.ListaFilmes);

        MyAdapter adapter = new MyAdapter();

        lstFilmes.setAdapter(adapter);

        lstFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Abrindo outra janela e passando os valores
                Intent intent = new Intent(getApplicationContext(), MostrarFilmes.class);

                intent.putExtra("titulo", titulo[position]);
                intent.putExtra("ano", ano[position]);
                intent.putExtra("classificacao", classificacao[position]);
                intent.putExtra("notas", notas[position]);
                intent.putExtra("imagemFilme", imgFilmes[position]);

                startActivity(intent);
            }
        });
    }
    //criando uma classe interna inner class

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgFilmes.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //Criando as viáveis globais para os componentes.

            ImageView imageMovies;
            TextView txtTitulo, txtAno, txtClassificados, txtNotas;

            //Instânciando e carregando o modelo ao adaptador

            View view1 = getLayoutInflater().inflate(R.layout.modelos_filmes, null);

            txtTitulo = view1.findViewById(R.id.txtModeloTitulo);
            txtAno = view1.findViewById(R.id.txtModeloAno);
            txtClassificados = view1.findViewById(R.id.txtModeloClassificacao);
            txtNotas = view1.findViewById(R.id.txtModeloNotas);
            imageMovies = view1.findViewById(R.id.imgModeloFilme);

            //Passando os valores para os componentes do modelo
            txtTitulo.setText(titulo[position]);
            txtAno.setText(ano[position]);
            txtClassificados.setText(classificacao[position]);
            txtNotas.setText(notas[position]);

            imageMovies.setImageResource(imgFilmes[position]);

            return view1;
        }
    }
}

