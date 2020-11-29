package com.example.cookiecorner.viewFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookiecorner.R;
import com.example.cookiecorner.infoFragments.RatingsInfoFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RatingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RatingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RatingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RatingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RatingsFragment newInstance(String param1, String param2) {
        RatingsFragment fragment = new RatingsFragment();
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
        View view = inflater.inflate(R.layout.fragment_ratings, container, false);

        CustomViewPagerAdapter adapter = new CustomViewPagerAdapter(getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.ratingsViewPager);
        viewPager.setAdapter(adapter);

        return view;
    }

    public class CustomViewPagerAdapter extends FragmentPagerAdapter {

        public CustomViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return RatingsInfoFragment.newInstance("Farzana Moury", R.drawable.logo,
                        "Customer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\n");
                case 1: return RatingsInfoFragment.newInstance("Luke Skywalker", R.drawable.logo,
                        "Customer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\n");
                case 2: return RatingsInfoFragment.newInstance("Anakin", R.drawable.logo,
                        "Customer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\n");
                case 3: return RatingsInfoFragment.newInstance("Ariel Winter", R.drawable.logo,
                        "Customer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\n");
                case 4: return RatingsInfoFragment.newInstance("Linda Baker", R.drawable.logo,
                        "Customer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\n");
                default: return RatingsInfoFragment.newInstance("No name", R.drawable.logo,
                        "Customer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\nCustomer Review Goes here\n");
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}