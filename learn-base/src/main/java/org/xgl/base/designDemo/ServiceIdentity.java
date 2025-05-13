package org.xgl.base.designDemo;

/**
 * 三方服务标识
 *
 * @author wanglq
 * Date 2023/9/18
 * Time 13:57
 */
public interface ServiceIdentity {
    /**
     * 获取服务类型
     *
     * @return 服务类型
     */
    ThirdServiceTypeEnum getType();

    /**
     * 获取服务code
     *
     * @return 服务code
     */
    String getServiceCode();
}
