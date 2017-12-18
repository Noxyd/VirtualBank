package com.example.stri.virtualbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ReleveBancaire extends AppCompatActivity {

    //Liste de dépenses pour simuler l'utilisateur de l'application
    String tableauDepense[] = {"LIDL", "IrishPub", "SkiLocation", "ToTale", "truc", "Muche", "Gaumont", "Micromania", "IrishPub", "SkiLocation", "ToTale", "truc", "Muche", "Gaumont", "Micromania", "IrishPub", "SkiLocation", "ToTale", "truc", "Muche", "Gaumont", "Micromania", "IrishPub", "SkiLocation", "ToTale", "truc", "Muche", "Gaumont", "Micromania"};
    double tableauMontant[] = {40.50, 38., 41., 48., 1.50, 140., 7., 25.99, 38., 41., 48., 1.50, 140., 7., 25.99, 38., 41., 48., 1.50, 140., 7., 25.99, 38., 41., 48., 1.50, 140., 7., 25.99};
    String tableauDate[] = {"12/06/17", "11/05/17", "01/05/17", "04/04/17", "13/03/17", "12/03/17", "11/03/17", "10/03/17", "11/05/17", "01/05/17", "04/04/17", "13/03/17", "12/03/17", "11/03/17", "10/03/17", "11/05/17", "01/05/17", "04/04/17", "13/03/17", "12/03/17", "11/03/17", "10/03/17", "11/05/17", "01/05/17", "04/04/17", "13/03/17", "12/03/17", "11/03/17", "10/03/17"};
    String tableauCategorie[] = {"Nourriture", "Loisirs", "Sports", "Voiture", "TrucMuche", "TrucMuche", "Loisirs", "Loisirs", "Loisirs", "Sports", "Voiture", "TrucMuche", "TrucMuche", "Loisirs", "Loisirs", "Loisirs", "Sports", "Voiture", "TrucMuche", "TrucMuche", "Loisirs", "Loisirs", "Loisirs", "Sports", "Voiture", "TrucMuche", "TrucMuche", "Loisirs", "Loisirs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_releve_bancaire);

        //récupérer les 4 colonnes
        TextView txcol1 = (TextView) findViewById(R.id.col1TextView);
        TextView txcol2 = (TextView) findViewById(R.id.col2TextView);
        TextView txcol3 = (TextView) findViewById(R.id.col3TextView);
        TextView txcol4 = (TextView) findViewById(R.id.col4TextView);

        //ajouter les valeurs des variables tests à l'affichage
        for(int i = 0; i < tableauDepense.length; i++){
            txcol1.setText(txcol1.getText() + tableauDepense[i] + "\n");
            txcol2.setText(txcol2.getText() + String.valueOf(tableauMontant[i]) + "\n");
            txcol3.setText(txcol3.getText() + tableauDate[i] + "\n");
            txcol4.setText(txcol4.getText() + tableauCategorie[i] + "\n");
        }

        //récupération & attribution d'actions de redirection aux boutons
        final Button btn_menu = (Button) findViewById(R.id.id_bt_menu);

        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.id_frame_layout_accueil);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(frameLayout.getVisibility() == View.VISIBLE)
                    frameLayout.setVisibility(View.INVISIBLE);
                else
                    frameLayout.setVisibility(View.VISIBLE);
            }
        });

        //allé sur l'activité mapsActivity
        final Button btn_map = (Button) findViewById(R.id.id_btn_map);

        /*btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Accueil.this, MapsActivity.class);
                startActivity(intent);
            }
        });*/

        final Button btn_return = (Button) findViewById(R.id.id_bt_return);
        final Button btn_home = (Button) findViewById(R.id.id_btn_home);
        final Button btn_lcpt = (Button) findViewById(R.id.id_btn_liste_compte);
        final Button btn_stat = (Button) findViewById(R.id.id_btn_stat);
        final Button btn_vir = (Button) findViewById(R.id.id_btn_virement);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                ReleveBancaire.this.finish();
            }
        });


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ReleveBancaire.this, Accueil.class);
                startActivity(intent);
            }
        });


        btn_lcpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ReleveBancaire.this, ListeCompte.class);
                startActivity(intent);
            }
        });

        btn_stat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ReleveBancaire.this, Stat.class);
                startActivity(intent);
            }
        });

        btn_vir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ReleveBancaire.this, AjoutVirement.class);
                startActivity(intent);
            }
        });
        /* END OF FRAGMENT */
    }
}
