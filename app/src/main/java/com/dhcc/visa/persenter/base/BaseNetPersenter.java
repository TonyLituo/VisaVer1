package com.dhcc.visa.persenter.base;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.visa.model.bean.Bean;
import com.dhcc.visa.ui.base.IBaseNetView;

/**
 * Created by Lituo on 2017/4/5 0005. 16:08 .
 * Mail：tony1994_vip@163.com
 * 含有网络请求数据处理的persenter的基类
 * <p>
 */

public abstract class BaseNetPersenter<V extends IBaseNetView> extends BasePersenter<V> {
    //用于json字符串转化为JSONObject的对象
    protected JSONObject json;


    public BaseNetPersenter() {
        JSONObject json = new JSONObject();
    }

    /**
     * 根据响应码获取错误的信息
     */
    public String getNetError(int responseCode) {
        switch (responseCode) {
            case 404:
                return "请求页面路径错误";
            case 500:
                return "服务器内部错误";
            case 502:
                return "错误网关";
            case 504:
                return "网关超时";
            default:
                return responseCode + "错误";
        }
    }

    /**
     * 网络连接失败
     *
     * @return
     */
    public String connFailure() {
        return "网络连接失败";
    }

    /**
     * 访问成功
     */
    public void succeed(Bean bean) {
        onSucceed(bean);
    }

    /**
     * 访问成功后，  响应数据在成员变量json中
     */
    public abstract void onSucceed(Bean bean);
}
