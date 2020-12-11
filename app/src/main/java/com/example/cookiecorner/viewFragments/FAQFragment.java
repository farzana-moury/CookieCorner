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
import static com.example.cookiecorner.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FAQFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Farzana Moury
 * @version 1.0
 * @since Nov 28th 2020
 */
public class FAQFragment extends Fragment {


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FAQFragment.
     */
    public static FAQFragment newInstance(String param1, String param2) {
        FAQFragment fragment = new FAQFragment();
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
        View view = inflater.inflate(R.layout.fragment_f_a_q, container, false);

        //recyclerView we are going to use
        RecyclerView recyclerView = view.findViewById(R.id.faqRecyclerView);

        //list of faq items (each item consists of question and answer)
        ArrayList<FAQItem> faqList = new ArrayList<>();

        //populating the faq arrayList
        faqList.add(new FAQItem("What is your best selling cookie?", "Over the years we've mixed and mashed different cookies, but overall the most popular cookie is the" +
                " peanut butter cookie, mostly because of its texture and melty flavour."));
        faqList.add(new FAQItem("Where can I find the best cookie recipe?", "On our website of course! visit www.cookiecorner.ca to access all of our best recipes."));
        faqList.add(new FAQItem("Can we add gelatin for texture?", "Yes! As long as you get the consistency and measurements, you can make your own jello cookie!"));
        faqList.add(new FAQItem("Are the cookies 100% halal?", "Yes! We take into consideration the whole community to meet their needs. Everyone is welcome to enjoy."));
        faqList.add(new FAQItem("How long does it take to bake a cookie?", "It all depends on the recipe. On average, a batch of cookies can take around 1.5 hours."));
        faqList.add(new FAQItem("How was Cookie Corner founded?", "Well it was an idea that my ancestors came up with. The neighbourhood needed a sweet shop - " +
                "so we opened a bakery at the heart of Windsor!"));
        faqList.add(new FAQItem("Is the bakery solely based in Canada?", "So far we've had this family business for the past 50 years. We have other bakeries across the province" +
                " of Ontario and plan to branch out to other provinces. Who knows? We may decide to internationally brand in the future."));


        //layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //setting an adapter
        recyclerView.setAdapter(new FAQRecyclerViewAdapter(faqList));

        return view;
    }
}