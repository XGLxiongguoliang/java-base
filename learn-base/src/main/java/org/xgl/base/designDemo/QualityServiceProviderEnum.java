package org.xgl.base.designDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;


/**
 * @author 代码搬运工 Min
 * Date 2023-09-11
 * Time 10:57
 */
@Getter
@AllArgsConstructor
public enum QualityServiceProviderEnum {

    ACTIVE(1, "生效"),
    NEGTIVE(2, "未生效");

    private final Integer code;

    private final String mark;

    public static Optional<QualityServiceProviderEnum> getByCode(Integer code) {
        return Arrays.stream(values()).filter(v -> v.getCode().equals(code)).findFirst();
    }
}
