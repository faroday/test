package CategoryC;

public class ReadBreackets extends Breackets {

    @Override
    String read(String str, CountFactory factory) {
        str2 = str;
        for (int i = 0; i < str.length(); i++) {
            //ищем открывающую скобку
            if (str.charAt(i) == '(') {
                position = i;
            }
            //ищем закрывающую скобку
            if (str.charAt(i) == ')') {
                //разбиваем выражение на части
                partInBrackets = str.substring(position + 1, i);
                partBefor = str.substring(0, position);
                partAfter = str.substring(i + 1);
                //склеиваем строку с подсчитанным выражением в скобках
                str = partBefor + factory.count(partInBrackets) + partAfter;

                partInBrackets = "";
                partBefor = "";
                partAfter = "";
            }
        }
        if (!str.equals(str2)) //если строки не одинаковые, проверяем выражение на скобки еще раз
            str = read(str, factory);
        return str;
    }
}
