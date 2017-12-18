package com.example.stri.virtualbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AjoutVirement extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ArrayMap comptes;
    Spinner compte1;
    Spinner compte2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //add content of the page
        setContentView(R.layout.activity_ajoutvirement);

        //identification des spinners
        Spinner banque1 = (Spinner) findViewById(R.id.ab_banque_debit);
        Spinner banque2 = (Spinner) findViewById(R.id.ab_banque_credit);
        compte1 = (Spinner) findViewById(R.id.ab_compte_debit);
        compte2 = (Spinner) findViewById(R.id.ab_compte_credit);

        //Ajout des comptes
        comptes = new ArrayMap();
        comptes.put("Boursorama", ArrayAdapter.createFromResource(this, R.array.Boursorama, android.R.layout.simple_spinner_item));
        comptes.put("Monabanq", ArrayAdapter.createFromResource(this, R.array.Monabanq, android.R.layout.simple_spinner_item));
        comptes.put("HSBC", ArrayAdapter.createFromResource(this, R.array.HSBC, android.R.layout.simple_spinner_item));

        //ajout d'une fonctionne au spinner banque1 et banque 2
        //cette fonction s'active lors que l'utilisateur change le contenu du spinner
        banque1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //init
                //Va chercher dans comptes, les comptes qui appartiennent à la banque dont le nom est sélectionné !
                ArrayAdapter<CharSequence> adapter_banque = (ArrayAdapter<CharSequence>) comptes.get(parent.getItemAtPosition(position).toString());
                adapter_banque.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

                compte1.setAdapter(adapter_banque);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });

        banque2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //init
                //Va chercher dans comptes, les comptes qui appartiennent à la banque dont le nom est sélectionné !
                ArrayAdapter<CharSequence> adapter_banque = (ArrayAdapter<CharSequence>) comptes.get(parent.getItemAtPosition(position).toString());
                adapter_banque.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

                compte2.setAdapter(adapter_banque);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });
        //Récupération de la ressource stockée dans util_banque.xml
        ArrayAdapter<CharSequence> adapter_banque = ArrayAdapter.createFromResource(this, R.array.util_banque, android.R.layout.simple_spinner_item);


        adapter_banque.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        //Application des adapters aux spinneurs banque 1 et 2
        banque1.setAdapter(adapter_banque);
        banque2.setAdapter(adapter_banque);

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
        final Button btn_lcpt = (Button) findViewById(R.id.id_btn_liste_compte);
        final Button btn_stat = (Button) findViewById(R.id.id_btn_stat);
        final Button btn_vir = (Button) findViewById(R.id.id_btn_virement);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                AjoutVirement.this.finish();
            }
        });


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AjoutVirement.this, Accueil.class);
                startActivity(intent);
            }
        });

        btn_rlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AjoutVirement.this, ReleveBancaire.class);
                startActivity(intent);
            }
        });


        btn_lcpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AjoutVirement.this, ListeCompte.class);
                startActivity(intent);
            }
        });

        btn_stat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AjoutVirement.this, Stat.class);
                startActivity(intent);
            }
        });

        btn_vir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(AjoutVirement.this, AjoutVirement.class);
                startActivity(intent);
            }
        });
        /* END OF FRAGMENT */
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
}
