package com.example.policemodule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.policemodule.police.Police_Info;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PoliceAdapter extends RecyclerView.Adapter<PoliceAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<Police_Info> info;

    public PoliceAdapter(Context context, ArrayList<Police_Info> info) {
        this.context = context;
        this.info = info;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.police_fragment_list_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.stationimage.setImageResource(info.get(position).getImage());
        holder.location.setText(info.get(position).getLocation());
        holder.policestation.setText(info.get(position).getPolicestation());
        holder.police_address.setText(info.get(position).getAddress());
        holder.phoneno.setText(info.get(position).getPhno());


    }
    @Override
    public int getItemCount()
    {

         return  info.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.police_frag_tv_stationimage)
        ImageView stationimage;
        @BindView(R.id.police_frag_tv_locationplace)
        TextView location;
        @BindView(R.id.police_frag_policestation_name)
        TextView policestation;
        @BindView(R.id.police_frag_police_address)
        TextView police_address;
        @BindView(R.id.police_frag_tv_phoneno)
        TextView  phoneno;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
