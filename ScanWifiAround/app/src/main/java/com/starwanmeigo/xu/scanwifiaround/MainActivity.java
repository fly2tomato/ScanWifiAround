/*pick up there strongest signals of the signals around */
package com.starwanmeigo.xu.scanwifiaround;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;


public class MainActivity extends ActionBarActivity {
    List<ScanResult> wifiList;
    private WifiManager wifiManager;
    private WifiInfo wifiConnectedInfo;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView show = (TextView) findViewById(R.id.show);
        EditText xianshi = (EditText) findViewById(R.id.main_et_show);
        wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        wifiConnectedInfo = wifiManager.getConnectionInfo();
        Log.d("wifiInfo............", wifiConnectedInfo.toString());
        Log.d("SSID.................",wifiConnectedInfo.getSSID());
        Log.d("RSSI.................",Float.toString(wifiConnectedInfo.getRssi()));



        wifiList = (List<ScanResult>) wifiManager.getScanResults();
        float level [] = new float[wifiList.size()];
        String ssid [] = new String[wifiList.size()];
/*
        float temp_level []  = new float[wifiList.size()+1];


        String temp_ssid [] = new String[wifiList.size()];
*/


        /*StringBuffer sb = new StringBuffer();*/
        for (int i=0;i<wifiList.size();i++) {
            level [i] = wifiList.get(i).level;
            ssid [i] = wifiList.get(i).SSID;

        }

        for (int i=0;i<wifiList.size();i++){
            for (int j=i+1;j<wifiList.size();j++){
                if(level [i]< level [j]){
                    float temp_level  = level [j];
                    level [j] = level [i];
                    level [i] = temp_level;
                    String temp_ssid = ssid [j];
                    ssid [j] = ssid [i];
                    ssid [i] = temp_ssid;
                }
            }
        }
            /*for (int j=1;j<wifiList.size();j++){
                if (abs(wifiList.get(i).level)>abs(wifiList.get(j).level)){
                    temp_level [i] = wifiList.get(j).level;
                    wifiList.get(j).level = wifiList.get(i).level;
                    *//*wifiList.get(i).level = temp_level [i];*//*
                    level [i] = temp_level [i];
                    temp_ssid [i] = wifiList.get(j).SSID;
                    wifiList.get(j).SSID = wifiList.get(i).SSID;
                    ssid [i] = temp_ssid [i];
                }
                *//*else{
                    level [i] = wifiList.get(j).level;
                    ssid [i] = wifiList.get(j).SSID;
                }*//*
            }*/

            /*for (int j = 1; j < wifiList.size(); j++) {
                *//*ScanResult sr = wifiList.get(i);*//*
                *//*android.net.wifi.ScanResult sr = wifiList.get(i);*//*
                if (wifiList.get(i).level < wifiList.get(j).level) {
                    android.net.wifi.ScanResult temp = null;
                    temp = wifiList.get(i);
                    wifiList.set(i, wifiList.get(j));
                    wifiList.set(j, temp);
                }
            }*/
           /* sb.append("SSID :" + ssid [i] + "\n");
            sb.append("level :" + Float.toString(level[i])+ "\n");
            xianshi.setText(sb.toString());*/

        Log.d("............1",Float.toString(wifiList.get(0).level));
        Log.d("............2",Float.toString(wifiList.get(1).level));
        Log.d("1level-ssid:",Float.toString(level [0])+" "+ssid [0]);
        Log.d("2level-ssid:",Float.toString(level [1])+" "+ssid [1]);
        Log.d("3level-ssid:",Float.toString(level [2])+" "+ssid [2]);
        Log.d("4level-ssid:",Float.toString(level [3])+" "+ssid [3]);
        Log.d("5level-ssid:",Float.toString(level [4])+" "+ssid [4]);
        Log.d("6level-ssid:",Float.toString(level [5])+" "+ssid [5]);

        StringBuffer sb = new StringBuffer();
        sb.append("SSID :" + ssid [0] + "\n");
        sb.append("level :" + Float.toString(level[0])+ "\n");
        sb.append("SSID :" + ssid [1] + "\n");
        sb.append("level :" + Float.toString(level[1]) + "\n");
        sb.append("SSID :" + ssid [2] + "\n");
        sb.append("level :" + Float.toString(level[2]) + "\n");
        sb.append("SSID :" + ssid [3] + "\n");
        sb.append("level :" + Float.toString(level[3]) + "\n");
        sb.append("SSID :" + ssid [4] + "\n");
        sb.append("level :" + Float.toString(level[4]) + "\n");
        sb.append("SSID :" + ssid [5] + "\n");
        sb.append("level :" + Float.toString(level[5]) + "\n");
        sb.append("SSID :" + ssid [6] + "\n");
        sb.append("level :" + Float.toString(level[6]) + "\n");
        xianshi.setText(sb.toString());




        /*show.setText(wifiList.toString());*/
        //wifiList.toArray();

    }

    /*private void updateView(Location location){

        StringBuffer sb = new StringBuffer();
        sb.append("SSID :" + ssid [0] + "\n");
        sb.append("level :" + Float.toString(level[0])+ "\n");
        sb.append("SSID :" + ssid [1] + "\n");
        sb.append("level :" + Float.toString(level[1]) + "\n");
        sb.append("SSID :" + ssid [2] + "\n");
        sb.append("level :" + Float.toString(level[2]) + "\n");
        sb.append("SSID :" + ssid [3] + "\n");
        sb.append("level :" + Float.toString(level[3]) + "\n");
        xianshi.setText(sb.toString());
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
