package com.dotinfiny.tablesampleapp.viewHolder;

import android.view.View;

import androidx.annotation.NonNull;

import com.dotinfiny.tablesampleapp.R;
import com.dotinfiny.tablesampleapp.TableViewModel;

public class GenderCellViewHolder extends MoodCellViewHolder {

    public GenderCellViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void setData(Object data) {
        int gender = (int) data;
        int genderDrawable = gender == TableViewModel.BOY ? R.drawable.ic_male : R.drawable.ic_female;

        cell_image.setImageResource(genderDrawable);
    }
}