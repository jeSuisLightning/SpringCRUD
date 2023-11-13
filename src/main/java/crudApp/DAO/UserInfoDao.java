package crudApp.DAO;

import crudApp.Models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserInfoDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
     public UserInfoDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    List<UserInfo> userList = new ArrayList<>();

    public UserInfo read(int id)throws SQLException{
        return jdbcTemplate.query("SELECT * FROM users_info.userInfo WHERE ID =?",new Object[]{id},new BeanPropertyRowMapper<>(UserInfo.class)).stream().findAny().orElse(null);

    }

    public void update(int id,UserInfo userUpInfo)throws SQLException{
        jdbcTemplate.update("UPDATE users_info.userInfo SET user=?,login=?,password=? where id = ?",new Object[]{id},userUpInfo.getName(),
                userUpInfo.getLogin(),userUpInfo.getPassword(),id);


//        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users_info.userInfo SET user=?,login=?,password=? where id = ?");
//        preparedStatement.setString(1,userUpInfo.getName());
//        preparedStatement.setString(2,userUpInfo.getLogin());
//        preparedStatement.setString(3, userUpInfo.getPassword());
//        preparedStatement.setInt(4,userUpInfo.getId());
//        preparedStatement.executeUpdate();


    }
    public void delete(int id,UserInfo userInfo)throws SQLException{
        jdbcTemplate.update("DELETE FROM users_info.userInfo WHERE id=?",id);
//        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users_info.userInfo WHERE id=?");
//        preparedStatement.setInt(1,id);
//        preparedStatement.executeUpdate();
    }

    public void create(UserInfo userInfo) throws SQLException{
        jdbcTemplate.update("INSERT INTO users_info.userInfo VALUES(1,?,?,?)",userInfo.getName(),userInfo.getLogin(),userInfo.getPassword());

//            Statement statement = connection.createStatement();
//            String SQL = "INSERT INTO users_info.userInfo VALUES(id,user,login,password)";
//            ResultSet resultSet = statement.executeQuery(SQL);
//            statement.executeUpdate(SQL);



    }


    public List<UserInfo> index() throws SQLException {
        return jdbcTemplate.query("SELECT*FROM users_info.userInfo",new BeanPropertyRowMapper<>(UserInfo.class));
        }


    }





