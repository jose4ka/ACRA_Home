package com.example.acra_home.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.acra_home.R;
import com.example.acra_home.acra.ACRASenderFactory;
import com.example.acra_home.retrofit.NetworkService;

import org.acra.annotation.AcraCore;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AcraCore(reportSenderFactoryClasses = ACRASenderFactory.class)
public class MainActivity extends AppCompatActivity {

    private Button btnGenerateException;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!checkPermissions()) requestPerms();

        btnGenerateException = findViewById(R.id.btnGenerateException);
        btnGenerateException.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermissions())generateException();
                else requestPerms();

            }
        });
    }

    private void generateException()
    {
        throw new RuntimeException("Biba error!");
//        NetworkService.getInstance().getDownloadAPI()
//                .sendErrorMessage("ERROR").enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });
    }

    private void requestPerms(){
        String[] perm = new String[]{Manifest.permission.INTERNET};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            ActivityCompat.requestPermissions(this,perm,123);
        }
    }


    private boolean checkPermissions(){

        if((ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET) == PackageManager.PERMISSION_DENIED)){
            return false;
        }
        else {
            return true;
        }
    }

}