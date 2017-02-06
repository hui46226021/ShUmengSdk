package com.jrm.hailing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.sh.zsh.code.umeng_sdk.ShareDialog;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton qq;
    ImageButton weixin;
    ImageButton weibo;
    Button share;
    UMShareAPI mShareAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qq = (ImageButton) findViewById(R.id.qq);
        weixin = (ImageButton) findViewById(R.id.weixin);
        weibo = (ImageButton) findViewById(R.id.weibo);
        share= (Button) findViewById(R.id.share);
        qq.setOnClickListener(this);
        weixin.setOnClickListener(this);
        weibo.setOnClickListener(this);
        share.setOnClickListener(this);

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
            case R.id.share://微博
                ShareDialog.getInstance(this,null,"测试分享","https://www.baidu.co,","测试分享").showDialog();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }


}
