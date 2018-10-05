package CategoryC.operations;

import CategoryC.impl.Operation;

//ищем и считаем математические операции

public class FindOperation implements Operation {

    @Override
    public String find(String str, char operator) {
        String firstDigit = ""; //первое число математической операции
        String secondDigit = "";//второе число математической операции
        int index = 1; //счетчик для перебора ближайщих цифр стоящих к оператору

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == operator && i != 0) { //ищем ближайший математический оператор
                boolean minus = false;
                //записываем число слева от оператора
                while ((Character.isDigit(str.charAt(i - index)) &&
                        !minus) || //если в числе уже есть минус прекращаем ввод первого числа
                        str.charAt(i - index) == '.' || //учитывая, дробную часть
                        (str.charAt(i - index) == '-' && i == index)) { //и отрицательное число

                    firstDigit = str.charAt(i - index) + firstDigit; //порядок добавления символов в строку
                    if (str.charAt(i - index) == '-')//если число с минусом
                        minus = true;
                    index++;
                    if (index > i) break; //прерываем цикл, если индекс указывает на элемент
                                        //перед нулевым
                }
                index = 1;
                while (Character.isDigit(str.charAt(i + index)) || //записываем число справа от оператора
                        str.charAt(i + index) == '.') {

                    secondDigit += str.charAt(i + index);
                    index++;
                    if (index >= str.length() - i) //прерываем цикл, если индекс больше длины массива
                        break;
                }


                double first = Double.parseDouble(firstDigit);
                //для перевода числа из строки в double
                double second = Double.parseDouble(secondDigit);
                double ans = count(first, second, operator);
                if (ans >= 0) { // если получилось положительное число
                    str = str.substring(0, i - firstDigit.length()) +
                            ans +
                            str.substring(i + secondDigit.length() + 1);
                } else { //если отрицательное, учитываем его минус
                    str = str.substring(0, i - firstDigit.length() - 1) +
                            count(first, second, operator) +
                            str.substring(i + secondDigit.length() + 1);
                    i = 0;
                }
                index = 1;
                firstDigit = "";
                secondDigit = "";
            }
        }
        return str;
    }

    @Override
    public double count(double first, double second, char operator){
        switch (operator){
            case '+' : return first + second;
            case '-' : return first - second;
            case '*' : return first * second;
            case '/' : return first / second;
            default: return 0;
        }
    }

    public String doOperate(String str){
        str = find(str, '*');
        str = find(str, '/');
        str = find(str, '-');
        str = find(str, '+');
        return str;
    }
}
