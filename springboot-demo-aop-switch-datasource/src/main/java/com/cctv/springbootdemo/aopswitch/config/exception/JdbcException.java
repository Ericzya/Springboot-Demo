package com.cctv.springbootdemo.aopswitch.config.exception;

/**
 * @Author: Eric
 * @Date: 2020/3/13 13:36
 */
public class JdbcException extends Exception {

    public JdbcException() {
        super();
    }

    /**
     * 用详细信息指定一个异常
     * @param message
     */
    public JdbcException(String message) {
        super(message);
    }

    /**
     * 用指定的详细信息和原因构造一个新的异常
     * @param message
     * @param cause
     */
    public JdbcException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 用指定原因构造一个新的异常
     * @param cause
     */
    public JdbcException(Throwable cause) {
        super(cause);
    }
}
