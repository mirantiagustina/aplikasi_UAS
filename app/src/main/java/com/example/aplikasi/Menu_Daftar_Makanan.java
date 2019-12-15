package com.example.aplikasi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class Menu_Daftar_Makanan extends AppCompatActivity {

    ListView lvItem;
    EditText Edtcari;
    ListViewAdapterCall adapter;
    ArrayList<ListViewAdapterMenu> arraylist = new ArrayList<ListViewAdapterMenu>();

    int[] Gambar;
    String[] NamaItem;
    String[] HargaItem;
    String[] Deskripsi;
    String[] NomorHP;
    String[] Lat;
    String[] Long;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_daftar);

        lvItem		= (ListView)findViewById(R.id.listView1);
        Edtcari     = (EditText)findViewById(R.id.editText1);


        Gambar		= new int[]{
                R.mipmap.sayur,
                R.mipmap.buah,
                R.mipmap.kedelai,
                R.mipmap.outmeal,
                R.mipmap.susu,
                R.mipmap.salmon,
                R.mipmap.yogurt};

        NamaItem 	= new String[]{
                "Sayur Sayuran",
                "Buah Buahan",
                "Kedelai hitam",
                "Oatmeal ",
                "susu",
                "Salmon",
                "Yogurt"};

        HargaItem 	= new String[]{
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  "};

        Deskripsi 	= new String[]{
                "Sayuran hijau memiliki kandungan serat yang tinggi, serta kaya akan vitamin dan mineral. Jadi, tidak heran jika sayuran hijau merupakan salah satu jenis makanan yang paling sering dianjurkan dokter, karena memang ada banyak sekali manfaat sayuran hijau untuk kesehatan.\n" +
                        "\n" +
                        "Sayuran hijau merupakan kelompok makanan yang kaya nutrisi, tidak sulit dicari, relatif murah, pengolahannya mudah, dan dapat divariasikan menjadi beragam menu masakan. " +
                        "Hal-hal ini merupakan alasan yang kuat untuk memasukkan sayuran hijau ke dalam pola makan Anda sehari-hari.",

                "seluruh buah buahan baik untuk balita dan anak anak. sebab didalamnya mengandunng banyak vitamin, mineral, serat," +
                        "dan nutrisi lainnya. Berikan balita dan anak anak buah buahan setiap hari untuk mendapatkan nutrisi itu.",

                "kedelai adalah sumber protein, serat, dan kalsium yang baik. sebaiknya pilih kedelai hitam dengan khasiat pencegah " +
                        "penyakit jantung dan kolestrol ",

                "sebuah penelitian pernah menyebutkan kalau balita dan anak anak yang makan oatmeal lebih mampu berkonsentrasi" +
                        "dan penuh perhatian ketika di seklah. Oatmeal juga kaya serat yang baik bagi pencernaan.",

                "Protein dan Kalsium pada susu adalah sumber energi bagi otak dan tubuh. Protein membantu tubuh membentuk" +
                        "jaringan otak, sementara kalsium menjaga kekuatan tulang dan gigi.",

                "Kandungan asam lemak omega-3 pada salmon menjadikan ikan tersebut sebagai makanan wajib konsumsi untuk balita dan anak anak" +
                        "khasiatnya adalah untuk menjaga perkembangan otak, mencegah depresi, dan menurunkan resiko inflasi.",

                "Cemilan lain yang lezat sekaligus bergizi untuk balita dan anak anak adalah yogurt. yogurt mempunyai khasiat meningkaykan" +
                        "sistem kekebalan tubuh dan menjaga kesehatan pencernaan karena ada bakteri baik di dalamnya. "};


        //Nomor HP harus dimulai dengan kode negara yaitu : +62
        NomorHP  = new String[]{
                "+6281278977788",
                "+6281324607225",
                "+6281615444433",
                "+6281324607225",
                "+6281324607225",
                "+6281535224733",
                "+6281324607225"
        };

        Lat  = new String[]{
                "-2.9771237",
                "-2.969675",
                "-3.0000124",
                "-2.9913172",
                "-2.9801306",
                "-2.9913172",
                "-2.9670725"
        };

        Long  = new String[]{
                "104.7573521",
                "104.7318573",
                "104.7593849",
                "104.7516047",
                "104.7693137",
                "104.7450386",
                "104.741623"
        };




        for (int i = 0; i < NamaItem.length; i++)
        {
            ListViewAdapterMenu wp = new ListViewAdapterMenu(NamaItem[i], HargaItem[i], Deskripsi[i], Gambar[i], NomorHP[i], Lat[i], Long[i]);
            arraylist.add(wp);
        }

        adapter = new ListViewAdapterCall(this, arraylist);
        lvItem.setAdapter(adapter);

        Edtcari.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                String text = Edtcari.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage("Pencarian dilakukan");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
        });

    }

    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
