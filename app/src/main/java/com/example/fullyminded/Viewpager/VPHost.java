package com.example.fullyminded.Viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fullyminded.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VPHost#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VPHost extends Fragment {
    ViewPager2 viewPager2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VPHost() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VPHost.
     */
    // TODO: Rename and change types and number of parameters
    public static VPHost newInstance(String param1, String param2) {
        VPHost fragment = new VPHost();
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

        /**
         * This holds the content for the viewpager
         */
        View view = inflater.inflate(R.layout.fragment_v_p_host, container, false);
        viewPager2 = view.findViewById(R.id.tipsViewPager);
        viewPager2.setAdapter(new CustomViewPagerAdapter(getActivity()));
        return view;
    }
}