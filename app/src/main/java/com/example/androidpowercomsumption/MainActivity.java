package com.example.androidpowercomsumption;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;

public class MainActivity extends AppCompatActivity implements LifecycleObserver {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStop() {
        super.onStop();
//        threadController.finish();
//        List<ThreadConsumptionDiff.ThreadDiff> threadDiffList = threadController.threadDiffList;
//        for(ThreadConsumptionDiff.ThreadDiff threadDiff:threadDiffList){
//            Log.d(TAG, threadDiff.toString());
//        }
    }



}