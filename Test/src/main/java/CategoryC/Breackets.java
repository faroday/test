package CategoryC;

public abstract class Breackets {
    public String partInBrackets; //часть выражения находящаяся в скобках
    String partBefor; //часть выр. до скобок
    String partAfter; // часть выр. после скобок
    String str2; //для проверки входной и выходной строки, в случае совпадения прерываем проверку на скобки
    int position = 0; //позиция на которой стоит открывающая скобка

    abstract String read(String str, CountFactory factory);
}
