package com.zkp.gank.crash;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.zkp.gank.BuildConfig;
import com.zkp.gank.module.main.MainActivity;
import com.zkp.gank.R;
import com.zkp.gank.app.GankApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author: zkp
 * @project: Demos
 * @package: com.zkp.demos
 * @time: 2019/4/2 9:43
 * @description: 闪退重启处理
 */
public class UnCaughtHandler implements Thread.UncaughtExceptionHandler {

    /**
     * 错误报告文件的扩展名
     */
    private static final String CRASH_REPORTER_EXTENSION = ".txt";
    private GankApplication mApplication;
    /**
     * 默认Exception Handler
     */
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    public UnCaughtHandler(GankApplication application) {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.mApplication = application;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (mDefaultHandler != null && e == null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(t, null);
        } else {
            Intent intent = new Intent(mApplication.getApplicationContext(), MainActivity.class);
            @SuppressLint("WrongConstant")
            PendingIntent restartIntent = PendingIntent.getActivity(mApplication.getApplicationContext(),
                    0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);

            //收集设备信息
            //保存错误报告文件
            saveCrashInfoToFile(e);

            //退出App后再重启App
            AlarmManager alarmManager = (AlarmManager) mApplication.getSystemService(Context.ALARM_SERVICE);
            assert alarmManager != null;
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 3000, restartIntent);
            SmartToast.warning("应用将在3秒后重启");
            mApplication.exitApplication();
        }
    }

    /**
     * 错误信息存储到文本并保存到手机中
     *
     * @param ex Throwable
     */
    private void saveCrashInfoToFile(Throwable ex) {
        Writer info = new StringWriter();
        PrintWriter printWriter = new PrintWriter(info);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        String result = info.toString();
        printWriter.close();
        StringBuilder sb = new StringBuilder();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String now = sdf.format(new Date());
        //崩溃时间
        sb.append("TIME:").append(now);
        //程序信息
        //软件APPLICATION_ID
        sb.append("\nAPPLICATION_ID:").append(BuildConfig.APPLICATION_ID);
        //软件版本号
        sb.append("\nVERSION_CODE:").append(BuildConfig.VERSION_CODE);
        //VERSION_NAME
        sb.append("\nVERSION_NAME:").append(BuildConfig.VERSION_NAME);
        //是否是DEBUG版本
        sb.append("\nBUILD_TYPE:").append(BuildConfig.BUILD_TYPE);
        //设备信息
        sb.append("\nMODEL:").append(Build.MODEL);
        sb.append("\nRELEASE:").append(Build.VERSION.RELEASE);
        sb.append("\nSDK:").append(Build.VERSION.SDK_INT);
        sb.append("\nEXCEPTION:").append(ex.getLocalizedMessage());
        sb.append("\nSTACK_TRACE:").append(result);
        try {
            FileWriter writer = new FileWriter(getCrashFilePath(mApplication.getApplicationContext()) + now + CRASH_REPORTER_EXTENSION);
            writer.write(sb.toString());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文件夹路径
     *
     * @param context 上下文
     * @return 文件夹路径
     */
    private static String getCrashFilePath(Context context) {
        String path = Environment.getExternalStorageDirectory() + File.separator + context.getResources().getString(R.string.app_name) + "/Crash/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }
}
