package com.taskmanagement.taskmanagement.Exception;

public class BaseException extends RuntimeException {

    public BaseException() {

    }

    public BaseException(ErrorMessage errorMessage) {

        super(errorMessage.prepareErrorMessage());

    }


}
