package com.example.stri.virtualbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Connexion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_connexion);

        final Button btn_connect = (Button) findViewById(R.id.id_btn_connect);
        final Button btn_inscription = (Button) findViewById(R.id.id_btn_inscription);


        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO Ajouter les contrôles de compte

                Intent intent = new Intent(Connexion.this, Accueil.class);
                startActivity(intent);
            }
        });

        btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO Ajouter les contrôles de compte

                Intent intent = new Intent(Connexion.this, Inscription.class);
                startActivity(intent);
            }
        });
    }


}
