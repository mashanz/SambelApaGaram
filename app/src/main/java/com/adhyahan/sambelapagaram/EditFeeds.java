package com.adhyahan.sambelapagaram;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class EditFeeds extends AppCompatActivity {

    private static final String TAG = "MPROG EditFeeds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_feeds);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        Log.i(TAG,"onCreateOption");
        final MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actifity_feeds, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Log.i(TAG,"onOptionItemSelected");
        switch (item.getItemId()){
            case R.id.menuPost:
                onPostingFeeds();
                return true;
            case R.id.menuCencel:
                onCencel();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onPostingFeeds(){
        Log.i(TAG,"onCreate");
        Context context = getApplicationContext();
        CharSequence text = "onPostingFeeds";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent intent = new Intent(getApplicationContext(), FeedsActifity.class);
        startActivity(intent);
        finish();
    }

    public void onCencel(){
        Intent intent = new Intent(getApplicationContext(), FeedsActifity.class);
        startActivity(intent);
        finish();
    }
}
