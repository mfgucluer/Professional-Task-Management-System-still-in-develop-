package com.taskmanagement.taskmanagement.Exception;

public class ErrorMessage {
/// Mesajlari yonetebilmek icin actigim class
/*
Bana enum'dan gelen message tipini burada yoneticem aslinda.
Mesaj tipimi hazirladim daha sonra
bu class icinde bu mesaj tipini aldim
bir de ofStatic diye bir sey olusturup kullanicini verdigi degeri aldim
ve burada

Simdi prepare de bu ikisini birlestirip birlestirmis oldugum degeri dondum.
Simdi BaseException sinifina donuyorum

 */

    private MessageType messageType;
    private String ofStatic; ///Extra bir deger verilebilir diye bir tane string tanimladik.


    /// Bu method messageType'in mesajini donmeye calisacak tipe gore.
    public String prepareErrorMessage(){
            StringBuilder builder = new StringBuilder();
            builder.append(messageType.getMessage());
            if(ofStatic != null){
                builder.append(" : " + ofStatic);
            }
            return builder.toString();
    }




















    public ErrorMessage(MessageType messageType, String ofStatic) {
        this.messageType = messageType;
        this.ofStatic = ofStatic;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getOfStatic() {
        return ofStatic;
    }

    public void setOfStatic(String ofStatic) {
        this.ofStatic = ofStatic;
    }


}
