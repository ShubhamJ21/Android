package me.varunon9.remotecontrolpc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class Createlab extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText edittextc1;
    private Button buttonc1;
    private EditText edittextc2;
    private Button buttonc2;
    private ListView liste1;
    private ListView liste2;

    private ArrayList<String> items;
    private ArrayAdapter<String> Adap;
    private ArrayList<String> items1;
    private ArrayAdapter<String> Adap1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createlab);
        edittextc1 =findViewById(R.id.edittextc1);
        buttonc1 = findViewById(R.id.buttonc1);
        edittextc2 =findViewById(R.id.edittextc2);
        buttonc2 = findViewById(R.id.buttonc2);
        liste1=findViewById(R.id.liste1);
        liste2=findViewById(R.id.liste2);
        items =labhelper.reasData(this);
        Adap = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        liste1.setAdapter(Adap);
        items1 =pchelper.reasData(this);
        Adap1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items1);
        liste2.setAdapter(Adap1);
        buttonc1.setOnClickListener(this);
        buttonc2.setOnClickListener(this);
        liste1.setOnItemClickListener(this);
        liste2.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonc1:
                String itemEntered =edittextc1.getText().toString();
                Adap.add(itemEntered);
                edittextc1.setText("");
                 labhelper.Writedata(items,this);
                Toast.makeText(this,"Lab Created Successfully",LENGTH_LONG).show();
                break;
            case R.id.buttonc2:
                String itemEntered1 =edittextc2.getText().toString();
                Adap1.add(itemEntered1);
                edittextc2.setText("");
                 pchelper.Writedata(items,this);
                Toast.makeText(this,"PC added Successfully",LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (view.getId())
        {
            case R.id.liste1:
                Adap.notifyDataSetChanged();
                Toast.makeText(this,"Coming Soon",LENGTH_LONG).show();
                break;
            case R.id.liste2:
                items1.remove(position);
                Adap1.notifyDataSetChanged();
                Toast.makeText(this,"PC Deleted",LENGTH_LONG).show();
                break;
        }

    }
}
