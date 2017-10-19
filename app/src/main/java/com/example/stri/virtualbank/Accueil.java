package com.example.stri.virtualbank;

/**
 * Created by Samuel on 13/10/2017.
 * Modified by Alexis on 18/10/2017
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accueil extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        // -    to remove   -
        //  -   BEGIN     -
        final Button btn_rlv = (Button) findViewById(R.id.id_btn_releve_bancaire);

        btn_rlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Accueil.this, ReleveBancaire.class);
                startActivity(intent);
            }
        });

        // -    END    -
    }
}
