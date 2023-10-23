package com.example.fullyminded;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CounselorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CounselorsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CounselorsFragment() {
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
    public static CounselorsFragment newInstance(String param1, String param2) {
        CounselorsFragment fragment = new CounselorsFragment();
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
        View view = inflater.inflate(R.layout.fragment_counselors, container, false);
        ListView listView = view.findViewById(R.id.counselorList);
        ArrayList<CounselorTypeItems> counselorTypeItems = new ArrayList<>();
        counselorTypeItems.add(new CounselorTypeItems("Marcus Walls", "MSW: Masters of Social Work", "Marcus walls has been practicing for 5 years and specializes in mental health issues such as depression and anxiety."));
        counselorTypeItems.add(new CounselorTypeItems("Amanda Renaud", "PhD Social Work (University of Windsor)", "Amanda has been practicing mental health therapy for 8 years. She specialized in childhood trauma. Targeting the pas traumas of our past that still affect us today."));
        counselorTypeItems.add(new CounselorTypeItems("Melissa Wilson", "Psyd.D. in Clinical Psychology", "description"));
        counselorTypeItems.add(new CounselorTypeItems("David Harris", "ICF Certified ", "Description"));
        counselorTypeItems.add(new CounselorTypeItems("Amber Byrne", "ICF Certified ", "Description"));
        counselorTypeItems.add(new CounselorTypeItems("Joshua Battle", "ICF Certified", "Description"));

        //Method 1:
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, counselorTypeItems);
        listView.setAdapter(adapter);



        return view;
    }
}