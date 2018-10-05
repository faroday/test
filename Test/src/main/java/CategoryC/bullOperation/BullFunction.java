package CategoryC.bullOperation;

import CategoryC.CountFactory;
import CategoryC.impl.Breackets;
import CategoryC.impl.Function;


public class BullFunction implements Function {

    //вычисляем логические отрицание
    @Override
    public double function(String num, String func) {
        if (func.equals("!"))
            return Double.parseDouble(num) == 1 ? 0 : 1;
        return 0;
    }

    //ищем логические отрицание
    @Override
    public String find(String str, Breackets breackets, CountFactory factory) {
        String num = "";
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '!') {
                num += str.charAt(i + 1);
                str = str.substring(0, i) + function(num, "!") + str.substring(i + 2);
                num = "";
            }
        }
        return str;
    }
}
