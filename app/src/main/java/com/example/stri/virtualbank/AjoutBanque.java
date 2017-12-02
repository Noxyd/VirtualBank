package com.example.stri.virtualbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AjoutBanque extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //add content of the page
        setContentView(R.layout.activity_ajoutbanque);

        //vars
        Spinner banques         = (Spinner) findViewById(R.id.ab_banques);
        EditText idUtilisateur  = (EditText) findViewById(R.id.ab_idutilisateur);
        EditText mdpUtilisateur = (EditText) findViewById(R.id.ab_mdputilisateur);
        Button btnListeCompte   = (Button) findViewById(R.id.ab_valider);

        //Récupération de la ressource stockée dans avail_banque.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.avail_banque, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //Ajout de cette ressource dans le spinner
        banques.setAdapter(adapter);

        btnListeCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AjoutBanque.this, ListeCompte.class);
                startActivity(intent);
            }
        });


    }
}
