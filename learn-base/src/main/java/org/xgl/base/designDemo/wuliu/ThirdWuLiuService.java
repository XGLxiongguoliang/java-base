package org.xgl.base.designDemo.wuliu;

import org.xgl.base.designDemo.WuLiuServiceCodeEnum;
import org.xgl.base.designDemo.ThirdService;


/**
 * 三方服务（wuliu）接口
 */
public interface ThirdWuLiuService extends ThirdService {
    /**
     * 获取物流服务标识
     */
    @Override
    WuLiuServiceCodeEnum getServiceIdentity();
}
