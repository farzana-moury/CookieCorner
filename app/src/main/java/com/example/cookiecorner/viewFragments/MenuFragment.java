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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cookiecorner.R;
import com.example.cookiecorner.ShoppingCart;
import com.example.cookiecorner.pojo.CookieMenuItem;

import java.util.ArrayList;

import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TITLE = "TITLE";
    private static final String IMAGE = "IMAGE";
    private static final String DESC = "DESC";
    private static final String PRICE = "PRICE";

    public static int cookiePosition = 0;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        final ListView listView = view.findViewById(R.id.menuList);

        final ArrayList<CookieMenuItem> menu = ShoppingCart.menu;

        listView.setAdapter(new CustomListViewAdapter(getContext(), menu));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();

                bundle.putString(TITLE, menu.get(position).getName());
                bundle.putInt(IMAGE, menu.get(position).getImage());
                bundle.putDouble(PRICE, menu.get(position).getPrice());
                bundle.putString(DESC, menu.get(position).getDescription());

                Navigation.findNavController(view).navigate(R.id.action_nav_menu_to_cookieInfoFragment, bundle);

                cookiePosition = position;
            }
        });

        return view;
    }

    public class CustomListViewAdapter extends ArrayAdapter<CookieMenuItem> {

        //CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), itemArrayList)
        public CustomListViewAdapter(@NonNull Context context, ArrayList<CookieMenuItem> items) {
            super(context, 0, items);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_listview, parent, false);

                //populating the textviews with the passed in values from the CookieMenuItem class
                TextView name = convertView.findViewById(R.id.menuName);
                name.setText(getItem(position).getName());

                TextView price = convertView.findViewById(R.id.menuPrice);
                price.setText("$ " + getItem(position).getPrice());
            }
            return convertView;
        }
    }



}