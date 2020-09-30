package com.example.acra_home.acra;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.acra_home.retrofit.NetworkService;


import org.acra.data.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ACRASender implements ReportSender {

    @Override
    public void send(@NonNull Context context, @NonNull CrashReportData errorContent) throws ReportSenderException {
        Log.d("ACRA_TAG", "SEND SIGNAL");
        NetworkService.getInstance().getDownloadAPI()
                .sendErrorMessage("ERROR!").enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
