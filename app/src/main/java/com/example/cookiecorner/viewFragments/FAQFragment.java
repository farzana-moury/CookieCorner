package com.example.cookiecorner.viewFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookiecorner.R;
import com.example.cookiecorner.pojo.FAQItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FAQFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FAQFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FAQFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FAQFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FAQFragment newInstance(String param1, String param2) {
        FAQFragment fragment = new FAQFragment();
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
        View view = inflater.inflate(R.layout.fragment_f_a_q, container, false);

        //recyclerView we are going to use
        RecyclerView recyclerView = view.findViewById(R.id.faqRecyclerView);

        //list of faq items (each item consists of question and answer)
        ArrayList<FAQItem> faqList = new ArrayList<>();

        //populating the faq arrayList
        faqList.add(new FAQItem("How long does it take to bake a cookie?", "Depends on the recipe"));
        faqList.add(new FAQItem("What is your favourite cookie?", "Chocolate Chip"));
        faqList.add(new FAQItem("Can we add gelatin for texture?", "Yes, for filling or the dough! Hoewever, this could change the bake time and temperature and whatnot"));
        faqList.add(new FAQItem("How long does it take to bake a cookie?", "Depends on the recipe"));
        faqList.add(new FAQItem("How long does it take to bake a cookie?", "Depends on the recipe"));
        faqList.add(new FAQItem("How long does it take to bake a cookie?", "Depends on the recipe"));
        faqList.add(new FAQItem("How long does it take to bake a cookie?", "Depends on the recipe"));
        faqList.add(new FAQItem("How long does it take to bake a cookie?", "Depends on the recipe"));

        //layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //setting an adapter
        recyclerView.setAdapter(new FAQRecyclerViewAdapter(faqList));

        return view;
    }
}