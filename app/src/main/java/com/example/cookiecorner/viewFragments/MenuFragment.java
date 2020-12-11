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
import android.widget.ListView;
import android.widget.TextView;
import com.example.cookiecorner.R;
import com.example.cookiecorner.singleton.ShoppingCart;
import com.example.cookiecorner.pojo.CookieMenuItem;
import java.util.ArrayList;
import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 8th 2020
 */
public class MenuFragment extends Fragment {
    // constants to be used as keys in the bundle, representing each piece of info
    private static final String TITLE = "TITLE";
    private static final String IMAGE = "IMAGE";
    private static final String DESC = "DESC";
    private static final String PRICE = "PRICE";

    // property to store the index of the cookie in the list
    public static int cookiePosition = 0;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        // the listView to hold the arrayList
        final ListView listView = view.findViewById(R.id.menuList);

        // accessing the default menu from the Shopping Cart class
        final ArrayList<CookieMenuItem> menu = ShoppingCart.menu;

        // setting the adapter to the custom listView adapter we made earlier
        listView.setAdapter(new CustomListViewAdapter(getContext(), menu));

        // checking if any item in the list has been clicked. If so...
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // we will bundle up data to be transferred to the Cookie Info fragment
                Bundle bundle = new Bundle();

                bundle.putString(TITLE, menu.get(position).getName());
                bundle.putInt(IMAGE, menu.get(position).getImage());
                bundle.putDouble(PRICE, menu.get(position).getPrice());
                bundle.putString(DESC, menu.get(position).getDescription());

                //navigating to the cookie info fragment
                Navigation.findNavController(view).navigate(R.id.action_nav_menu_to_cookieInfoFragment, bundle);

                // setting the static variable cookiePosition to hold the position of the item
                cookiePosition = position;
            }
        });

        return view;
    }

    /**
     * Making a Custom ListView Adapter to contain elements of CookieMenuItem class
     *
     * @author Farzana Moury
     * @version 1.0
     * @since Nov 23rd 2020
    */
    public class CustomListViewAdapter extends ArrayAdapter<CookieMenuItem> {

        /**
         * CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), itemArrayList)
         * constructor.
         *
         * @param context context
         * @param items items
         */
        public CustomListViewAdapter(@NonNull Context context, ArrayList<CookieMenuItem> items) {
            super(context, 0, items);
        }

        /**
         * accessing the View object and setting its UI elements to the pieces of information
         *
         * @param position the position of the item
         * @param convertView the View to convert into
         * @param parent the ViewGroup parent
         * @return the converted view
         */
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