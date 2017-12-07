package com.example.stri.virtualbank;
/**
 * Created by Francois on 07/11/2017.
 */

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.FrameLayout;
        import android.widget.ListView;

public class AjouterOperation extends AppCompatActivity{


    private String[] categorie = new String[]{
            "Courses","Impot","Loisir","Santé","Sport","Transport","Voiture"
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_operation);


        ListView catList = (ListView) findViewById(R.id.maCat);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(AjouterOperation.this, android.R.layout.simple_list_item_1, categorie);
        catList.setAdapter(adapter);


        final Button ajouter = (Button) findViewById(R.id.ajouter);
        ajouter.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                int montant = 0;
                EditText mont = (EditText) findViewById(R.id.valMontant);
                String stringMon = mont.getText().toString().trim();

                if(stringMon.length() != 0){
                    montant = Integer.parseInt(stringMon);
                }

                EditText dat = (EditText) findViewById (R.id.maDate);
                String date = dat.getText().toString();

                EditText lib = (EditText) findViewById (R.id.monlib);
                String libel = lib.getText().toString();


                Intent i = new Intent(AjouterOperation.this, Accueil.class);

                i.putExtra("LeLibel", libel);
                i.putExtra("LaDate", date);
                i.putExtra("LeMontant", String.valueOf(montant));

                startActivity(i);
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


        // -    to remove   -
        //  -   BEGIN     -
        final Button btn_return = (Button) findViewById(R.id.id_bt_return);
        final Button btn_home = (Button) findViewById(R.id.id_btn_home);
        final Button btn_rlv = (Button) findViewById(R.id.id_btn_releve_bancaire);
        final Button btn_lcpt = (Button) findViewById(R.id.id_btn_liste_compte);
        final Button btn_stat = (Button) findViewById(R.id.id_btn_stat);
        final Button btn_vir = (Button) findViewById(R.id.id_btn_virement);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                AjouterOperation.this.finish();
            }
        });


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AjouterOperation.this, Accueil.class);
                startActivity(intent);
            }
        });

        btn_rlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AjouterOperation.this, ReleveBancaire.class);
                startActivity(intent);
            }
        });


        btn_lcpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AjouterOperation.this, ListeCompte.class);
                startActivity(intent);
            }
        });

        btn_stat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AjouterOperation.this, Stat.class);
                startActivity(intent);
            }
        });

        btn_vir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AjouterOperation.this, AjoutVirement.class);
                startActivity(intent);
            }
        });
        /* END OF FRAGMENT */

    }
}

