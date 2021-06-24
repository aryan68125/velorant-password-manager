package com.aditya.passwordgenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class AddActivity extends AppCompatActivity {

    //binding our EditText to our AddActivity
    EditText email_input;
    EditText Password_input;
    //code related to password generation
    //initializing all the three seek bars in the addNoteActivity
    SeekBar charater_numbers;
    SeekBar numbers;
    SeekBar Symbols;

    final int startingPosition = 0; //0 is the number which should be seekBar starting position
    TextView textView6;
    TextView textView7;
    TextView textView8;

    //calling our generate button
    Button Generate;
    Button Save_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        email_input = findViewById(R.id.email_input);
        Password_input = findViewById(R.id.Password_input);
        Password_input. setShowSoftInputOnFocus(false);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        // code related to password generation
        //Variables to hold number of characters,numbers and symbols
        final char num[]= {'1','2','3','4','5','6','7','8','9','0'};
        final char letters[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        final char symbol[]={'!','@','#','$','%','^','&','*','(',')','_'};

        //setting up all the textViews
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        //setting up all the seekbars
        charater_numbers = findViewById(R.id.charater_numbers);
        numbers = findViewById(R.id.numbers);
        Symbols = findViewById(R.id.Symbols);

        Generate = findViewById(R.id.Generate);
        Save_Password = findViewById(R.id.Save_Password);

        int max = 9; //10 is the number which can be either no of symbols,characters or numbers

        //setting up the max and starting position of the numbers seekbar
        numbers.setMax(max);
        numbers.setProgress(startingPosition);

        numbers.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("characters", Integer.toString(progress));
                //calling Update textView6
                String Progress_string = Integer.toString(progress);
                textView7.setText(Progress_string);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //setting up the Symbols seek bar
        Symbols.setMax(max);
        Symbols.setProgress(startingPosition);

        Symbols.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("characters", Integer.toString(progress));
                //calling Update textView6
                String Progress_string = Integer.toString(progress);
                textView8.setText(Progress_string);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //setting up the character seekbar
        charater_numbers.setMax(max);
        charater_numbers.setProgress(startingPosition);

        charater_numbers.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("characters", Integer.toString(progress));
                //calling Update textView6
                String Progress_string = Integer.toString(progress);
                textView6.setText(Progress_string);


            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Logic for generating randome password from the list present above
        Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num_length;
                int letter_length;
                int symbol_length;
                //getting all the data related to password generator
                num_length= numbers.getProgress();
                symbol_length = Symbols.getProgress();
                letter_length = charater_numbers.getProgress();

                Random random = new Random();

                //code that will generate randome numbers and store it inside a StringBuffer that will store numbers
                // Create a StringBuffer to store the result for numbers
                StringBuffer numbers = new StringBuffer(num_length);
                for (int i=0;i<num_length;i++)
                {

            /*
            int nextRandomChar = lowerLimit
                                 + (int)(random.nextFloat()
                                         * (upperLimit - lowerLimit + 1));
             */
                    int nextRandomChar1 = 0
                            + (int)(random.nextFloat()
                            * (9));

                    char n = num[nextRandomChar1];

                    // append a character at the end of bs
                    numbers.append(n);

                }

                //code that will generate random letters and store it inside a StringBuffer that will store letters
                // Create a StringBuffer to store the result for letters
                StringBuffer letter = new StringBuffer(letter_length);
                for (int i=0;i<letter_length;i++)
                {

            /*
            int nextRandomChar = lowerLimit
                                 + (int)(random.nextFloat()
                                         * (upperLimit - lowerLimit + 1));
             */
                    int nextRandomChar2 = 0
                            + (int)(random.nextFloat()
                            * (25));
                    char l = letters[nextRandomChar2];
                    // append a character at the end of bs
                    letter.append(l);

                }

                //code that will generate random symbols and store it inside a StringBuffer that will store symbols
                // Create a StringBuffer to store the result for symbols
                StringBuffer symbols = new StringBuffer(symbol_length);
                for (int i=0;i<symbol_length;i++)
                {

            /*
            int nextRandomChar = lowerLimit
                                 + (int)(random.nextFloat()
                                         * (upperLimit - lowerLimit + 1));
             */
                    int nextRandomChar2 = 0
                            + (int)(random.nextFloat()
                            * (10));
                    char s = symbol[nextRandomChar2];

                    // append a character at the end of bs
                    symbols.append(s);

                }
                //now saving the result of String buffer in a String variable
                String sym = symbols.toString();
                String numb = numbers.toString();
                String lettersS=letter.toString();

                //now we will merge all the three Strings
                // To store the final string
                StringBuilder Password_result = new StringBuilder();
                // For every index in the strings
                for (int i = 0; i < sym.length() || i < numb.length() || i<lettersS.length(); i++) {

                    // First choose the ith character of the
                    // first string if it exists
                    if (i < lettersS.length())
                        Password_result.append(lettersS.charAt(i));

                    // Then choose the ith character of the
                    // second string if it exists
                    if (i < numb.length())
                        Password_result.append(numb.charAt(i));
                    // Then choose the ith character of the
                    // third string if it exists
                    if (i < sym.length())
                        Password_result.append(sym.charAt(i));
                }

                //now generating final Password
                final String Passwd = Password_result.toString();
                Password_input.setText(Passwd);
            }
        });

        //set onclick Listener on our save button
        Save_Password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //create MyDatabaseHelper class object
                    MyDatabaseHelper MyDB = new MyDatabaseHelper(AddActivity.this);

                    //getting data from our three editText
                    String email_address_AddActivity = email_input.getText().toString();
                    String password_AddActivity = Password_input.getText().toString();

                    //now we can call addPassword method from our MyDatabaseHelper class
                    MyDB.addPassword(email_address_AddActivity, password_AddActivity);
                    email_input.getText().clear();
                    Password_input.getText().clear();
            }
        });

    }//oncreate function closed

    // this event will enable the back activity action bar back button
    // function to the button on press activity action bar back button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                overridePendingTransition(R.anim.nothing, R.anim.slide_out_right);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //this method handles back button of android os
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.nothing, R.anim.slide_out_right);

    }
}