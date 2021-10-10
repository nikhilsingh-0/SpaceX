package com.mk.nk.spacex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mk.nk.spacex.Room.Crew;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.viewHolder> {

    private Context context;
//    ArrayList<CrewModel> list;
    List<CrewModel> list;

    public CrewAdapter(Context context, List<CrewModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        CrewModel model=list.get(position);
        holder.name.setText(model.getName());
        holder.agency.setText(model.getAgency());
        holder.status.setText(model.getStatus());
        holder.link.setText(model.getWikipedia());
        Picasso.get().load(model.getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView name,agency,status,link;
        ImageView image;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            agency=itemView.findViewById(R.id.agency);
            status=itemView.findViewById(R.id.status);
            link=itemView.findViewById(R.id.link);
            image=itemView.findViewById(R.id.image);

        }
    }
}
