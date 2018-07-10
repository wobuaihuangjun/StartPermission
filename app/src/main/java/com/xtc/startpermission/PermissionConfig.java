package com.xtc.startpermission;

class PermissionConfig {

    String packageName;

    String className;

    private PermissionConfig(String packageName, String className) {
        this.packageName = packageName;
        this.className = className;
    }

    static final PermissionConfig[] HUAWEI = {
            new PermissionConfig("com.huawei.systemmanager",
                    "com.huawei.systemmanager.optimize.process.ProtectActivity"),// 后台进程保护界面

            new PermissionConfig("com.huawei.systemmanager",
                    "com.huawei.systemmanager.optimize.bootstart.BootStartActivity")// 开机自启动界面
    };

    static final PermissionConfig[] OPPO = {
            new PermissionConfig("com.coloros.safecenter",
                    "com.coloros.safecenter.permission.startup.StartupAppListActivity"),// 手机管家，自启动管理界面


            new PermissionConfig("com.coloros.safecenter",
                    "com.coloros.privacypermissionsentry.PermissionTopActivity")// 手机管家，权限隐私界面
    };

    static final PermissionConfig[] VIVO = {
            new PermissionConfig("com.iqoo.secure",
                    "com.iqoo.secure.safeguard.PurviewTabActivity"),

            new PermissionConfig("com.iqoo.secure",
                    "com.iqoo.secure..MainActivity")// i管家 主界面
    };

    static final PermissionConfig[] XIAOMI = {
            new PermissionConfig("com.miui.securitycenter",
                    "com.miui.permcenter.autostart.AutoStartManagementActivity")
    };

    static final PermissionConfig[] IMOO = {
            new PermissionConfig("com.eebbk.bbksafe",
                    "com.eebbk.bbksafe.module.permission.PermissionActivity")
    };
}
