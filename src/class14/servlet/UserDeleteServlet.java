package class14.servlet;

import class14.dao.UsersDao;
import class14.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "UserDeleteServlet",urlPatterns = "UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受请求，获得参数

        int id= Integer.parseInt(request.getParameter("id"));
        //信息入库
        UsersDao usersDao=new UsersDao();
        boolean result=usersDao.delete(id);
        //返回结果
        if(result){
            response.getWriter().println("delete success");
        }else{
            response.getWriter().println("delete failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
