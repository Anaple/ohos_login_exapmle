package ohos.example.ohos_login_exapmle.mapper;

import ohos.example.ohos_login_exapmle.provider.LoginProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface LoginMapper {
    @SelectProvider(type = LoginProvider.class,method = "checkLoginSql")
    int checkLogin(String username ,String password);

    @InsertProvider(type = LoginProvider.class,method = "createUserSql")
    boolean createUser(String username,String password);

    @SelectProvider(type = LoginProvider.class ,method = "checkUserSql")
    int checkUser(String username);

    @DeleteProvider(type = LoginProvider.class ,method = "deleteUserSql")

    boolean deleteUser(int id);

    @UpdateProvider(type = LoginProvider.class,method = "updateUserSql")

    boolean updateUser(String value ,String col,int id);
    @SelectProvider(type = LoginProvider.class,method = "getAllUserSql")
    List<Map<String,Object>> getAllUser();


}
