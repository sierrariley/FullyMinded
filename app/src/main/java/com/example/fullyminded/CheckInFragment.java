package com.example.fullyminded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

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
    boolean sleep;
    boolean affirm;
    boolean focus;
    boolean activity;


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

        if(sleepYes.isChecked()){
            sleep = true;
        }else{
            sleep = false;
        }

        if(affirmYes.isChecked()){
            affirm = true;
        }else{
            affirm = false;
        }

        if(focusYes.isChecked()){
            focus = true;
        }else{
            focus = false;
        }

        if(activityYes.isChecked()){
            activity = true;
        }else{
            activity = false;
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


        Button resultsButton = view.findViewById(R.id.resultsButton);
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_TEXT, "Here is you Daily Check in results: " +
                        "1. Did you get enough sleep? " + sleep +
                        "\n I am feeling: " + percent + "%" +
                        "\n I recited my affirmations today?: " + affirm +
                        "\n Have I had a hard time focusing on tasks?: " + focus +
                        "\n I have engaged in physical activity today: " + activity);
                startActivity(i);
            }
        });



        return view;
    }
}