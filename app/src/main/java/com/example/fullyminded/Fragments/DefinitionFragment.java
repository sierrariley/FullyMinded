package com.example.fullyminded.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;

import android.widget.TextView;


import com.example.fullyminded.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DefinitionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DefinitionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DefinitionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DefinitionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DefinitionFragment newInstance(String param1, String param2) {
        DefinitionFragment fragment = new DefinitionFragment();
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


        View view = inflater.inflate(R.layout.fragment_definition, container, false);

        Button dailyAffirm = view.findViewById(R.id.affirmationButton);
        Uri instaLink = Uri.parse("https://www.instagram.com/iam.affirmations/");
        dailyAffirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, instaLink);
                startActivity(i);
            }
        });


        TextView therpayDef = view.findViewById(R.id.therapyDescript);
        TextView lifeCoachDescript = view.findViewById(R.id.lifeCoachDescript);

        //Font size Settings
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        String selectedValue = preferences.getString("font_size", "16");
        therpayDef.setTextSize(Integer.parseInt(selectedValue));
        lifeCoachDescript.setTextSize(Integer.parseInt(selectedValue));

        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(getContext());
        Boolean notification = preferences1.getBoolean("switch_notification", true);
        if(notification) {
            Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Don't forget to do your Daily Check In", Snackbar.LENGTH_LONG);
            snackbar.show();
        }



        return view;
    }
}