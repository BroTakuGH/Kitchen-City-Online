package com.example.finals;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finals.databinding.ActivityMain4Binding;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity4 extends AppCompatActivity {

//    ActivityMain4Binding binding;
//    ActivityResultLauncher<String> mTakePhoto;
//    StorageReference storageReference;
//    ProgressDialog progressDialog;
 Uri imageUri;
 private ImageView uploadImage;
 Button button;
 EditText price;
 final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Images");
 final private StorageReference storageReference = FirebaseStorage.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        button = findViewById(R.id.button2);
        price = findViewById(R.id.editText);
        uploadImage = findViewById(R.id.imageView);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            imageUri = data.getData();
                            uploadImage.setImageURI(imageUri);
                        } else {
                            Toast.makeText(MainActivity4.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent();
                photoPicker.setAction(Intent.ACTION_GET_CONTENT);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageUri != null) {
                    uploadToFirebase(imageUri);
                } else {
                    Toast.makeText(MainActivity4.this, "Please select image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void uploadToFirebase (Uri uri){
        String caption = price.getText().toString();
        final StorageReference imageReference = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(uri));

        imageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                    DataClass dataClass = new DataClass(uri.toString(), caption);
                    String key = databaseReference.push().getKey();
                    databaseReference.child(key).setValue(dataClass);
                        Toast.makeText(MainActivity4.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity4.this, adminui.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
    }
    private String getFileExtension(Uri fileUri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(fileUri));
    }
//        binding = ActivityMain4Binding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        mTakePhoto = registerForActivityResult(
//                new ActivityResultContracts.GetContent(),
//                new ActivityResultCallback<Uri>() {
//                    @Override
//                    public void onActivityResult(Uri result) {
//
//                        binding.imageView.setImageURI(result);
//
//                    }
//                }
//                );
//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                mTakePhoto.launch("image/*");
//            }
//        });
//        binding.button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                uploadImage();
//
//            }
//        });
//    }
//
//    private void uploadImage() {
//
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setTitle("Uploading File...");
//        progressDialog.show();
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.JAPAN);
//        Date now = new Date();
//        String fileName = formatter.format(now);
//        storageReference = FirebaseStorage.getInstance().getReference("images/" + fileName);
//
//        storageReference.putFile(imageUri)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//                        binding.imageView.setImageURI(null);
//                        Toast.makeText(MainActivity4.this, "Succefully Uploaded",Toast.LENGTH_SHORT).show();
//                        if (progressDialog.isShowing()) {
//                            progressDialog.dismiss();
//                        }
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        if (progressDialog.isShowing()) {
//                            progressDialog.dismiss();
//                        }
//                        Toast.makeText(MainActivity4.this, "Failed to Upload",Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 100 && data !=null && data.getData() != null){
//            imageUri = data.getData();
//            binding.imageView.setImageURI(imageUri);
//        }
//    }
}