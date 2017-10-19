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

public class FeedsActifity extends AppCompatActivity {

    private static final String TAG = "MPROG FeedsActifity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds_actifity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        Log.i(TAG,"onCreateOption");
        final MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Log.i(TAG,"onOptionItemSelected");
        switch (item.getItemId()){
            case R.id.menuAdd:
                onAddFeeds();
                return true;
            case R.id.menuProfil:
                onProfil();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onAddFeeds(){

        Intent intent = new Intent(getApplicationContext(), EditFeeds.class);
        startActivity(intent);
        finish();
    }

    public void onProfil(){

        Intent intent = new Intent(getApplicationContext(), Profil.class);
        startActivity(intent);
        finish();
    }
}
