package com.example.cookiecorner.infoFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cookiecorner.R;

import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 27th 2020
 */
public class RecipeInfoFragment extends Fragment {

    // properties to hold each piece of information on a particular rating
    String title = "no_value";
    int image = R.drawable.logo;
    String duration = "no_value";
    String calories = "no_value";
    String instructions = "no_value";


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipeInfoFragment.
     */
    public static RecipeInfoFragment newInstance(String param1, String param2) {
        RecipeInfoFragment fragment = new RecipeInfoFragment();
        return fragment;
    }

    /**
     * This method is called when the Fragment is first created. Here we put initialization code.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            // retrieving the bundled data from the Recipe Fragment
            title = getArguments().getString("TITLE");
            image = getArguments().getInt("IMAGE");
            duration = getArguments().getString("DURATION");
            calories = getArguments().getString("CALORIES");
            instructions = getArguments().getString("INSTRUCTIONS");
        }
    }

    /**
     * This method is used to draw the Fragment UI -- the things to be viewed on screen
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
        View view = inflater.inflate(R.layout.fragment_recipe_info, container, false);

        // displaying each piece of information using the view objects
        TextView recipeTitle = view.findViewById(R.id.recipeTitle);
        recipeTitle.setText(title); // title of the recipe

        ImageView recipeImage = view.findViewById(R.id.recipePic);
        recipeImage.setImageResource(image); // recipe image

        TextView durationTime = view.findViewById(R.id.recipeDuration);
        durationTime.setText("Duration (prep + bake): " + duration); // duration

        TextView caloriesVal = view.findViewById(R.id.recipeCalories);
        caloriesVal.setText("Calories (per serving): " + calories); // calories

        TextView recipeInstruct = view.findViewById(R.id.recipeDesc);
        recipeInstruct.setText(instructions); // recipe instructions (includes ingredients too)

        return view;
    }
}