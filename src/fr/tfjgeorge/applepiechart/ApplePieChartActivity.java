package fr.tfjgeorge.applepiechart;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

public class ApplePieChartActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ArrayList<Float>data =  new ArrayList<Float>();
        data.add(32f);
        data.add(132f);
        PieChart mpc = (PieChart) findViewById(R.id.pieChart1);
        mpc.setData(data);
    }
}