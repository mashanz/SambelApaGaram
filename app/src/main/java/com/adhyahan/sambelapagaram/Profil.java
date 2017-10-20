package com.adhyahan.sambelapagaram;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Profil extends AppCompatActivity {

    private ImageView imageView;

    private static final String TAG = "MPROG Profil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        imageView = (ImageView) findViewById(R.id.imageProfil);

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

        try {
            Log.i(TAG, "createImageFile");
            createImageFile();
            Log.i(TAG, "createImageFile SUCCESS");
        } catch (IOException e) {
            Log.i(TAG, "createImageFile ERROR");
            e.printStackTrace();
        }

        // TODO pindah
        Intent intent = new Intent(getApplicationContext(), FeedsActifity.class);
        startActivity(intent);
        finish();
    }

    //TODO IMAGE TAKE FOTO
    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
}
