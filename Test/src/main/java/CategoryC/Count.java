package CategoryC;

public class Count extends Operation {

    @Override
    String count(String str, char operator) {
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
                first = Double.parseDouble(firstDigit);
                second = Double.parseDouble(secondDigit);
                str = str.substring(0, i - firstDigit.length()) + //склеиваем строку с посчитанным значением
                        operation(first, second, operator) +
                        str.substring(i + secondDigit.length() + 1);
                index = 1;
                firstDigit = "";
                secondDigit = "";
            }
        }
        return str;
    }
}
