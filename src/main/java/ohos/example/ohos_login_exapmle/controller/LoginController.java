package ohos.example.ohos_login_exapmle.controller;

import ohos.example.ohos_login_exapmle.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    public Map login(@RequestBody Map<String,Object> loginInfo){
       try {
           String username = loginInfo.get("username").toString();
           String password = loginInfo.get("password").toString();
           Map<String,Object> returnData = new HashMap<>();
           if(loginService.checkLogin(username,password) !=0)
           {
               returnData.put("code",0);
               returnData.put("msg","登录成功");
               return returnData;
           }else {
               returnData.put("code",1);
               returnData.put("msg","登录失败，用户名或密码错误");
               return returnData;
           }

       }catch (Exception e){
           Map<String,Object> errorReturn = new HashMap<>();
           errorReturn.put("msg","未知错误");
           errorReturn.put("code",-1);
           System.err.println(e);
           return  errorReturn;
       }



    }
}
