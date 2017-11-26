package madedicoding.alhanifdev.net.kulinerpalangkaraya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailKuliner extends AppCompatActivity {
    public static final String EXTRA_NAMA= "extra_name";
    public static final String EXTRA_KETERANGAN = "extra_keterangan";
    public static final String EXTRA_FOTO= "extra_foto";
    public static final String EXTRA_DETAIL= "extra_detail";
    TextView tvNamaKuliner, tvDetilKuliner;
    ImageView fotoKuliner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kuliner);
        tvNamaKuliner = findViewById(R.id.tv_item_nama_kuliner);
        tvDetilKuliner = findViewById(R.id.tv_item_detail_kuliner);
        fotoKuliner =findViewById(R.id.img_item_photo_det);

        String namakuliner = getIntent().getStringExtra(EXTRA_NAMA);
        String detailkuliner = getIntent().getStringExtra(EXTRA_DETAIL);
        String foto = getIntent().getStringExtra(EXTRA_FOTO);

        tvNamaKuliner.setText(namakuliner);
        tvDetilKuliner.setText(detailkuliner);
        //Kuliner p = getListKuliner().get(position);
        Glide.with(DetailKuliner.this)
                .load(foto)
                .override(350, 550)
                .into(fotoKuliner);
    }
}
