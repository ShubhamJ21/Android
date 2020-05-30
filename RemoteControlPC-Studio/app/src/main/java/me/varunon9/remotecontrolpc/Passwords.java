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

public class Passwords extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{
    private Button buttonp;
    private EditText edittextp;
    private ListView listp;
    private ArrayList<String> arraylistp;
    private ArrayAdapter<String> arrayadapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwords);
        buttonp = findViewById(R.id.buttonp);
        edittextp =findViewById(R.id.edittextp);
        listp =findViewById(R.id.listp);
        arraylistp =helperpasswords.reasData(this);
        arrayadapp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arraylistp);
        listp.setAdapter(arrayadapp);
        buttonp.setOnClickListener(this);
        listp.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonp:
                String itemEntered = edittextp.getText().toString();
                arrayadapp.add(itemEntered);
                edittextp.setText("");
                helperpasswords.Writedata(arraylistp, this);
                Toast.makeText(this, "Password Saved", LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            arraylistp.remove(position);
            arrayadapp.notifyDataSetChanged();
            Toast.makeText(this,"Delete",LENGTH_LONG).show();

        }
}
