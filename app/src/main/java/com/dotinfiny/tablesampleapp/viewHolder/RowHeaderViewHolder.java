package com.dotinfiny.tablesampleapp.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.dotinfiny.tablesampleapp.R;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

public class RowHeaderViewHolder extends AbstractViewHolder {
    @NonNull
    public final TextView row_header_textview;

    public RowHeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        row_header_textview = itemView.findViewById(R.id.row_header_textview);
    }
}