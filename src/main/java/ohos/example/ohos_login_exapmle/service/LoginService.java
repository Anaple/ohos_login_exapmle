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
    public boolean createUser(String username,String password){
        return  loginMapper.createUser(username,password);
    }
    public boolean checkUser(String username){
        if(loginMapper.checkUser(username)!=0){
            return  false;
        }else {
            return true;
        }
    }
    public boolean deleteUser(int id){
        return loginMapper.deleteUser(id);
    }
    public boolean updateUser(String value,String col ,int id){
        return loginMapper.updateUser(value,col,id);
    }

}
