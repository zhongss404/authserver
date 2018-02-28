package com.example.dao.model;

/**
 * Created by dashuai on 2017/11/23.
 */
public class LogoutStatus {
    private boolean status;

    private String message;

    public LogoutStatus() {
    }

    public LogoutStatus(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
