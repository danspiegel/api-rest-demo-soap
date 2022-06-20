package br.com.aws.soap.demo.exception;

public class DemoException extends RuntimeException {

    public DemoException() {
        super();
    }

    public DemoException(String msg){
        super(msg);
    }

    public DemoException(String msg, Throwable cause){
        super(msg, cause);
    }

}
