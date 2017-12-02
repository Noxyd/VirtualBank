package com.example.stri.virtualbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListeCompte extends AppCompatActivity {

    //test var
    String banque[] = {"Banque Postale","Société Générale", "HSBC"};

    String compte[][] = {{"Compte A", "Compte B", "Compte C"},{"Compte 1", "Compte 2", "Compte 3"}, {"Compte H", "Compte I", "Compte J"}};

    int getIndexOfBank(String pNomBanque){
        int index = 0;
        boolean lContinue = true;

        while(lContinue){
            if(banque[index].compareTo(pNomBanque) == 0){
                lContinue = false;
            }
            else
                index++;
        }

        return index;
    }

    int getNbOfCountByBank(String pNomBanque){
        String lCompteOfBank[];

        lCompteOfBank = compte[getIndexOfBank(pNomBanque)];

        return lCompteOfBank.length;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_compte);
        final Button btn_lcpt = (Button) findViewById(R.id.lc_ajoutbanque);


        //récupérer les 4 colonnes
        TextView txcol3 = (TextView) findViewById(R.id.col3TextView);


        for(int i = 0; i < banque.length; i++){
            txcol3.setText(txcol3.getText() + banque[i] + "\n");
            for(int j = 0; j < getNbOfCountByBank(banque[i]); j++){
                txcol3.setText(txcol3.getText() + "    " + compte[getIndexOfBank(banque[i])][j] + "\n");
            }

        }

        btn_lcpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ListeCompte.this, AjoutBanque.class);
                startActivity(intent);
            }
        });


    }
}
