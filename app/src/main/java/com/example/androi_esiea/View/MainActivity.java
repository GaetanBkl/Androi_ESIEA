package com.example.androi_esiea.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androi_esiea.Controller.Controller;
import com.example.androi_esiea.Model.Films;
import com.example.androi_esiea.R;

import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void displayListFilms(List<Films> filmsList) {
            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            recyclerView.setHasFixedSize(true);
            // use a linear layout manager
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            mAdapter = new MyAdapter(filmsList);
            recyclerView.setAdapter(mAdapter);
        }
    public void main(String[] args) {
        Controller controller = new Controller(this,Controller.getAPI());
        controller.start();
    }

}