package yx.entity;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum implements IEnum<Integer> {
    ACTIVE(0, "激活"),
    INACTIVE(1, "未激活");

    private final int code;
    private final String desc;

    @Override
    public Integer getValue() {
        return this.code;
    }
}
