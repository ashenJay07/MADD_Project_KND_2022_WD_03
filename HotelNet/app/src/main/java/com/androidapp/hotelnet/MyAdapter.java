package com.androidapp.hotelnet;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<String> name_id, email_id, age_id;
    private List<String>tempHotelName, tempLocation, tempRoomPrice;

    public MyAdapter(Context context, List<String> name_id, List<String> email_id, List<String> age_id) {
        this.context = context;
        this.name_id = name_id;
        this.email_id = email_id;
        this.age_id = age_id;
        this.tempHotelName = name_id;
        this.tempLocation = email_id;
        this.tempRoomPrice = age_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.hotelentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.email_id.setText(String.valueOf(email_id.get(position)));
        holder.age_id.setText(String.valueOf(age_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id, email_id, age_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.findViewById(R.id.bookNowBtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(v.getContext(), RoomActivity.class);
                    i.putExtra("hotelName", tempHotelName.get(getAdapterPosition()));
                    i.putExtra("location", tempLocation.get(getAdapterPosition()));
                    i.putExtra("roomPrice", tempRoomPrice.get(getAdapterPosition()));
                    v.getContext().startActivity(i);

                }
            });


            name_id = itemView.findViewById(R.id.textHotelName);
            email_id = itemView.findViewById(R.id.textLocation);
            age_id = itemView.findViewById(R.id.textRoomPrice);
        }
    }
}
