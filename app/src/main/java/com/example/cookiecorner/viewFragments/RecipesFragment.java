package com.example.cookiecorner.viewFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cookiecorner.R;
import com.example.cookiecorner.pojo.RecipeItem;

import java.util.ArrayList;

import static com.example.cookiecorner.MainActivity.fab;

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

    private static final String TITLE = "TITLE";
    private static final String IMAGE = "IMAGE";
    private static final String DURATION = "DURATION";
    private static final String CALORIES = "CALORIES";
    private static final String INSTRUCTIONS = "INSTRUCTIONS";

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
        fab.hide();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        final ListView listView = view.findViewById(R.id.recipeList);

        final ArrayList<RecipeItem> recipes = new ArrayList<>();

        recipes.add(new RecipeItem("Flaky Puff Pastry", R.drawable.recipe1,
                "3h 40m", "418 cal",
                "Ingredients\n\n• Flour\n• Salt\n• Butter \n• Water\n• Sugar" +
                "\n\n\nInstructions\n\n1. Combine flour and salt in a big bowl with a whisk until even mixture is obtained" +
                        "\n\n2. Get your cold butter and slice into thin pieces before tossing into mixture. Each slice shouldn't be thicker than 1/4 inch." +
                        "\n\n3. Pour cold water into mixture and stir everything together until the dough forms a ball. Don't worry about the butter chunks." +
                        "\n\n4. Flatten the dough into a disk shape, before popping it into the freezer for 1 hour." +
                        "\n\n5. Once it's cool, dust your work surface and roll the dough into a flat rectangle." +
                        "\n\n6. Fold the rectangle into thirds, like you do a letter. Repeat this process as many times to get as many layers." +
                        "\n\n7. Put the puff pastry back in the freezer for 20-30 min." +
                        "\n\n8. Preheat the oven to 230˚  C." +
                        "\n\n9. Once it's cool, take out the pastry and roll it into a thickness of about 1/8 inch." +
                        "\n\n10. Fold your pastry into whatever shape you want into a baking tray. MAKE SURE your pastry dough is cold" +
                        "\n\n11. Put the tray into the oven for about 10 minutes. The layers should rise and dough turn golden and crispy. " +
                        "\n\n12. Enjoy!"));

//        recipes.add(new RecipeItem("recipe2", R.drawable.logo,
//                "2h 00m", "350 cal", "1. Mix dough\n2. Mix dry ingredients with wet ingredients\n3. Bake 350° for 30 min\n4. Enjoy!"));
//
//        recipes.add(new RecipeItem("recipe3", R.drawable.logo,
//                "1h 20m", "150 cal", "1. Mix dough\n2. Mix dry ingredients with wet ingredients\n3. Bake 350° for 30 min\n4. Enjoy!"));
//
//        recipes.add(new RecipeItem("recipe4", R.drawable.logo,
//                "2h 15m", "100 cal", "1. Mix dough\n2. Mix dry ingredients with wet ingredients\n3. Bake 350° for 30 min\n4. Enjoy!"));
//
//        recipes.add(new RecipeItem("recipe5", R.drawable.logo,
//                "1h 30m", "200 cal", "1. Mix dough\n2. Mix dry ingredients with wet ingredients\n3. Bake 350° for 30 min\n4. Enjoy!"));


        listView.setAdapter(new CustomListViewAdapter(getContext(), recipes));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();

                bundle.putString(TITLE, recipes.get(position).getName());
                bundle.putInt(IMAGE, recipes.get(position).getImage());
                bundle.putString(DURATION, recipes.get(position).getDuration());
                bundle.putString(CALORIES, recipes.get(position).getCalories());
                bundle.putString(INSTRUCTIONS, recipes.get(position).getInstructions());

                Navigation.findNavController(view).navigate(R.id.action_nav_recipes_to_recipeInfoFragment, bundle);
            }
        });

        return view;
    }

    public class CustomListViewAdapter extends ArrayAdapter<RecipeItem> {

        //CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), itemArrayList)
        public CustomListViewAdapter(@NonNull Context context, ArrayList<RecipeItem> items) {
            super(context, 0, items);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.recipes_listview, parent, false);

                //populating the textviews with the passed in values from the CookieMenuItem class
                TextView name = convertView.findViewById(R.id.recipeName);
                name.setText(getItem(position).getName());

                ImageView image = convertView.findViewById(R.id.recipeImage);
                image.setImageResource(getItem(position).getImage());

                TextView duration = convertView.findViewById(R.id.duration);
                duration.setText(getItem(position).getDuration());

                TextView calories = convertView.findViewById(R.id.calories);
                calories.setText("" + getItem(position).getCalories());
            }
            return convertView;
        }
    }
}