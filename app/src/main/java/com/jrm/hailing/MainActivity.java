package com.jrm.hailing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;


import com.sh.zsh.code.umeng_sdk.ShareActivity;
import com.sh.zsh.code.umeng_sdk.ShareDialog;
import com.sh.zsh.code.umeng_sdk.UMShareHelper;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton qq;
    ImageButton weixin;
    ImageButton weibo;
    Button share;
    Button share1;
    Button weChatPay;

    UMShareAPI mShareAPI;
    LinearLayout activityMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qq = (ImageButton) findViewById(R.id.qq);
        weixin = (ImageButton) findViewById(R.id.weixin);
        weibo = (ImageButton) findViewById(R.id.weibo);
        share= (Button) findViewById(R.id.share);
        share1= (Button) findViewById(R.id.share1);
        weChatPay= (Button) findViewById(R.id.weChatPay);
        activityMain = (LinearLayout) findViewById(R.id.activity_main);
        qq.setOnClickListener(this);
        weixin.setOnClickListener(this);
        weibo.setOnClickListener(this);
        share.setOnClickListener(this);
        share1.setOnClickListener(this);
        weChatPay.setOnClickListener(this);
         mShareAPI = UMShareAPI.get(this);

    }




        //登录 回调 文档 http://dev.umeng.com/social/android/login-page#2
        UMAuthListener umAuthListener = new UMAuthListener() {
            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Log.i("登录结果",map.toString());
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        };

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.weixin://微信
                mShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
                break;
            case R.id.qq://QQ
                mShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.weibo://微博
                mShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.SINA, umAuthListener);
                break;
            case R.id.share1://分享
                ShareActivity.share(activityMain,this,null,"测试分享","https://www.baidu.co,","测试分享");
                break;
            case R.id.share://分享
                ShareDialog.getInstance(this,null,"测试分享","https://www.baidu.co,","测试分享").showDialog();
                break;
            case R.id.weChatPay://微信支付
                //调用微信支付  参数由后台获取
                UMShareHelper.weChatPay(this,"1900000109","WX1217752501201407033233368018","C380BEC2BFD727A4B6845133519F3AD6","5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}
