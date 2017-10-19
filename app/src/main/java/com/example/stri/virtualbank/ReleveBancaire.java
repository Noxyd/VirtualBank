package com.example.stri.virtualbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReleveBancaire extends AppCompatActivity {

    //test var
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

        //init le début du tableau
        txcol1.setText("Dépense\n");
        txcol2.setText("Montant\n");
        txcol3.setText("Date\n");
        txcol4.setText("Catégorie\n");

        for(int i = 0; i < tableauDepense.length; i++){
            txcol1.setText(txcol1.getText() + tableauDepense[i] + "\n");
            txcol2.setText(txcol2.getText() + String.valueOf(tableauMontant[i]) + "\n");
            txcol3.setText(txcol3.getText() + tableauDate[i] + "\n");
            txcol4.setText(txcol4.getText() + tableauCategorie[i] + "\n");
        }

    }
}
