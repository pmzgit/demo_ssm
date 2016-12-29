package com.pmz.web.sys;

import com.pmz.model.sys.User;
import com.pmz.web.base.BaseController;
import com.pmz.model.PageData;
import com.pmz.service.sys.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;

/**
 * Created by Administrator on 2016/11/8.
 */
@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    @Resource(name="userService")
    private UserService userService;

    /*@Resource(name="roleService")
    private RoleService roleService;
    @Resource(name="menuService")
    private MenuService menuService;*/

    @RequestMapping("/user")
    public String index(){
        return "sys/editUser";
    };

    /**
     * 保存用户
     */
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(User user, ModelMap modelMap) throws Exception{
        User u = userService.save(user);
        System.out.println("id: "+u.getId());
        modelMap.addAttribute("user",user);
        return "sys/showUser";
    }
    /*@RequestMapping("/showUserToJspById/{userId}")
    public String showUser(Model model, @PathVariable("userId") Integer userId){
        User user = this.userService.getUser(userId);
        model.addAttribute("user", user);
        return "showUser";
    }
    @RequestMapping("/showUserToJSONById/{userId}")
    @ResponseBody
    public User showUser(@PathVariable("userId") Integer userId){
        User user = userService.getUser(userId);
        return user;
    }*/
}
