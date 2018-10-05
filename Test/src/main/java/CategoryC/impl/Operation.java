package CategoryC.impl;

public interface Operation {

    //принимает на входе 2 числа и выполняет математическую операцию между ними
    double count(double first, double second, char operator);

    //находим математический оператор в строке, определяем числа стоящие рядом с этим оператором
    //и передаем числа и оператор функции operation
    String find(String str, char operator);

    String doOperate(String str);
}
