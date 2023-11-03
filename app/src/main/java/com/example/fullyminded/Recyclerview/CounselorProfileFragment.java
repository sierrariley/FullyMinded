package com.example.fullyminded.Recyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.fullyminded.JavaBeans.Counselor;
import com.example.fullyminded.JavaBeans.CounselorTypeItems;
import com.example.fullyminded.ListView.CustomListViewAdapter;
import com.example.fullyminded.R;
import com.google.android.material.carousel.CarouselLayoutManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CounselorProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CounselorProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CounselorProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CounselorProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CounselorProfileFragment newInstance(String param1, String param2) {
        CounselorProfileFragment fragment = new CounselorProfileFragment();
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

        View view = inflater.inflate(R.layout.fragment_counselor_profile, container, false);
        ArrayList<Counselor> counselor = new ArrayList<>();
        counselor.add(new Counselor("Marcus Walls", "MSW: Masters of Social Work"));
        counselor.add(new Counselor("Amanda Renaud", "PhD Social Work (University of Windsor)"));
        counselor.add(new Counselor("Melissa Wilson", "Psyd.D. in Clinical Psychology"));
        counselor.add(new Counselor("Joshua Battle", "ICF Certified"));
        counselor.add(new Counselor("David Harris", "ICF Certified"));
        counselor.add(new Counselor("Amber Byrne", "ICF Certified"));

//        ArrayList<CounselorTypeItems> counselorTypeItems = new ArrayList<>();
//        counselorTypeItems.add(new CounselorTypeItems("Mental Illness"));
//        counselorTypeItems.add(new CounselorTypeItems("Mental Illness"));
//        counselorTypeItems.add(new CounselorTypeItems("Mental Illness"));
//
//        ListView listView = view.findViewById(R.id.listView2);
//        CustomListViewAdapter adapter = new CustomListViewAdapter(getContext(), counselorTypeItems);
//        listView.setAdapter(adapter);

        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(new CounselorRecycleAdapter(counselor));



        return view;
    }
}