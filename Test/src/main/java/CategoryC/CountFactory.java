package CategoryC;

import CategoryC.bullOperation.BullFunction;
import CategoryC.bullOperation.BullOperation;
import CategoryC.impl.Breackets;
import CategoryC.impl.Function;
import CategoryC.impl.Operation;
import CategoryC.impl.Validation;
import CategoryC.operations.FindBreackets;
import CategoryC.operations.FindFunction;
import CategoryC.operations.FindOperation;
import CategoryC.validation.BullValidation;
import CategoryC.validation.InputValidation;

//соберем все методы в вызов одного
public class CountFactory {
    private Operation operation;
    private Breackets breackets;
    private Function function;

    private Validation test;

    public CountFactory(){
        basicMode();
    }

    //логические вычисления
    public void booleanMode(){
        operation = new BullOperation();
        breackets = new FindBreackets();
        function = new BullFunction();

        test = new BullValidation();
    }

    public void basicMode(){
        operation = new FindOperation();
        breackets = new FindBreackets();
        function = new FindFunction();

        test = new InputValidation();
    }

    //вызов проверки ввода
    public boolean valid(String str){
        return test.validation(str);
    }

    //выполним все подсчеты
    public String doAll(String str, CountFactory factory){
        str = function.find(str, breackets, factory);
        str = breackets.find(str, factory); //подсчитаем выражения в скобках
        return count(str); //посчитаем все, что осталось
    }

    public String count(String str){
        return operation.doOperate(str);
    }
}
