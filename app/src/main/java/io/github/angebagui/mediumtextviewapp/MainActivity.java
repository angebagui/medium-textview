package io.github.angebagui.mediumtextviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

//https://github.com/angebagui/medium-textview/blob/master/screenshot/Screenshot_2016-08-14-19-59-32.png
//https://github.com/angebagui/medium-textview/blob/master/screenshot/Screenshot_2016-08-14-19-59-48.png

import io.github.angebagui.mediumtextview.MediumTextView;

public class MainActivity extends AppCompatActivity {

    final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Content content = Content.deserialize(this);

        if(content == null){
            return;
        }
        MediumTextView mediumTextView = (MediumTextView)findViewById(R.id.medium_text_view);
        mediumTextView.setText(content.getContent());


        //Toast.makeText(this, content.getContent(), Toast.LENGTH_LONG).show();
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
