package com.example.abnormal.dialoglistview;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abnormal on 09/09/18.
 */

public class PlayersFragment extends DialogFragment implements AdapterView.OnItemSelectedListener {

    Button cancel;
    ListView listView;
    SearchView searchView;
    Spinner spinner;
    ArrayAdapter<String> adapter;
    String[] players={"Lionel Messi","Christiano Ronaldo","Neymar","Gareth Bale"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View rootView = inflater.inflate(R.layout.dialoglayout, null);

        //SET TITLE DIALOG TITLE
        getDialog().setTitle("Best Players In The World");

        //Spinner
        spinner = (Spinner) rootView.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        final List<String> categories = new ArrayList<String>();
        categories.add("uncategories");
        categories.add("Berita");
        categories.add("Tips");

        //ListView
        listView = (ListView) rootView.findViewById(R.id.listView);
        adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,players);
        listView.setAdapter(adapter);
        //SearchView
        searchView = (SearchView) rootView.findViewById(R.id.serachView);
        searchView.setQueryHint("Search..");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String txt) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean onQueryTextChange(String txt) {
                // TODO Auto-generated method stub

                adapter.getFilter().filter(txt);
                return false;
            }
        });

        //BUTTON
        cancel = (Button) rootView.findViewById(R.id.textView);
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                dismiss();
            }
        });

        return rootView;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
