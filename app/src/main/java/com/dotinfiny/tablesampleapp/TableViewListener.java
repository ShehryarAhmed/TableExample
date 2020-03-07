package com.dotinfiny.tablesampleapp;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.dotinfiny.tablesampleapp.popup.ColumnHeaderLongPressPopup;
//import com.dotinfiny.tablesampleapp.popup.RowHeaderLongPressPopup;
import com.dotinfiny.tablesampleapp.viewHolder.ColumnHeaderViewHolder;
import com.evrencoskun.tableview.TableView;
import com.evrencoskun.tableview.listener.ITableViewListener;

public class TableViewListener implements ITableViewListener {
    @NonNull
    private Context mContext;
    @NonNull
    private TableView mTableView;

    public TableViewListener(@NonNull TableView tableView) {
        this.mContext = tableView.getContext();
        this.mTableView = tableView;
    }

    @Override
    public void onCellClicked(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {

    }

    @Override
    public void onCellLongPressed(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {

    }

    @Override
    public void onColumnHeaderClicked(@NonNull RecyclerView.ViewHolder columnHeaderView, int column) {
    }

    @Override
    public void onColumnHeaderLongPressed(@NonNull RecyclerView.ViewHolder columnHeaderView, int column) {

    }

    @Override
    public void onRowHeaderClicked(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {

    }

    @Override
    public void onRowHeaderLongPressed(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {

    }
}