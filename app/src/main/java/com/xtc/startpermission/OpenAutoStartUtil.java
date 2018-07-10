package com.xtc.startpermission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
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
     *
     * @param context
     */
    public static void jumpStartInterface(Context context) {
        String brand = DeviceUtil.getPhoneBrand().toLowerCase();
        String product = DeviceUtil.getPhoneProduct().toLowerCase();
        String model = DeviceUtil.getPhoneModel();
        Log.d(TAG, "手机品牌brand：" + brand + "，厂商product：" + product + "，型号model：" + model);

        PermissionConfig[] permissionConfigs = {};
        if (HUAWEI_PHONE.equals(product) || HUAWEI_PHONE.equals(brand)) {
            permissionConfigs = PermissionConfig.HUAWEI;
        } else if (OPPO_PHONE.equals(product) || OPPO_PHONE.equals(brand)) {
            permissionConfigs = PermissionConfig.OPPO;
        }else if (VIVO_PHONE.equals(product) || VIVO_PHONE.equals(brand)) {
            permissionConfigs = PermissionConfig.VIVO;
        }else if (XIAOMI_PHONE.equals(product) || XIAOMI_PHONE.equals(brand)) {
            permissionConfigs = PermissionConfig.XIAOMI;
        }else if (MEIZU_PHONE.equals(product) || MEIZU_PHONE.equals(brand)) {
            permissionConfigs = PermissionConfig.MEIZU;
        }else if (SAMSUNG_PHONE.equals(product) || SAMSUNG_PHONE.equals(brand)) {
            permissionConfigs = PermissionConfig.SAMSUNG;
        }else if (PHONE360.equals(product) || PHONE360.equals(brand)) {
            permissionConfigs = PermissionConfig.PHONE360;
        }else if (IMMO_PHONE.equals(product) || IMMO_PHONE.equals(brand)) {
            permissionConfigs = PermissionConfig.IMOO;
        }else {
            Log.d(TAG, "当前手机未适配");
        }

        for (PermissionConfig permissionConfig : permissionConfigs) {
            if(jumpStartPermissionSetting(context, permissionConfig.packageName, permissionConfig.className)){
                return;
            }
        }


        try {
            ComponentName componentName = null;
            Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            if (product.equals("Letv")) { // 乐视2测试通过
                intent.setAction("com.letv.android.permissionautoboot");

            } else if (product.equals("OPPO")) { // OPPO R8205测试通过
                componentName = ComponentName.unflattenFromString("com.oppo.safe" +
                        "/.permission.startup.StartupAppListActivity");
                Intent intentOppo = new Intent();
                intentOppo.setClassName("com.oppo.safe/.permission.startup",
                        "StartupAppListActivity");
                if (context.getPackageManager().resolveActivity(intentOppo, 0) == null) {
                    componentName = ComponentName.unflattenFromString("com.coloros.safecenter" +
                            "/.startupapp.StartupAppListActivity");
                }

            } else if (product.equals("ulong")) { // 360手机 未测试
                componentName = new ComponentName("com.yulong.android.coolsafe",
                        ".ui.activity.autorun.AutoRunListActivity");
            } else {
                // 以上只是市面上主流机型，由于公司你懂的，所以很不容易才凑齐以上设备
                // 针对于其他设备，我们只能调整当前系统app查看详情界面
                // 在此根据用户手机当前版本跳转系统设置界面
                if (Build.VERSION.SDK_INT >= 9) {
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                } else if (Build.VERSION.SDK_INT <= 8) {
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setClassName("com.android.settings",
                            "com.android.settings.InstalledAppDetails");
                    intent.putExtra("com.android.settings.ApplicationPkgName",
                            context.getPackageName());
                }
            }
            intent.setComponent(componentName);
            context.startActivity(intent);
        } catch (Exception e) {//抛出异常就直接打开设置页面
            e.printStackTrace();
        }
    }
}
