package com.xtc.startpermission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


/**
 * 跳转到自启动权限设置
 * <p>
 * Created by hzj on 2018/7/6.
 */

public class OpenAutoStartUtil {

    private static final String TAG = "OpenAutoStartUtil";

    private static final String OPPO_PHONE = "oppo";

    private static final String HUAWEI_PHONE = "huawei";

    private static final String VIVO_PHONE = "vivo";

    private static final String XIAOMI_PHONE = "xiaomi";

    private static final String MEIZU_PHONE = "meizu";

    private static final String SAMSUNG_PHONE = "samsung";

    private static final String HTC_PHONE = "htc";// 不支持设置，google系统

    private static final String TCL_PHONE = "tcl";

    private static final String LETV_PHONE = "Letv"; //乐视

    private static final String PHONE360 = "360"; // 360

    private static final String IMMO_PHONE = "immo"; // 步步高IMOO

    private static final String SMARTISAN_PHONE = "smartisan"; // 锤子


    public static boolean jumpStartPermissionSetting(Context context, String packageName, String className) {
        ComponentName componentName;
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Log.d(TAG, packageName + "/" + className);
        try {
            componentName = new ComponentName(packageName, className);
            intent.setComponent(componentName);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * GoTo Open Self Setting Layout
     * Compatible Mainstream Models 兼容市面主流机型
     */
    public static void jumpStartInterface(Context context) {
        String brand = DeviceUtil.getPhoneBrand();
        String product = DeviceUtil.getPhoneProduct();
        String model = DeviceUtil.getPhoneModel();
        Log.d(TAG, "手机品牌brand：" + brand + "，厂商product：" + product + "，型号model：" + model);

        PermissionConfig[] permissionConfigs = {};
        if (HUAWEI_PHONE.equalsIgnoreCase(product) || HUAWEI_PHONE.equalsIgnoreCase(brand)) {
            permissionConfigs = PermissionConfig.HUAWEI;
        } else if (OPPO_PHONE.equalsIgnoreCase(product) || OPPO_PHONE.equalsIgnoreCase(brand)) {
            permissionConfigs = PermissionConfig.OPPO;
        } else if (VIVO_PHONE.equalsIgnoreCase(product) || VIVO_PHONE.equalsIgnoreCase(brand)) {
            permissionConfigs = PermissionConfig.VIVO;
        } else if (XIAOMI_PHONE.equalsIgnoreCase(product) || XIAOMI_PHONE.equalsIgnoreCase(brand)) {
            permissionConfigs = PermissionConfig.XIAOMI;
        } else if (MEIZU_PHONE.equalsIgnoreCase(product) || MEIZU_PHONE.equalsIgnoreCase(brand)) {
            permissionConfigs = PermissionConfig.MEIZU;
        } else if (SAMSUNG_PHONE.equalsIgnoreCase(product) || SAMSUNG_PHONE.equalsIgnoreCase(brand)) {
            permissionConfigs = PermissionConfig.SAMSUNG;
        } else if (PHONE360.equalsIgnoreCase(product) || PHONE360.equalsIgnoreCase(brand)) {
            permissionConfigs = PermissionConfig.PHONE360;
        } else if (IMMO_PHONE.equalsIgnoreCase(product) || IMMO_PHONE.equalsIgnoreCase(brand)) {
            permissionConfigs = PermissionConfig.IMOO;
        } else if (SMARTISAN_PHONE.equalsIgnoreCase(product) || SMARTISAN_PHONE.equalsIgnoreCase(brand)) {
            permissionConfigs = PermissionConfig.SMARTISAN;
        } else {
            Log.d(TAG, "当前手机未适配");
        }

        for (PermissionConfig permissionConfig : permissionConfigs) {
            if (jumpStartPermissionSetting(context, permissionConfig.packageName, permissionConfig.className)) {
                return;
            }
        }

    }
}
