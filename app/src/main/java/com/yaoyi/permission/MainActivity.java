package com.yaoyi.permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private final int TEST_PERMISSION_WRITE_EXTERNAL_STORAGE = 0;//权限请求函数的tag定义

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*直接请求权限*/
//                         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, TEST_PERMISSION_WRITE_EXTERNAL_STORAGE);//接着请求权限
//        }

        /*官方检查、请求权限模式*/
        checkPermission();
    }

    /**
     * Check permission.
     * 我的检查权限测试函数
     */
    public void checkPermission() {//检查写外置存储器权限。
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //询问用户
               if (ActivityCompat.shouldShowRequestPermissionRationale(this, //一开始直接进入false分支，当用户点拒绝的时候，会返回true，允许的话就不需要进行进一步操作
                       Manifest.permission.WRITE_EXTERNAL_STORAGE)) {//用户选择拒绝后，进入向用户解释原因环节
                       Toast.makeText(getApplicationContext(), "本应要需要访问存储器才能正常工作，请允许", Toast.LENGTH_SHORT).show();

                       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, TEST_PERMISSION_WRITE_EXTERNAL_STORAGE);//接着请求权限
                }


            }
               else  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                   requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, TEST_PERMISSION_WRITE_EXTERNAL_STORAGE);//接着请求权限
               }
        }

    }
/*请求权限回调函数*/
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case TEST_PERMISSION_WRITE_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                          // 用户同意授予写外存权限

                } else {

                         //用户选择拒绝授予写外存权限
                         finish();//结束Activity
                }
                return;
            }
        }
    }


}
