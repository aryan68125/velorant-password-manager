package com.aditya.passwordgenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ViewActivity extends AppCompatActivity {

    //binding our EditText to our AddActivity
    EditText email_input_view_activity;
    EditText Password_input_view_activity;
    //code related to password generation
    //initializing all the three seek bars in the addNoteActivity
    SeekBar charater_numbers_view_activity;
    SeekBar numbers_view_activity;
    SeekBar Symbols_view_activity;

    final int startingPosition = 0; //0 is the number which should be seekBar starting position
    TextView textView6_view_activity;
    TextView textView7_view_activity;
    TextView textView8_view_activity;

    //calling our generate button
    Button Generate_view_activity;
    Button Save_Changes_view_activity;

    //creating an object of MyDatabaseHelper Class
    MyDatabaseHelper mydb;

    String id_String,email_String,Password_String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        email_input_view_activity = findViewById(R.id.email_input_view_activity);
        Password_input_view_activity = findViewById(R.id.Password_input_view_activity);
        Password_input_view_activity. setShowSoftInputOnFocus(false);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        //First call this
        getIntentDataFromCustomAdapter();

        // code related to password generation
        //Variables to hold number of characters,numbers and symbols
        final char num[]= {'1','2','3','4','5','6','7','8','9','0'};
        final char letters[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        final char symbol[]={'!','@','#','$','%','^','&','*','(',')','_'};

        //setting up all the textViews
        textView6_view_activity = findViewById(R.id.textView6_view_activity);
        textView7_view_activity = findViewById(R.id.textView7_view_activity);
        textView8_view_activity = findViewById(R.id.textView8_view_activity);
        //setting up all the seekbars
        charater_numbers_view_activity = findViewById(R.id.charater_numbers_view_activity);
        numbers_view_activity = findViewById(R.id.numbers_view_activity);
        Symbols_view_activity = findViewById(R.id.Symbols_view_activity);

        Generate_view_activity = findViewById(R.id.Generate_view_activity);
        Save_Changes_view_activity = findViewById(R.id.Save_Changes_view_activity);

        int max = 9; //10 is the number which can be either no of symbols,characters or numbers

        //setting up the max and starting position of the numbers seekbar
        numbers_view_activity.setMax(max);
        numbers_view_activity.setProgress(startingPosition);

        numbers_view_activity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("characters", Integer.toString(progress));
                //calling Update textView6
                String Progress_string = Integer.toString(progress);
                textView7_view_activity.setText(Progress_string);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //setting up the Symbols seek bar
        Symbols_view_activity.setMax(max);
        Symbols_view_activity.setProgress(startingPosition);

        Symbols_view_activity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("characters", Integer.toString(progress));
                //calling Update textView6
                String Progress_string = Integer.toString(progress);
                textView8_view_activity.setText(Progress_string);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //setting up the character seekbar
        charater_numbers_view_activity.setMax(max);
        charater_numbers_view_activity.setProgress(startingPosition);

        charater_numbers_view_activity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("characters", Integer.toString(progress));
                //calling Update textView6
                String Progress_string = Integer.toString(progress);
                textView6_view_activity.setText(Progress_string);


            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Logic for generating randome password from the list present above
        Generate_view_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num_length;
                int letter_length;
                int symbol_length;
                //getting all the data related to password generator
                num_length= numbers_view_activity.getProgress();
                symbol_length = Symbols_view_activity.getProgress();
                letter_length = charater_numbers_view_activity.getProgress();

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
                Password_input_view_activity.setText(Passwd);
            }
        });

        //set onclick Listener on our save changed button
        Save_Changes_view_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Second initialize the class and call update() function from that class
                //initiating MyDatabaseHelper class
                mydb = new MyDatabaseHelper(ViewActivity.this);
                //get text from editText
                String email_input_view_activity_temp_editText = email_input_view_activity.getText().toString();
                String Password_input_view_activity_temp_editText = Password_input_view_activity.getText().toString();
                mydb.UpdatePassword(id_String,email_input_view_activity_temp_editText,Password_input_view_activity_temp_editText);
            }
        });

    } //oncreate function closed

    //get data from the CustomAdapter Layout via intent
    void getIntentDataFromCustomAdapter()
    {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("email") && getIntent().hasExtra("password"))
        {
            //get data from CustomAdapter class via Intent
            id_String = getIntent().getStringExtra("id");
            email_String = getIntent().getStringExtra("email");
            Password_String = getIntent().getStringExtra("password");

            //setting data to the editText
            email_input_view_activity.setText(email_String);
            Password_input_view_activity.setText(Password_String);
        }
        else
        {
            Toast.makeText(this,"No data Err A113 000x2273821",Toast.LENGTH_SHORT).show();
        }
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.copy){
            //here logic for copying the password into the clipboard from editText will come

            //here we will copy the contents of the password to the clipboard of the device
            ClipboardManager clipboardManager =(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData data = ClipData.newPlainText("copy",Password_input_view_activity.getText().toString());
            clipboardManager.setPrimaryClip(data);
            Toast.makeText(ViewActivity.this,"Password Copied!",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.delete){
           //here logic for deleting the password from database will come
            //this function creates a delete dialogue bax with yes to delete and no to abort options
            deleteConfirmDialogBox();
        }
        else if(item.getItemId() == android.R.id.home) {
            this.finish();
            overridePendingTransition(R.anim.nothing, R.anim.slide_out_right);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //this functioon will create a delete confirm dialog box
    void deleteConfirmDialogBox()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.danger);
        builder.setTitle("Delete "+ email_String + " ?");
        builder.setMessage("Are you sure you want to delete "+ email_String+ " and it's associated Password ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //create MyDatabaseHelper Class object so that we can use the function deleteOneRowFromTheTableOfDatabase(String row_id)
                //from MyDatabaseHelper class
                MyDatabaseHelper mydb = new MyDatabaseHelper(ViewActivity.this);
                mydb.deleteOneRowFromTheTableOfDatabase(id_String);
                //finish(); will destroy our update activity and open the main Activity
                finish();
                overridePendingTransition(R.anim.nothing, R.anim.slide_out_right);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //do nothing if no is pressed by the user in the delete dialogue box
            }
        });
        builder.create().show();
    }

    //this method handles back button of android os
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.nothing, R.anim.slide_out_right);

    }

}