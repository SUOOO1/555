package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * �滻HttpServlet, ��������·�������һ�������з����ַ�
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.��ȡ����·��
        String uri = req.getRequestURI();

        //2.��ȡ���һ�η�����
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);

        //2.ִ�з���
        //2.1 ��ȡBrandServlet  UserServlet �ֽ������class
        //˭����this, this�ʹ���˭, �������
        Class<? extends BaseServlet> cls = this.getClass();

        try {
            //2.2 ��ȡ��������
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //2.3 ִ�з���
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
