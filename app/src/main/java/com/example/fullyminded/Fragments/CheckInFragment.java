package com.example.fullyminded.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.fullyminded.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CheckInFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckInFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CheckInFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckInFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckInFragment newInstance(String param1, String param2) {
        CheckInFragment fragment = new CheckInFragment();
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


    SeekBar feelSeekBar;
    TextView seekBarTextView;
    RadioButton sleepYes;
    RadioButton sleepNo;
    RadioButton affirmYes;
    RadioButton affirmNo;
    RadioButton focusYes;
    RadioButton focusNo;
    RadioButton activityYes;
    RadioButton activityNo;

    RadioGroup sleepGroup;

    int percent = 0;
    String sleep;
    String affirm;
    String focus;
    String activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_in, container, false);

        feelSeekBar = view.findViewById(R.id.seekBar);
        seekBarTextView = view.findViewById(R.id.seekBarTextView);
        sleepYes = view.findViewById(R.id.sleepYes);
        sleepNo = view.findViewById(R.id.sleepNo);
        affirmYes = view.findViewById(R.id.affrimYes);
        affirmNo = view.findViewById(R.id.affrimNo);
        focusYes = view.findViewById(R.id.focusYes);
        focusNo = view.findViewById(R.id.focusNo);
        activityYes = view.findViewById(R.id.activityYes);
        activityNo = view.findViewById(R.id.activityNo);

        sleepGroup = view.findViewById(R.id.slepRadioButtons);

        TextView sleepText = view.findViewById(R.id.sleepQuestion);
        TextView feelText = view.findViewById(R.id.feelQuestion);
        TextView affrimQ = view.findViewById(R.id.affirmQuestion);
        TextView focusQ = view.findViewById(R.id.focusQuestion);
        TextView activityQ = view.findViewById(R.id.activityQuestion);

        //Font size settings
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        String selectedValue = preferences.getString("font_size", "16");
        seekBarTextView.setTextSize(Integer.parseInt(selectedValue));
        sleepText.setTextSize(Integer.parseInt(selectedValue));
        feelText.setTextSize(Integer.parseInt(selectedValue));
        affrimQ.setTextSize(Integer.parseInt(selectedValue));
        focusQ.setTextSize(Integer.parseInt(selectedValue));
        activityQ.setTextSize(Integer.parseInt(selectedValue));


        //This gives the response yes or no when sending the results in the email
        if(sleepYes.isChecked()){
            sleep = "Yes";
        }else{
            sleep = "No";
        }

        if(affirmYes.isChecked()){
            affirm = "Yes";
        }else{
            affirm = "No";
        }

        if(focusYes.isChecked()){
            focus = "Yes";
        }else{
            focus = "No";
        }

        if(activityYes.isChecked()){
            activity = "Yes";
        }else{
            activity = "No";
        }



        feelSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarTextView.setText(i + " %");
                percent = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //Create A button for email Intent
        Button resultsButton = view.findViewById(R.id.resultsButton);
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override

            //Send results to Yourself to track and give to therapist or life coach at sessions
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_TEXT, "Here is you Daily Check in results: "  +
                        "\n 1. Did your get enough sleep? " + sleep +
                        "\n 2. I am feeling: " + percent + "%" +
                        "\n 3. I recited my affirmations today?: " + affirm +
                        "\n 4. Have I had a hard time focusing on tasks?: " + focus +
                        "\n 5. I have engaged in physical activity today: " + activity);
                startActivity(i);
            }
        });



        return view;
    }
}