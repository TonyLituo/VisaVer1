package com.dhcc.visa.common.config;

import com.dhcc.visa.imageloader.ILoader;
import com.dhcc.visa.router.Router;

/**
 * Created by m on 2017/4/6.
 * ${describe}
 */

public class Config {

    // #router
    public static final int ROUTER_ANIM_ENTER = Router.RES_NONE;
    public static final int ROUTER_ANIM_EXIT = Router.RES_NONE;

    // #imageloader
    public static final int IL_LOADING_RES = ILoader.Options.RES_NONE;
    public static final int IL_ERROR_RES = ILoader.Options.RES_NONE;

    // #cache
    public static final String CACHE_SP_NAME = "config";
}
