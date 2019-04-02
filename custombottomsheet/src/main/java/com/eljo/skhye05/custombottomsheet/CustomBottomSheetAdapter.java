package com.eljo.skhye05.custombottomsheet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eljo.skhye05.custombottomsheet.CustomBottomSheetItem;
import com.eljo.skhye05.custombottomsheet.R;

import java.util.List;

public class CustomBottomSheetAdapter extends RecyclerView.Adapter<CustomBottomSheetAdapter.MyViewHolder> {

    private List<CustomBottomSheetItem> items;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            icon = (ImageView) view.findViewById(R.id.icon);
        }
    }


    public CustomBottomSheetAdapter(List<CustomBottomSheetItem> items) {
        this.items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CustomBottomSheetItem item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.geticon());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}