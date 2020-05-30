package me.varunon9.remotecontrolpc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class Admininfo extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText ItemET;
    private Button btn;
    private ListView ItemList;
    private ArrayList<String> items;
    private ArrayAdapter<String> Adap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admininfo);
        ItemET = findViewById(R.id.edittexta);
        btn = findViewById(R.id.buttona);
        ItemList= findViewById(R.id.lista);

        items =helperadmin.reasData(this);
        Adap = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        ItemList.setAdapter(Adap);


        btn.setOnClickListener(this);
        ItemList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttona:
                String itemEntered =ItemET.getText().toString();
                Adap.add(itemEntered);
                ItemET.setText("");
                helperadmin.Writedata(items,this);
                Toast.makeText(this,"Admin Info_added",LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        Adap.notifyDataSetChanged();
        Toast.makeText(this,"Delete",LENGTH_LONG).show();

    }
}
