package CategoryC;

import CategoryC.impl.Breackets;
import CategoryC.impl.Function;
import CategoryC.impl.Operation;

public class CountFactory {
    private Operation operation;
    private Breackets breackets;
    private Function function;

    public CountFactory(){
        operation = new FindOperation();
        breackets = new FindBreackets();
        function = new FindFunction();
    }

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
