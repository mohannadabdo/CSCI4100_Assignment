package com.example.a100523158.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AskQuestion extends AppCompatActivity {
    //Declaration of YES/NO Buttons
    private Button yesB;
    private Button noB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);

        WriteQuestion();

        YesPressed();
        NoPressed();

    }
    public void WriteQuestion(){

        TextView questions= (TextView) findViewById(R.id.qtext);
        //Get the bundle from MainMenu
        Bundle bundle = getIntent().getExtras();
        //Extract the questions in the bundle
        String quesArray = bundle.getString(getString(R.string.qArray));
        //Write the question to the textView
        questions.setText(quesArray);
    }

    public void YesPressed() {
        //Set Action for YES Button
        yesB = (Button) findViewById(R.id.yes);
        yesB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //Send Action to MainMenu
                Intent resultIntent = new Intent(Intent.ACTION_PICK);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    public void NoPressed() {
        //Set Action for NO Button
        noB = (Button) findViewById(R.id.no);
        noB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //Send Action to MainMenu
                Intent resultIntent = new Intent(Intent.ACTION_PICK);
                setResult(RESULT_CANCELED, resultIntent);
                finish();
            }
        });
    }
}
