package com.example.finals;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.finals.databinding.ActivityMain4Binding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity4 extends AppCompatActivity {

    ActivityMain4Binding binding;
    ActivityResultLauncher<String> mTakePhoto;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTakePhoto = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {

                        binding.imageView.setImageURI(result);

                    }
                }
                );
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mTakePhoto.launch("image/*");
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uploadImage();

            }
        });
    }

    private void uploadImage() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading File...");
        progressDialog.show();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.JAPAN);
        Date now = new Date();
        String fileName = formatter.format(now);
        storageReference = FirebaseStorage.getInstance().getReference("images/" + fileName);

        storageReference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        binding.imageView.setImageURI(null);
                        Toast.makeText(MainActivity4.this, "Succefully Uploaded",Toast.LENGTH_SHORT).show();
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                        Toast.makeText(MainActivity4.this, "Failed to Upload",Toast.LENGTH_SHORT).show();

                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && data !=null && data.getData() != null){
            imageUri = data.getData();
            binding.imageView.setImageURI(imageUri);
        }
    }
}