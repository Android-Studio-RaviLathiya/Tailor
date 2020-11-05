package com.example.mytailor.SettingActivity.NewbusinessStart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytailor.Adepter.CusmorItem;
import com.example.mytailor.R;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class SchoolAdepter extends RecyclerView.Adapter<SchoolAdepter.ADDSCHOOLNAME> {
    ArrayList<Schoolitem> schoolitems;
    Context context;
    ArrayList<ArrayList<Schoolitem>> tempcusmorItems;
    SQLiteDatabase db;


    public SchoolAdepter(ArrayList<Schoolitem> schoolitems, Context context) {
        this.schoolitems = schoolitems;
        this.context = context;
        tempcusmorItems = new ArrayList<ArrayList<Schoolitem>>();
        tempcusmorItems.add(schoolitems);
    }

    @NonNull
    @Override
    public ADDSCHOOLNAME onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.addschoolitem, parent, false);
        db = context.openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);
        return new ADDSCHOOLNAME(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ADDSCHOOLNAME holder, final int position) {

        holder.name.setText(schoolitems.get(position).getName());

        holder.delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                db.execSQL("delete from addschoolname where id = '" + schoolitems.get(position).getId() + "'");
                schoolitems.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context, "Delet", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return schoolitems.size();
    }

    public class ADDSCHOOLNAME extends RecyclerView.ViewHolder {
        TextView name;
        ImageView delet;

        public ADDSCHOOLNAME(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            delet = itemView.findViewById(R.id.delet);


        }
    }
}
