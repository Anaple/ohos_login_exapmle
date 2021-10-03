package ohos.example.ohos_login_exapmle.mapper;

import ohos.example.ohos_login_exapmle.provider.LoginProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
@Repository
public interface LoginMapper {
    @SelectProvider(type = LoginProvider.class,method = "checkLoginSql")
    int checkLogin(String username ,String password);

}
