# PermissionDemo
android 6.0 之后权限申请方式
最简单方式 直接使用  requestPermissions（）方法         
requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, TEST_PERMISSION_WRITE_EXTERNAL_STORAGE);

WRITE_EXTERNAL_STORAGE为命令种类，其它命令查看https://developer.android.com/reference/android/Manifest.permission.html?hl=zh-cn

TEST_PERMISSION_WRITE_EXTERNAL_STORAGE为requestcode，由自己定义

若按照谷歌的官方方式的话，可参考本demo中的流程、检查、解释危险权限授予的原因（若直接授予，这步直接省去）、授予
