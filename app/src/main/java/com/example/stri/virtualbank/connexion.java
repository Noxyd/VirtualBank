package com.example.stri.virtualbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class connexion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_connexion);

        //récupération des boutons de connexion et d'inscription
        final Button btn_connect = (Button) findViewById(R.id.id_btn_connect);
        final Button btn_inscription = (Button) findViewById(R.id.id_btn_inscription);


        //si l'utilisateur appuie sur 'connexion' :
        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //var accueillant les valeurs correctes à entrer
                String mail = new String();
                String mdp = new String();

                // -> variables stockées en dur car aucun serveur existant
                mail = "mymail@mailbox.com";
                mdp = "mypassword";

                //récupération des edittexts utilisés par l'utilisateur pour les ids
                EditText champ_mail = (EditText) findViewById(R.id.id_text_mail);
                EditText champ_mdp = (EditText) findViewById(R.id.id_text_mdp);

                //récupération et comparaison avec les valeurs inscrites en dur.
                if (mail.compareTo(champ_mail.getText().toString()) == 0 && mdp.compareTo(champ_mdp.getText().toString()) == 0) {
                    Intent intent = new Intent(connexion.this, Accueil.class);
                    startActivity(intent);
                }
            }
        });

        //si l'utilisateur appuie sur 'inscription' :
        btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //redirection vers la page d'inscription
                //TODO Ajouter les contrôles de compte
                Intent intent = new Intent(connexion.this, Inscription.class);
                startActivity(intent);
            }
        });
    }


}
