package com.stevefat.coolweather.util;

/**
 * Author : stevefat
 * Email :ngh8897@gmail.com
 * Created : 17-3-22 下午4:24.
 */

public class CheckCode {
    private static final int APP_KEY = 10001; //  appkey不合法
    private static final int INTE_PROTECT = 10020; //接口维护
    private static final int INTE_STOP = 10021;//接口停用
    private static final int SUCCESS = 200; //成功


    /**
     * 检测网络请求数据
     * @param code 请求返回的code
     * @return  是否成功
     */
    public static String valiteCode(int code) {
        String result = "0";
        switch (code) {
            case APP_KEY:
                result = "appkey 不合法";
                break;
            case INTE_PROTECT:
                result = "接口维护暂停使用";
                break;
            case INTE_STOP:
                result = "接口已停止使用";
                break;
            case SUCCESS:
                result = "1";
                break;
        }
        return result;

    }
}
