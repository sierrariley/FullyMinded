package com.example.fullyminded.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fullyminded.JavaBeans.TermTypeItems;
import com.example.fullyminded.R;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<TermTypeItems> {


    public CustomListViewAdapter(@NonNull Context context, @NonNull List<TermTypeItems> objects) {
        super(context,0,  objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TermTypeItems item = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_item_view, parent, false);
            TextView name = convertView.findViewById(R.id.name);
            name.setText(item.getName());
        }
        return convertView;
    }
}
