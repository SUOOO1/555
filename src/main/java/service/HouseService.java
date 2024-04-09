package service;

import org.apache.ibatis.annotations.Param;
import pojo.House;

import java.util.List;

public interface HouseService {

    /**
     * 查询所有房屋信息
     * @return
     */
    List<House> selectAll();

    /**
     * 分页查询
     * @param begin
     * @param size
     */
    List<House> selectByPage(int begin, int size);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    House selectById(int id);

    /**
     * 总条目数
     * @return
     */
    int selectTotal();

    /**
     * 删除数据
     */
    void deleteById(int id);

    /**
     * 添加数据
     * @param house
     */
    void add(House house);

    /**
     * 修改房屋数据
     */
    void update(House house);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 多条件动态查询
     * @param house
     * @return
     */
    List<House> selectByCondition(House house);

    /**
     * 查询房屋平均单价
     * @return
     */
    int selectUnitPrice();

    /**
     * 查询房屋平均大小
     * @return
     */
    int selectSize();

    /**
     * 查询房屋平均总价
     * @return
     */
    int selectTotalPrice();

}
