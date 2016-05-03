package com.example.fileininternalstorage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sudhanshu on 30/4/16.
 */
public class FileAdapter extends RecyclerView.Adapter<FileAdapter.ViewHolder> {

    private ArrayList<HashMap<String,String>> fileList;

    public FileAdapter(ArrayList<HashMap<String, String>> fileList) {
        this.fileList = fileList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.column_row, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        HashMap<String ,String > map = fileList.get(i);
        TextView textView1 = viewHolder.txtFirst;
        TextView textView2 = viewHolder.txtSecond;
        TextView textView3 = viewHolder.txtThird;
        TextView textView4 = viewHolder.txtFourth;
        textView1.setText(map.get(Constants.FIRST_COLUMN));
        textView2.setText(map.get(Constants.SECOND_COLUMN));
        textView3.setText(map.get(Constants.THIRD_COLUMN));
        textView4.setText(map.get(Constants.FOURTH_COLUMN));


    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        TextView txtFirst;
        TextView txtSecond;
        TextView txtThird;
        TextView txtFourth;


        public ViewHolder(View itemView) {

            super(itemView);

            txtFirst = (TextView) itemView.findViewById(R.id.name);
            txtSecond = (TextView) itemView.findViewById(R.id.isFile);
            txtThird = (TextView) itemView.findViewById(R.id.extension);
            txtFourth = (TextView) itemView.findViewById(R.id.source);

        }
    }
}
