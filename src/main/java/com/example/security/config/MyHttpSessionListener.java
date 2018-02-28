package com.example.security.config;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dashuai on 2017/11/24.
 */
@Component
public class MyHttpSessionListener implements HttpSessionListener {

    private Map<String,HttpSession> sessions = new HashMap<>();


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        sessions.put(httpSessionEvent.getSession().getId(),httpSessionEvent.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessions.remove(httpSessionEvent.getSession().getId());

    }

    //清空session
    public void clearSession(){
        sessions.clear();
    }

    public Map<String, HttpSession> getSessions() {
        return sessions;
    }

    public void setSessions(Map<String, HttpSession> sessions) {
        this.sessions = sessions;
    }
}
