package ohos.example.ohos_login_exapmle.controller;

import ohos.example.ohos_login_exapmle.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ManagerController {
    @Autowired
    LoginService loginService;
    @GetMapping("/delete")
    public Map<String,Object> deleteUser(@Param("id") int id){
       Map<String,Object> returnData = new HashMap<>();
       try{

       if(loginService.deleteUser(id)){
           returnData.put("msg","删除用户成功");
           returnData.put("code",1);
       }else {
           returnData.put("msg","删除用户失败");
           returnData.put("code",0);
       }
           return returnData;

       }catch (Exception e){
           System.err.println(e);
           returnData.put("msg","系统错误");
           returnData.put("code",-1);
           return  returnData;
       }
    }
    @PostMapping("/update")
    public Map<String,Object> updateUser(@RequestBody Map<String,Object> objectMap){
        int id = (int) objectMap.get("id");
        String method = objectMap.get("method").toString();
        String value = objectMap.get("value").toString();
        Map<String,Object> returnData = new HashMap<>();
        if(loginService.updateUser(value,method,id)){
            returnData.put("msg","修改成功");
            returnData.put("code",0);
        }else {
            returnData.put("msg","修改失败");
            returnData.put("code",1);
        }
        return returnData;



    }


}
