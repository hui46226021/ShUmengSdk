# ShUmengSdk
封装友盟 第三方 分享 登录 微信支付
###当前友盟SDK版本v6.0.9
###所需各种 appkey 质询QQ 3431339973
##使用方法
* 导入Module(umeng_sdk)
* 替换key_strings.xml下的所有 appkey
* 在项目的Application 里调用  UMShareHelper.init(this); 注册友盟
* 添加微信 回调页面WXEntryActivity  注意：wxapi 后的路径一定不能变
* 通过 ShareDialog.getInstance(this,null,"测试分享","https://www.baidu.co,","测试分享").showDialog();弹出分享菜单
* 通过 mShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener); 第三方登录
注意：在调用分享的页面 要加入 页面回调
~~~java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
~~~



