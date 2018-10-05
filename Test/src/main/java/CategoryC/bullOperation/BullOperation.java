package CategoryC.bullOperation;


import CategoryC.operations.FindOperation;

public class BullOperation extends FindOperation {


    //вычисляем логические операции
    @Override
    public double count(double first, double second, char operator){
        switch (operator){
            case '&' : if (first == 1 && second == 1)
                    return 1;
                if (first == 0 || second == 0)
                    return 0;
            case '|' : if (first == 1 || second == 1)
                return 1;
                if (first == 0 && second == 0)
                    return 0;
            default: return 0;
        }
    }

    @Override
    public String doOperate(String str){
        str = find(str, '&');
        str = find(str, '|');
        return str;
    }
}
