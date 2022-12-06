package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);

        //Datos a mostrar - Data to display
        names = new ArrayList<String>();
        names.add("Carlos");
        names.add("Alejandro");
        names.add("Ruben");
        names.add("Santiago");

        names.add("Carlos2");
        names.add("Alejandro");
        names.add("Ruben");
        names.add("Santiago");

        names.add("Carlos3");
        names.add("Alejandro");
        names.add("Ruben");
        names.add("Santiago");

        names.add("Carlos4");
        names.add("Alejandro");
        names.add("Ruben");
        names.add("Santiago");

        //Option 1
        //Adaptador - Adapter
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //Enlazamos el adaptador con el ListView - Set adapter with ListView
        //listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListActivity.this,"Clicked: " + names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        //Option 2
        //Enlazamos con nuestro adaptador personalizado - Set custom adapter
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, names);
        listView.setAdapter(myAdapter);
    }
}