package com.corn.vsound.web.filter;

import com.corn.boot.base.HttpBase;
import com.corn.boot.base.LogClientBase;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yyc
 * @apiNote 跨域过滤器
 * */
public class CorsFilter extends LogClientBase implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("********** 跨域过滤器初始化 **********");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String method = request.getMethod();
        log.info("接口请求:{},方式:{}",request.getRequestURI(),request.getMethod());

        response.setHeader("Access-Control-Expose-Headers", "isign,app,x-requested-with,content-type,No-Cache");
        //请求方法
        response.setHeader("Access-Control-Request-Method", "GET,POST,PUT,DELETE,OPTIONS");
        //请求头
        response.setHeader("Access-Control-Request-Headers", "app,x-requested-with,content-type,No-Cache");
        //同意的方法
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        //同意的请求头
        response.setHeader("Access-Control-Allow-Headers", "app,x-requested-with,content-type,No-Cache");

        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setHeader("Access-Control-Allow-Origin","*");

        response.setCharacterEncoding(HttpBase.HTTP_CHARSET);

        if(HttpBase.HTTP_REQUEST_METHOD_OPTION.equals(method)){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("cross pass ok !");
            return;
        }

        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        log.info("********** 跨域过滤器销毁 **********");
    }

}
