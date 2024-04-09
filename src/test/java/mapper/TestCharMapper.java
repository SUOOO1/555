package mapper;

import org.junit.Test;
import pojo.PieChart;
import service.ChartService;
import service.impl.ChartServiceImpl;

import java.util.List;

public class TestCharMapper {

    ChartService chartService = new ChartServiceImpl();

    @Test
    public void testSelectForAddressTopThree(){
        List<PieChart> pieCharts = chartService.selectForAddressTopThree();
        System.out.println(pieCharts);
    }

    @Test
    public void testSelectForShelfDate(){
        List<PieChart> pieCharts = chartService.selectForShelfDate();
        System.out.println(pieCharts);
    }

}
