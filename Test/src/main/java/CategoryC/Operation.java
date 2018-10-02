package CategoryC;

public abstract class Operation {

    String firstDigit = ""; //первое число математической операции
    String secondDigit = "";//второе число математической операции
    double first = 0, second = 0; //для перевода числа из строки в double
    int index = 1; //счетчик для перебора ближайщих цифр стоящих к оператору

    //выполняем математическую операцию
    public double operation(double first, double second, char operator){
        switch (operator){
            case '+' : return first + second;
            case '-' : return first - second;
            case '*' : return first * second;
            case '/' : return first / second;
            default: return 0;
        }
    }

    //находим математический оператор в строке, определяем числа стоящие рядом с этим оператором
    //и передаем числа и оператор функции operation
    abstract String count(String str, char operator);
}
