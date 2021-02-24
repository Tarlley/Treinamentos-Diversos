package DAO;

import JDBC.ConnectionFactory;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private final Connection connection;

    public UserDao(){
        this.connection = new ConnectionFactory().getConnection();

    }

    public boolean insert(User user){

        String sql = "INSERT INTO user(user_name, user_email, user_password, user_nickName) values(?,?,?,?);";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4,user.getPassword());
            stmt.execute();
            stmt.close();
            connection.close();

            return true;

        } catch (Exception throwables) {
            throwables.printStackTrace();
            throwables.getCause();

            return false;
        }


    }

    public boolean update(User user){

        String sql = "update user set user_name = ?, user_email = ?, user_password = ?, user_nickName = ? WHERE user_id = ?;";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4,user.getPassword());
            stmt.setInt(5,user.getId());
            stmt.execute();
            stmt.close();
            connection.close();

            return true;

        } catch (Exception throwables) {
            throwables.printStackTrace();
            throwables.getCause();

            return false;
        }


    }

    public boolean delete(User user){

        String sql = "delete from user where user_id = ?;";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,user.getId());
            stmt.execute();
            stmt.close();
            connection.close();

            return true;

        } catch (Exception throwables) {
            throwables.printStackTrace();
            throwables.getCause();

            return false;
        }


    }

    public List<User> getList() {

        List<User> users = new ArrayList<>();
        String sql = "Select * from user";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getNString("user_name"));
                user.setEmail(rs.getNString("user_email"));
                user.setPassword(rs.getNString("user_password"));
                user.setNickName(rs.getNString("user_nickName"));

                users.add(user);
            }
            stmt.close();
            rs.close();
            connection.close();
        }catch (Exception e){
            e.getCause();
            e.printStackTrace();
            return null;
        }
        return users;
    }

}
