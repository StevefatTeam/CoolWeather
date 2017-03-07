package com.stevefat.coolweather.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.stevefat.coolweather.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stevefat on 2017/2/27.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private List<String> needPermission;

    private final int REQUEST_CODE_PERMISSION = 0;

    private String[] permissionArray = new String[]{
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = getLayoutView();
        setContentView(layout);
        initView();
    }

    protected abstract void initView();

    protected abstract int getLayoutView();


    public void askMultiplePermission() {
        needPermission = new ArrayList<>();
        for (String permissionName :
                permissionArray) {
            if (!checkIsAskPermission(this, permissionName)) {
                needPermission.add(permissionName);
            }
        }

        if (needPermission.size() > 0) {
            //开始申请权限
            ActivityCompat.requestPermissions(this, needPermission.toArray(new String[needPermission.size()]), REQUEST_CODE_PERMISSION);
        } else {
            //获取数据
            getData();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION:
                Map<String, Integer> permissionMap = new HashMap<>();
                for (String name :
                        needPermission) {
                    permissionMap.put(name, PackageManager.PERMISSION_GRANTED);
                }

                for (int i = 0; i < permissions.length; i++) {
                    permissionMap.put(permissions[i], grantResults[i]);
                }
                if (checkIsAskPermissionState(permissionMap, permissions)) {
                    //获取数据
                    getData();
                } else {
                    //提示权限获取不完成，可能有的功能不能使用
                    Toast.makeText(this, "权限获取不完整，功能受限！", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    public  boolean checkIsAskPermission(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }

    }

    public  boolean checkIsAskPermissionState(Map<String, Integer> maps, String[] list) {
        for (int i = 0; i < list.length; i++) {
            if (maps.get(list[i]) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;

    }
    public void getData(){};

}
