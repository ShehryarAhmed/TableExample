package com.dotinfiny.tablesampleapp.viewHolder;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dotinfiny.tablesampleapp.R;
import com.dotinfiny.tablesampleapp.model.ColumnHeader;
import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractSorterViewHolder;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.evrencoskun.tableview.sort.SortState;

public class ColumnHeaderViewHolder extends AbstractViewHolder {

    private static final String LOG_TAG = ColumnHeaderViewHolder.class.getSimpleName();

    @NonNull
    private final TextView column_header_textview;

    @Nullable
    private final ITableView tableView;

    public ColumnHeaderViewHolder(@NonNull View itemView, @Nullable ITableView tableView) {
        super(itemView);
        this.tableView = tableView;
        column_header_textview = itemView.findViewById(R.id.column_header_textView);

    }


    public void setColumnHeader(@Nullable ColumnHeader columnHeader) {
        column_header_textview.setText(String.valueOf(columnHeader.getData()));

    }


}