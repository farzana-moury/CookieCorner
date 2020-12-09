package com.example.cookiecorner.viewFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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
 */
public class GalleryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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