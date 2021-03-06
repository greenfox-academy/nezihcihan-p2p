package com.greenfox.nezihcihanp2p.service;

import com.greenfox.nezihcihanp2p.model.Log;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogChecker {

    public boolean logIsInfo() {
        return System.getenv("CHAT_APP_LOGLEVEL").equals("INFO");
    }
    public void printErrorLog(HttpServletRequest request) {
        Log log = new Log(request);
        log.setLogLevel("ERROR");
        String logMessage = log.toString();
        System.err.println(logMessage);
    }

    public void printNormalLog(HttpServletRequest request) {
        if (logIsInfo()) {
            Log log = new Log(request);
            String logMessage = log.toString();
            System.out.println(logMessage);
        }
    }
}