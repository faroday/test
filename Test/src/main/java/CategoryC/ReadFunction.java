package CategoryC;

public class ReadFunction extends Function {

    @Override
    String read(String str, Breackets breackets, CountFactory factory) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {//проверяем входит ли символ в буквенный диапазон
                funcName += str.charAt(i);
            } else  {
                if (str.charAt(i) == '(') {
                    position = i;
                }
                if (str.charAt(i) == ')') {
                    str = str.substring(0, position - funcName.length()) +
                            function(breackets.read(str.substring(position + 1, i), factory), funcName) +
                            str.substring(i + 1);
                    funcName = "";
                    position = 0;
                }
            }
        }
        return str;
    }
}
