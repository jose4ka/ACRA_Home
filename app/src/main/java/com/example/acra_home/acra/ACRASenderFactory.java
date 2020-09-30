package com.example.acra_home.acra;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import org.acra.config.CoreConfiguration;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderFactory;

public class ACRASenderFactory implements ReportSenderFactory {

    @NonNull
    @Override
    public ReportSender create(@NonNull Context context, @NonNull CoreConfiguration config) {
        return new ACRASender();
    }


}
