package com.taskmanagement.taskmanagement.exception;


public enum MessageType {


    NO_RECORD_EXIST("1001", "kayıt bulunamadı"),
    GENERAL_EXCEPTION("9999", "genel bir hata oluştu");

    private String code;
    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
