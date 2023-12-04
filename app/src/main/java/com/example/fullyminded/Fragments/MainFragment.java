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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fullyminded.R;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Uri webPage = Uri.parse("https://www.psychologytoday.com/ca?tr=Hdr_Brand");
        ImageView imageView = view.findViewById(R.id.helpImage);

        Button webButton = view.findViewById(R.id.officialWebButton);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, webPage);
                startActivity(i);

            }
        });

        TextView aboutText = view.findViewById(R.id.whoWeAreText);
        TextView purpose = view.findViewById(R.id.purposeText);

        /**
         * @preferences - hold the setting for font sizing
         * allows user to change the font size of text in app
         * @preferences1 - hold the setting for snackbar
         * snack bar gives a reminder to do the daily check in. If switchpreference is true, snackbar will show
         */
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        String selectedValue = preferences.getString("font_size", "16");
         aboutText.setTextSize(Integer.parseInt(selectedValue));
          purpose.setTextSize(Integer.parseInt(selectedValue));

        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(getContext());
        Boolean notification = preferences1.getBoolean("switch_notification", true);
        if(notification) {
            Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), "Don't forget to do your Daily Check In", Snackbar.LENGTH_LONG);
            snackbar.show();
        }


        //Fade animation for image
        Animation fade = AnimationUtils.loadAnimation(getContext(), R.anim.anim_fade);
        imageView.startAnimation(fade);



        return view;
    }
}