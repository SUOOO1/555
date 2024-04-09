package service;

import pojo.User;

import java.util.List;

public interface UserService {

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
    User selectById(String account);

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
    void deleteById(String account);

    /**
     * 批量删除用户
     * @param ids
     */
    void deleteByIds(String[] ids);

}
