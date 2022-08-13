package com.example.androidpowercomsumption.utils.controller;

import android.os.SystemClock;
import com.example.androidpowercomsumption.utils.ProcState;
import com.example.androidpowercomsumption.utils.ProcStateUtil;
import com.example.androidpowercomsumption.utils.diff.ThreadConsumptionDiff;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来开启和关闭线程监控
 */
public class ThreadController {

    public long startTime = SystemClock.uptimeMillis(); // 监控开始时间

    public List<ProcState> preProcState;
    public List<ProcState> curProcState;

    public List<ThreadConsumptionDiff.ThreadDiff> threadDiffList;

    public void start() {
        startTime = SystemClock.uptimeMillis();
        // 对开始时间的系统状态做快照

        // 线程
        ProcStateUtil procStateUtil = new ProcStateUtil();
        preProcState = procStateUtil.getAllThreadInfo();
    }

    public void finish() {
        // 对结束时间的系统状态做快照
        // 线程
        ProcStateUtil procStateUtil = new ProcStateUtil();
        curProcState = procStateUtil.getAllThreadInfo();
        ThreadConsumptionDiff threadConsumptionDiff = new ThreadConsumptionDiff();
        this.threadDiffList = threadConsumptionDiff.calculateDiff(this.preProcState, this.curProcState);
    }
}
