package com.example.cookiecorner.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cookiecorner.R;
import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 8th 2020
 */
public class HomeFragment extends Fragment {

    Animation imgAnim, titleAnim ,logoAnim; // animations
    ImageView image; // elements the animations will perform on
    LinearLayout title;
    ImageView logo;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        fab.hide();
        fab.setImageResource(R.drawable.ic_baseline_color_lens_24); // setting the image resource for the fab

        // performing the animations on the elements
        // image will fade in
        image = view.findViewById(R.id.homeImage);
        imgAnim = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
        image.startAnimation(imgAnim);

        // title and logo will come from the "corner"
        title = view.findViewById(R.id.logoContainer);
        titleAnim = AnimationUtils.loadAnimation(getContext(), R.anim.corner_entrance);
        title.startAnimation(titleAnim);

        logo = view.findViewById(R.id.logo);
        logoAnim = AnimationUtils.loadAnimation(getContext(), R.anim.corner_entrance);
        logo.startAnimation(logoAnim);


        // when the account button is pressed
        Button accountButton = view.findViewById(R.id.accountButton);
        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view)
                .navigate(R.id.action_nav_home_to_nav_account); // it will take you to the account fragment
            }
        });

        // when the menu button is pressed
        Button menuButton = view.findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view)
                        .navigate(R.id.action_nav_home_to_nav_menu); // it will take you to the menu fragment
            }
        });

        return view;
    }
}