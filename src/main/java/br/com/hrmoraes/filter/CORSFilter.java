package br.com.hrmoraes.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CORSFilter extends OncePerRequestFilter {

    private static final String ALLOW_HEADERS = "Content-Type, X-Requested-With, Accept, Origin, Access-Control-Request-Method, Access-Control-Request-Headers";
    private static final String ALLOW_METHODS = "POST, PUT, GET, OPTIONS, DELETE";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        response.setHeader("Access-Control-Allow-Headers", CORSFilter.ALLOW_HEADERS);
        response.setHeader("Access-Control-Allow-Methods", CORSFilter.ALLOW_METHODS);
        response.setHeader("Access-Control-Allow-Origin", "*");

        if (!"OPTIONS".equalsIgnoreCase(request.getMethod())) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

}