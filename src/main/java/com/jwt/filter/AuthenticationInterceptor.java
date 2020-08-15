package com.jwt.filter;

import com.jwt.annotation.JwtIgnore;
import com.jwt.annotation.PermissionIgnore;
import com.jwt.config.JwtParam;
import com.jwt.constants.JwtConstants;
import com.jwt.exception.MyException;
import com.jwt.services.user.UserService;
import com.jwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Decription：jwt 与 权限拦截器
 * @Author： huang_guoqiang
 * @Date 2019年05月05日 10:13
 * @Version 1.0
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtParam jwtParam;

    @Autowired
    private UserService userService;

    /**
     * 前置拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //预请求不做过滤
        if(HttpMethod.OPTIONS.equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验

        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if(jwtIgnore !=null){
                return true;
            }
        }

        final String headerToken = request.getHeader(JwtConstants.AUTH_HEADER_KEY);
        if(StringUtils.isEmpty(headerToken)){
            log.info("---------用户未登录，请登录----------");
            throw new MyException("用户未登录，请登录");
        }

        // token解析
        Claims claims = JwtUtils.parseToken(headerToken, jwtParam.getBase64Secret());
        if (claims == null) {
            log.info("------------- token解析异常 -----------------");
            throw new MyException("token解析异常");
        }

        //权限是否不做过滤
        //检查是否有PermissionIgore注释，有则跳过权限认证
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            PermissionIgnore permissionIgnore = handlerMethod.getMethodAnnotation(PermissionIgnore.class);
            if(permissionIgnore !=null){
                return true;
            }else{
//                userService.checkUserPermission();
            }
        }

        // 传递所需信息
        request.setAttribute("CLAIMS", claims);
        return true;
    }
}
