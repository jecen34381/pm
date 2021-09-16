package com.example.pm.interceptor;

import ch.qos.logback.classic.util.LoggerNameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class HandlerLogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loggerId = UUID.randomUUID().toString();
        //HandlerMethod requestHandler = (HandlerMethod)handler;
        final Logger logger = LoggerFactory.getLogger(HandlerLogInterceptor.class);

        logger.info("拦截器开始！");

        logger.info("request method:" + request.getMethod());
        logger.info("request url:" + request.getRequestURI());
        request.setAttribute("loggerId", loggerId);
        request.setAttribute("Logger", logger);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Logger logger = (Logger) request.getAttribute("Logger");
        String loggerId = (String)request.getAttribute("loggerId");
        logger.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Logger logger = (Logger) request.getAttribute("Logger");
        String loggerId = (String)request.getAttribute("loggerId");
        if (ex != null) {
            logger.info(ex.getMessage());
        }
    }
}
