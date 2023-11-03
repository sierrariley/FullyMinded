package com.example.fullyminded.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fullyminded.JavaBeans.CounselorTypeItems;
import com.example.fullyminded.R;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<CounselorTypeItems> {


    public CustomListViewAdapter(@NonNull Context context, @NonNull List<CounselorTypeItems> objects) {
        super(context,0,  objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CounselorTypeItems item = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_recycler_view, parent, false);
//            TextView specialty = convertView.findViewById(R.id.specialty);
//            specialty.setText(item.getSpecialty());
        }
        return convertView;
    }
}
