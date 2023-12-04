package com.example.fullyminded.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.fullyminded.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FormFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CallFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FormFragment newInstance(String param1, String param2) {
        FormFragment fragment = new FormFragment();
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

    //Variables
    RadioButton mentalHealth;
    RadioButton lifeCoach;
    RadioButton insuranceYes;
    RadioButton insuranceNo;
    TextInputEditText name;
    TextInputEditText age;
    String choice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_call, container, false);

        mentalHealth = view.findViewById(R.id.mentalHealth);
        lifeCoach = view.findViewById(R.id.lifeCoachCheck);
        insuranceYes = view.findViewById(R.id.insuranceYes);
        insuranceNo = view.findViewById(R.id.insuranceNo);
        name = view.findViewById(R.id.nameFill);
        age = view.findViewById(R.id.ageTextField);
        Button sendButton = view.findViewById(R.id.sendRequestButton);

        //This will set the checked radio button to a string
        if(mentalHealth.isChecked()){
            choice = "Mental Health";
        }else{
            choice = "Life Coaching";
        }

        /**
         * This onClickListener will allow user to email FullyMinded with their request. They will be emailed back.
         * @view View
         * @param Intent i uses ACTION_SEND to send an email
         */
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto: "));
                i.putExtra(Intent.EXTRA_SUBJECT, "Book Appointment Request");
                i.putExtra(Intent.EXTRA_TEXT, "FullyMinded Appointment Request: \n" +
                                                    "Type of counseling: " + choice + "\n" +
                                                    "Name: " + name + "\n" +
                                                    "Age: " + age );
                startActivity(i);
            }
        });

        /**
         * @preferences - hold the setting for font sizing
         * allows user to change the font size of text in app
         * @preferences1 - hold the setting for snackbar
         * snack bar gives a reminder to do the daily check in. If switchpreference is true, snackbar will show
         */
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        String selectedValue = preferences.getString("font_size", "16");
        mentalHealth.setTextSize(Integer.parseInt(selectedValue));
        lifeCoach.setTextSize(Integer.parseInt(selectedValue));
        insuranceYes.setTextSize(Integer.parseInt(selectedValue));
        insuranceNo.setTextSize(Integer.parseInt(selectedValue));
        name.setTextSize(Integer.parseInt(selectedValue));
        age.setTextSize(Integer.parseInt(selectedValue));

        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(getContext());
        Boolean notification = preferences1.getBoolean("switch_notification", true);
        if(notification) {
            Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Don't forget to do your Daily Check In", Snackbar.LENGTH_LONG);
            snackbar.show();
        }




        return view;
    }
}