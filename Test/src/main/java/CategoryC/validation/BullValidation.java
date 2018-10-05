package CategoryC.validation;

import CategoryC.impl.Validation;

public class BullValidation implements Validation {

    @Override
    public boolean validation(String str) {
        for (int i = 0; i < str.length(); i++){
            //проверим на недопустимые символы
            if (str.charAt(i) != '0' && str.charAt(i) != '1' &&
                    str.charAt(i) != '&' && str.charAt(i) != '|' &&
                    str.charAt(i) != '(' && str.charAt(i) != ')' &&
                    str.charAt(i) != '.' && str.charAt(i) != ',' &&
                    str.charAt(i) != '!')
                return false;

            //проверим на ввод нескольких операторов подряд
            if (i < str.length() - 1){
                if ((str.charAt(i) == '&' || str.charAt(i) == '|') &&
                        (str.charAt(i + 1) == '&' || str.charAt(i + 1) == '|'))
                    return false;
                if ((str.charAt(i) == '1' || str.charAt(i) == '0') &&
                        (str.charAt(i + 1) == '1' || str.charAt(i + 1) == '0'))
                    return false;
                if (str.charAt(i) == '!' &&
                        (str.charAt(i + 1) == '&' || str.charAt(i + 1) == '|'))
                    return false;
            }
        }
        return str.charAt(str.length() - 1) != '!'; //проверим чтобы последний символ не был
                                                    //не был пустым отрицанием
    }
}
