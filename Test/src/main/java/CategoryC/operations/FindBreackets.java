package CategoryC.operations;

import CategoryC.CountFactory;
import CategoryC.impl.Breackets;

public class FindBreackets implements Breackets {

    @Override
    public String find(String str, CountFactory factory) {
        String partInBrackets; //часть выражения находящаяся в скобках
        String partBefor; //часть выр. до скобок
        String partAfter; // часть выр. после скобок
        String str2 = str; //для проверки входной и выходной строки, в случае совпадения прерываем проверку на скобки
        int position = 0; //позиция на которой стоит открывающая скобка

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') { //ищем открывающую скобку
                position = i;
            }

            if (str.charAt(i) == ')') {//ищем закрывающую скобку
                //разбиваем выражение на части
                partInBrackets = str.substring(position + 1, i);
                partBefor = str.substring(0, position);
                partAfter = str.substring(i + 1);

                //склеиваем строку с подсчитанным выражением в скобках
                str = partBefor + factory.count(partInBrackets) + partAfter;
            }
        }

        if (!str.equals(str2)) //если строки не одинаковые, проверяем выражение на скобки еще раз
            str = find(str, factory);

        return str;
    }
}
