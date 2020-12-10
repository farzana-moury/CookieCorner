package com.example.cookiecorner.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.cookiecorner.R;
import static com.example.cookiecorner.MainActivity.fab;

/**
 * The Bakery Fragment
 * - holds the buttons that will take you to three other pages
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 8th 2020
 */
public class BakeryFragment extends Fragment {

    /**
     * This method is used to draw the Fragment UI -- the things to be viewed on screen
     *
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return the view that holds all the viewable objects
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fab.hide();

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_bakery, container, false);

        // when the gallery button is clicked
        Button galleryButton = view.findViewById(R.id.galleryButton);
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view)
                        .navigate(R.id.action_nav_bakery_to_galleryFragment); // it will take us to the gallery fragment
            }
        });

        //when the ratings button is clicked
        Button ratingsButton = view.findViewById(R.id.ratingsButton);
        ratingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view)
                        .navigate(R.id.action_nav_bakery_to_ratingsFragment); // it will take us to the ratings fragment
            }
        });

        //when the FAQ button is clicked
        Button faqButton = view.findViewById(R.id.faqButton);
        faqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view)
                        .navigate(R.id.action_nav_bakery_to_FAQFragment); // it will take us to the FAQ fragment
            }
        });

        return view;
    }
}