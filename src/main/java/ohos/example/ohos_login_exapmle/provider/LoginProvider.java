package ohos.example.ohos_login_exapmle.provider;

public class LoginProvider {
    public String checkLoginSql(){
        String sql ="SELECT COUNT(*) FROM userinfo WHERE username= #{username} AND password= #{password}";
        return sql;
    }
}
