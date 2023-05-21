package com.example.clubbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detailclub extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailclub);

        ImageView imgclub = findViewById(R.id.imgclub);
        TextView namaclub = findViewById(R.id.clubname);
        TextView detailclub = findViewById(R.id.clubdetail);

        club club = getIntent().getParcelableExtra(ITEM_EXTRA);
        if(club != null){
            Glide.with(this)
                    .load(club.getPhoto())
                    .into(imgclub);
            namaclub.setText(club.getName());
            detailclub.setText(club.getDetail());
        }
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("detail club");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


}