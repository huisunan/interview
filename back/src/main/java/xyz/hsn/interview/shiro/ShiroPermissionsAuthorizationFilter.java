package xyz.hsn.interview.shiro;


import com.alibaba.fastjson.JSON;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.tomcat.util.http.ResponseUtil;
import xyz.hsn.interview.bean.BaseResult;
import xyz.hsn.interview.constant.Constants;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShiroPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = this.getSubject(request, response);
        HttpServletResponse resp = (HttpServletResponse)response;
        if (subject.getPrincipal() == null) {
            /**
             * 在这里实现自己想返回的信息，其他地方和源码一样就可以了
             */
            resp.setHeader("Access-Control-Allow-Origin", "*");
            resp.setHeader("Access-Control-Allow-Credentials", "true");
            resp.setContentType("application/json; charset=utf-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            BaseResult baseResult = BaseResult.fail(Constants.NO_LOGIN, "未登录");
            writer.println(JSON.toJSONString(baseResult));
            writer.flush();
            writer.close();
        } else {
            /**
             * 在这里实现自己想返回的信息，其他地方和源码一样就可以了
             */
            HttpServletRequest resq = (HttpServletRequest) request;
            resp.setHeader("Access-Control-Allow-Origin", "*");
            resp.setHeader("Access-Control-Allow-Credentials", "true");
            resp.setContentType("application/json; charset=utf-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            BaseResult baseResult = BaseResult.fail(Constants.NO_PERMISSION, "权限不足");
            writer.println(JSON.toJSONString(baseResult));
            writer.flush();
            writer.close();
        }

        return false;
    }

}
