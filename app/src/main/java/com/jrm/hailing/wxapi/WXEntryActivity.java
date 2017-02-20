package com.jrm.hailing.wxapi;


//import com.umeng.weixin.callback.WXCallbackActivity;

import android.util.Log;

import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.umeng.socialize.weixin.view.WXCallbackActivity;

public class WXEntryActivity extends WXCallbackActivity {
    String TAG ="WXEntryActivity";

    /**
     * 微信支付回调
     * @param resp
     */
    public void onResp(BaseResp resp ){
        if(resp.getType()== ConstantsAPI.COMMAND_PAY_BY_WX){
            Log.d(TAG,"onPayFinish,errCode="+resp.errCode);
//            0 成功 展示成功页面
//            -1 错误 可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等。
//            -2 用户取消 无需处理。发生场景：用户不支付了，点击取消，返回APP。

        }
    }

}
