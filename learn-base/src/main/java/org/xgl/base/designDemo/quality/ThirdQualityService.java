package org.xgl.base.designDemo.quality;

import org.xgl.base.designDemo.QualityServiceCodeEnum;
import org.xgl.base.designDemo.ThirdService;

/**
 * 三方服务（quality）接口
 */
public interface ThirdQualityService extends ThirdService {
    /**
     * 获取质检服务标识
     */
    @Override
    QualityServiceCodeEnum getServiceIdentity();
}
