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

@WebServlet(name = "UserInsertServlet",urlPatterns = "/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受请求，获得参数
        User user=new User();
        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setSex(request.getParameter("sex"));
        user.setAge(Integer.valueOf(request.getParameter("age")));
        user.setBirthday(Date.valueOf(request.getParameter("birthday")));
        //信息入库
        UsersDao usersDao=new UsersDao();
        boolean result=usersDao.insert(user);
        //返回结果
        if(result){
            response.getWriter().println("Insert success");
        }else{
            response.getWriter().println("Insert failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
