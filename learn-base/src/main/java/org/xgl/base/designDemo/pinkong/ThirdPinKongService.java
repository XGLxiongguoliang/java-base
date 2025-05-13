package org.xgl.base.designDemo.pinkong;

import org.xgl.base.designDemo.PinKongServiceCodeEnum;
import org.xgl.base.designDemo.ThirdService;

/**
 * 三方服务（pinkong）接口
 */
public interface ThirdPinKongService extends ThirdService {
    /**
     * 获取监装监卸服务标识
     */
    @Override
    PinKongServiceCodeEnum getServiceIdentity();
}
