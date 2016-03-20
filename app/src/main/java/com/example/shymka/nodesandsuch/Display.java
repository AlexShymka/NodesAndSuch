package com.example.shymka.nodesandsuch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by alex on 3/20/2016.
 */
public class Display  extends android.app.Activity {

    private TextView hello;

    public void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.activity_inst);

        Intent intent = getIntent();
        String instructions = intent.getStringExtra("1");
        Double distance = intent.getDoubleExtra("2", 0);

        hello = (TextView) findViewById(R.id.textView);
        hello.setText("Instructions are " + instructions + "\n \n Distance is: " + distance);
    }
}
