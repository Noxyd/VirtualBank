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
        import android.widget.TextView;
        import java.util.ArrayList;


public class Accueil extends AppCompatActivity{

    //simulation de data sous forme de tableaux
    String tableauDepense[] = {"truc", "Muche", "Gaumont", "Micromania", "IrishPub", "SkiLocation", "ToTale"};
    double tableauMontant[] = {140., 7., 25.99, 38., 41., 48., 1.50};
    String tableauDate[] = {"12/03/17", "11/03/17", "10/03/17", "11/05/17", "01/05/17", "04/04/17", "13/03/17"};
    String tableauCategorie[] = {"TrucMuche", "Loisirs", "Loisirs", "Loisirs", "Sports", "Voiture", "TrucMuche"};

    //declaration arraylist
    ArrayList<String> DepenseString = new ArrayList<String>();
    ArrayList<Double> MontantString = new ArrayList<Double>();
    ArrayList<String> DateString = new ArrayList<String>();
    ArrayList<String> CatString = new ArrayList<String>();

    //variables communes
    int sld = 2500 ;
    String devise = "€";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        // --pas encore opé-- récupération des datas de l'activité de ajoutOperation
        String mont = getIntent().getStringExtra("LeMontant"); //à soustraire de solde
        String libel = getIntent().getStringExtra("LeLibel");
        String date = getIntent().getStringExtra("LaDate");


        //Conversion des tableaux de data vers des arraylist pour leur manipulation
        TextView DepList = (TextView) findViewById(R.id.col1TextView);
        TextView MonList = (TextView) findViewById(R.id.col2TextView);
        TextView DatList = (TextView) findViewById(R.id.col3TextView);
        TextView CatList = (TextView) findViewById(R.id.col4TextView);

        for(int i = 0; i < tableauDepense.length; i++){
            DepenseString.add(tableauDepense[i]);
            DepList.setText(DepList.getText()+"\n"+tableauDepense[i]);


            MontantString.add(tableauMontant[i]);
            MonList.setText(MonList.getText()+"\n"+tableauMontant[i]);
            //MonList.setText(MonList.getText()+"\n"+mont);

            DateString.add(tableauDate[i]);
            DatList.setText(DatList.getText()+"\n"+tableauDate[i]);

            CatString.add(tableauCategorie[i]);
            CatList.setText(CatList.getText()+"\n"+tableauCategorie[i]);
        }

        //afficher le solde --pas encore opé-- pour la différence avec la valeur ajouté à la mano dans ajoutOperation
        TextView solde = (TextView) findViewById(R.id.monSolde);
        solde.setText("Solde : " + sld +" "+ devise);

        //allé sur l'activité ajouterOperation
        final Button ajouter = (Button) findViewById(R.id.bAjouterOp);
        ajouter.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Accueil.this, AjouterOperation.class); //ajouter ajouterOperation
                startActivity(intent);
            }
        });

        //allé sur l'activité mapsActivity
    /*    final Button btn_map = (Button) findViewById(R.id.id_btn_map);

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Accueil.this, MapsActivity.class);
                startActivity(intent);
            }
        });*/


        // -    to remove   -
        //  -   BEGIN     -
        final Button btn_rlv = (Button) findViewById(R.id.id_btn_releve_bancaire);
        final Button btn_lcpt = (Button) findViewById(R.id.id_btn_liste_compte);
        final Button btn_stat = (Button) findViewById(R.id.id_btn_stat);
        final Button btn_vir = (Button) findViewById(R.id.id_btn_virement);



        btn_rlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Accueil.this, ReleveBancaire.class);
                startActivity(intent);
            }
        });


        btn_lcpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Accueil.this, ListeCompte.class);
                startActivity(intent);
            }
        });

        btn_stat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accueil.this, Stat.class);
                startActivity(intent);
            }
        });

        btn_vir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accueil.this, AjoutVirement.class);
                startActivity(intent);
            }
        });

        // -    END    -
    }
}
