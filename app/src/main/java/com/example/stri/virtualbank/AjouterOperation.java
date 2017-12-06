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

        final Button revenir = (Button) findViewById(R.id.revenir);
        revenir.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(AjouterOperation.this, Accueil.class);
                startActivity(intent);
            }
        });

    }
}

