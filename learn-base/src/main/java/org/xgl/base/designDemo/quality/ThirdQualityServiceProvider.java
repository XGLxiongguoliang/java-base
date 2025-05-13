package org.xgl.base.designDemo.quality;

import org.xgl.base.designDemo.ThirdServiceProvider;
import org.xgl.base.designDemo.ThirdServiceTypeEnum;

/**
 * 三方质检服务
 *
 * @author wanglq
 * Date 2023/9/18
 * Time 09:55
 */
public interface ThirdQualityServiceProvider extends ThirdServiceProvider<ThirdQualityService> {
    /**
     * 获取服务类型
     *
     * @return 服务类型
     */
    @Override
    default ThirdServiceTypeEnum getType() {
        return ThirdServiceTypeEnum.QUALITY;
    }
}
