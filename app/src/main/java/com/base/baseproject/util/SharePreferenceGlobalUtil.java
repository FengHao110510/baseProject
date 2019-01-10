package com.base.baseproject.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;


public class SharePreferenceGlobalUtil {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SharePreferenceGlobalUtil(Context context, String file) {
        sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    /**
     * 版本号
     *
     * @param lastVersion
     */
    public void setLastVersion(String lastVersion) {
        editor.putString("Last_version", lastVersion);
        editor.commit();
    }

    public String getLastVersion() {
        return sp.getString("Last_version", "");
    }


/**
 * TODO =================================LOGIN========================================================
 */
    /**
     * 是否登录
     *
     * @param checkLogin
     */
    public void setCheckLogin(boolean checkLogin) {
        editor.putBoolean("checkLogin", checkLogin);
        editor.commit();
    }

    public boolean getCheckLogin() {
        return sp.getBoolean("checkLogin", false);
    }

    /**
     * 是否记住密码
     *
     * @param checkPassword
     */
    public void setCheckPassword(boolean checkPassword) {
        editor.putBoolean("checkPassword", checkPassword);
        editor.commit();
    }

    public boolean getCheckPassword() {
        return sp.getBoolean("checkPassword", true);
    }


    /**
     * 用户名字
     *
     * @param userName
     */
    public void setUserName(String userName) {
        editor.putString("userName", userName);
        editor.commit();
    }

    public String getUserName() {
        return sp.getString("userName", "");
    }

    /**
     * 用户店铺名字
     *
     * @param shopName
     */
    public void setShopName(String shopName) {
        editor.putString("shopName", shopName);
        editor.commit();
    }

    public String getShopName() {
        return sp.getString("shopName", "");
    }

    /**
     * 账号
     *
     * @param user
     */
    public void setUser(String user) {
        editor.putString("user", user);
        editor.commit();
    }

    public String getUser() {
        return sp.getString("user", "");
    }

    /**
     * 密码
     *
     * @param password
     */
    public void setPassword(String password) {
        editor.putString("password", password);
        editor.commit();
    }

    public String getPassword() {
        return sp.getString("password", "");
    }

    /**
     * 设备编号
     *
     * @param code
     */
    public void setCode(String code) {
        editor.putString("code", code);
        editor.commit();
    }

    public String getCode() {
        return sp.getString("code", "");
    }

    /**
     * 品牌号
     *
     * @param brand
     */
    public void setPosBRAND(String brand) {
        editor.putString("brand", brand);
        editor.commit();
    }

    public String getPosBRAND() {
        return sp.getString("brand", "");
    }

    /**
     * 阿里用户标识
     *
     * @param aliCode
     */
    public void setAliCode(String aliCode) {
        editor.putString("ali_code", aliCode);
        editor.commit();
    }

    public String getAliCode() {
        return sp.getString("ali_code", "");
    }

    /**
     * 商户号
     *
     * @param storeId
     */
    public void setStoreId(String storeId) {
        editor.putString("storeId", storeId);
        editor.commit();
    }

    public String getstoreId() {
        return sp.getString("storeId", "");

    }

    /**
     * 用户标识
     *
     * @param userNumber
     */
    public void setUserNumber(String userNumber) {
        editor.putString("userNumber", userNumber);
        editor.commit();
    }

    public String getUserNumber() {
        return sp.getString("userNumber", "");

    }

    /**
     * 用户类型
     * 0 商户 1店长 2店员
     *
     * @param userType
     */
    public void setUserType(String userType) {
        editor.putString("userType", userType);
        editor.commit();
    }

    public String getUserType() {
        return sp.getString("userType", "");

    }

    /**
     * 唯一标示
     *
     * @param verifyCode
     */
    public void setVerifyCode(String verifyCode) {
        editor.putString("verifyCode", verifyCode);
        editor.commit();
    }

    public String getVerifyCode() {
        return sp.getString("verifyCode", "qwer");

    }

    /**
     * 商户编号
     *
     * @param paymentUser
     */
    public void setPaymentUser(String paymentUser) {
        editor.putString("paymentUser", paymentUser);
        editor.commit();
    }

    public String getPaymentUser() {
        return sp.getString("paymentUser", "");

    }

    /**
     * 微信用户表示
     *
     * @param wecharCode
     */
    public void setWecharCode(String wecharCode) {
        editor.putString("wecharCode", wecharCode);
        editor.commit();
    }

    public String getWecharCode() {
        return sp.getString("wecharCode", "");

    }

    /**
     * 台卡二维码
     *
     * @param taikaerweima
     */
    public void setTaikaerweima(String taikaerweima) {
        editor.putString("taikaerweima", taikaerweima);
        editor.commit();
    }

    public String getTaikaerweima() {
        return sp.getString("taikaerweima", "");
    }

    /**
     * 是否播放语音和推送
     *
     * @param voiceAndMsg
     */
    public void setVoiceAndMsg(boolean voiceAndMsg) {
        editor.putBoolean("voiceAndMsg", voiceAndMsg);
        editor.commit();
    }

    public boolean getVoiceAndMsg() {
        return sp.getBoolean("voiceAndMsg", true);
    }

    /**
     * 是否播放语音
     *
     * @param voice
     */
    public void setVoice(boolean voice) {
        editor.putBoolean("voice", voice);
        editor.commit();
    }

    public boolean getVoice() {
        return sp.getBoolean("voice", true);
    }

    /**
     * 是否推送
     *
     * @param msgVoice
     */
    public void setMsgVoice(boolean msgVoice) {
        editor.putBoolean("msgVoice", msgVoice);
        editor.commit();
    }

    public boolean getMsgVoice() {
        return sp.getBoolean("msgVoice", true);
    }

    /**
     * @param config cookie
     */
    public void setConfig(Set<String> config) {
        editor.putStringSet("config", config);
        editor.commit();
    }

    public Set<String> getConfig() {
        return sp.getStringSet("config", null);
    }
}