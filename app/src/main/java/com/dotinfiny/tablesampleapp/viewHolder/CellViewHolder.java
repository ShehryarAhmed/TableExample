package com.dotinfiny.tablesampleapp.viewHolder;

import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dotinfiny.tablesampleapp.R;
import com.dotinfiny.tablesampleapp.model.Cell;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

public class CellViewHolder extends AbstractViewHolder {
    @NonNull
    private final TextView cell_textview;
//    @NonNull
//    private final LinearLayout cell_container;

    public CellViewHolder(@NonNull View itemView) {
        super(itemView);
        cell_textview = itemView.findViewById(R.id.cell_data);
//        cell_container = itemView.findViewById(R.id.cell_container);
    }

    public void setCell(@Nullable Cell cell) {
        cell_textview.setText(String.valueOf(cell.getData()));
//        if(isNumeric(String.valueOf(cell.getData()))){
//            cell_textview.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
//        }else{
//            cell_textview.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
//        }
        // If your TableView should have auto resize for cells & columns.
        // Then you should consider the below lines. Otherwise, you can ignore them.

        // It is necessary to remeasure itself.
//        cell_container.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
//
//        cell_textview.requestLayout();
    }

    public boolean isNumeric(String str) {
        try {
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}