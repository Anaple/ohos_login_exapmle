package ohos.example.ohos_login_exapmle.service;

import ohos.example.ohos_login_exapmle.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;
    public int checkLogin(String username,String password){
        return  loginMapper.checkLogin(username,password);
    }
}
