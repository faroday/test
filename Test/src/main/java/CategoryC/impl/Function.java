package CategoryC.impl;

import CategoryC.CountFactory;
import CategoryC.impl.Breackets;

public abstract class Function {

    //доступный мматематические функции для выполнения
    public double function(String num, String func){
        if (func.equals("sqrt"))
            return Math.sqrt(Double.parseDouble(num));
        if (func.equals("sin"))
            return Math.sin(Double.parseDouble(num));
        if (func.equals("pow")) {
            String[] numbers = num.split(",");
            return Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
        }
        System.out.println(func + " is unknown function!");
        return 0;
    }

    public abstract String find(String str, Breackets breackets, CountFactory factory);
}
