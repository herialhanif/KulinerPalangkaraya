package madedicoding.alhanifdev.net.kulinerpalangkaraya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Kuliner> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        //requestWindowFeature(getWindow().FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_main);
        //getActionBar().hide();
        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        //Mengambil data kuliner dari Data Kuliner
        list = new ArrayList<>();
        list.addAll(DataKuliner.getListData());

        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewKulinerAdapter cardViewKulinerAdapter = new CardViewKulinerAdapter(this);

        //Menampilkan data kuliner pada cardview
        cardViewKulinerAdapter.setListKuliner(list);
        rvCategory.setAdapter(cardViewKulinerAdapter);
    }
}
