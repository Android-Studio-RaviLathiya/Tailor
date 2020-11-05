package com.example.mytailor.Adepter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytailor.AddActivity.EditDramaMapActivity;
import com.example.mytailor.R;

import java.util.ArrayList;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class DramaAdepter extends RecyclerView.Adapter<DramaAdepter.DRAMA> {

    ArrayList<DramaItem> dramaItems;
    //    ArrayList<ArrayList<DramaItem>> deletItem;
    Context context;
    SQLiteDatabase db;

    ArrayList<DramaItem> delet;


    public DramaAdepter(ArrayList<DramaItem> dramaItems, Context context) {
        this.dramaItems = dramaItems;
        this.context = context;
        delet = new ArrayList<>();
        delet.addAll(dramaItems);

//        deletItem = new ArrayList<ArrayList<DramaItem>>();
//        deletItem.add(dramaItems);
    }

    @NonNull
    @Override
    public DRAMA onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drama_item, parent, false);
        db = context.openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);
        return new DRAMA(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DRAMA holder, final int position) {

        holder.fname.setText(dramaItems.get(position).getFname());
        holder.sname.setText(dramaItems.get(position).getSname());


//        holder.delet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                db.execSQL("delete from drama where id = '" + dramaItems.get(position).getId() + "'");
//                dramaItems.remove(position);
//                notifyDataSetChanged();
//                Toast.makeText(context, "Delet", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return dramaItems.size();
    }



    public class DRAMA extends RecyclerView.ViewHolder {
        ImageView add, delet;
        TextView fname, sname;


        public DRAMA(@NonNull View itemView) {
            super(itemView);

            add = itemView.findViewById(R.id.add);
            delet = itemView.findViewById(R.id.delet);
            fname = itemView.findViewById(R.id.fname);
            sname = itemView.findViewById(R.id.sname);


        }
    }

    public void filter(String newText) {

        newText = newText.toLowerCase(Locale.getDefault());

        dramaItems.clear();
        if (newText.length() == 0) {

            dramaItems.addAll(delet);

        } else {
            for (DramaItem item : delet) {

                if (newText.length() != 0 && item.getFname().contains(newText)) {
                    dramaItems.add(item);
                }
            }

        }
        notifyDataSetChanged();

    }

}


