package CategoryC.impl;

import CategoryC.CountFactory;
import CategoryC.impl.Breackets;

public abstract class Function {

    public double function(String num, String func){
        if (func.equals("sqrt"))
            return Math.sqrt(Double.parseDouble(num));
        return 0;
    }

    public abstract String find(String str, Breackets breackets, CountFactory factory);
}
