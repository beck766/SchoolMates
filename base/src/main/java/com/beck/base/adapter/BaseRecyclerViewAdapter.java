package com.beck.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;

public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T>{

    protected AdapterView.OnItemClickListener onItemClickListener;
    protected AdapterView.OnItemLongClickListener onItemLongClickListener;

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    protected void onItemHolderClick(RecyclerView.ViewHolder itemHolder) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        } else {
            throw new IllegalStateException("Please call setOnItemClickListener method set the click event listeners");
        }
    }

    protected void onItemLongHolderClick(RecyclerView.ViewHolder itemHolder) {
        if (onItemLongClickListener != null) {
            onItemLongClickListener.onItemLongClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        } else {
            throw new IllegalStateException("Please call setOnItemLongClickListener method set the click event listeners");
        }
    }


}
