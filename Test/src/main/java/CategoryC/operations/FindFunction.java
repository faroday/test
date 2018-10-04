package CategoryC.operations;

import CategoryC.CountFactory;
import CategoryC.impl.Breackets;
import CategoryC.impl.Function;

//ищем функцию и считаем ее

public class FindFunction extends Function {

    @Override
    public String find(String str, Breackets breackets, CountFactory factory) {

        String funcName = ""; // название функции
        int position = 0;//позиция открывающей скобки
        int breacketsCounter = 0; //считаем сколько открывающих скобок внутри функции

        for (int i = 0; i < str.length(); i++) {

            if (Character.isLetter(str.charAt(i))) {//проверяем входит ли символ в буквенный диапазон
                funcName += str.charAt(i);
            } else if (!funcName.equals("")) { //если название функции закончилось
                if (str.charAt(i) == '(') {   //запоминаем положение открывающей скобки
                    if (position == 0)
                        position = i;
                    else
                        breacketsCounter++; //если внутренняя скобка функции, то увеличиваем счетчик
                }

                if (str.charAt(i) == ')') { //затем находим закрывающую
                    if (breacketsCounter != 0)
                        breacketsCounter--; //уменьшаем счетчик, если пройдена закрывающая скобка внутри функции
                    else {
                        //склеиваем строку с уже подсчитанным значением
                        str = str.substring(0, position - funcName.length()) +
                                function(factory.doAll(str.substring(position + 1, i), factory), funcName) +
                                str.substring(i + 1);

                        funcName = "";
                        position = 0;
                        i=0;
                    }
                }
            }
        }

        return str;
    }
}
