package com.example.cookiecorner.viewFragments;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cookiecorner.R;
import com.example.cookiecorner.pojo.GalleryItem;
import java.util.ArrayList;

/**
 * Adapter class that provides access to data items, making a View for each data item
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 28th 2020
 */
public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<GalleryRecyclerViewAdapter.CustomViewHolder> {

    // property to hold the RecyclerView list
    private ArrayList<GalleryItem> images;

    /**
     * constructor.
     * @param images the images in the gallery
     */
    public GalleryRecyclerViewAdapter(ArrayList<GalleryItem> images) {
        this.images = images;
    }

    /**
     * @param parent represents the parent ViewGroup
     * @param viewType represents the view type
     * @return the view holder
     */
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.gallery_recyclerview, null);

        return new CustomViewHolder(view);
    }

    /**
     * @param holder describes an item view and metadata about its place within the RecyclerView
     * @param position the position of the item
     */
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        GalleryItem galleryImage = images.get(position);
        holder.image.setImageResource(galleryImage.getImage());
    }

    /**
     * @return the size of the list
     */
    @Override
    public int getItemCount() {
        if(images != null){
            return images.size();
        }
        return 0;
    }

    /**
     * Making a Custom ViewHolder with RecyclerView and setting the UI objects to the data
     *
     * @author Farzana Moury
     * @version 1.0
     * @since Nov 28th 2020
     */
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView image;

        /**
         * @param itemView the item view
         */
        public CustomViewHolder(@NonNull View itemView){
            super(itemView);

            this.image = itemView.findViewById(R.id.galleryImage);

        }
    }
}