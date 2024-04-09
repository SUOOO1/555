package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();

    /**
     * 根据ID查询用户
     * @param account
     * @return
     */
    User selectById(@Param("account") String account);

    /**
     * 插入用户信息
     * @param user
     */
    void insert(User user);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);

    /**
     * 根据ID删除用户
     * @param account
     */
    void deleteById(@Param("account") String account);

    /**
     * 批量删除用户
     * @param ids
     */
    void deleteByIds(@Param("ids") String[] ids);

}
