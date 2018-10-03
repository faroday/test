package CategoryC;

import java.util.Scanner;

public class Calculator {
    private Scanner in;
    private String expression;
    private CountFactory factory;


    public Calculator(){
        in = new Scanner(System.in);
        factory = new CountFactory();
    }

    public void run(){
        while (true) {
            System.out.print(">>");
            expression = in.nextLine();
            if (expression.equals("exit")) return;
            expression = expression.replaceAll(" ", "");
            expression = factory.doAll(expression, factory);
            System.out.println(expression);
        }
    }
}
