package com.dotinfiny.tablesampleapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dotinfiny.tablesampleapp.model.Cell;
import com.dotinfiny.tablesampleapp.model.ColumnHeader;
import com.evrencoskun.tableview.TableView;
import com.evrencoskun.tableview.filter.Filter;
import com.evrencoskun.tableview.pagination.Pagination;
import com.google.gson.JsonElement;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {
    private Spinner moodFilter, genderFilter;
    private ImageButton previousButton, nextButton;
    private TextView tablePaginationDetails;
    private TableView mTableView;
    private Filter mTableFilter; // This is used for filtering the table.
    private Pagination mPagination; // This is used for paginating the table.

    private boolean mPaginationEnabled = false;

    List<ColumnHeader> columnHeader = new ArrayList<>();

    public MainFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_main, container, false);

        // Let's get TableView
        mTableView = layout.findViewById(R.id.tableview);

        for (String str : "Date,Meters,SPN%,DYG%,SIZ%,PRD%,WEV%,FIN%,TTL%".split(",")) {
            columnHeader.add(new ColumnHeader("1", str));
        }

        initializeTableView();

        return layout;
    }

    private void initializeTableView() {
        // Create TableView View model class  to group view models of TableView
        TableViewModel tableViewModel = new TableViewModel();
        // Create TableView Adapter
        TableViewAdapter tableViewAdapter = new TableViewAdapter(tableViewModel, getContext());

        mTableView.setAdapter(tableViewAdapter);
        mTableView.setTableViewListener(new TableViewListener(mTableView));
        mTableView.setHasFixedWidth(false);

        //        tableViewAdapter.setAllItems(tableViewModel.getColumnHeaderList(), new ArrayList<>(), tableViewModel.getCellList());
        tableViewAdapter.setColumnHeaderItems(columnHeader);
//        tableViewAdapter.setCellItems(tableViewModel.getCellList());

//        mTableView.setColumnWidth(0, 90);
//        mTableView.setColumnWidth(3, 100);
//        mTableView.setColumnWidth(4, 100);
//        mTableView.setColumnWidth(5, 500);

        initApi(tableViewAdapter);

    }


    private void initApi(TableViewAdapter tableViewAdapter) {
        List<List<Cell>> cell = new ArrayList<>();
        ApiCalls api = Clinet.getClient(getContext()).create(ApiCalls.class);
//        Call<List<JsonElement>> call = api.getData("EXEC EERP_Notification  '07 Mar 20 10:29 AM','07 Mar 20 11:29 PM','1'", "Machine,Batcher,Length,Grading,Notification Time", "Table");
        Call<List<JsonElement>> call = api.getData("Exec APPS_FabricProduction '01 Mar 20','18 Mar 20','1','1'", "Date,Meters,SPN%,DYG%,SIZ%,PRD%,WEV%,FIN%,TTL%", "TableFormatted");

        Log.d("Url",call.request().url().toString());

        call.enqueue(new Callback<List<JsonElement>>() {
            @Override
            public void onResponse(Call<List<JsonElement>> call, Response<List<JsonElement>> response) {
                Log.d("onResponse", "da");
                for (JsonElement element : response.body()) {
                    List<Cell> eachRow = new ArrayList<>();
                    for (JsonElement element1 : element.getAsJsonObject().get("Data").getAsJsonArray()) {
                        Log.d("value", "" + element1.getAsJsonObject().get("Values").getAsString());
                        eachRow.add(new Cell("id", "" + element1.getAsJsonObject().get("Values").getAsString().split("\\|")[0].toString()));
                    }
                    cell.add(eachRow);
                }
                tableViewAdapter.setCellItems(cell);
            }

            @Override
            public void onFailure(Call<List<JsonElement>> call, Throwable t) {
                Log.d("onFailure", "da");
            }
        });
    }
}