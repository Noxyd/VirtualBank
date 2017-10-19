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

        final Button btn_inscription_valider = (Button) findViewById(R.id.id_btn_inscription_valider);


        btn_inscription_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                Intent intent = new Intent(Inscription.this, connexion.class);
                startActivity(intent);
            }
        });
    }


}
