package CategoryC.operations;

import CategoryC.impl.Operation;

//ищем и считаем математические операции

public class FindOperation extends Operation {

    @Override
    public String find(String str, char operator) {
        String firstDigit = ""; //первое число математической операции
        String secondDigit = "";//второе число математической операции
        int index = 1; //счетчик для перебора ближайщих цифр стоящих к оператору

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == operator && i != 0) { //ищем ближайший математический оператор
                while (Character.isDigit(str.charAt(i - index)) || //записываем число слева от оператора
                        str.charAt(i - index) == '.' || //учитывая, дробную часть
                        (str.charAt(i - index) == '-' && i == index)) { //и отрицательное число
                    firstDigit = str.charAt(i - index) + firstDigit; //порядок добавления символов в строку
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
                str = str.substring(0, i - firstDigit.length()) + //склеиваем строку с посчитанным значением
                        count(first, second, operator) +
                        str.substring(i + secondDigit.length() + 1);
                index = 1;
                firstDigit = "";
                secondDigit = "";
            }
        }
        return str;
    }
}
