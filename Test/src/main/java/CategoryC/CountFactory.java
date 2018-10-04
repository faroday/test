package CategoryC;

import CategoryC.impl.Breackets;
import CategoryC.impl.Function;
import CategoryC.impl.Operation;
import CategoryC.operations.FindBreackets;
import CategoryC.operations.FindFunction;
import CategoryC.operations.FindOperation;

//соберем все методы в вызов одного

public class CountFactory {
    private Operation operation;
    private Breackets breackets;
    private Function function;

    public CountFactory(){
        operation = new FindOperation();
        breackets = new FindBreackets();
        function = new FindFunction();
    }

    //выполним все подсчеты
    public String doAll(String str, CountFactory factory){
        str = function.find(str, breackets, factory);
        str = breackets.find(str, factory); //подсчитаем выражения в скобках
        return count(str); //посчитаем все, что осталось
    }

    //выполним все возможные операторы
    public String count(String str){
        str = operation.find(str, '*');
        str = operation.find(str, '/');
        str = operation.find(str, '+');
        str = operation.find(str, '-');
        return str;
    }
}
