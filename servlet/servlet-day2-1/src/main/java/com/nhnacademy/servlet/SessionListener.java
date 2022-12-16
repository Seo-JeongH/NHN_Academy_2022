package com.nhnacademy.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class SessionListener implements HttpSessionListener {
    private int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("session count={}", ++sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("session count={}", --sessionCount);
    }

}
