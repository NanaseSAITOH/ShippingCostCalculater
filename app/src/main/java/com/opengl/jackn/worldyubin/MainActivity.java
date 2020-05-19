package com.opengl.jackn.worldyubin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends Activity {

    boolean mainboolean=true;
    boolean esayboolean=false;

    String[] AjiaData = {"グアム","サイパン","ウェーキ","北マリアナ諸島","ミッドウェイ諸島",
            "韓国","北朝鮮","台湾","中国","パラオ","フィリピン","香港","マーシャル","マカオ",
            "ミクロネシア","モンゴル","アフガニスタン","インド","インドネシア","カンボジア",
            "シンガポール","スリランカ","タイ", "ネパール","バングラデシュ","パキスタン","東ティモール",
            "ブータン","ブルネイ","ベトナム","マレーシア","ミャンマー","モルディブ","ラオス",};

    String[] Africadata = {"ウルグアイ","エクアドル","ガイアナ","コロンビア","スリナム","チリ","パラグアイ",
            "フォークランド諸島（マルヴィナス諸島）","仏領ギアナ","ブラジル","ベネズエラ","ペルー","ボリビア",
            "アセンション","アルジェリア","アンゴラ","ウガンダ","エジプト","エチオピア","エリトリア","カーボヴェルテ",
            "カメルーン","ガーナ","ガボン","ガンビア","ギニア","ギニアピサウ","ケニア","コートジボワール","コモロ",
            "コンゴ共和国","コンゴ民主共和国","サントメ・プリンシペ","ザンビア","シエラレオネ","ジブチ","ジンバブエ",
            "スーダン","スワジランド","セーシェル（アルダブラ、デロシュ及びファークァーの諸島含む）","赤道ギニア",
            "セネガル","セント・ヘレナ","ソマリア","タンザニア（２）ザンジバル","タンザニア（１）","チャド",
            "中央アフリカ","チュニジア","トーゴ","トリスタン・ダ・クーニャ","ナイジェリア","ナミビア","ニジェール",
            "ブルキナファソ","ブルンジ","ベナン","ボツワナ","マダガスカル","マラウイ","マリ","南アフリカ共和国",
            "南スーダン","モーリシャス","モーリタニア","モザンビーク","モロッコ","リビア","リベリア","ルワンダ",
            "レソト","レユニオン"};

    String[] EUData = {"アメリカ合衆国","アメリカ合衆国の海外領土（２）プエルト・リコ、サモア及び米領ヴァージン諸島","アンギラ","アンティグア・バーブーダ",
            "英領ヴァージン諸島","エルサルバドル","オランダ領アンティール（ボネール、キュラサオ、サバ、セント・ユースタティウス及びセント・マルテン）及びアルバ ",
            "カナダ","ガドループ","キューバ","グアテマラ","グレナダ","ケイマン諸島","コスタリカ","サンピエール及びミクロン","ジャマイカ",
            "セントクリストファー・ネイビス","セントビンセント（グレナディーン諸島含む）","セントルシア","タークス及びカイコス諸島","トリニダード・トバゴ",
            "ドミニカ","ドミニカ共和国","ニカラグア","ハイチ","バミューダ諸島","バハマ","バルバドス","パナマ","ベリーズ","ホンジュラス","マルチニーク","メキシコ",
            "モントセラト","オーストラリア(ロード・ハウ島及び南極におけるオーストラリアの地域含む）","キリバス","クック諸島（ニュージーランド）",
            "クリスマス島（オーストラリア）","ココス、キーリング諸島（オーストラリア） ","サモア","ソロモン","ツバル","トンガ","ナウル","ニュー・カレドニア",
            "ニュージーランド（ニウェ、トークラウ諸島及びロス含む） ","ノーフォーク島（オーストラリア）","バヌアツ","パプアニューギニア",
            "ピトアケン（オノエ、デュシー、ヘンダーソン含む）","フィジー","仏領ポリネシア","ワリス及びフツナ諸島","アイスランド","アイルランド",
            "アゼルバイジャン","アルバニア","アルメニア","イタリア","ウクライナ","ウズベキスタン","英国（ガーンジー、マン島及びジャージーを含む。）",
            "エストニア","オーストリア","オランダ領","カザフスタン","キルギス ","ギリシャ","クロアチア","グリーンランド（デンマーク）","コソボ","サンマリノ",
            "ジブラルタル","ジョージア","スイス","スウェーデン","スペイン","スロバキア","スロベニア","セルビア","タジキスタン","チェコ","デンマーク",
            "トルクメニスタン","ドイツ","南極におけるフランスの地域","ノルウェー","ハンガリー","バチカン","フィンランド","フェロー島（デンマーク）",
            "フランス（コルシカ、アンドラ及びマイヨットを含む。）","ブルガリア","ベラルーシ","ベルギー","北方諸島（歯舞群島、色丹島、国後島、択捉島）",
            "ボスニア・ヘルツェゴビナ","ポーランド","ポルトガル","マケドニア旧ユーゴスラビア共和国","マルタ","モナコ","モルドバ","モンテネグロ","ラトビア",
            "リトアニア","リヒテンシュタイン","ルーマニア","ルクセンブルク","ロシア ",
            "アラブ首長国連邦（アブ・ダビ、アジュマン、デュバイ、フジャイラ、ラス・アル・カイマ、シャルジャ及びウンム・アル・カイワイン）",
            "イエメン","イスラエル","イラク","イラン","オマーン","カタール","キプロス","クウェート","サウジアラビア","シリア","トルコ","バーレーン",
            "ヨルダン","レバノン"};

    String dataContent;
    String dataCountry;
    int dataWeight;

    boolean bSAL;
    boolean bSAL1;
    boolean bAIR;
    boolean bEMS;
    boolean bEpacket;
    boolean bEpacketLight1;
    boolean bFunabin;

    int a=0,b=0,c=0,d=0,e=0,f=0,g=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tujo= (Button) findViewById(R.id.tujo);
        Button kantan= (Button) findViewById(R.id.kantan);
        Button information= (Button) findViewById(R.id.information);
        final CheckBox SAL1 = findViewById(R.id.checkBox);
        final CheckBox AIR = findViewById(R.id.checkBox2);
        final CheckBox SAL = findViewById(R.id.checkBox3);
        final CheckBox EMS = findViewById(R.id.checkBox4);
        final CheckBox Epacket = findViewById(R.id.checkBox5);
       final CheckBox EpacketLight = findViewById(R.id.checkBox6);
        final CheckBox Funabin = findViewById(R.id.checkBox7);


        setWeightSpinner();
        setContinentSpinnner();

        SAL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bSAL1=SAL1.isChecked();
            }
        });
        AIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bAIR=AIR.isChecked();

            }

        });
        SAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bSAL=SAL.isChecked();

            }


        });
        EMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bEMS=EMS.isChecked();


            }
        });
        Epacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bEpacket=Epacket.isChecked();
            }
        });
        EpacketLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bEpacketLight1=EpacketLight.isChecked();

            }
        });
        Funabin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bFunabin=Funabin.isChecked();

            }
        });

        tujo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mainboolean=true;
                esayboolean=false;
                LinearLayout layout = (LinearLayout)findViewById(R.id.main);

                // 内容を全部消す
                layout.removeAllViews();

                // test_sub.xmlに変更する
                getLayoutInflater().inflate(R.layout.activity_main2, layout);

                setup();
            }
        });

        kantan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainboolean=false;
                esayboolean=true;

                LinearLayout layout = (LinearLayout)findViewById(R.id.main);

                // 内容を全部消す
                layout.removeAllViews();

                // test_sub.xmlに変更する
                getLayoutInflater().inflate(R.layout.activity_kantan, layout);

                setup();

            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout layout = (LinearLayout)findViewById(R.id.main);

                // 内容を全部消す
                layout.removeAllViews();

                // test_sub.xmlに変更する
                getLayoutInflater().inflate(R.layout.activity_information, layout);

            }
        });

        Button mainsearch = findViewById(R.id.mainsearch);

        mainsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(), MainSearchActivity.class);
                intent.putExtra("DATA1", dataContent);
                intent.putExtra("DATA2", dataCountry);
                intent.putExtra("DATA3", dataWeight);

                intent.putExtra("EMS", bEMS);
                intent.putExtra("Epacket", bEpacket);
                intent.putExtra("EpacketLight", bEpacketLight1);
                intent.putExtra("SAL1", bSAL1);
                intent.putExtra("SAL", bSAL);
                intent.putExtra("AIR", bAIR);
                intent.putExtra("Funabin",bFunabin);
                startActivity(intent);

            }
        });

    }

    private void setContinentSpinnner(){
        // Adapterの作成
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Adapterにアイテムを追加
        adapter.add("アジア");
        adapter.add("北米、ヨーロッパ、オセアニア、中東");
        adapter.add("南米、アフリカ");
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// SpinnerにAdapterを設定
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Spinner spinner = (Spinner) parent;
                // 選択したアイテムを取得
                String item = (String) spinner.getSelectedItem();

                // ログで確認
                Log.v("spinner item", item);
                dataContent=item;
                if(mainboolean==true) {

                    if (item == "アジア") {
                        setAjiaSpinner();
                    }
                    if (item == "北米、ヨーロッパ、オセアニア、中東") {
                        setEUSpinner();
                    }
                    if (item == "南米、アフリカ") {
                        setAfricaSpinner();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setAjiaSpinner(){
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,AjiaData);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
// SpinnerにAdapterを設定
        spinner.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Spinner spinner = (Spinner) parent;
                // 選択したアイテムを取得
                String item = (String) spinner.getSelectedItem();

                // ログで確認
                Log.v("spinner item", item);
                dataCountry=item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setEUSpinner(){
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,EUData);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
// SpinnerにAdapterを設定
        spinner.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Spinner spinner = (Spinner) parent;
                // 選択したアイテムを取得
                String item = (String) spinner.getSelectedItem();

                // ログで確認
                Log.v("spinner item", item);
                dataCountry=item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setAfricaSpinner(){
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Africadata);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
// SpinnerにAdapterを設定
        spinner.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Spinner spinner = (Spinner) parent;
                // 選択したアイテムを取得
                String item = (String) spinner.getSelectedItem();

                // ログで確認
                Log.v("spinner item", item);
                dataCountry=item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private  void setWeightSpinner(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Adapterにアイテムを追加
        for(int i=50;i<=300;i=i+50) {
            adapter.add("～"+i+"g");
        }
        for(int i=400;i<=1200;i=i+100) {
            adapter.add("～"+i+"g");
        }
        for(int i=1250;i<=1250;i=i+100) {
            adapter.add("～"+i+"g");
        }
        for(int i=1300;i<=1700;i=i+100) {
            adapter.add("～"+i+"g");
        }
        for(int i=1750;i<=1750;i=i+100) {
            adapter.add("～"+i+"g");
        }
        for(int i=1800;i<=2000;i=i+100) {
            adapter.add("～"+i+"g");
        }
        Spinner spinner = (Spinner) findViewById(R.id.spinner3);
// SpinnerにAdapterを設定
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int a, long l) {
                Spinner spinner = (Spinner) parent;
                // 選択したアイテムを取得
                String item = (String) spinner.getSelectedItem();

                for(int i=50;i<=300;i=i+50) {
                    if(item.equals("～"+i+"g")){
                        dataWeight=i;
                    };
                }
                for(int i=400;i<=1200;i=i+100) {
                    if(item.equals("～"+i+"g")){
                        dataWeight=i;
                    };
                }
                for(int i=1250;i<=1250;i=i+100) {
                    if(item.equals("～"+i+"g")){
                        dataWeight=i;
                    };
                }
                for(int i=1300;i<=1700;i=i+100) {
                    if(item.equals("～"+i+"g")){
                        dataWeight=i;
                    };
                }
                for(int i=1750;i<=1750;i=i+100) {
                    if(item.equals("～"+i+"g")){
                        dataWeight=i;
                    };
                }
                for(int i=1800;i<=2000;i=i+100) {
                    if(item.equals("～"+i+"g")){
                        dataWeight=i;
                    };
                }

                Log.d("weight", item);

                Log.d("weight", String.valueOf(dataWeight));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setup(){

        Button mainsearch= findViewById(R.id.mainsearch);
        if(mainboolean==true) {
            final CheckBox SAL1 = findViewById(R.id.checkBox);
            final CheckBox AIR = findViewById(R.id.checkBox2);
            final CheckBox SAL = findViewById(R.id.checkBox3);
            final CheckBox EMS = findViewById(R.id.checkBox4);
            final CheckBox Epacket = findViewById(R.id.checkBox5);
            final CheckBox EpacketLight = findViewById(R.id.checkBox6);
            final CheckBox Funabin = findViewById(R.id.checkBox7);

            mainsearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bSAL1=SAL1.isChecked();
                    bAIR=AIR.isChecked();
                    bSAL=SAL.isChecked();
                    bEMS=EMS.isChecked();
                    bEpacket=Epacket.isChecked();
                    bEpacketLight1=EpacketLight.isChecked();
                    bFunabin=Funabin.isChecked();



                    Intent intent = new Intent(getApplication(), MainSearchActivity.class);
                    intent.putExtra("DATA1", dataContent);
                    intent.putExtra("DATA2", dataCountry);
                    intent.putExtra("DATA3", dataWeight);

                    intent.putExtra("EMS", bEMS);
                    intent.putExtra("Epacket", bEpacket);
                    intent.putExtra("EpacketLight", bEpacketLight1);
                    intent.putExtra("SAL1", bSAL1);
                    intent.putExtra("SAL", bSAL);
                    intent.putExtra("AIR", bAIR);
                    intent.putExtra("Funabin", bFunabin);
                    startActivity(intent);

                }
            });
        }

        if(esayboolean==true) {
            Button easysearch = findViewById(R.id.easysearch);
            easysearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplication(), EasySearchActivity.class);
                    intent.putExtra("DATA1", dataContent);
                    intent.putExtra("DATA3", dataWeight);
                    startActivity(intent);
                }
            });
        }
        setWeightSpinner();
        setContinentSpinnner();
    }


}
