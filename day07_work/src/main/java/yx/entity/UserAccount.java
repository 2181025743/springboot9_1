package yx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("user_account")
public class UserAccount {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private Integer balance;

    @Version
    private Integer version;
}
