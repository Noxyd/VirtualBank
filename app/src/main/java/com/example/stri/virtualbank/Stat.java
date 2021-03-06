package com.example.stri.virtualbank;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.*;

/**
 * Created by alexis on 02/12/17.
 */

public class Stat extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        //BEGIN LINE CHART
        //récupération de la line chart

        LineChart lChart = (LineChart) findViewById(R.id.lineChart);

        //Remplissage de la line data avec des valeurs factices
        List<Entry> lEntries = new ArrayList<Entry>();

        lEntries.add(new Entry(700, 0));
        lEntries.add(new Entry(981, 1));
        lEntries.add(new Entry(863, 2));
        lEntries.add(new Entry(862, 3));
        lEntries.add(new Entry(431, 4));
        lEntries.add(new Entry(856, 5));
        lEntries.add(new Entry(789, 6));
        lEntries.add(new Entry(1002, 7));

        //Création d'une ligne de données et configuration
        LineDataSet lDataSet = new LineDataSet(lEntries, "Compte 1");
        lDataSet.setColor(CYAN);
        lDataSet.setValueTextColor(CYAN);

        //Remplissage d'une deuxième line data avec valeurs factices
        List<Entry> lEntries2 = new ArrayList<Entry>();

        lEntries2.add(new Entry(201, 0));
        lEntries2.add(new Entry(310, 1));
        lEntries2.add(new Entry(104, 2));
        lEntries2.add(new Entry(85, 3));
        lEntries2.add(new Entry(50, 4));
        lEntries2.add(new Entry(66, 5));
        lEntries2.add(new Entry(79, 6));
        lEntries2.add(new Entry(101, 7));

        //Création d'une ligne de données et configuration
        LineDataSet lDataSet2 = new LineDataSet(lEntries2, "Compte 2");
        lDataSet2.setColor(BLUE);
        lDataSet2.setValueTextColor(BLUE);

        //Remplissage d'une troisième line data avec valeurs factices
        List<Entry> lEntries3 = new ArrayList<Entry>();

        lEntries3.add(new Entry(456, 0));
        lEntries3.add(new Entry(354, 1));
        lEntries3.add(new Entry(322, 2));
        lEntries3.add(new Entry(277, 3));
        lEntries3.add(new Entry(236, 4));
        lEntries3.add(new Entry(189, 5));
        lEntries3.add(new Entry(156, 6));
        lEntries3.add(new Entry(99, 7));

        //Création d'une ligne de données et configuration
        LineDataSet lDataSet3 = new LineDataSet(lEntries3, "Compte 3");
        lDataSet3.setColor(RED);
        lDataSet3.setValueTextColor(RED);

        //Créations des labels de la line chart
        ArrayList<String> lLabels = new ArrayList<String>();
        lLabels.add("Juin");
        lLabels.add("Juillet");
        lLabels.add("Aout");
        lLabels.add("Septembre");
        lLabels.add("Octobre");
        lLabels.add("Novembre");
        lLabels.add("Décembre");
        lLabels.add("Janvier");

        //Création d'une arraylist de line data en vue de les ajouter au visuel (line chart)
        ArrayList<ILineDataSet> lLineDataSets = new ArrayList<ILineDataSet>();
        lLineDataSets.add(lDataSet);
        lLineDataSets.add(lDataSet2);
        lLineDataSets.add(lDataSet3);

        //Ajout au visuel
        LineData lLineData = new LineData(lLabels, lLineDataSets);
        lChart.setDescription("(en €)");
        lChart.setData(lLineData);
        lChart.invalidate(); // refresh

        //END LINE CHART

        //BEGIN PIE CHART

        //récupération de la pie chart
        PieChart pChart = (PieChart) findViewById(R.id.pieChart);

        //remplissage de la pie data avec des valeurs factices
        List<Entry> pEntries = new ArrayList<Entry>();
        pEntries.add(new Entry(80f, 0));
        pEntries.add(new Entry(10f, 1));
        pEntries.add(new Entry(10f, 2));

        //Créations des labels de la pie chart et configuration
        PieDataSet pDataSet = new PieDataSet(pEntries, "");
        ArrayList<String> pLabels = new ArrayList<String>();
        pLabels.add("Compte 1");
        pLabels.add("Compte 2");
        pLabels.add("Compte 3");

        int[] tab = {CYAN, BLUE, RED};
        pDataSet.setColors(tab);

        //ajout au visuel
        PieData pLineData = new PieData(pLabels, pDataSet);
        pChart.setData(pLineData);
        pChart.setDescription("(en %)");
        pChart.invalidate(); // refresh

        //END PIE CHART

        //BEGIN PIE CHART

        BarChart bChart = (BarChart) findViewById(R.id.barChart);

        //remplissage d'un arraylist avec des valeurs factices de la bar chart
        List<BarEntry> bEntries = new ArrayList<BarEntry>();

        bEntries.add(new BarEntry(4f, 0));
        bEntries.add(new BarEntry(8f, 1));
        bEntries.add(new BarEntry(6f, 2));
        bEntries.add(new BarEntry(12f, 3));
        bEntries.add(new BarEntry(18f, 4));
        bEntries.add(new BarEntry(9f, 5));

        BarDataSet bDataSet = new BarDataSet(bEntries, "Compte 1");


        //remplissage d'un arraylist avec des valeurs factices de la bar chart
        List<BarEntry> bEntries2 = new ArrayList<BarEntry>();

        bEntries2.add(new BarEntry(0f, 0));
        bEntries2.add(new BarEntry(0f, 1));
        bEntries2.add(new BarEntry(0f, 2));
        bEntries2.add(new BarEntry(10f, 3));
        bEntries2.add(new BarEntry(1f, 4));
        bEntries2.add(new BarEntry(9f, 5));

        BarDataSet bDataSet2 = new BarDataSet(bEntries2, "Compte 2");


        //remplissage d'un arraylist avec des valeurs factices de la bar chart
        List<BarEntry> bEntries3 = new ArrayList<BarEntry>();

        bEntries3.add(new BarEntry(0f, 0));
        bEntries3.add(new BarEntry(5f, 1));
        bEntries3.add(new BarEntry(2f, 2));
        bEntries3.add(new BarEntry(1f, 3));
        bEntries3.add(new BarEntry(1f, 4));
        bEntries3.add(new BarEntry(1f, 5));

        BarDataSet bDataSet3 = new BarDataSet(bEntries3, "Compte 3");

        //Création des labels de la bar chart
        ArrayList<String> bLabels = new ArrayList<String>();
        bLabels.add("Cad.");
        bLabels.add("Voit.");
        bLabels.add("Log.");
        bLabels.add("Nou.");
        bLabels.add("Sort.");
        bLabels.add("Jeux");

        //création des data de la bar chart avec les précédents arraylist + configuration du visuel
        BarData bLineData = new BarData(bLabels, bDataSet);

        ArrayList<IBarDataSet> bBarDataSets = new ArrayList<IBarDataSet>();
        bDataSet.setColor(CYAN);
        bDataSet2.setColor(BLUE);
        bDataSet3.setColor(RED);

        bBarDataSets.add(bDataSet);
        bBarDataSets.add(bDataSet2);
        bBarDataSets.add(bDataSet3);

        //ajout des data au visuel
        BarData barData = new BarData(bLabels, bBarDataSets);

        bChart.setData(barData);
        bChart.setDescription("(en %)");
        bChart.invalidate();

        //END PIE CHART

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
        final Button btn_vir = (Button) findViewById(R.id.id_btn_virement);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Stat.this.finish();
            }
        });


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(Stat.this, Accueil.class);
                startActivity(intent);
            }
        });

        btn_rlv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(Stat.this, ReleveBancaire.class);
                startActivity(intent);
            }
        });


        btn_lcpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(Stat.this, ListeCompte.class);
                startActivity(intent);
            }
        });

        btn_vir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(Stat.this, AjoutVirement.class);
                startActivity(intent);
            }
        });
        /* END OF FRAGMENT */
    }
}
