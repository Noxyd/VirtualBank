package com.example.stri.virtualbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ListeCompte extends AppCompatActivity {

    //Liste de banques et de comptes factices, pour simuler l'utilisateur de l'application
    String banque[] = {"Banque Postale","Société Générale", "HSBC"};
    String compte[][] = {{"Compte A", "Compte B", "Compte C"},{"Compte 1", "Compte 2", "Compte 3"}, {"Compte H", "Compte I", "Compte J"}};

    //récupére l'index d'une banque à partir de son nom
    int getIndexOfBank(String pNomBanque){
        //début à 0
        int index = 0;
        //variable booleenne pour la boucle while
        boolean lContinue = true;

        //tant que la boucle n'est pas finie
        while(lContinue){
            //si on a trouvé le bon index
            if(banque[index].compareTo(pNomBanque) == 0){
                lContinue = false;
            }
            else
                //sinon on incrémente
                index++;

            //si l'index est supérieur à la longueur du tableau, on a testé toutes les valeurs donc on sort de la boucle
            //aussi, on invalide l'index
            if(index > banque.length -1){
                index = -1;
                lContinue = false;
            }
        }

        return index;
    }

    //récupère le nombre de compte lié à une banque
    int getNbOfCountByBank(String pNomBanque){
        //Variable qui stocke les comptes de la banque en question
        String lCompteOfBank[] = {};

        //Si l'index est valide, on remplit le tableau
        if(getIndexOfBank(pNomBanque) != -1)
            lCompteOfBank = compte[getIndexOfBank(pNomBanque)];

        //On retourne le nombre de compte lié à la banque
        return lCompteOfBank.length;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_compte);

        //récupération du bouton d'ajout de banque
        final Button btn_lcptadd = (Button) findViewById(R.id.lc_ajoutbanque);

        //récupérer les 4 colonnes
        TextView txcol3 = (TextView) findViewById(R.id.col3TextView);

        //remplir l'affichage avec la liste des comptes et les banques
        for(int i = 0; i < banque.length; i++){
            txcol3.setText(txcol3.getText() + banque[i] + "\n");
            for(int j = 0; j < getNbOfCountByBank(banque[i]); j++){
                txcol3.setText(txcol3.getText() + "    " + compte[getIndexOfBank(banque[i])][j] + "\n");
            }

        }

        //si l'utilisateur appuie sur 'ajout banque'
        btn_lcptadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirection vers la page associée
                Intent intent = new Intent(ListeCompte.this, AjoutBanque.class);
                startActivity(intent);
            }
        });

    /* PART OF THE LEFT LAYOUT FRAGMENT MENU */
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


        //récupération & attribution d'actions de redirection aux boutons
        final Button btn_return = (Button) findViewById(R.id.id_bt_return);
        final Button btn_home = (Button) findViewById(R.id.id_btn_home);
        final Button btn_rlv = (Button) findViewById(R.id.id_btn_releve_bancaire);
        final Button btn_stat = (Button) findViewById(R.id.id_btn_stat);
        final Button btn_vir = (Button) findViewById(R.id.id_btn_virement);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                ListeCompte.this.finish();
            }
        });


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ListeCompte.this, Accueil.class);
                startActivity(intent);
            }
        });

        btn_rlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ListeCompte.this, ReleveBancaire.class);
                startActivity(intent);
            }
        });

        btn_stat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ListeCompte.this, Stat.class);
                startActivity(intent);
            }
        });

        btn_vir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ListeCompte.this, AjoutVirement.class);
                startActivity(intent);
            }
        });
    }
}
