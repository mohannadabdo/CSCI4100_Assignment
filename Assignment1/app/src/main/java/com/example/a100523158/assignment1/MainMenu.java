package com.example.a100523158.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainMenu extends AppCompatActivity {
    //Counter of YES Answers
    int yesCounter;
    //Counter of NO Answers
    int noCounter;
    //Total number of YES & NO Answers
    int num;

    String cYString;
    String cNString;
    //Length of Questions Array
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void onClick(View view){

        //Sends an Intent to AskQuestion
        Intent i= new Intent(this,AskQuestion.class);
        //Array for all questions
        String questions[] = getResources().getStringArray(R.array.questions);
        //Create the bundle to show questions in AskQuestion
        Bundle bundle = new Bundle();

        length = questions.length;

        //Loops through the questions
        for(int x = 0; x < length; x++)
        {
            //Add questions to bundle
            bundle.putString(getString(R.string.qArray), questions[x]);
            //Add the bundle to the intent
            i.putExtras(bundle);
            startActivityForResult(i, 1);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        //If Answer is YES
        if (resultCode == RESULT_OK) {
            //Increment the number of YES Answers
            yesCounter++;

        //If Answer is NO
        }else if (resultCode == RESULT_CANCELED) {
            //Increment the number of NO Answers
            noCounter++;
        }
        //Total number of YES & NO Answers
        num = yesCounter + noCounter;

        //If Total Answers is a multiple of 5
        if(num % length == 0){
            SendAnswers();

            yesCounter = 0;
            noCounter = 0;
        }
    }

    public void SendAnswers(){

        cYString = Integer.toString(yesCounter);
        cNString = Integer.toString(noCounter);

        //Create the bundle to show number of YES Answers in Summary
        Bundle bundleCountY = new Bundle();
        bundleCountY.putString(getString(R.string.yesCounter), cYString);

        //Create the bundle to show number of NO Answers in Summary
        Bundle bundleCountN = new Bundle();
        bundleCountY.putString(getString(R.string.noCounter), cNString);

        //Sends an Intent to Summary
        Intent f = new Intent(this, Summary.class);

        //Add bundles to the intent
        f.putExtras(bundleCountY);
        f.putExtras(bundleCountN);

        startActivity(f);

    }

}
