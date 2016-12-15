package com.pmz.cms.controller.auth;

import com.pmz.cms.controller.base.BaseController;
import com.pmz.model.PageData;
import com.pmz.model.auth.User;
import com.pmz.service.auth.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/11/8.
 */
@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    @Resource(name="userService")
    private UserService userService;
    /*@Resource(name="roleService")
    private RoleService roleService;
    @Resource(name="menuService")
    private MenuService menuService;*/

    /**
     * 保存用户
     */
    @RequestMapping(value="/saveU")
    public ModelAndView saveU(PrintWriter out) throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();

        pd.put("USER_ID", this.get32UUID());	//ID
        pd.put("RIGHTS", "");					//权限
        pd.put("LAST_LOGIN", "");				//最后登录时间
        pd.put("IP", "");						//IP
        pd.put("STATUS", "0");					//状态
        pd.put("SKIN", "default");				//默认皮肤

//        pd.put("PASSWORD", new SimpleHash("SHA-1", pd.getString("USERNAME"), pd.getString("PASSWORD")).toString());

//        if(null == userService.findByUId(pd)){
//            if(Jurisdiction.buttonJurisdiction(menuUrl, "add")){userService.saveU(pd);} //判断新增权限
//            mv.addObject("msg","success");
//        }else{
            mv.addObject("msg","failed");
//        }
        mv.setViewName("save_result");
        return mv;
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
