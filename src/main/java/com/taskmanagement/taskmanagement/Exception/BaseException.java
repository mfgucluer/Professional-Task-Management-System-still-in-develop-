package com.taskmanagement.taskmanagement.Exception;

public class BaseException extends RuntimeException {

    public BaseException() {
        //NoArgConstructor aciyorum. Buradan almis oldugum degeri
        /// Run Time Exception'a vericem
    }

    public BaseException(ErrorMessage errorMessage) {
        /*
        Simdi parametreli constructor actim bir tane sen disarida
        bir tane errorMessage alacaksin ve aldigin bu mesaji super methodu ile
        RunTimeException'in base'ine gonder

        super biliyorsun aslinda burada runTime exceptionin constructorini gosterir
        ve bunun constructori benden aslinda bir hata mesaji bekliyor getLocalizedMessage diye
         */
        super(errorMessage.prepareErrorMessage());
        /// Simdi hata firlatmak istedigim yere gidiyorum. Yani kullanici bir eylem yapacak ve ben aslinda hata uretecegim onunla iligil
        /// ancak o hatayi sadece simdi uretecegim yani firlatacagim onu yakalayip kullaniciya henuz response donmedim

    }


}
