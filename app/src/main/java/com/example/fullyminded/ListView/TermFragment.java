package com.example.fullyminded.ListView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fullyminded.JavaBeans.TermTypeItems;
import com.example.fullyminded.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TermFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class TermFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TermFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CounselorsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TermFragment newInstance(String param1, String param2) {
        TermFragment fragment = new TermFragment();
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

//    public ArrayList<CounselorTypeItems> counselorTypeItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_counselors, container, false);
        ListView listView = view.findViewById(R.id.termList);
        ArrayList<TermTypeItems> termTypeItems = new ArrayList<>();

        //Populating the Arraylist that will show in listview
        termTypeItems.add(new TermTypeItems("Depression"));
        termTypeItems.add(new TermTypeItems("Anxiety"));
        termTypeItems.add(new TermTypeItems("Bipolar"));
        termTypeItems.add(new TermTypeItems("Obsessive Compulsive Disorder"));
        termTypeItems.add(new TermTypeItems("Procrastination"));
        termTypeItems.add(new TermTypeItems("Grief/Loss"));
        termTypeItems.add(new TermTypeItems("Phobias"));
        termTypeItems.add(new TermTypeItems("Relationship Issues"));
        termTypeItems.add(new TermTypeItems("Stress"));
        termTypeItems.add(new TermTypeItems("Breaking Habits"));
        termTypeItems.add(new TermTypeItems("Goal Setting"));
        termTypeItems.add(new TermTypeItems("Trauma"));


        //Custom View for listview
        CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), termTypeItems);
        listView.setAdapter(adapter);

        //Fade animations for images
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_in);
        listView.startAnimation(animation);



        return view;
    }
}