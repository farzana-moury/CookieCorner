package com.example.cookiecorner.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.cookiecorner.R;
import com.example.cookiecorner.pojo.RecipeItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecipesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipesFragment newInstance(String param1, String param2) {
        RecipesFragment fragment = new RecipesFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        final ListView listView = view.findViewById(R.id.recipeList);

        final ArrayList<RecipeItem> recipes = new ArrayList<>();

        recipes.add(new RecipeItem("recipe1", R.drawable.logo,
                "Calories: 100 \nDuration: 1 h \nPrep: 30 min \nBake: 30 min", "• flour\n• brown sugar\n• chocolate chips",
                        "1. Mix dough\n2. Mix dry ingredients with wet ingredients\n3. Bake 350° for 30 min\n4. Enjoy!"));

        recipes.add(new RecipeItem("recipe2", R.drawable.logo,
                "Calories: 100 \nDuration: 1 h \nPrep: 30 min \nBake: 30 min", "• flour\n• brown sugar\n• chocolate chips",
                "1. Mix dough\n2. Mix dry ingredients with wet ingredients\n3. Bake 350° for 30 min\n4. Enjoy!"));

        recipes.add(new RecipeItem("recipe3", R.drawable.logo,
                "Calories: 100 \nDuration: 1 h \nPrep: 30 min \nBake: 30 min", "• flour\n• brown sugar\n• chocolate chips",
                "1. Mix dough\n2. Mix dry ingredients with wet ingredients\n3. Bake 350° for 30 min\n4. Enjoy!"));

        recipes.add(new RecipeItem("recipe4", R.drawable.logo,
                "Calories: 100 \nDuration: 1 h \nPrep: 30 min \nBake: 30 min", "• flour\n• brown sugar\n• chocolate chips",
                "1. Mix dough\n2. Mix dry ingredients with wet ingredients\n3. Bake 350° for 30 min\n4. Enjoy!"));

        recipes.add(new RecipeItem("recipe5", R.drawable.logo,
                "Calories: 100 \nDuration: 1 h \nPrep: 30 min \nBake: 30 min", "• flour\n• brown sugar\n• chocolate chips",
                "1. Mix dough\n2. Mix dry ingredients with wet ingredients\n3. Bake 350° for 30 min\n4. Enjoy!"));

        listView.setAdapter(new CustomListViewAdapter(getContext(), recipes));

        return view;
    }
}