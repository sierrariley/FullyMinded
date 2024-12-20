package com.example.fullyminded.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.example.fullyminded.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
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

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        TextView signUpFully = view.findViewById(R.id.signUpFully);
        TextView onlineSignUp = view.findViewById(R.id.signUpOnline);
        TextView emerg = view.findViewById(R.id.emergText);

        //This sets a transition animation
        NavOptions options = new NavOptions.Builder().
                setEnterAnim(R.anim.anim_backin).
                setExitAnim(R.anim.anim_backout).
                build();

        /**
         * @preferences - hold the setting for font sizing
         * allows user to change the font size of text in app
         */
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        String selectedValue = preferences.getString("font_size", "14");
        signUpFully.setTextSize(Integer.parseInt(selectedValue));
        onlineSignUp.setTextSize(Integer.parseInt(selectedValue));
        emerg.setTextSize(Integer.parseInt(selectedValue));

        Button call = view.findViewById(R.id.emergencyButton);
        /**
         * This calls the emergency hotline
         * @view View
         * Intent i uses ACTION_DIAL to call
         */
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:1-833-456-4566"));
//                if(i.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(i);
//                }

            }
        });

        /**
         * @view View
         * Intent i URI to access google maps and searches for therapy, life coach, counseling
         */
        Button webButton = view.findViewById(R.id.webButton);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri places = Uri.parse("geo:0,0?q= therapy, life coach, counseling");
                Intent i = new Intent(Intent.ACTION_VIEW, places);
                startActivity(i);
            }
        });

        /**
         * @view View
         * Navigates to another fragment when button is pressed
         */
        Button formButton = view.findViewById(R.id.formButton);
        formButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_formFragment2, null, options);
            }
        });
        return view;
    }
}