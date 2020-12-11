package com.example.cookiecorner.viewFragments;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Use the {@link OrdersFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 8th 2020
 */
public class OrdersFragment extends Fragment {

    // properties
    CustomListViewAdapter adapter;
    public ArrayList<CookieMenuItem> orders;
    public ListView listView;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrdersFragment.
     */
    public static OrdersFragment newInstance(String param1, String param2) {
        OrdersFragment fragment = new OrdersFragment();
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
        final View view = inflater.inflate(R.layout.fragment_orders, container, false);

        // the listView to hold the arrayList
        listView = view.findViewById(R.id.ordersList);

        fab.show();

        // accessing the same shopping list that will contain the orders
        orders = ShoppingCart.getInstance().getShoppingList();

        // setting the adapter to the custom listView adapter we made earlier
        adapter = new OrdersFragment.CustomListViewAdapter(getContext(), orders);

        // refreshing the orders list
        adapter.notifyDataSetChanged(); // letting the adapter know we removed an item (refreshes the view)
        listView.setAdapter(adapter); // setting the adapter to the listview

        return view;
    }

    /**
     * Making a Custom ListView Adapter to contain elements of CookieMenuItem class
     *
     * @author Farzana Moury
     * @version 1.0
     * @since Nov 30th 2020
     */
    public class CustomListViewAdapter extends ArrayAdapter<CookieMenuItem> {

        /**
         * CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), itemArrayList)
         *
         * @param context context
         * @param items items
         */
        public CustomListViewAdapter(@NonNull Context context, ArrayList<CookieMenuItem> items) {
            super(context, 0, orders);
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
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.orders_listview, parent, false);

                //populating the textviews with the passed in values from the CookieMenuItem class
                TextView name = convertView.findViewById(R.id.orderName);
                name.setText(getItem(position).getName());

                Button removeOrder = convertView.findViewById(R.id.removeOrderButton);
                removeOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //removing an order
                        orders.remove(orders.get(position));

                        adapter.notifyDataSetChanged(); //letting the adapter know we removed an item (refreshes the view)

                        listView.setAdapter(adapter); //resetting the adapter to the listview
                    }
                });

            }
            return convertView;
        }
    }
}