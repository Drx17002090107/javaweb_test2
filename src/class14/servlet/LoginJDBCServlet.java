package class14.servlet;



import class14.dao.UsersDao;
import class14.domain.User;
import class14.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


/**
 * @Author: Salexal.fww
 * @Date: 2018/12/27 20:53
 * @Version 1.0
 * @Type
 */
@WebServlet(name = "LoginJDBCServlet",urlPatterns = "/LoginJDBCServlet")
public class LoginJDBCServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setAge(Integer.valueOf(request.getParameter("age")));
        user.setSex(request.getParameter("sex"));
        Date date = null;
        user.setBirthday(new java.sql.Date((new java.util.Date()).getTime()));
        UsersDao usersDao = new UsersDao();

        if(usersDao.insert(user)==true)
            response.sendRedirect("login.html");
        else
            response.getWriter().println("存入数据失败！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
