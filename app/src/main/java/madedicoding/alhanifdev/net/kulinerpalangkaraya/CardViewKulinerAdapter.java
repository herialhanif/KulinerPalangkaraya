package madedicoding.alhanifdev.net.kulinerpalangkaraya;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by STMIK PALANGKARAYA on 05/11/2017.
 */

public class CardViewKulinerAdapter extends RecyclerView.Adapter<CardViewKulinerAdapter.CardViewViewHolder> {
    private ArrayList<Kuliner> listKuliner;
    private Context context;

    public CardViewKulinerAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Kuliner> getListKuliner() {
        return listKuliner;
    }

    public void setListKuliner(ArrayList<Kuliner> listKuliner) {
        this.listKuliner = listKuliner;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_kuliner, parent ,false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {
        Kuliner p = getListKuliner().get(position);
        Glide.with(context)
                .load(p.getFoto())
                .override(350, 550)
                .into(holder.imgPhoto);
        holder.tvName.setText(p.getNama());
        holder.tvRemarks.setText(p.getKeterangan());
        holder.btnDetail.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

            //@Override
            public void onItemClicked(View view, int position) {
                //Toast.makeText(context, "Favorite " + getListKuliner().get(position).getNama(), Toast.LENGTH_SHORT).show();
                Intent detailIntent = new Intent(context, DetailKuliner.class);
                detailIntent.putExtra(DetailKuliner.EXTRA_NAMA, getListKuliner().get(position).getNama());
                detailIntent.putExtra(DetailKuliner.EXTRA_DETAIL, getListKuliner().get(position).getDetail());
                detailIntent.putExtra(DetailKuliner.EXTRA_FOTO, getListKuliner().get(position).getFoto());
                context.startActivity(detailIntent);
            }
        }));


    }

    @Override

    public int getItemCount() {
        return getListKuliner().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnDetail;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView) itemView.findViewById(R.id.tv_item_remarks);
            btnDetail = (Button) itemView.findViewById(R.id.btn_set_favorite);
        }
    }
}
