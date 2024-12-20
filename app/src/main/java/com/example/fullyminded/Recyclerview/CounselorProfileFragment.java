package com.example.fullyminded.Recyclerview;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.fullyminded.JavaBeans.Counselor;
import com.example.fullyminded.R;
import com.google.android.material.snackbar.Snackbar;

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
//    private Switch layoutSwitch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.fragment_counselor_profile, container, false);

        //Populating Arraylist for recycler view
        ArrayList<Counselor> counselor = new ArrayList<>();
        counselor.add(new Counselor("Marcus Walls", "MSW: Masters of Social Work"));
        counselor.add(new Counselor("Amanda Renaud", "PhD Social Work (University of Windsor)"));
        counselor.add(new Counselor("Melissa Wilson", "Psyd.D. in Clinical Psychology"));
        counselor.add(new Counselor("Joshua Battle", "ICF Certified"));
        counselor.add(new Counselor("David Harris", "ICF Certified"));
        counselor.add(new Counselor("Amber Byrne", "ICF Certified"));

        //Setting the adapter for view
        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        recyclerView.setAdapter(new CounselorRecycleAdapter(counselor));

        /**
         * @preferences - hold the setting for recycler layout
         * allows user to change layout to a grid view
         * @preferences1 - hold the setting for snackbar
         * snack bar gives a reminder to do the daily check in. If switchpreference is true, snackbar will show
         */
      SharedPreferences preferences =  PreferenceManager.getDefaultSharedPreferences(getContext());
      Boolean switchPreference = preferences.getBoolean("grid_view", false);
        if(switchPreference){
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        }else{
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(getContext());
        Boolean notification = preferences1.getBoolean("switch_notification", true);
        if(notification) {
            Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Don't forget to do your Daily Check In", Snackbar.LENGTH_LONG);
            snackbar.show();
        }




        return view;
    }


    }