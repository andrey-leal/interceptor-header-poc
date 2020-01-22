package com.example.idempotencia.webconfig;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransactionIdInterceptor extends HandlerInterceptorAdapter {

    private RequestTransaction requestTransaction;

    public TransactionIdInterceptor(RequestTransaction requestTransaction1) {
        this.requestTransaction = requestTransaction1;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String transactionId = request.getHeader("transactionId");
        String canal = request.getHeader("canal");
        requestTransaction.setTransactionId(transactionId);
        requestTransaction.setCanal(canal);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(requestTransaction + " " + response.getHeader("transactionCompleted") );
    }
}
