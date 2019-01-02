package class14.servlet;

import class14.dao.UsersDao;
import class14.domain.User;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserSelectAllServlet",urlPatterns = "/UserSelectAllServlet")
public class UserSelectAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有用户
        UsersDao usersDao=new UsersDao();
        List<User> userList=usersDao.selectAll();
        //给客户端，返回所有用户数据
        //java对象转换为json字符串
        String result=JSON.toJSONString(userList);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
