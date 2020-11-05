package com.example.mytailor.Adepter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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

import com.example.mytailor.AddActivity.ShowGirlActivity;
import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;

import java.util.ArrayList;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class GirlsAdepter extends RecyclerView.Adapter<GirlsAdepter.MYHOLDER> {

    ArrayList<GirlsItem> girlsItems;
    ArrayList<ArrayList<GirlsItem>> temItem;
    ArrayList<GirlsItem> search;
    Context context;
    SQLiteDatabase db;

    public GirlsAdepter(ArrayList<GirlsItem> girlsItems, Context context) {
        this.girlsItems = girlsItems;
        this.context = context;
        temItem = new ArrayList<ArrayList<GirlsItem>>();
        temItem.add(girlsItems);
        search = new ArrayList<>();
        search.addAll(girlsItems);
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

        holder.text.setText(girlsItems.get(position).getFname());
        holder.sname.setText(girlsItems.get(position).getSname());
        holder.phone.setText(girlsItems.get(position).getPhone());
        holder.weight.setText(girlsItems.get(position).getWeight());
        holder.height.setText(girlsItems.get(position).getHeight());

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowGirlActivity.class);
                intent.putExtra("gname", girlsItems.get(position).getFname());
                intent.putExtra("gsname", girlsItems.get(position).getSname());
                intent.putExtra("gphone", girlsItems.get(position).getPhone());
                intent.putExtra("gheight", girlsItems.get(position).getHeight());
                intent.putExtra("gweight", girlsItems.get(position).getWeight());
                intent.putExtra("girl", girlsItems.get(position).getId());
                context.startActivity(intent);

            }
        });

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.inflate(R.menu.yesandno);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getItemId() == R.id.no) {
                        }
                        if (item.getItemId() == R.id.yes) {
                            db.execSQL("delete from girls where id = '" + girlsItems.get(position).getId() + "'");
                            girlsItems.remove(position);
                            notifyDataSetChanged();
                            Toast.makeText(context, "Delet", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return girlsItems.size();
    }


    public class MYHOLDER extends RecyclerView.ViewHolder {

        TextView text, phone, sname, weight, height;
        ImageView btn;
        CheckBox cb;
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
    public void filter(String newText) {

        newText = newText.toLowerCase(Locale.getDefault());

        girlsItems.clear();
        if (newText.length() == 0) {

            girlsItems.addAll(search);

        } else {
            for (GirlsItem item : search) {

                if (newText.length() != 0 && item.getFname().contains(newText)) {
                    girlsItems.add(item);
                }
            }

        }
        notifyDataSetChanged();

    }

}

