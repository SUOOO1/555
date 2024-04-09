package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.PieChart;

import java.util.List;

public interface ChartMapper {

    /**
     * 查询户型Top5
     * @return
     */
    List<PieChart> selectForTypeTopFive();

    /**
     * 查询售价Top5
     * @return
     */
    PieChart selectForUnitPriceTopFive(@Param("begin") int begin, @Param("end") int end);

    /**
     * 查询售房位置分布情况Top3
     * @return
     */
    List<PieChart> selectForAddressTopThree();

    /**
     * 查询售房小区Top5
     * @return
     */
    List<PieChart> selectForCommunityTopFive();

    /**
     * 统计每天的售房数量
     * @return
     */
    List<PieChart> selectForShelfDate();

    /**
     * 统计每天的均价
     * @return
     */
    List<PieChart> selectForUnitPrice();

    /**
     * 统计每种户型的平均面积
     * @return
     */
    List<PieChart> selectForTypeSize();

}
