package es.joseljg.relojesmundiales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import es.joseljg.relojesmundiales.clases.HiloReloj;

public class MainActivity extends AppCompatActivity {

    private TextView txt_reloj_madrid;
    private TextView txt_reloj_tokio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_reloj_madrid = (TextView) findViewById(R.id.txt_reloj_madrid);
        ThreadGroup tg = new ThreadGroup("relojes");
          HiloReloj h1 = new HiloReloj(this,txt_reloj_madrid, tg, "reloj_madrid", 5, "Europe/Madrid");
          h1.getHilo().start();
        txt_reloj_tokio = (TextView) findViewById(R.id.txt_reloj_tokio);
        HiloReloj h2 = new HiloReloj(this,txt_reloj_tokio, tg, "reloj_tokio", 5, "Asia/Tokyo");
        h2.getHilo().start();

    }
}