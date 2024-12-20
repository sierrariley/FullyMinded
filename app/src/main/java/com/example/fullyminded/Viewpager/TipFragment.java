package com.example.fullyminded.Viewpager;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fullyminded.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TipFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TipFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int mParam3;

    public TipFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TipFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TipFragment newInstance(String param1, String param2, int param3) {
        TipFragment fragment = new TipFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_tip, container, false);
        TextView heading = view.findViewById(R.id.tipHeading);
        TextView tip = view.findViewById(R.id.tipText);
        ImageView tipImage = view.findViewById(R.id.tipImage);

        /**
         * Fill the textViews and Image view with the texts and images set for mparams
         */
        if(mParam1 != null && mParam2 != null && mParam3 != 0){
            heading.setText(mParam1);
            tip.setText(mParam2);
            tipImage.setImageResource(mParam3);
        }

        //Fade Animations for Images
        Animation fade = AnimationUtils.loadAnimation(getContext(), R.anim.anim_fade);
        tipImage.startAnimation(fade);

        /**
         * @preferences1 - hold the setting for snackbar
         * snack bar gives a reminder to do the daily check in. If switchpreference is true, snackbar will show
         */
        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(getContext());
        Boolean notification = preferences1.getBoolean("switch_notification", true);
        if(notification) {
            Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Don't forget to do your Daily Check In", Snackbar.LENGTH_LONG);
            snackbar.show();
        }

        return view;
    }
}