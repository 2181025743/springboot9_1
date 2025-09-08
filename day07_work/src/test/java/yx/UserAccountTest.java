package yx;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yx.entity.UserAccount;
import yx.mapper.UserAccountMapper;

@SpringBootTest
public class UserAccountTest {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Test
    @DS("db2")
        // <-- 同样为这个方法指定 db2
    void testInsert() {
        // 插入新用户账户
        UserAccount account = new UserAccount()
                .setName("张三")
                .setBalance(1000);

        userAccountMapper.insert(account);
        System.out.println("插入成功，ID: " + account.getId());
    }

    @Test
    @DS("db2")
        // <-- 明确指定此测试方法使用 db2 数据源
    void testOptimisticLock() {
        // 1. 插入测试数据
        UserAccount account = new UserAccount()
                .setName("李四")
                .setBalance(2000);
        userAccountMapper.insert(account);
        Long id = account.getId();

        // 2. 模拟两个用户同时查询
        UserAccount user1 = userAccountMapper.selectById(id);
        UserAccount user2 = userAccountMapper.selectById(id);

        // 3. 用户1修改余额
        user1.setBalance(user1.getBalance() - 100);
        int result1 = userAccountMapper.updateById(user1);
        System.out.println("用户1更新结果: " + (result1 > 0 ? "成功" : "失败"));

        // 4. 用户2修改余额（此时会失败，因为版本号已经改变）
        user2.setBalance(user2.getBalance() - 200);
        int result2 = userAccountMapper.updateById(user2);
        System.out.println("用户2更新结果: " + (result2 > 0 ? "成功" : "失败"));

        // 5. 查看最终结果
        UserAccount finalAccount = userAccountMapper.selectById(id);
        System.out.println("最终余额: " + finalAccount.getBalance());
        System.out.println("版本号: " + finalAccount.getVersion());
    }

    @Test
    @DS("db1")
        // 临时切换到 db1 数据源
    void testDb1() {
        // 这里可以操作 db1 的数据
        System.out.println("使用 db1 数据源");
    }
}