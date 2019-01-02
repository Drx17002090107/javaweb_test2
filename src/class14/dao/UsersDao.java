package class14.dao;



import class14.domain.User;
import class14.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {

    public boolean insert(User user) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            //预先编译提高查询速度 防止sql注入数据
            String sql = "insert into users values(?,?,?,?,?,?)";
            //1005,'kuai','121233','男',20,'2018-12-24'
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getSex());
            pstmt.setInt(5, user.getAge());
            pstmt.setDate(6, user.getBirthday());

            int res = pstmt.executeUpdate();

            if (res > 0)
                return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(pstmt, conn);
        }
        return false;
    }

    public boolean delete(Integer id) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            //预先编译提高查询速度 防止sql注入数据
            String sql = "delete from users where id = ?";
            //1005,'kuai','121233','男',20,'2018-12-24'
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int res = pstmt.executeUpdate();

            if (res > 0)
                return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(pstmt, conn);
        }
        return false;
    }

    public boolean update(User user) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            //预先编译提高查询速度 防止sql注入数据
            String sql = "update users set name = ?,password = ?,sex = ?,age = ?,birthday = ? where id = ?";
            //1005,'kuai','121233','男',20,'2018-12-24'
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(6, user.getId());
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getSex());
            pstmt.setInt(4, user.getAge());
            pstmt.setDate(5, user.getBirthday());
            int res = pstmt.executeUpdate();

            if (res > 0)
                return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(pstmt, conn);
        }
        return false;
    }

    public List<User> selectAll() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            List<User> userList = new ArrayList<>();
            String sql = "select * from users";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String psw = rs.getString("password");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");
                userList.add(new User(id,name,psw,sex,age,birthday));
            }
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }

        return null;
    }

}
