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

public class Profil extends AppCompatActivity {

    private static final String TAG = "MPROG Profil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        Log.i(TAG,"onCreateOption");
        final MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.profil_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Log.i(TAG,"onOptionItemSelected");
        switch (item.getItemId()){
            case R.id.menuSave:
                onSave();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void onSave(){
        Log.i(TAG,"onSave");
        Context context = getApplicationContext();
        CharSequence text = "onSave";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent intent = new Intent(getApplicationContext(), FeedsActifity.class);
        startActivity(intent);
        finish();
    }
}
