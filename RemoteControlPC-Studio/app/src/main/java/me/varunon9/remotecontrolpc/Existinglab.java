package me.varunon9.remotecontrolpc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class Existinglab extends AppCompatActivity implements View.OnClickListener{

    private Button buttonh;

    private ArrayList<String> items;
    private ArrayAdapter<String> Adap;
    private ArrayList<String> items1;
    private ArrayAdapter<String> Adap1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existinglab);
        buttonh =findViewById(R.id.buttonh);

        buttonh.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonh:
                Intent intent2 =new Intent(this, MainActivity.class);
                startActivity(intent2);
                Toast.makeText(this,"DHCP Successfully Opened",LENGTH_LONG).show();
                break;
        }
    }
}
