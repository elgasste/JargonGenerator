package com.shinytoylabs.jargongenerator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
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

        // default to technical jargon
        _jargonGenerator = new JargonGenerator();
        JargonLoader.LoadJargon(_jargonGenerator, "technical");

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

        // initially hide the copy jargon button and text
        final Button copyButton = (Button)findViewById(R.id.buttonCopyJargon);
        copyButton.setVisibility(View.INVISIBLE);

        final TextView copiedText = (TextView)findViewById(R.id.textViewCopied);
        copiedText.setVisibility(View.INVISIBLE);

        // plug in the copy jargon button
        copyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            TextView jargonView = (TextView)findViewById(R.id.textViewJargon);
            ClipboardManager clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("jargon", jargonView.getText());
            clipboard.setPrimaryClip(clip);

            // fade copied text in/out
            TextView copiedView = (TextView)findViewById(R.id.textViewCopied);

            AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
            AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
            fadeIn.setDuration(100);
            fadeOut.setDuration(500);
            fadeOut.setFillAfter(true);
            fadeOut.setStartOffset(2000 + fadeIn.getStartOffset());

            copiedView.startAnimation(fadeIn);
            copiedView.startAnimation(fadeOut);
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
        int id = item.getItemId();

        // load the selected jargon type
        switch(id) {
            case R.id.action_technical:
                JargonLoader.LoadJargon(_jargonGenerator, "technical");
                break;
            case R.id.action_audio:
                JargonLoader.LoadJargon(_jargonGenerator, "audio");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
