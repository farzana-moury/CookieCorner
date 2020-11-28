package com.example.cookiecorner.viewFragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookiecorner.R;
import com.example.cookiecorner.pojo.GalleryItem;

import java.util.ArrayList;

public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<GalleryRecyclerViewAdapter.CustomViewHolder> {

    private ArrayList<GalleryItem> images;

    public GalleryRecyclerViewAdapter(ArrayList<GalleryItem> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.gallery_recyclerview, null);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView image;

        public CustomViewHolder(@NonNull View itemView){
            super(itemView);

            this.image = itemView.findViewById(R.id.galleryImage);

        }
    }
}