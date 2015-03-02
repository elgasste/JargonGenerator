package com.shinytoylabs.jargongenerator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.content.ClipboardManager;
import android.content.ClipData;


public class MainActivity extends ActionBarActivity {

    private JargonGenerator _jargonGenerator;
    private Button _generateButton;
    private Button _copyButton;
    private TextView _jargonTextView;
    private TextView _copiedTextView;

    private void updateAppTitle(String prefix) {
        setTitle(prefix + " " + getString(R.string.app_name));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _generateButton = (Button)findViewById(R.id.buttonGenerate);
        _copyButton = (Button)findViewById(R.id.buttonCopyJargon);
        _jargonTextView = (TextView)findViewById(R.id.textViewJargon);
        _copiedTextView = (TextView)findViewById(R.id.textViewCopied);

        // default to technical jargon
        _jargonGenerator = new JargonGenerator();
        JargonLoader.LoadJargon(_jargonGenerator, "technical");
        updateAppTitle(getString(R.string.action_technical));

        // initially hide the copy jargon button and text
        _copyButton.setVisibility(View.INVISIBLE);
        _copiedTextView.setVisibility(View.INVISIBLE);

        // plug in the generate button
        _generateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // show the jargon text and copy button
                _jargonTextView.setText(_jargonGenerator.GenerateJargon());
                _copyButton.setVisibility(View.VISIBLE);
            }
        });

        // plug in the copy jargon button
        _copyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("jargon", _jargonTextView.getText());
                clipboard.setPrimaryClip(clip);

                // fade copied text in/out
                AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
                AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
                fadeIn.setDuration(100);
                fadeOut.setDuration(500);
                fadeOut.setFillAfter(true);
                fadeOut.setStartOffset(2000 + fadeIn.getStartOffset());

                _copiedTextView.startAnimation(fadeIn);
                _copiedTextView.startAnimation(fadeOut);
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
        // reset jargon view and hide copy button
        _jargonTextView.setText("");
        _copiedTextView.setVisibility(View.INVISIBLE);
        _copyButton.setVisibility(View.INVISIBLE);

        // load the selected jargon type
        switch(item.getItemId()) {
            case R.id.action_technical:
                JargonLoader.LoadJargon(_jargonGenerator, "technical");
                updateAppTitle(getString(R.string.action_technical));
                break;
            case R.id.action_audio:
                JargonLoader.LoadJargon(_jargonGenerator, "audio");
                updateAppTitle(getString(R.string.action_audio));
                break;
            case R.id.action_excuse:
                JargonLoader.LoadJargon(_jargonGenerator, "excuse");
                updateAppTitle(getString(R.string.action_excuse));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
