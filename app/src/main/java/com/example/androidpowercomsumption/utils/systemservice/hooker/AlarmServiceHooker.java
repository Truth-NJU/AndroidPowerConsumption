package com.example.androidpowercomsumption.utils.systemservice.hooker;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;

import java.lang.reflect.Method;

public class AlarmServiceHooker {
    private static final String TAG = "AlarmService";

    private int setTime;

    public int getSetTime() {
        return setTime;
    }

    public void setSetTime(int setTime) {
        this.setTime = setTime;
    }

    private ServiceHookCallback sHookCallback = new ServiceHookCallback() {
        @Override
        public void serviceMethodInvoke(Method method, Object[] args) {
            if (method.getName().equals("set")
                    || method.getName().equals("setRepeating") || method.getName().equals("setInexactRepeating")) {
                setTime++;
                Log.d(TAG, "setTime++");
            }
        }

        @Nullable
        @Override
        public Object serviceMethodIntercept(Object receiver, Method method, Object[] args) throws Throwable {
            return null;
        }
    };

    public SystemServiceHooker sHookHelper = new SystemServiceHooker(Context.ALARM_SERVICE, "android.app.IAlarmManager", sHookCallback);
}
