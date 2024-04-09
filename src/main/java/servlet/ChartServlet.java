package servlet;

import com.alibaba.fastjson.JSON;
import pojo.PieChart;
import service.ChartService;
import service.impl.ChartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chart/*")
public class ChartServlet extends BaseServlet{

    ChartService chartService = new ChartServiceImpl();

    public void selectForTypeTopFive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PieChart> pieCharts = chartService.selectForTypeTopFive();

        String jsonString = JSON.toJSONString(pieCharts);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectForUnitPriceTopFive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int[] sections = {5000, 10000, 15000, 20000, 25000, 30000};

        List<PieChart> pieCharts = new ArrayList<>();

        for (int i = 0; i < sections.length - 1; i++) {
            PieChart pieChart = chartService.selectForUnitPriceTopFive(sections[i], sections[i + 1]);
            String name = sections[i] + "-" + sections[i + 1];
            pieChart.setName(name);
            pieCharts.add(pieChart);
        }

        String jsonString = JSON.toJSONString(pieCharts);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectForAddressTopThree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PieChart> pieCharts = chartService.selectForAddressTopThree();

        String jsonString = JSON.toJSONString(pieCharts);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectForCommunityTopFive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PieChart> pieCharts = chartService.selectForCommunityTopFive();

        String jsonString = JSON.toJSONString(pieCharts);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectForShelfDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PieChart> pieCharts = chartService.selectForShelfDate();

        String jsonString = JSON.toJSONString(pieCharts);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectForUnitPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PieChart> pieCharts = chartService.selectForUnitPrice();

        String jsonString = JSON.toJSONString(pieCharts);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectForTypeSize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PieChart> pieCharts = chartService.selectForTypeSize();

        String jsonString = JSON.toJSONString(pieCharts);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
