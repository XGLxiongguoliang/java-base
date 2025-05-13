package org.xgl.base.designDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * 物流服务code码
 *
 * @author wanglq
 * Date 2023/9/18
 * Time 14:47
 */
@Getter
@AllArgsConstructor
public enum WuLiuServiceCodeEnum implements ServiceIdentity {
    MSL_LOGISTICS("mslLogistics", "马上来物流");

    private final String code;
    private final String remark;

    public static Optional<WuLiuServiceCodeEnum> getByCode(String code) {
        return Arrays.stream(values()).filter(v -> v.getCode().equals(code)).findFirst();
    }

    /**
     * 获取服务类型
     *
     * @return 服务类型
     */
    @Override
    public ThirdServiceTypeEnum getType() {
        return ThirdServiceTypeEnum.LOGISTICS;
    }

    /**
     * 获取服务code
     *
     * @return 服务类型
     */
    @Override
    public String getServiceCode() {
        return code;
    }
}
