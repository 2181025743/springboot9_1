package yx.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import yx.entity.UserAccount;

@DS("db2") // 指定使用 db2 数据源
public interface UserAccountMapper extends BaseMapper<UserAccount> {
}