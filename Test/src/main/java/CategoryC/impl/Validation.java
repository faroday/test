package CategoryC.impl;


//проверка ввода на корректность
public interface Validation {
    //принимает строку, проверяет ее и возвращает ложь, если что то неверно
    boolean validation(String str);
}
