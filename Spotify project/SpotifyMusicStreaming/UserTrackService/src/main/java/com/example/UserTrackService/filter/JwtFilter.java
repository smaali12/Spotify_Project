package com.example.UserTrackService.filter;

import io.jsonwebtoken.Jwts;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest; //typecasting coz we are usig
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        ServletOutputStream serveOutput = httpServletResponse.getOutputStream();        //ServletOutputStream is abstract of class

        //expect the token
        String authHearder = httpServletRequest.getHeader("Authorization");//get token here

        System.out.println("**AuthHeader  " + authHearder + "***************");

        if (authHearder == null || !authHearder.startsWith("Bearer"))
        {
            // token is missing execute this code
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            serveOutput.println("Missing or invalid token");
            serveOutput.close();
        }
        else
        {
            //token is valid then execute this
            String jwtToken = authHearder.substring(7);
            System.out.println("******************************jwtToken " + jwtToken + " ***********************");
            String username = Jwts.parser().setSigningKey("securityKey").parseClaimsJws(jwtToken).getBody().getSubject();
            System.out.println("***************************username  " + username + "***************");
            httpServletRequest.setAttribute("firstname", username);
            filterChain.doFilter(servletRequest, servletResponse);//doFilter allows to do next filter
        }
    }

}