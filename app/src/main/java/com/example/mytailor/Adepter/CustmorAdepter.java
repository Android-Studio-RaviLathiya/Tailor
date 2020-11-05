package com.example.mytailor.Adepter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytailor.AddActivity.ShowBoyActivity;
import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;

import java.util.ArrayList;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class CustmorAdepter extends RecyclerView.Adapter<CustmorAdepter.MYHOLDER> {

    ArrayList<CusmorItem> cusmorItems;
    ArrayList<ArrayList<CusmorItem>> tempcusmorItems;
    ArrayList<CusmorItem> searchview;
    Context context;
    SQLiteDatabase db;


    public CustmorAdepter(ArrayList<CusmorItem> cusmorItems, Context context) {
        this.cusmorItems = cusmorItems;
        this.context = context;
        searchview = new ArrayList<>();
        searchview.addAll(cusmorItems);
//        tempcusmorItems = new ArrayList<ArrayList<CusmorItem>>();
//        tempcusmorItems.add(cusmorItems);
    }


    @NonNull
    @Override
    public MYHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custmor_item, parent, false);
        db = context.openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);
        return new MYHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MYHOLDER holder, final int position) {

        holder.text.setText(cusmorItems.get(position).getFname());
        holder.sname.setText(cusmorItems.get(position).getSname());
        holder.phone.setText(cusmorItems.get(position).getPhone());
        holder.weight.setText(cusmorItems.get(position).getWeight());
        holder.height.setText(cusmorItems.get(position).getHeight());

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                context.startActivity(new Intent(context, ShowCustmorActivity.class));
                Intent intent = new Intent(context, ShowBoyActivity.class);
                intent.putExtra("Boy", cusmorItems.get(position).getId());
                intent.putExtra("fname", cusmorItems.get(position).getFname());
                intent.putExtra("sname", cusmorItems.get(position).getSname());
                intent.putExtra("bphone", cusmorItems.get(position).getPhone());
                intent.putExtra("bheight", cusmorItems.get(position).getHeight());
                intent.putExtra("bweight", cusmorItems.get(position).getWeight());
                context.startActivity(intent);

            }
        });

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                PopupMenu popupMenu = new PopupMenu(context, v);
//                popupMenu.inflate(R.menu.yesandno);
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//
//                        if (item.getItemId() == R.id.no) {
//                        }
//
//                        if (item.getItemId() == R.id.yes) {
//                            db.execSQL("delete from boys where id = '" + cusmorItems.get(position).getId() + "'");
//                            cusmorItems.remove(position);
//                            notifyDataSetChanged();
//                            Toast.makeText(context, "Delet", Toast.LENGTH_SHORT).show();
//                        }
//
//                        return false;
//                    }
//                });
//                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return cusmorItems.size();
    }

    public void filter(String newText) {


        newText = newText.toLowerCase(Locale.getDefault());

        cusmorItems.clear();
        if (newText.length() == 0) {

            cusmorItems.addAll(searchview);
        } else {

            for (CusmorItem item : searchview) {


                if (newText.length() != 0 && item.getFname().contains(newText)) {
                    cusmorItems.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }


    public class MYHOLDER extends RecyclerView.ViewHolder {
        TextView text, phone, sname, weight, height;
        ImageView btn;
        CheckBox cb;
        String t;
        RelativeLayout show;
        ImageView add;

        public MYHOLDER(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
            phone = itemView.findViewById(R.id.phone);
            sname = itemView.findViewById(R.id.sname);
            weight = itemView.findViewById(R.id.weight);
            height = itemView.findViewById(R.id.height);
            add = itemView.findViewById(R.id.add);

            btn = itemView.findViewById(R.id.button);
            cb = itemView.findViewById(R.id.cb);
            show = itemView.findViewById(R.id.show);


            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (cb.isChecked()) {
                        show.setVisibility(View.VISIBLE);
                    } else {
                        show.setVisibility(View.GONE);
                    }
                }
            });

        }
    }


}