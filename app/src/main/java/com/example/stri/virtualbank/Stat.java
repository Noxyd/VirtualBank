package com.example.stri.virtualbank;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

        LineChart lChart = (LineChart) findViewById(R.id.lineChart);

        //fill charts
        //begin
        List<Entry> lEntries = new ArrayList<Entry>();

        lEntries.add(new Entry(700, 0));
        lEntries.add(new Entry(981, 1));
        lEntries.add(new Entry(863, 2));
        lEntries.add(new Entry(862, 3));
        lEntries.add(new Entry(431, 4));
        lEntries.add(new Entry(856, 5));
        lEntries.add(new Entry(789, 6));
        lEntries.add(new Entry(1002, 7));


        LineDataSet lDataSet = new LineDataSet(lEntries, "Compte 1");
        lDataSet.setColor(CYAN);
        lDataSet.setValueTextColor(CYAN);

        List<Entry> lEntries2 = new ArrayList<Entry>();

        lEntries2.add(new Entry(201, 0));
        lEntries2.add(new Entry(310, 1));
        lEntries2.add(new Entry(104, 2));
        lEntries2.add(new Entry(85, 3));
        lEntries2.add(new Entry(50, 4));
        lEntries2.add(new Entry(66, 5));
        lEntries2.add(new Entry(79, 6));
        lEntries2.add(new Entry(101, 7));


        LineDataSet lDataSet2 = new LineDataSet(lEntries2, "Compte 2");
        lDataSet2.setColor(BLUE);
        lDataSet2.setValueTextColor(BLUE);

        List<Entry> lEntries3 = new ArrayList<Entry>();

        lEntries3.add(new Entry(456, 0));
        lEntries3.add(new Entry(354, 1));
        lEntries3.add(new Entry(322, 2));
        lEntries3.add(new Entry(277, 3));
        lEntries3.add(new Entry(236, 4));
        lEntries3.add(new Entry(189, 5));
        lEntries3.add(new Entry(156, 6));
        lEntries3.add(new Entry(99, 7));


        LineDataSet lDataSet3 = new LineDataSet(lEntries3, "Compte 3");
        lDataSet3.setColor(RED);
        lDataSet3.setValueTextColor(RED);

        ArrayList<String> lLabels = new ArrayList<String>();
        lLabels.add("Juin");
        lLabels.add("Juillet");
        lLabels.add("Aout");
        lLabels.add("Septembre");
        lLabels.add("Octobre");
        lLabels.add("Novembre");
        lLabels.add("Décembre");
        lLabels.add("Janvier");

        ArrayList<ILineDataSet> lLineDataSets = new ArrayList<ILineDataSet>();
        lLineDataSets.add(lDataSet);
        lLineDataSets.add(lDataSet2);
        lLineDataSets.add(lDataSet3);

        LineData lLineData = new LineData(lLabels, lLineDataSets);
        lChart.setDescription("(en €)");
        lChart.setData(lLineData);
        lChart.invalidate(); // refresh

        //END LINE CHART

        //BEGIN PIE CHART

        PieChart pChart = (PieChart) findViewById(R.id.pieChart);

        //fill charts
        //begin
        List<Entry> pEntries = new ArrayList<Entry>();

        pEntries.add(new Entry(80f, 0));
        pEntries.add(new Entry(10f, 1));
        pEntries.add(new Entry(10f, 2));

        PieDataSet pDataSet = new PieDataSet(pEntries, "");
        ArrayList<String> pLabels = new ArrayList<String>();
        pLabels.add("Compte 1");
        pLabels.add("Compte 2");
        pLabels.add("Compte 3");

        int[] tab = {CYAN, BLUE, RED};
        pDataSet.setColors(tab);

        PieData pLineData = new PieData(pLabels, pDataSet);
        pChart.setData(pLineData);
        pChart.setDescription("(en %)");
        pChart.invalidate(); // refresh

        //END PIE CHART

        //BEGIN PIE CHART

        BarChart bChart = (BarChart) findViewById(R.id.barChart);

        //fill charts
        //begin
        List<BarEntry> bEntries = new ArrayList<BarEntry>();

        bEntries.add(new BarEntry(4f, 0));
        bEntries.add(new BarEntry(8f, 1));
        bEntries.add(new BarEntry(6f, 2));
        bEntries.add(new BarEntry(12f, 3));
        bEntries.add(new BarEntry(18f, 4));
        bEntries.add(new BarEntry(9f, 5));

        BarDataSet bDataSet = new BarDataSet(bEntries, "Compte 1");

        List<BarEntry> bEntries2 = new ArrayList<BarEntry>();

        bEntries2.add(new BarEntry(0f, 0));
        bEntries2.add(new BarEntry(0f, 1));
        bEntries2.add(new BarEntry(0f, 2));
        bEntries2.add(new BarEntry(10f, 3));
        bEntries2.add(new BarEntry(1f, 4));
        bEntries2.add(new BarEntry(9f, 5));

        BarDataSet bDataSet2 = new BarDataSet(bEntries2, "Compte 2");

        List<BarEntry> bEntries3 = new ArrayList<BarEntry>();

        bEntries3.add(new BarEntry(0f, 0));
        bEntries3.add(new BarEntry(5f, 1));
        bEntries3.add(new BarEntry(2f, 2));
        bEntries3.add(new BarEntry(1f, 3));
        bEntries3.add(new BarEntry(1f, 4));
        bEntries3.add(new BarEntry(1f, 5));

        BarDataSet bDataSet3 = new BarDataSet(bEntries3, "Compte 3");

        ArrayList<String> bLabels = new ArrayList<String>();
        bLabels.add("Cad.");
        bLabels.add("Voit.");
        bLabels.add("Log.");
        bLabels.add("Nou.");
        bLabels.add("Sort.");
        bLabels.add("Jeux");

        BarData bLineData = new BarData(bLabels, bDataSet);

        ArrayList<IBarDataSet> bBarDataSets = new ArrayList<IBarDataSet>();
        bDataSet.setColor(CYAN);
        bDataSet2.setColor(BLUE);
        bDataSet3.setColor(RED);

        bBarDataSets.add(bDataSet);
        bBarDataSets.add(bDataSet2);
        bBarDataSets.add(bDataSet3);

        BarData barData = new BarData(bLabels, bBarDataSets);

        bChart.setData(barData);
        bChart.setDescription("(en %)");
        bChart.invalidate(); // refresh

        /*ArrayList<ILineDataSet> lLineDataSets = new ArrayList<ILineDataSet>();
        lLineDataSets.add(lDataSet);
        lLineDataSets.add(lDataSet2);
        lLineDataSets.add(lDataSet3);

        LineData lLineData = new LineData(lLabels, lLineDataSets);
        lChart.setDescription("(en €)");
        lChart.setData(lLineData);
        lChart.invalidate(); // refresh*/

        //END PIE CHART
    }
}
