package com.example.a100523158.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        WriteYesCount();
        WriteNoCount();

    }
    public void WriteYesCount(){
        TextView counterYes = (TextView) findViewById(R.id.numYes);
        //Get the bundle from MainMenu
        Bundle bundleCountY = getIntent().getExtras();
        //Extract the number of YES Answers
        String cY = bundleCountY.getString(getString(R.string.yesCounter));
        //Write the Total Number of YES Answers into textView
        counterYes.setText(cY);
    }

    public void WriteNoCount(){
        TextView counterNo = (TextView) findViewById(R.id.numNo);
        //Get the bundle from ManiMenu
        Bundle bundleCountN = getIntent().getExtras();
        //Extract the number of NO Answers
        String cN = bundleCountN.getString(getString(R.string.noCounter));
        //Write the Total Number of NO Answers into textView
        counterNo.setText(cN);
    }
}
