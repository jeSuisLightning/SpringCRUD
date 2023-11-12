package crudApp.Controllers;

import crudApp.DAO.UserInfoDao;
import crudApp.Models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/create/{id}")
    public String create(@ModelAttribute("userInfo") UserInfo userInfo,@PathVariable("id") int id){
        userInfoDao.create(id,userInfo);
        return "";
    }
    @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("userInfo")UserInfo userInfo,@PathVariable("id")int id){
        userInfoDao.update(id,userInfo);
        return "";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,@ModelAttribute("userInfo") UserInfo userInfo){
        userInfoDao.delete(id,userInfo);
        return"";
    }
    @GetMapping("/{id}")
    public String getId(@PathVariable("id")int id,Model model){
        model.addAttribute("userInfo",userInfoDao.read(id));
        return "";

    }
    @PostMapping("/save/{id}")
    public String save(@ModelAttribute("userInfo")UserInfo userInfo,@PathVariable("id")int id){
        userInfoDao.save(id,userInfo);
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

        }
        return "";

    }

}
