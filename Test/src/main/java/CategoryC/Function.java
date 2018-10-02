package CategoryC;

public abstract class Function {
    String funcName = ""; //записываем название функции
    int position = 0;//позиция открывающей скобки

    double function(String num, String func){
        if (func.equals("sqrt"))
            return Math.sqrt(Double.parseDouble(num));
        return 0;
    }

    abstract String read(String str, Breackets breackets, CountFactory factory);
}
