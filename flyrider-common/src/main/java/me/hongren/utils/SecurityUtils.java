package me.hongren.utils;

import cn.hutool.json.JSONObject;
import me.hongren.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @ClassName SecurityUtils
 * @Description: TODO
 * @Author Tomy
 * @Date 2019/12/28
 * @Version V1.0
 **/
public class SecurityUtils {

    public static UserDetails getUserDetails(){
        UserDetails userDetails;
        try {
            userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            throw new BadRequestException(HttpStatus.UNAUTHORIZED,"登录状态过期");
        }
        return userDetails;
    }

    public static String getUsername(){
        UserDetails userDetails = getUserDetails();
        return new JSONObject(userDetails).get("username",String.class);
    }
}
