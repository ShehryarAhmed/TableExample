package com.dotinfiny.tablesampleapp;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dotinfiny.tablesampleapp.model.Cell;
import com.dotinfiny.tablesampleapp.model.ColumnHeader;
import com.dotinfiny.tablesampleapp.model.RowHeader;
import com.dotinfiny.tablesampleapp.viewHolder.CellViewHolder;
import com.dotinfiny.tablesampleapp.viewHolder.ColumnHeaderViewHolder;
import com.dotinfiny.tablesampleapp.viewHolder.GenderCellViewHolder;
import com.dotinfiny.tablesampleapp.viewHolder.MoodCellViewHolder;
import com.dotinfiny.tablesampleapp.viewHolder.RowHeaderViewHolder;
import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.evrencoskun.tableview.sort.SortState;

/**
 * Created by evrencoskun on 11/06/2017.
 * <p>
 * This is a sample of custom TableView Adapter.
 */

public class TableViewAdapter extends AbstractTableAdapter<ColumnHeader, RowHeader, Cell> {

    private static final int MOOD_CELL_TYPE = 1;
    private static final int GENDER_CELL_TYPE = 2;

    private static final String LOG_TAG = TableViewAdapter.class.getSimpleName();

    @NonNull
    private TableViewModel mTableViewModel;
    private Context context;

    public TableViewAdapter(@NonNull TableViewModel tableViewModel, Context context) {
        super();
        this.mTableViewModel = tableViewModel;
        this.context = context;
    }


    @NonNull
    @Override
    public AbstractViewHolder onCreateCellViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO check
        Log.e(LOG_TAG, " onCreateCellViewHolder has been called");

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.table_view_cell_layout, parent, false);

        return new CellViewHolder(layout);
    }


    @Override
    public void onBindCellViewHolder(@NonNull AbstractViewHolder holder, @Nullable Cell cellItemModel, int
            columnPosition, int rowPosition) {

        switch (holder.getItemViewType()) {
            case MOOD_CELL_TYPE:
                MoodCellViewHolder moodViewHolder = (MoodCellViewHolder) holder;

                moodViewHolder.cell_image.setImageResource(mTableViewModel.getDrawable((int) cellItemModel
                        .getData(), false));
                break;
            case GENDER_CELL_TYPE:
                GenderCellViewHolder genderViewHolder = (GenderCellViewHolder) holder;

                genderViewHolder.cell_image.setImageResource(mTableViewModel.getDrawable((int)
                        cellItemModel.getData(), true));
                break;
            default:
                // Get the holder to update cell item text
                CellViewHolder viewHolder = (CellViewHolder) holder;
                viewHolder.setCell(cellItemModel);
                break;
        }

    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateColumnHeaderViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table_view_column_header_layout, parent, false);

        return new ColumnHeaderViewHolder(layout, getTableView());
    }


    @Override
    public void onBindColumnHeaderViewHolder(@NonNull AbstractViewHolder holder, @Nullable ColumnHeader
            columnHeaderItemModel, int columnPosition) {

        // Get the holder to update cell item text
        ColumnHeaderViewHolder columnHeaderViewHolder = (ColumnHeaderViewHolder) holder;
        columnHeaderViewHolder.setColumnHeader(columnHeaderItemModel);
    }


    @NonNull
    @Override
    public AbstractViewHolder onCreateRowHeaderViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Get Row Header xml Layout
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table_view_row_header_layout, parent, false);
        return new RowHeaderViewHolder(layout);
    }


    @Override
    public void onBindRowHeaderViewHolder(@NonNull AbstractViewHolder holder, @Nullable RowHeader rowHeaderItemModel,
                                          int rowPosition) {
        // Get the holder to update row header item text
        RowHeaderViewHolder rowHeaderViewHolder = (RowHeaderViewHolder) holder;
        rowHeaderViewHolder.row_header_textview.setText(String.valueOf(rowHeaderItemModel.getData()));
        Log.d("row", "" + rowHeaderItemModel.getData());

    }

    @NonNull
    @Override
    public View onCreateCornerView(@NonNull ViewGroup parent) {
        // Get Corner xml layout
        View corner = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table_view_corner_layout, parent, false);
        return corner;
    }

    @Override
    public int getColumnHeaderItemViewType(int position) {
        return 0;
    }

    @Override
    public int getRowHeaderItemViewType(int position) {
        return 0;
    }

    @Override
    public int getCellItemViewType(int column) {

        switch (column) {
            case TableViewModel.MOOD_COLUMN_INDEX:
//                return MOOD_CELL_TYPE;
                return 0;
            case TableViewModel.GENDER_COLUMN_INDEX:
//                return GENDER_CELL_TYPE;
                return 0;
            default:
                // Default view type
                return 0;
        }
    }
}