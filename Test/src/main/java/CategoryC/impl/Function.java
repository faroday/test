package CategoryC.impl;

import CategoryC.CountFactory;
import CategoryC.impl.Breackets;

public interface Function {

    //доступные математические функции для выполнения
    double function(String num, String func);

    //найдем функцию в строке
    String find(String str, Breackets breackets, CountFactory factory);
}
