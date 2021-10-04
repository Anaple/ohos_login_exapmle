package ohos.example.ohos_login_exapmle.controller;

import ohos.example.ohos_login_exapmle.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    LoginService loginService;
    @PostMapping("/register")
    public Object createUser(@RequestBody Map<String,String> data){
        Map<String,String> returnData = new HashMap<>();
        try {
            if (loginService.checkUser(data.get("username"))) {
                if(loginService.createUser(data.get("username"), data.get("password"))) {
                    returnData.put("msg", "注册成功");
                    returnData.put("code", "0");

                }else {
                    returnData.put("msg","系统错误");
                    returnData.put("code","-1");
                }
                return returnData;
            } else {
                returnData.put("msg", "注册失败,用户名重复");
                returnData.put("code", "1");
                return returnData;
            }
        }catch (Exception e){
            System.err.println(e);
            returnData.put("msg","系统错误");
            returnData.put("code","-1");
            return returnData;
        }


    }
}
