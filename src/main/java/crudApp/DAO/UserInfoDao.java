package crudApp.DAO;

import crudApp.Models.UserInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserInfoDao {
    List<UserInfo> userList = new ArrayList<>();

    public UserInfo read(int id){
        return userList.stream().filter(userInfo -> userInfo.getId()==id).findAny().orElse(null);
    }
    public void create(int id,UserInfo userInfo){
        userList.add(id,userInfo);

    }
    public void update(int id,UserInfo userInfo){
        UserInfo userInfo1 = read(id);
        userInfo.setName(userInfo.getName());
        userInfo.setLogin(userInfo.getLogin());
        userInfo.setPassword(userInfo.getPassword());
    }
    public void delete(int id,UserInfo userInfo){
        userList.remove(userInfo);
    }
    public void save(int id,UserInfo userInfo){
        userInfo.setId(id);
        userList.add(new UserInfo());
    }

    }


