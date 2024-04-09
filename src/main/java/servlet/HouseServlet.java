package servlet;

import com.alibaba.fastjson.JSON;
import pojo.House;
import pojo.PageBean;
import service.HouseService;
import service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/house/*")
public class HouseServlet extends BaseServlet{

    HouseService houseService = new HouseServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<House> houses = houseService.selectAll();

        String jsonString = JSON.toJSONString(houses);

        response.setContentType("test/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String begin = request.getParameter("begin");
        String size = request.getParameter("size");
        List<House> houses = houseService.selectByPage(Integer.parseInt(begin), Integer.parseInt(size));

        int total = houseService.selectTotal();

        PageBean<House> housePage = new PageBean<>();
        housePage.setTotalCount(total);
        housePage.setRows(houses);

        String jsonString = JSON.toJSONString(housePage);

        response.setContentType("test/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        House house = houseService.selectById(id);

        if(house != null){
            houseService.deleteById(id);
            response.getWriter().write("success");
        }else {
            response.getWriter().write("error");
        }
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        System.out.println(params);

        House house = JSON.parseObject(params, House.class);

        houseService.add(house);

        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        House house = JSON.parseObject(params, House.class);

        houseService.update(house);

        response.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        int[] ids = JSON.parseObject(params, int[].class);

        houseService.deleteByIds(ids);

        response.getWriter().write("success");
    }

    public void selectByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        House house = JSON.parseObject(params, House.class);

        List<House> houses = houseService.selectByCondition(house);

        if(houses == null){
            response.getWriter().write("error");
        }else {
            String jsonString = JSON.toJSONString(houses);

            response.setContentType("test/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }

    public void selectTotal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int total = houseService.selectTotal();

        response.getWriter().write(String.valueOf(total));
    }

    public void selectUnitPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int unitPrice = houseService.selectUnitPrice();

        response.getWriter().write(String.valueOf(unitPrice));
    }

    public void selectSize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int size = houseService.selectSize();

        response.getWriter().write(String.valueOf(size));
    }

    public void selectTotalPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalPrice = houseService.selectTotalPrice();

        response.getWriter().write(String.valueOf(totalPrice));
    }
}

