package com.sh.zsh.code.umeng_sdk;

import android.app.Application;
import android.content.res.Resources;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by zhush on 2017/2/6.
 * E-mail zhush@jerei.com
 * PS
 */
public class UMShareHelper {

    public static void init(Application application){

       Resources resources= application.getResources();
        //注册第三方 id
        PlatformConfig.setWeixin(resources.getString(R.string.wexin_app_id), resources.getString(R.string.wexin_app_secret));
        PlatformConfig.setSinaWeibo(resources.getString(R.string.weibo_app_key), resources.getString(R.string.weibo_app_secret));
        PlatformConfig.setQQZone(resources.getString(R.string.qq_appid), resources.getString(R.string.qq_appkey));
        UMShareAPI.get(application);

    }
}
