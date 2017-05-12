package com.moblab.zsolt.moblab.interactor.user.event;

import com.moblab.zsolt.moblab.model.User;

/**
 * Created by mobsoft on 2017. 05. 12..
 */

public class SignUpEvent {

    private int code;
    private User user;
    private Throwable throwable;

    public SignUpEvent() {
    }

    public SignUpEvent(int code, Throwable throwable, User user) {
        this.code = code;
        this.throwable = throwable;
        this.user = user;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
