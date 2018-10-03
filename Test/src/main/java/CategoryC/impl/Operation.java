package CategoryC.impl;

public abstract class Operation {

    //принимает на входе 2 числа и выполняет математическую операцию между ними
    public double count(double first, double second, char operator){
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
    public abstract String find(String str, char operator);
}
