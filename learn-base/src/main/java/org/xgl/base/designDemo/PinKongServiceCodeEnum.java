package org.xgl.base.designDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * 监装监卸服务code码
 *
 * @author wanglq
 * Date 2023/9/18
 * Time 14:49
 */
@Getter
@AllArgsConstructor
public enum PinKongServiceCodeEnum implements ServiceIdentity {
    HUI_BIAO("huiBiao", "慧标质监"),
    ;

    private final String code;
    private final String remark;

    public static Optional<PinKongServiceCodeEnum> getByCode(String code) {
        return Arrays.stream(values()).filter(v -> v.getCode().equals(code)).findFirst();
    }

    /**
     * 获取服务类型
     *
     * @return 服务类型
     */
    @Override
    public ThirdServiceTypeEnum getType() {
        return ThirdServiceTypeEnum.SUPERVISE;
    }

    /**
     * 获取服务code
     *
     * @return 服务code
     */
    @Override
    public String getServiceCode() {
        return code;
    }
}