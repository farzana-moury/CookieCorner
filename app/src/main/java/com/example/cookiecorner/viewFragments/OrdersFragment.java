package com.example.cookiecorner.viewFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cookiecorner.MainActivity;
import com.example.cookiecorner.R;
import com.example.cookiecorner.SettingsActivity;
import com.example.cookiecorner.ShoppingCart;
import com.example.cookiecorner.pojo.CookieMenuItem;

import java.util.ArrayList;

import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrdersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrdersFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    CustomListViewAdapter adapter;
    public ArrayList<CookieMenuItem> orders;
    public ListView listView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrdersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrdersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrdersFragment newInstance(String param1, String param2) {
        OrdersFragment fragment = new OrdersFragment();
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
        final View view = inflater.inflate(R.layout.fragment_orders, container, false);

        listView = view.findViewById(R.id.ordersList);

        fab.show();

        orders = ShoppingCart.getInstance().getShoppingList();

        adapter = new OrdersFragment.CustomListViewAdapter(getContext(), orders);

        adapter.notifyDataSetChanged(); //letting the adapter know we removed an item (refreshes the view)

        listView.setAdapter(adapter); //setting the adapter to the listview

        for (CookieMenuItem o : orders){
            System.out.println(o.getName());
        }

        return view;
    }

    public class CustomListViewAdapter extends ArrayAdapter<CookieMenuItem> {

        //CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), itemArrayList)
        public CustomListViewAdapter(@NonNull Context context, ArrayList<CookieMenuItem> items) {
            super(context, 0, orders);
        }

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