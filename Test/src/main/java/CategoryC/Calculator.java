package CategoryC;

import java.util.Scanner;

public class Calculator {
    private Scanner in;
    private String expression;
    private CountFactory factory;
    private Breackets breackets;
    private Function function;

    public Calculator(){
        in = new Scanner(System.in);
        factory = new CountFactory();
        breackets = new ReadBreackets();
        function = new ReadFunction();
    }

    public void run(){
        while (true) {
            System.out.print(">>");
            expression = in.nextLine();
            if (expression.equals("exit")) return;
            expression = expression.replaceAll(" ", "");
            expression = function.read(expression, breackets, factory);
            expression = breackets.read(expression, factory); //подсчитаем выражения в скобках
            expression = factory.count(expression); //посчитаем все, что осталось
            System.out.println(expression);
        }
    }
}
