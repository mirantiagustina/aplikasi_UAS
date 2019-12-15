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

public class menu_daftar_olahraga extends AppCompatActivity {

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
                R.mipmap.yoga,
                R.mipmap.berenang,
                R.mipmap.naik_tangga,
                R.mipmap.lompat,
                R.mipmap.sepeda,
                R.mipmap.sit_up,
                R.mipmap.push_up};

        NamaItem 	= new String[]{
                "Yoga",
                "Renang ",
                "Naik Turun Tangga",
                "Lompat Tali",
                "Bersepeda",
                "Sit Up",
                "Push Up"};

        HargaItem 	= new String[]{
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  "};

        Deskripsi 	= new String[]{
                "Faktanya, yoga, jika dilakukan secara rutin dan benar, bisa membakar lemak secara menyeluruh dan membuat bentuk tubuh lebih indah. Semakin rumit dan menantang posenya, semakin banyak juga lemak yang dibakar. Kunci saat melakukan yoga adalah mengatur pernapasan dengan benar. " +
                        "Mengambil napas dalam-dalam dan panjang dapat membantu meningkatkan konsentrasi saat melakukan yoga.",

                "Berenang dapat membangun kekuatan tubuh. Sebab, untuk bergerak di dalam air, seseorang membutuhkan tenaga yang lebih kuat. Lebih jauh lagi," +
                        " berenang adalah olah fisik yang akan melatih semua kelompok otot utama, dari bahu, punggung, panggul, bokong, hingga kaki.",

                "Jenis olahraga yang satu ini merupakan deskripsi yang sangat tepat untuk menggambarkan olahraga ringan yang dapat dilakukan di pagi hari. Untuk dapat melakukan naik turun tangga, anda hanya perlu melakukan " +
                        "peregangan beberapa saat sebelum menaiki dan menuruni tangga di rumah anda. Lakukan hal ini di pagi hari bahkan sebelum orang rumah anda terbangun, agar tidak ada yang mengganggu olahraga anda. Bagi anda yang tidak memiliki tangga dapat" +
                        " memanfaatkan permukaan yang lebih tinggi di rumah untuk dinaik turunkan bergantian, seakan-akan tangga.",

                "olahraga skipping membutuhkan stamina yang kuat. Namun, tidak berarti anda harus menjauhinya. Karna stamina anda pun dapat sedikit demi sedikit terlatih dengan kuat," +
                        "jika ada rutin melakukan skipping. Olahraga ini tergolong ringan karena dapat anda lakukan di mana saja, bahkan tanpa perlu keluar dari kamar. Jangan lupa untuk menyiapkan tali skipping anda. Variasi berbagai gerakan lompat tali pun diketahui dapat menambah " +
                        "efektif hasil dari olahraga pagi yang anda lakukan. Jadi silahkan mencoba skipping menjadi olahraga pagi anda. ",

                "Bersepeda merupakan jenis olahraga yang paling ringan di masa sekarang ini. Tidak membutuhkan biaya yang banyak dan hanya memerlukan waktu beberapa menit, membuat olahraga bersepda menjadi pilihan idaman olahraga pagi masyarakat saat ini. " +
                        "Tips untuk anda yang ingin melakukan olahraga bersepeda, pilihlah jalur yang tidak banyak kendaraan bermotornya. Hal ini akan membuat anda lebih nyaman dalam bersepeda dan tidak perlu lagi menghabiskan banyak waktu" +
                        " untuk bermacet-macetan dengan motor dan mobil lainnya. Tubuh anda pun dapat terbakar kalorinya dengan maksimal.",

                "Olahraga sit up ini diketahui ampuh untuk membakar kalori, khususnya di bagian tubuh sekitar perut. Bagi anda yang tidak ingin berlama-lama berolahraga, sit up pun merupakan salah satu pilihan yang paling tepat. " +
                        "Sit up dapat melatih tubuh anda menjadi lebih sehat dan membuatnya memiliki bentuk tubuh yang lebih ideal. Lakukanlah sit up ini dengan rutin setiap paginya. Lakukanlah minimal 30 banyaknya dalam hitungan waktu 5 sampai 10 menit." +
                        "Ketika semakin terbiasa, tambahkanlah kuantitas sit up anda menjadi lebih banyak setiap waktunya.",

                "Pada kenyataannya, olahraga ini memang tidak terlalu berat. Hanya perlu beberapa menit saja untuk membakar kalori dengan melakukan push up. Selain itu, olahraga ini pun dapat bermanfaat untuk melatih stamina anda. " +
                        "Sehingga anda pun dapat menjadi lebih semangat dan segar dalam menjalani hari. " +
                        "Anda perlu menyiapkan alas olahraga seperti karpet olahraga dan lakukanlah push up di atasnya. Jika dibutuhkan, mintalah bantuan seseorang untuk menghitung timer berapa banyak push up yang dapat anda lakukan dalam satu hitungan waktu. " +
                        "Jadi, anda pun dapat semakin termotivasi untuk rutin melakukan push up setiap harinya."};


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
