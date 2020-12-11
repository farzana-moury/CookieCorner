package com.example.cookiecorner.viewFragments;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cookiecorner.R;
import com.example.cookiecorner.pojo.GalleryItem;
import java.util.ArrayList;
import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 28th 2020
 */
public class GalleryFragment extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        return fragment;
    }

    /**
     * This method is used to draw the Fragment UI -- the things to be viewed on screen
     *
     * @param inflater a system service that converts xml files into view objects
     * @param container the invisible container that holds View and ViewGroup
     * @param savedInstanceState a reference to a bundle object passed into the onCreate method
     * @return the view that holds all the viewable objects
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fab.hide();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        //reyclerView we are going to use
        RecyclerView recyclerView = view.findViewById(R.id.galleryRecyclerView);

        //list of gallery images
        ArrayList<GalleryItem> images = new ArrayList<>();

        //populating the images arrayList
        images.add(new GalleryItem(R.drawable.b));
        images.add(new GalleryItem(R.drawable.c1));
        images.add(new GalleryItem(R.drawable.c5));
        images.add(new GalleryItem(R.drawable.c3));
        images.add(new GalleryItem(R.drawable.c2));
        images.add(new GalleryItem(R.drawable.c7));
        images.add(new GalleryItem(R.drawable.c6));
        images.add(new GalleryItem(R.drawable.c8));
        images.add(new GalleryItem(R.drawable.c4));
        images.add(new GalleryItem(R.drawable.c9));

        //layout manager
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        //setting an adapter
        recyclerView.setAdapter(new GalleryRecyclerViewAdapter(images));

        return view;
    }
}