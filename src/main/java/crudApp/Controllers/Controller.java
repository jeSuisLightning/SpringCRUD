package crudApp.Controllers;

import crudApp.DAO.UserInfoDao;
import crudApp.Models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Component
@RestController
@RequestMapping("/info")
public class Controller {
    @Autowired
    private UserInfoDao userInfoDao;
    @GetMapping("/read")
    public String read(Model model){
        model.addAttribute("userInfo",UserInfo.class);
        return "";
    }
    @GetMapping("/index/{id}")
    public String getIndex(@ModelAttribute("userInfo")UserInfo userInfo,@PathVariable("id") int id) throws SQLException{
        userInfoDao.index();
        return "";
    }

    @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("userInfo")UserInfo userInfo,@PathVariable("id")int id) throws SQLException {
        userInfoDao.update(id,userInfo);
        return "";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,@ModelAttribute("userInfo") UserInfo userInfo) throws SQLException {
        userInfoDao.delete(id,userInfo);
        return"";
    }
    @GetMapping("/{id}")
    public String getId(@PathVariable("id")int id,Model model) throws SQLException {
        model.addAttribute("userInfo",userInfoDao.read(id));
        return "";

    }
    @PostMapping("/save")
    public String create(@ModelAttribute("userInfo")UserInfo userInfo) throws SQLException {
        userInfoDao.create(userInfo);
        return "";
    }
    @GetMapping("/calc")
    public String calc(@RequestParam("a")int a,@RequestParam("b")double b,@RequestParam("action")String action){
        double result;
        switch (action){
            case"+":
                result = a+b;
                break;
            case "-":
                result = a-b;
            case "*":
                result = a*b;
            case "/":
                result = a/b;
            default:result = 0;
            return action;
        }
        return "";

    }

}
