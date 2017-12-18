package com.example.stri.virtualbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        getSupportActionBar().hide();

        //récupération du bouton valider
        final Button btn_inscription_valider = (Button) findViewById(R.id.id_btn_inscription_valider);

        //si l'utilisateur appuie sur 'valider' :
        btn_inscription_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                //redirection vers la page connexion
                Intent intent = new Intent(Inscription.this, connexion.class);
                startActivity(intent);
            }
        });

        //Pas de traitement supplémentaire car cette version ne supporte pas l'inscription utilisateur.
    }


}
