package com.opengl.jackn.worldyubin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by jackn on 2017/11/17.
 */

public class EasySearchActivity extends Activity {

    String dataContent;

    int howSAL=0,howSAL1 = 0,howEms=0,howAir = 0,howEpacket = 0,howEpacketLight = 0,howHunabin=0,weight=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
         dataContent = intent.getStringExtra("DATA1");
         weight = intent.getIntExtra("DATA3", 0);

        TextView EMS = findViewById(R.id.easyEMSmoney);
        TextView AIR = findViewById(R.id.easyAIRmoney);
        TextView Epacket = findViewById(R.id.easyEpacketMoney);
        TextView EpacketLight = findViewById(R.id.easyEpacketLightMoney);
        TextView Hunabin = findViewById(R.id.easyHunabinMoney);
        TextView SAL = findViewById(R.id.easySALmoney);
        TextView SAL1 = findViewById(R.id.easySAL1Money);

        checkHunabinmoney();
        checkSALmoney();
        checkSAL1money();
        checkEpacketLightmoney();
        checkEMSmoney();
        checkEpacketmoney();

        AIR.setText(String.valueOf(howAir)+"円");
        SAL.setText(String.valueOf(howSAL)+"円");
        SAL1.setText(String.valueOf(howSAL1)+"円");
        EMS.setText(String.valueOf(howEms)+"円");
        Epacket.setText(String.valueOf(howEpacket)+"円");
        EpacketLight.setText(String.valueOf(howEpacketLight)+"円");
        Hunabin.setText(String.valueOf(howHunabin)+"円");


    }

    private void checkHunabinmoney(){
        for(int i=0;i<=1;i++){
            if(weight<100){
                howHunabin=130;
                break;
            }else if(weight<250){
                howHunabin=220;
                break;
            }else if(weight<500){
                howHunabin=430;
                break;
            }else if(weight<1000){
                howHunabin=770;
                break;
            }else if(weight<=2000){
                howHunabin=1080;
                break;
            }
        }

    }
    private void checkSALmoney() {
        int oldI=0;
        if (dataContent.equals("アジア")) {
            for (int i = 100; i <= 2000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howSAL=160+(i/100-1)*80;
                }
                oldI=i;
            }
        }
        if (dataContent.equals("北米、ヨーロッパ、オセアニア、中東")) {
            for (int i = 100; i <= 2000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howSAL=180+(i/100-1)*100;
                }
                oldI=i;
            }
        }
        if (dataContent.equals("南米、アフリカ")) {
            for (int i = 100; i <= 2000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howSAL=200+(i/100-1)*120;
                }
                oldI=i;
            }
        }
    }
    private void checkSAL1money() {
        int oldI=0;
        if (dataContent.equals("アジア")) {
            for (int i = 100; i <= 2000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howSAL1=570+(i/100-1)*80;
                }
                oldI=i;
            }
        }
        if (dataContent.equals("北米、ヨーロッパ、オセアニア、中東")) {
            for (int i = 100; i <= 2000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howSAL1=590+(i/100-1)*100;
                }
                oldI=i;
            }
        }
        if (dataContent.equals("南米、アフリカ")) {
            for (int i = 100; i <= 2000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howSAL1=610+(i/100-1)*120;
                }
                oldI=i;
            }
        }
    }
    private void checkEpacketmoney() {
        if (dataContent.equals("アジア")) {
            int oldI=0;
            int i;
            for (i = 50; i <= 300; i=i+50) {
                if(oldI<weight&&weight<=i){
                    howEpacket=530+(i/100-1)*50;
                    return;
                }
                oldI=i;
            }
            oldI=300;
            for (i = 400; i <= 1000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEpacket=880+(i/100-1)*100;
                    return;
                }
                oldI=i;
            }
            for(i=0;i<=1;i++) {
                if (weight<=1200) {
                    howEpacket=1700;
                    break;
                }
                if (weight<=1500) {
                    howEpacket=1920;
                    break;
                }
                if (weight<=1700) {
                    howEpacket=2140;
                    break;
                }
                if (weight<=2000) {
                    howEpacket=2360;
                    break;
                }
            }
        }
        if (dataContent.equals("南米、アフリカ")) {
            int oldI=0;
            int i;
            for (i = 50; i <= 300; i=i+50) {
                if(oldI<weight&&weight<=i){
                    howEpacket=580+(i/100-1)*105;
                }
                oldI=i;
            }

            for (i = 400; i <= 1000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEpacket=1315+(i/100-1)*210;
                }
                oldI=i;
            }
            for(i=0;i<=1;i++) {
                if (weight<=1200) {
                    howEpacket=2945;
                    break;
                }
                if (weight<=1500) {
                    howEpacket=3315;
                    break;
                }
                if (weight<=1700) {
                    howEpacket=3685;
                    break;
                }
                if (weight<=2000) {
                    howEpacket=4055;
                    break;
                }
            }
        }
        if (dataContent.equals("北米、ヨーロッパ、オセアニア、中東")) {
            int oldI=0;
            int i;
            for (i = 50; i <= 300; i=i+50) {
                if(oldI<weight&&weight<=i){
                    howEpacket=560+(i/100-1)*75;
                }
                oldI=i;
            }
            for (i = 400; i <= 1000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEpacket=1085+(i/100-1)*150;
                }
                oldI=i;
            }
            for(i=0;i<=1;i++) {
                if (weight<1200) {
                    howEpacket=2255;
                    break;
                }
                if (weight<1500) {
                    howEpacket=2525;
                    break;
                }
                if (weight<1700) {
                    howEpacket=2795;
                    break;
                }
                if (weight<=2000) {
                    howEpacket=3065;
                    break;
                }
            }
        }
    }
    private void checkEpacketLightmoney() {
        if (dataContent.equals("アジア")) {
            int oldI=0;
            int i;
            for (i = 100; i <= 300; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEpacketLight=530+(i/100-1)*50;
                    return;
                }
                oldI=i;
            }
            for (i = 400; i <= 1000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEpacketLight=700+(i/100-1)*70;
                    return;
                }
                oldI=i;
            }
            for(i=0;i<=1;i++) {
                if (weight<1250) {
                    howEpacketLight=1340;
                    break;
                }
                if (weight<1500) {
                    howEpacketLight=1560;
                    break;
                }
                if (weight<1750) {
                    howEpacketLight=1780;
                    break;
                }
                if (weight<=2000) {
                    howEpacketLight=2000;
                    break;
                }
            }
        }
        if (dataContent.equals("南米、アフリカ")) {
            int oldI=0;
            int i;
            for (i = 100; i <= 300; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEpacketLight=570+(i/100-1)*90;
                    return;
                }
                oldI=i;
            }
            for (i = 400; i <= 1000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEpacketLight=860+(i/100-1)*110;
                    return;
                }
                oldI=i;
            }
            for(i=0;i<=1;i++) {
                if (weight<1250) {
                    howEpacketLight=1840;
                    break;
                }
                if (weight<1500) {
                    howEpacketLight=2160;
                    break;
                }
                if (weight<1750) {
                    howEpacketLight=2480;
                    break;
                }
                if (weight<=2000) {
                    howEpacketLight=2800;
                    break;
                }
            }
        }
        if (dataContent.equals("北米、ヨーロッパ、オセアニア、中東")) {
            int oldI=0;
            int i;
            for (i = 100; i <= 300; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEpacketLight=550+(i/100-1)*70;
                    return;
                }
                oldI=i;
            }
            for (i = 400; i <= 1000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEpacketLight=780+(i/100-1)*90;
                    return;
                }
                oldI=i;
            }
            for(i=0;i<=1;i++) {
                if (weight<1250) {
                    howEpacketLight=1590;
                    break;
                }
                if (weight<1500) {
                    howEpacketLight=1860;
                    break;
                }
                if (weight<1750) {
                    howEpacketLight=2130;
                    break;
                }
                if (weight<=2000) {
                    howEpacketLight=2400;
                    break;
                }
            }
        }
    }
    private void checkEMSmoney() {
        if (dataContent.equals("2-1")) {
            int oldI=500;
            int i;
            if(weight<=500){
                howEms=2000;
                return;
            }
            for (i = 600; i <= 1000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEms=2180+(i/100-1)*180;
                    return;
                }
                oldI=i;
            }
            for(i=0;i<=1;i++) {
                if (weight<1250) {
                    howEms=3300;
                    break;
                }
                if (weight<1500) {
                    howEms=3700;
                    break;
                }
                if (weight<1750) {
                    howEms=4100;
                    break;
                }
                if (weight<=2000) {
                    howEms=4500;
                    break;
                }
            }
        }
        if (dataContent.equals("2-2")) {
            int oldI=500;
            int i;
            if(weight<=500){
                howEms=2200;
                return;
            }
            for (i = 600; i <= 1000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEms=2400+(i/100-1)*200;
                    return;
                }
                oldI=i;
            }
            for(i=0;i<=1;i++) {
                if (weight<1250) {
                    howEms=3650;
                    break;
                }
                if (weight<1500) {
                    howEms=4100;
                    break;
                }
                if (weight<1750) {
                    howEms=4550;
                    break;
                }
                if (weight<=2000) {
                    howEms=5000;
                    break;
                }
            }
        }
        if (dataContent.equals("南米、アフリカ")) {
            int i;
            int oldI=500;
            if(weight<=500){
                howEms=2400;
                return;
            }
            for (i = 600; i <= 1000; i=i+100) {
                if(oldI<weight&&weight<=i){
                    howEms=2740+(i/100-1)*340;
                    return;
                }
                oldI=i;
            }
            for(i=0;i<=1;i++) {
                if (weight<1250) {
                    howEms=4900;
                    break;
                }
                if (weight<1500) {
                    howEms=5700;
                    break;
                }
                if (weight<1750) {
                    howEms=6500;
                    break;
                }
                if (weight<=2000) {
                    howEms=7300;
                    break;
                }
            }
        }
        if (dataContent.equals("アジア")) {
            int oldI=500;
            int i;
            if (weight <= 500) {
                howEms = 1400;
                return;
            }
            for (i = 600; i <= 1000; i = i + 100) {
                if (oldI < weight && weight <= i) {
                    howEms = 1540 + (i / 100 - 1) * 140;
                    return;
                }
                oldI = i;
            }
            for (i = 0; i <= 1; i++) {
                if (weight < 1250) {
                    howEms = 2400;
                    break;
                }
                if (weight < 1500) {
                    howEms = 2700;
                    break;
                }
                if (weight < 1750) {
                    howEms = 3000;
                    break;
                }
                if (weight <= 2000) {
                    howEms = 3300;
                    break;
                }
            }
        }
    }
}
