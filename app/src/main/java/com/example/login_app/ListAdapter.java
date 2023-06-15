package com.example.login_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> pmData;
    private LayoutInflater pmInflater;
    private Context context;

    private SelectListener listener;

    public ListAdapter(List<ListElement> itemList, Context context, SelectListener listener){
        this.pmInflater = LayoutInflater.from(context);
        this.context = context;
        this.pmData = itemList;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return pmData.size();
    }

    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = pmInflater.inflate(R.layout.list_pm_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(pmData.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(pmData.get(position));
            }
        });
    }

    public void setItems(List<ListElement> items){pmData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView equipment,status, time;
        CardView cardView;

        ViewHolder(View itemView){
            super(itemView);
            equipment = itemView.findViewById(R.id.equipment);
            status = itemView.findViewById(R.id.status);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cv);
        }

        void bindData(final ListElement item){
            equipment.setText(item.getEquipment_type() + " | " + item.getEquipment_name() + " (" + item.getReference_no() + ") ");
            status.setText(item.getStatus());
            time.setText(item.getSchedule_dateAndTime());
        }
    }

}
