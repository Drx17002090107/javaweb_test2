package class14.servlet;

import class14.dao.UsersDao;
import class14.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/28 13:44
 * @Version 1.0
 * @Type
 */
@WebServlet(name = "YanZhengServlet",urlPatterns = "/YanZhengServlet")
public class YanZhengServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao usersDao = new UsersDao();
        List<User> userList = usersDao.selectAll();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int flag = 0;
        for(User user:userList){
            if(user.getName().equals(name)&&user.getPassword().equals(password)){
                flag = 1;
            }
        }
        if(flag==1)
            response.sendRedirect("index.html");
        else
            response.sendRedirect("error.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
