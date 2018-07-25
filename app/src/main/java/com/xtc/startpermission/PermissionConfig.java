package com.xtc.startpermission;

class PermissionConfig {

    String packageName;

    String className;

    private PermissionConfig(String packageName, String className) {
        this.packageName = packageName;
        this.className = className;
    }

    static final PermissionConfig[] HUAWEI = {// 测试通过：
            new PermissionConfig("com.huawei.systemmanager",
                    "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"),//mate 9

            new PermissionConfig("com.huawei.systemmanager",
                    "com.huawei.systemmanager.optimize.process.ProtectActivity"),// 后台进程保护界面

            new PermissionConfig("com.huawei.systemmanager",
                    "com.huawei.systemmanager.optimize.bootstart.BootStartActivity")// 开机自启动界面
    };

    static final PermissionConfig[] OPPO = { // 测试通过：r9 r15
            new PermissionConfig("com.coloros.safecenter",
                    "com.coloros.safecenter.permission.startup.StartupAppListActivity"),// 手机管家，自启动管理界面

            new PermissionConfig("com.coloros.safecenter",
                    "com.coloros.privacypermissionsentry.PermissionTopActivity")// 手机管家，权限隐私界面
    };

    static final PermissionConfig[] VIVO = { // 测试通过：vivo X5Pro D
            new PermissionConfig("com.iqoo.secure",
                    "com.iqoo.secure.safeguard.PurviewTabActivity"),// 未验证

            new PermissionConfig("com.iqoo.secure",
                    "com.iqoo.secure.MainGuideActivity"),// i管家主界面。vivo X5Pro D
    };

    static final PermissionConfig[] XIAOMI = { //测试通过：MI 4、MI 6、MIX 2
            new PermissionConfig("com.miui.securitycenter",
                    "com.miui.permcenter.autostart.AutoStartManagementActivity")
    };

    static final PermissionConfig[] MEIZU = { //测试通过：PRO 5
            new PermissionConfig("com.meizu.safe",
                    "com.meizu.safe.permission.SmartBGActivity"),

            new PermissionConfig("com.meizu.safe",
                    "com.meizu.safe.permission.PermissionMainActivity")
    };

    static final PermissionConfig[] SAMSUNG = { // 测试通过：SM-G9009D
            new PermissionConfig("com.samsung.android.sm",
                    "com.samsung.android.sm.ui.ram.RamActivity"),// 智能管理器 内存 界面

            new PermissionConfig("com.samsung.android.sm",
                    "com.samsung.android.sm.ui.dashboard.SmartManagerDashBoardActivity"),// 智能管理器 首页

            new PermissionConfig("com.samsung.android.sm_cn",
                    "com.samsung.android.sm.ui.ram.AutoRunActivity")// 未测试
    };

    static final PermissionConfig[] PHONE360 = { // 测试通过：1807-A01
            new PermissionConfig("com.qiku.android.security",
                    "com.qiku.android.security.ui.activity.protection.ProtectAppActivity"),// 受保护应用 界面

            new PermissionConfig("com.android.settings",
                    "com.android.settings.Settings$AppAndNotificationDashboardActivity"),// 应用和权限 界面

            new PermissionConfig("com.yulong.android.coolsafe",
                    "com.yulong.android.coolsafe.ui.activity.autorun.AutoRunListActivity")// 未测试
    };

    static final PermissionConfig[] IMOO = { // 测试通过：C1
            new PermissionConfig("com.eebbk.bbksafe",
                    "com.eebbk.bbksafe.module.permission.PermissionActivity")
    };

    static final PermissionConfig[] SMARTISAN = {
            new PermissionConfig("com.smartisanos.security",
                    "com.smartisanos.security.RadioPermissions"),//坚果3 自启动权限管理

            new PermissionConfig("com.smartisanos.security",
                    "com.smartisanos.security.PackagesOverview"),//后台启动

            new PermissionConfig("com.android.settings",
                    "com.android.settings.fuelgauge.appBatteryUseOptimization.AppBatteryUseOptimizationActivity")//耗电保护
    };
}
