package servlet;

import com.alibaba.fastjson.JSON;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        User user = JSON.parseObject(params, User.class);

        User testUser = userService.selectById(user.getAccount());
        if (testUser == null) {
            userService.insert(user);
            response.getWriter().write("success");
        } else {
            response.getWriter().write("error");
        }

    }

    /**
     * 登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        //JSON字符串转为Brand对象
        User user = JSON.parseObject(params, User.class);

        User testUser = userService.selectById(user.getAccount());

        if (testUser != null && user.getPassword().equals(testUser.getPassword()) && user.getStatus().equals(testUser.getStatus())) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("error");
        }

    }

    /**
     * 查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.selectAll();

        String jsonString = JSON.toJSONString(users);

        response.setContentType("test/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 删除用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");

        userService.deleteById(account);

        response.getWriter().write("success");
    }

    /**
     * 修改用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        User user = JSON.parseObject(params, User.class);

        userService.update(user);

        response.getWriter().write("success");
    }

    /**
     * 批量删除用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//JSON字符串

        String[] ids = JSON.parseObject(params, String[].class);

        userService.deleteByIds(ids);

        response.getWriter().write("success");
    }
}
