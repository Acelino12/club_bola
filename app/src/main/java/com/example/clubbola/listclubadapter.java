package com.example.clubbola;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class listclubadapter extends RecyclerView.Adapter<listclubadapter.ListViewHolder> {

    private ArrayList<club> listclub;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }


    public listclubadapter(ArrayList<club> list){
        this.listclub = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_club, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        club club = listclub.get(position);
        Glide.with(holder.itemView.getContext())
                .load(club.getPhoto())
                .apply(new RequestOptions().override(60,60))
                .into(holder.imgphoto);
        holder.tvname.setText(club.getName());
        holder.tvditail.setText(club.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listclub.get(holder.getAbsoluteAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listclub.size();
    }



    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgphoto;
        TextView tvname;
        TextView tvditail;

        public ListViewHolder(View itemview) {
            super(itemview);
            imgphoto = itemview.findViewById(R.id.gambar);
            tvditail = itemview.findViewById(R.id.tv_ditail);
            tvname = itemview.findViewById(R.id.tv_item_name);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(club club);
    }

}
