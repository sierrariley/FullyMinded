package com.example.fullyminded.Recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fullyminded.JavaBeans.Counselor;
import com.example.fullyminded.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CounselorRecycleAdapter extends RecyclerView.Adapter<CounselorRecycleAdapter.CustomViewHolder>{

    public ArrayList<Counselor> counselorArrayList;

    public CounselorRecycleAdapter(ArrayList<Counselor> counselors){this.counselorArrayList = counselors;}

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recycler_view, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Counselor counselor = counselorArrayList.get(position);
        holder.credentials.setText(counselor.getCredentials());
        holder.name.setText(counselor.getName());
    }

    @Override
    public int getItemCount() {
        return counselorArrayList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected TextView name;
        protected TextView credentials;

        public CustomViewHolder(@NonNull View view) {
            super(view);
            this.name = view.findViewById(R.id.nameCounselor);
            this.credentials = view.findViewById(R.id.credentialsText);
        }
    }
}
