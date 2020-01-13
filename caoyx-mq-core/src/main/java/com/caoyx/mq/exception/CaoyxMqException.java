package com.caoyx.mq.exception;

/**
 * @Author: caoyixiong
 */
public class CaoyxMqException extends Exception {
    public CaoyxMqException(String msg) {
        super(msg);
    }

    public CaoyxMqException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CaoyxMqException(Throwable cause) {
        super(cause);
    }

    public static CaoyxMqException buildByMsg(String msg) {
        return new CaoyxMqException(msg);
    }
}