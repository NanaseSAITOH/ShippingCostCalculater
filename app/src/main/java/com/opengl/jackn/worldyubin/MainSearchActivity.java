package com.opengl.jackn.worldyubin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;



public class MainSearchActivity extends Activity {

    String dataContent,dataCountry;
    boolean EMSok=true;
    boolean AIRok=true;
    boolean SALok=true;
    boolean SAL1ok=true;
    boolean Epacketok=true;
    boolean EpacketLightok=true;

    int howSAL=0,howSAL1 = 0,howEms=0,howAir = 0,howEpacket = 0,howEpacketLight = 0,howHunabin=0,weight=0;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_secound);
        Intent intent = getIntent();

        dataContent = intent.getStringExtra("DATA1");
        dataCountry = intent.getStringExtra("DATA2");
         weight = intent.getIntExtra("DATA3", 0);

        boolean bSAL = intent.getBooleanExtra("SAL",false);
        boolean bSAL1 = intent.getBooleanExtra("SAL1",false);
        boolean bEMS = intent.getBooleanExtra("EMS",false);
        boolean bAIR = intent.getBooleanExtra("AIR",false);
        boolean bEpacket = intent.getBooleanExtra("Epacket",false);
        boolean bEpacketLight = intent.getBooleanExtra("EpacketLight",false);
        boolean bFunabin = intent.getBooleanExtra("Funabin",false);

        Log.d("continent",dataContent);
        Log.d("country",dataCountry);
        Log.d("Funabin", String.valueOf(bFunabin));

        TextView textViewSAL = findViewById(R.id.textViewSAL);
        TextView textViewSAL1 = findViewById(R.id.textViewSAL1);
        TextView textViewEMS = findViewById(R.id.textViewEMS);
        TextView textViewAIR = findViewById(R.id.textViewAIR);
        TextView textViewEpacket = findViewById(R.id.textViewEpacket);
        TextView textViewEpacketLight = findViewById(R.id.textViewEpacketLight);

        //金
        TextView SALMoney = findViewById(R.id.SALMoney);
        TextView SAL1Money = findViewById(R.id.SAL1Money);
        TextView EmsMoney = findViewById(R.id.EmsMoney);
        TextView AirMoney = findViewById(R.id.AirMoney);
        TextView EpacketMoney = findViewById(R.id.EpacketMoney);
        TextView EpacketLightMoney = findViewById(R.id.EpacketLightMoney);
        TextView HunabinMoney = findViewById(R.id.HunabinMoney);

        int blue=Color.parseColor("#FF00ddff");


        if(bSAL==false){
            LinearLayout layout = (LinearLayout)findViewById(R.id.SALLayout);
            // 内容を全部消す
            layout.removeAllViews();
        }

        if(bSAL1==false){
            LinearLayout layout = (LinearLayout)findViewById(R.id.Sal1Layout);
            // 内容を全部消す
            layout.removeAllViews();
        }
        if(bEMS==false){
            LinearLayout layout = (LinearLayout)findViewById(R.id.EMSLayout);
            // 内容を全部消す
            layout.removeAllViews();
        }
        if(bAIR==false){
            LinearLayout layout = (LinearLayout)findViewById(R.id.AIRLayout);
            // 内容を全部消す
            layout.removeAllViews();
        }
        if(bEpacket==false){
            LinearLayout layout = (LinearLayout)findViewById(R.id.EpacketLayout);
            // 内容を全部消す
            layout.removeAllViews();
        }
        if(bEpacketLight==false){
            LinearLayout layout = (LinearLayout)findViewById(R.id.EpacketLightLayout);
            // 内容を全部消す
            layout.removeAllViews();
        }
        if(bFunabin==false){
            LinearLayout layout = (LinearLayout)findViewById(R.id.HunabinLayout);
            // 内容を全部消す
            layout.removeAllViews();
        }
        checkSAL();
        checkAIR();
        checkEMS();
        checkEpacket();
        checkEpacketLight();
        checkSAL1();

        checkHunabinmoney();
        checkSALmoney();
        checkSAL1money();
        checkEpacketLightmoney();
        checkEMSmoney();
        checkEpacketmoney();

        HunabinMoney.setText(String.valueOf(howHunabin));

        if(EpacketLightok==true){
            EpacketLightMoney.setText(String.valueOf(howEpacketLight));
            textViewEpacketLight.setText("対応");
            textViewEpacketLight.setBackgroundColor(blue);
        }
        if(Epacketok==true){
            EpacketMoney.setText(String.valueOf(howEpacket));
            textViewEpacket.setBackgroundColor(blue);
            textViewEpacket.setText("対応");
        }
        if(EMSok==true){
            EmsMoney.setText(String.valueOf(howEms));
            textViewEMS.setBackgroundColor(blue);
            textViewEMS.setText("対応");
        }
        if(SALok==true){
            SALMoney.setText(String.valueOf(howSAL));
            textViewSAL.setBackgroundColor(blue);
            textViewSAL.setText("対応");
        }
        if(SAL1ok==true){
            SAL1Money.setText(String.valueOf(howSAL1));
            textViewSAL1.setText("対応");
            textViewSAL1.setBackgroundColor(blue);
        }
        if(AIRok==true){
            AirMoney.setText(String.valueOf(howAir));
            textViewAIR.setText("対応");
            textViewAIR.setBackgroundColor(blue);
        }

    }



    private void checkSAL(){
        String Ajia[]={"韓国","北朝鮮","台湾","マカオ","モンゴル","アフガニスタン",
                "カンボジア","ネパール","東ティモール","ブータン","ブルネイ","ベトナム","ミャンマー","モルディブ","ラオス"};
        String Africa[]={"アルゼンチン","コロンビア","チリ","パラグアイ","ブラジル","ペルー","アルジェリア","エジプト","ケニア","南アフリカ共和国"};

        String EU[]={"アンギラ","アンティグア・バーブーダ","英領ヴァージン諸島","エルサルバドル",
                "オランダ領アンティール（ボネール、キュラサオ、サバ、セント・ユースタティウス及びセント・マルテン）及びアルバ",
                "ガドループ","キューバ","グアテマラ","グレナダ","ケイマン諸島","コスタリカ","ジャマイカ","セントクリストファー・ネイビス",
                "セントビンセント（グレナディーン諸島含む）","セントルシア","タークス及びカイコス諸島","トリニダード・トバゴ","ドミニカ",
                "ドミニカ共和国","ニカラグア","ハイチ","バミューダ諸島","バハマ","バルバドス","パナマ","ベリーズ","ホンジュラス","マルチニーク",
                "モントセラト","キリバス","クック諸島（ニュージーランド）","クリスマス島（オーストラリア）","ココス、キーリング諸島（オーストラリア）",
                "サモア","ソロモン","ツバル","トンガ","ナウル","ニュー・カレドニア","ノーフォーク島（オーストラリア）","バヌアツ","パプアニューギニア",
                "ピトアケン（オノエ、デュシー、ヘンダーソン含む）","フィジー","仏領ポリネシア","ワリス及びフツナ諸島","アルバニア",
                "南極におけるフランスの地域","フェロー島（デンマーク）", "ブルガリア","ボスニア・ヘルツェゴビナ","ルーマニア",
                "イエメン","イラク","イラン","オマーン","カタール","キプロス","シリア","ヨルダン","レバノン"};

        Log.d("numberAJia", String.valueOf(Ajia.length));
        Log.d("numberAfrica", String.valueOf(Africa.length));
        Log.d("numberEU", String.valueOf(EU.length));

        for(int i=0;i<=14;i++){

            if(dataContent.equals("アジア")&&dataCountry.equals(Ajia[i])){
                SALok=false;
            }
        }
        for(int i=0;i<=9;i++){
            if(dataContent.equals("南米、アフリカ")&&dataCountry.equals(Africa[i])){
                SALok=true;
                break;
            }else if(dataContent.equals("南米、アフリカ")&&!(dataCountry.equals(Africa[i]))){
                SALok=false;
            }

        }

        for(int i=0;i<=60;i++){
            if (dataContent.equals("北米、ヨーロッパ、オセアニア、中東")&&dataCountry.equals(EU[i])) {
                SALok = false;
            }
        }



    }
    private void checkSAL1(){
        String Ajia[]={"韓国","北朝鮮","台湾","マカオ","モンゴル","アフガニスタン",
                "カンボジア","ネパール","東ティモール","ブータン","ブルネイ","ベトナム","ミャンマー","モルディブ","ラオス"};
        String EU[]={"アンギラ","アンティグア・バーブーダ","英領ヴァージン諸島","エルサルバドル",
                "オランダ領アンティール（ボネール、キュラサオ、サバ、セント・ユースタティウス及びセント・マルテン）及びアルバ","モルドバ",
                "ガドループ","キューバ","グアテマラ","グレナダ","ケイマン諸島","コスタリカ","ジャマイカ","セントクリストファー・ネイビス",
                "セントビンセント（グレナディーン諸島含む）","セントルシア","タークス及びカイコス諸島","トリニダード・トバゴ","ドミニカ","マケドニア旧ユーゴスラビア共和国",
                "ドミニカ共和国","ニカラグア","ハイチ","バミューダ諸島","バハマ","バルバドス","パナマ","ベリーズ","ホンジュラス","マルチニーク",
                "モントセラト","キリバス","クック諸島（ニュージーランド）","クリスマス島（オーストラリア）","ココス、キーリング諸島（オーストラリア）",
                "サモア","ソロモン","ツバル","トンガ","ナウル","ニュー・カレドニア","ノーフォーク島（オーストラリア）","バヌアツ","パプアニューギニア",
                "ピトアケン（オノエ、デュシー、ヘンダーソン含む）","フィジー","仏領ポリネシア","ワリス及びフツナ諸島","アルバニア","ポーランド",
                "南極におけるフランスの地域","フェロー島（デンマーク）", "ブルガリア","ボスニア・ヘルツェゴビナ","ルーマニア","ハンガリー","フィンランド",
                "イエメン","イラク","イラン","オマーン","カタール","キプロス","シリア","ヨルダン","レバノン","オーストラリア(ロード・ハウ島及び南極におけるオーストラリアの地域含む"
        };
        String Africa[]={"アルゼンチン","コロンビア","チリ","ブラジル","ペルー","アルジェリア","エジプト","ケニア","南アフリカ共和国"};
        Log.d("numberAJia", String.valueOf(Ajia.length));
        Log.d("numberAfrica", String.valueOf(Africa.length));
        Log.d("numberEU", String.valueOf(EU.length));
        for(int i=0;i<=14;i++){
            if(dataContent.equals("アジア")&&dataCountry.equals(Ajia[i])){
                SAL1ok=false;
            }
        }
        for(int i=0;i<=66;i++){
            if (dataContent == "北米、ヨーロッパ、オセアニア、中東" && dataCountry == EU[i]) {
                SAL1ok = false;
            }
        }

        for(int i=0;i<=8;i++){
            if(dataContent.equals("南米、アフリカ")&&dataCountry.equals(Africa[i])){
                SAL1ok=true;
                break;
            }else if(dataContent.equals("南米、アフリカ")&&!(dataCountry.equals(Africa[i]))){
                SAL1ok=false;
            }

        }
    }
    private void checkEMS(){
        String Ajia[]={"北朝鮮","パラオ","マーシャル","ミクロネシア","アフガニスタン","東ティモール"};
        String EU[]={"アンギラ","アンティグア・バーブーダ","英領ヴァージン諸島",
                "オランダ領アンティール（ボネール、キュラサオ、サバ、セント・ユースタティウス及びセント・マルテン）及びアルバ","グアテマラ","グレナダ",
                "ケイマン諸島","セントクリストファー・ネイビス","セントビンセント（グレナディーン諸島含む）","セントルシア","タークス及びカイコス諸島",
                "ドミニカ","ドミニカ共和国","ニカラグア","ハイチ","バミューダ諸島","バハマ","ベリーズ","モントセラト","キリバス","クック諸島（ニュージーランド）",
                "クリスマス島（オーストラリア）","ココス、キーリング諸島（オーストラリア）","サモア","ツバル","トンガ","ナウル","ニュー・カレドニア",
                "ノーフォーク島（オーストラリア）","バヌアツ","ピトアケン（オノエ、デュシー、ヘンダーソン含む）","仏領ポリネシア","ワリス及びフツナ諸島",
                "アルバニア","アルメニア","ウズベキスタン","カザフスタン","","グリーンランド（デンマーク）","コソボ","ジブラルタル","ジョージア",
                "セルビア","タジキスタン","トルクメニスタン","南極におけるフランスの地域","バチカン",
                "フェロー島（デンマーク）","北方諸島（歯舞群島、色丹島、国後島、択捉島）","ボスニア・ヘルツェゴビナ","モルドバ","モンテネグロ","イエメン"};

        String Africa[]={"ガイアナ","スリナム","フォークランド諸島（マルヴィナス諸島）","ボリビア","アセンション","アンゴラ","エリトリア","カーボヴェルテ",
                "カメルーン","ガンビア","ギニア","ギニアピサウ","コモロ","コンゴ共和国","コンゴ民主共和国","サントメ・プリンシペ","ザンビア","スワジランド",
                "セーシェル（アルダブラ、デロシュ及びファークァーの諸島含む）","赤道ギニア","セント・ヘレナ","ソマリア","チャド","中央アフリカ",
                "トリスタン・ダ・クーニャ","ナミビア","ニジェール","ブルキナファソ","ブルンジ","ベナン","マラウイ","マリ","南スーダン","モーリタニア",
                "モザンビーク","リビア","リベリア","レソト","レユニオン"};

        Log.d("numberAJia", String.valueOf(Ajia.length));
        Log.d("numberAfrica", String.valueOf(Africa.length));
        Log.d("numberEU", String.valueOf(EU.length));



        for(int i=0;i<=5;i++){
            if(dataContent.equals("アジア")&&dataCountry.equals(Ajia[i])) {
                EMSok = false;
            }
        }

        for(int i=0;i<=52;i++){
            if(dataContent.equals("北米、ヨーロッパ、オセアニア、中東")&&dataCountry.equals(EU[i])) {
                EMSok = false;
            }
        }

        for(int i=0;i<=38;i++){
            if(dataContent.equals("南米、アフリカ")&&dataCountry.equals(Africa[i])) {
                EMSok = false;
            }
        }

    }
    private void checkAIR(){
        if(dataCountry.equals("アセンション")){
            AIRok=false;
        }
    }
    private void checkEpacketLight(){
        String Ajia[]={"グアム","サイパン","韓国","台湾","中国","フィリピン","香港","インドネシア","シンガポール","タイ","ベトナム","マレーシア"};
        String EU[]={"アメリカ合衆国","カナダ","メキシコ","オーストラリア(ロード・ハウ島及び南極におけるオーストラリアの地域含む）",
                "ニュージーランド（ニウェ、トークラウ諸島及びロス含む）","アイルランド","イタリア","英国（ガーンジー、マン島及びジャージーを含む。）",
                "オーストリア","オランダ領","ギリシャ","スイス","スウェーデン","スペイン","ドイツ","ベルギー","ノルウェー","ハンガリー",
                "フィンランド","フランス（コルシカ、アンドラ及びマイヨットを含む。）","ポーランド","ポルトガル","ロシア","イスラエル","トルコ"};

        String Africa="ブラジル";

        Log.d("numberAJia", String.valueOf(Ajia.length));
        Log.d("numberEU", String.valueOf(EU.length));

        for(int i=0;i<=11;i++){
            if(dataContent.equals("アジア")&&dataCountry.equals(Ajia[i])) {
                EpacketLightok = true;
                break;
            }else if(dataContent.equals("アジア")&&!(dataCountry.equals(Ajia[i]))) {
                EpacketLightok = false;
            }
        }

        for(int i=0;i<=24;i++){
            if(dataContent.equals("北米、ヨーロッパ、オセアニア、中東")&&dataCountry.equals(EU[i])) {
                EpacketLightok = true;
                break;
            }else if(dataContent.equals("北米、ヨーロッパ、オセアニア、中東")&&!(dataCountry.equals(EU[i]))) {
                EpacketLightok = false;
            }
        }


            if(dataContent.equals("南米、アフリカ")&&dataCountry.equals(Africa)) {
                EpacketLightok = true;
            }else if(dataContent.equals("南米、アフリカ")&&!(dataCountry.equals(Africa))){
                EpacketLightok = false;
        }

    }
    private void checkEpacket(){
        String Ajia[]={"グアム","サイパン","韓国","台湾","中国","フィリピン","香港","インドネシア","シンガポール","タイ","ベトナム","マレーシア",
                "マーシャル","マカオ","ミクロネシア","モンゴル","インド","カンボジア","スリランカ","ネパール","バングラデシュ","パキスタン",
                "ブータン","ブルネイ","ミャンマー","モルディブ","ラオス"};

        String EU[]={"アメリカ合衆国の海外領土（２）プエルト・リコ、サモア及び米領ヴァージン諸島","アンギラ","アンティグア・バーブーダ","英領ヴァージン諸島",
                "オランダ領アンティール（ボネール、キュラサオ、サバ、セント・ユースタティウス及びセント・マルテン）及びアルバ","グアテマラ","グレナダ",
                "ケイマン諸島","セントクリストファー・ネイビス","セントビンセント（グレナディーン諸島含む）","セントルシア","タークス及びカイコス諸島",
                "ドミニカ","ドミニカ共和国","ニカラグア","ハイチ","バミューダ諸島","バハマ","ベリーズ","モントセラト","キリバス","クック諸島（ニュージーランド）",
                "クリスマス島（オーストラリア）","ココス、キーリング諸島（オーストラリア）","サモア","ツバル","トンガ","ナウル","ニュー・カレドニア",
                "ノーフォーク島（オーストラリア）","バヌアツ","ピトアケン（オノエ、デュシー、ヘンダーソン含む）","仏領ポリネシア","ワリス及びフツナ諸島",
                "アルバニア","アルメニア","ウズベキスタン","グリーンランド（デンマーク）","コソボ","ジブラルタル","ジョージア",
                "セルビア","タジキスタン","トルクメニスタン","南極におけるフランスの地域","バチカン",
                "フェロー島（デンマーク）","北方諸島（歯舞群島、色丹島、国後島、択捉島）","ボスニア・ヘルツェゴビナ","モルドバ","モンテネグロ","イエメン"};

        String Africa[]={"ガイアナ","シエラレオネ","スリナム","フォークランド諸島（マルヴィナス諸島）","ボリビア","アセンション","アンゴラ","エリトリア","カーボヴェルテ",
                "カメルーン","ガンビア","ギニア","ギニアピサウ","コモロ","コンゴ共和国","コンゴ民主共和国","サントメ・プリンシペ","ザンビア","スワジランド",
                "セーシェル（アルダブラ、デロシュ及びファークァーの諸島含む）","赤道ギニア","セント・ヘレナ","ソマリア","チャド","中央アフリカ",
                "トリスタン・ダ・クーニャ","ナミビア","ニジェール","ブルキナファソ","ブルンジ","ベナン","マラウイ","マリ","南スーダン","モーリタニア",
                "モザンビーク","リビア","リベリア","レソト","レユニオン"};

        Log.d("numberAJia", String.valueOf(Ajia.length));
        Log.d("numberAfrica", String.valueOf(Africa.length));
        Log.d("numberEU", String.valueOf(EU.length));

        for(int i=0;i<=26;i++){
            if(dataContent.equals("アジア")&&dataCountry.equals(Ajia[i])) {
                Epacketok = true;
                break;
            }else if(dataContent.equals("アジア")&&!(dataCountry.equals(Ajia[i]))) {
                Epacketok = false;
            }
        }

        for(int i=0;i<=51;i++){
            if(dataContent.equals("北米、ヨーロッパ、オセアニア、中東")&&dataCountry.equals(EU[i])) {
                Epacketok = false;
            }
        }

        for(int i=0;i<=39;i++){
            if(dataContent.equals("南米、アフリカ")&&dataCountry.equals(Africa[i])) {
                Epacketok = false;
            }
        }

    }

    private void checkHunabinmoney(){
        Log.d("weight", String.valueOf(weight));
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
                if (weight<=1250) {
                    howEpacketLight=1340;
                    break;
                }
                if (weight<=1500) {
                    howEpacketLight=1560;
                    break;
                }
                if (weight<=1750) {
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
                if (weight<=1250) {
                    howEpacketLight=1840;
                    break;
                }
                if (weight<=1500) {
                    howEpacketLight=2160;
                    break;
                }
                if (weight<=1750) {
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
                if (weight<=1250) {
                    howEpacketLight=1590;
                    break;
                }
                if (weight<=1500) {
                    howEpacketLight=1860;
                    break;
                }
                if (weight<=1750) {
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
                if (weight<=1250) {
                    howEms=3650;
                    break;
                }
                if (weight<=1500) {
                    howEms=4100;
                    break;
                }
                if (weight<=1750) {
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
                if (weight<=1250) {
                    howEms=4900;
                    break;
                }
                if (weight<=1500) {
                    howEms=5700;
                    break;
                }
                if (weight<=1750) {
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
                if (weight <= 1250) {
                    howEms = 2400;
                    break;
                }
                if (weight <= 1500) {
                    howEms = 2700;
                    break;
                }
                if (weight <= 1750) {
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
