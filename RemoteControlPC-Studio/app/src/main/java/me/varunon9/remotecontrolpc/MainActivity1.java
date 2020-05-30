package me.varunon9.remotecontrolpc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.support.v7.app.AppCompatActivity;

 public class MainActivity1 extends AppCompatActivity implements View.OnClickListener{
    private Button createlab;
    private Button existinglab;
    private Button passwords;
    private Button admininfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_main1);
            createlab =findViewById(R.id.createlab);
            existinglab=findViewById(R.id.existinglab);
            passwords =findViewById(R.id.passwords);
            admininfo =findViewById(R.id.admininfo);
            createlab.setOnClickListener(this);
        existinglab.setOnClickListener(this);
        passwords.setOnClickListener(this);
        admininfo.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.createlab:
                Intent intent1 =new Intent(this, Createlab.class);
                startActivity(intent1);
                break;
            case R.id.existinglab:
                Intent intent2 =new Intent(this, Existinglab.class);
                startActivity(intent2);
                break;
            case R.id.passwords:
                Intent intent3 =new Intent(this, Passwords.class);
                startActivity(intent3);
                break;
            case R.id.admininfo:
                Intent intent4 =new Intent(this, Admininfo.class);
                startActivity(intent4);
                break;
        }
    }



    }
