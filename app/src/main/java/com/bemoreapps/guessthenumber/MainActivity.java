package com.bemoreapps.guessthenumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends Activity {

    int randomNumber;
    int guesses;
    public TextView title;
    public TextView guessCounter;
    String titleText;

    public void guessCommence (View view) {

        EditText guessedNumber = (EditText) findViewById(R.id.guess);

        String guessedNumberString = guessedNumber.getText().toString();

        int guessedNumberInt = Integer.parseInt(guessedNumberString);

        String toastMessage = "";
        title = (TextView) findViewById(R.id.title);

        //This is where the magic happens!
        if (guessedNumberInt == randomNumber) {
            guesses++;
            toastMessage = "You're right! I was thinking of " + randomNumber + ". It took you " + guesses + " guesses!";
            titleText = "New Game. Enter Your Guess Below!";

            Random randomGenerator = new Random();
            randomNumber = randomGenerator.nextInt(101);
            guesses = 0;
        } else if (guessedNumberInt > randomNumber) {
            toastMessage = "Too High. Guess Lower.";
            titleText = guessedNumberInt + " is too High. Guess Lower.";
            guesses++;

        } else {
            toastMessage = "Too Low. Guess Higher.";
            titleText = guessedNumberInt + " is too Low. Guess Higher.";
            guesses++;

        }

        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
        title.setText(titleText);
        guessedNumber.setText("");
        guessCounter = (TextView) findViewById(R.id.guessCounter);
        guessCounter.setText("Guesses: " + guesses);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(101);
        guesses = 0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
