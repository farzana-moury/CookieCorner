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
 */
public class RecipeInfoFragment extends Fragment {

    String title = "no_value";
    int image = R.drawable.logo;
    String duration = "no_value";
    String calories = "no_value";
    String instructions = "no_value";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecipeInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipeInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeInfoFragment newInstance(String param1, String param2) {
        RecipeInfoFragment fragment = new RecipeInfoFragment();
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

            title = getArguments().getString("TITLE");
            image = getArguments().getInt("IMAGE");
            duration = getArguments().getString("DURATION");
            calories = getArguments().getString("CALORIES");
            instructions = getArguments().getString("INSTRUCTIONS");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fab.hide();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_info, container, false);

        TextView recipeTitle = view.findViewById(R.id.recipeTitle);
        recipeTitle.setText(title);

        ImageView recipeImage = view.findViewById(R.id.recipePic);
        recipeImage.setImageResource(image);

        TextView durationTime = view.findViewById(R.id.recipeDuration);
        durationTime.setText("Duration (prep + bake time): " + duration);

        TextView caloriesVal = view.findViewById(R.id.recipeCalories);
        caloriesVal.setText("Calories (per cookie): " + calories);

        TextView recipeInstruct = view.findViewById(R.id.recipeDesc);
        recipeInstruct.setText(instructions);

        return view;
    }
}