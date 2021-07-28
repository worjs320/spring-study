package net.madvirus.spring4.chap07.jgkim;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HandlerInterceptorTest implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Date date = new Date();
        request.setAttribute("beginTime", date);
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
        Date beginTime = (Date) request.getAttribute("beginTime");
        Date endTime = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");

        System.out.println("시작 시간: " + simpleDateFormat.format(beginTime));
        System.out.println("종료 시간: " + simpleDateFormat.format(endTime));
        long runTime = (endTime.getTime() - beginTime.getTime());
        System.out.println(request.getRequestURI() + "실행 시간: " + runTime);
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

    }
}
