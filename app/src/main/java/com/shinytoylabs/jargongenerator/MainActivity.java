package com.shinytoylabs.jargongenerator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.ClipboardManager;
import android.content.ClipData;


public class MainActivity extends ActionBarActivity {

    private JargonGenerator _jargonGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _jargonGenerator = new JargonGenerator();
        JargonLoader.LoadJargon(_jargonGenerator, "Technical");

        // plug in the spinner
        final Spinner spinner = (Spinner)findViewById(R.id.spinnerJargonType);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedType = parent.getItemAtPosition(position).toString();
                JargonLoader.LoadJargon(_jargonGenerator, selectedType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // auto-generated method stub
            }
        });

        // initially hide the copy jargon button
        final Button copyButton = (Button)findViewById(R.id.buttonCopyJargon);
        copyButton.setVisibility(View.INVISIBLE);

        // plug in the copy jargon button
        copyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView view = (TextView)findViewById(R.id.textViewJargon);
                ClipboardManager clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("jargon", view.getText());
                clipboard.setPrimaryClip(clip);
            }
        });

        // plug in the generate button
        final Button generateButton = (Button)findViewById(R.id.buttonGenerate);
        generateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView view = (TextView)findViewById(R.id.textViewJargon);
                view.setText(_jargonGenerator.GenerateJargon());

                // now that we have text, show the copy button
                copyButton.setVisibility(View.VISIBLE);
            }
        });
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
