package com.dhcc.visa.ui.base;

import com.dhcc.visa.model.bean.Bean;

/**
 * Created by Lituo on 2017/4/7 0007. 13:40 .
 * Mail：tony1994_vip@163.com
 * <p>
 * 含有网络请求数据处理的视图接口
 * <p>
 * ####无特殊要求可直接使用，有特殊要求的继承即可
 */

public interface IBaseNetView<T extends Bean> extends IBaseView {
    /**
     * 显示加载进度条
     */
    void showPrgbar();

    /**
     * 隐藏加载进度条
     */
    void hidePrgbar();

    /**
     * 加载成功
     */
    void succeed(T t);

    /**
     * 网络连接失败
     */
    void failure();

    /**
     * 网络错误失败
     *
     * @param responseCode 响应码
     */
    void error(int responseCode);
}
