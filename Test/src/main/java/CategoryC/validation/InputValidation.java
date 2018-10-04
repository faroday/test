package CategoryC.validation;

import CategoryC.impl.Validation;

public class InputValidation implements Validation {

    @Override
    public boolean validation(String str) {
        for (int i = 0; i < str.length(); i++){
            //проверим на недопустимые символы
            if (!Character.isLetterOrDigit(str.charAt(i)) &&
                    str.charAt(i) != '*' && str.charAt(i) != '/' &&
                    str.charAt(i) != '+' && str.charAt(i) != '-' &&
                    str.charAt(i) != '(' && str.charAt(i) != ')')
                return false;

            //проверим на ввод нескольких операторов подряд
            if (i < str.length() - 1){
                if ((str.charAt(i) == '+' || str.charAt(i) == '-' ||
                        str.charAt(i) == '*' || str.charAt(i) == '/') &&
                        (str.charAt(i + 1) == '+' || str.charAt(i + 1) == '-' ||
                                str.charAt(i + 1) == '*' || str.charAt(i + 1) == '/'))
                    return false;
            }
        }
        return true;
    }
}
