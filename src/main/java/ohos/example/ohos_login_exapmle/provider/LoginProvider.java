package ohos.example.ohos_login_exapmle.provider;

public class LoginProvider {
    public String checkLoginSql(){
        String sql ="SELECT COUNT(*) FROM userinfo WHERE username= #{username} AND password= #{password}";
        return sql;
    }
    public String createUserSql(){
        String sql = "INSERT INTO userinfo (id,username,password) VALUES (#{id},#{username},#{password})";
        return  sql;
    }
    public String checkUserSql(){
        String sql = "SELECT COUNT(*) FROM userinfo WHERE username=#{username}";
        return sql;
    }
    public String deleteUserSql(){
        String sql = "DELETE FROM userinfo WHERE id =#{id}";
        return sql;
    }
    public String updateUserSql(String value ,String col,int id){
        String sql = "UPDATE userinfo SET "+col+"='"+value +"' WHERE id='"+id+"';";
        return sql;

    }
    public String getAllUserSql(){
        String sql ="SELECT * FROM userinfo";
        return sql;
    }

}
