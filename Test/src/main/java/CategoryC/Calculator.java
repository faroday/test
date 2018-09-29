package CategoryC;

import java.util.Scanner;

public class Calculator {
    private Scanner in;
    private String expression;
    private String partInBrackets;
    private String partBefor;
    private String partAfter;

    public Calculator(){
        in = new Scanner(System.in);
    }

    public void run(){
        while (true) {
            System.out.print(">>");
            expression = in.nextLine();
            if (expression.equals("exit")) return;
            expression = expression.replaceAll(" ", "");
            countSecond(expression);
        }
    }

    private void readBreackets(){
        int position = 0; //позиция на которой стоит открывающая скобка
        for (int i = 0; i < expression.length() - 1; i++) {
            if (expression.charAt(i) == '(') {
                position = i;
            }
            if (expression.charAt(i) == ')') {
                partInBrackets = expression.substring(position - 1, i);
                partBefor = expression.substring(0, position);
                partAfter = expression.substring(i + 1);
            }
        }

        System.out.println(partInBrackets);
        System.out.println(partAfter);
        System.out.println(partBefor);
    }

    private void readFunc(){
        String funcName = "";
        String func = "";
        int position = 0;
        for (int i = 0; i < expression.length() - 1; i++) {
            if (expression.charAt(i) >= 'a' && expression.charAt(i) >= 'z') {
                funcName += expression.charAt(i);
            }
            if (funcName != "") {
                if (expression.charAt(i) == '(') {
                    position = i;
                }
                if (expression.charAt(i) == ')') {
                    func = expression.substring(position - 1, i);
                }
            }
        }
    }

    private double operation(double first, double second, char operate){
        switch (operate){
            case '+' : return first + second;
            case '-' : return first - second;
            case '*' : return first * second;
            case '/' : return first / second;
            default: return 0;
        }
    }

    //операции которые в выражении выполняются первыми(*,/)
    private double countFirst(String str){
        String firstDigit = "";
        String secondDigit = "";
        char operator;
        double first, second;
        int index = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*' || str.charAt(i) == '/') {
                operator = str.charAt(i);
                while (Character.isDigit(str.charAt(i - index)) || str.charAt(i - index) == '.') {
                    firstDigit = str.charAt(i - index) + firstDigit;
                    index++;
                    if (index > i) break;
                }
                index = 1;
                while (Character.isDigit(str.charAt(i + index)) || str.charAt(i + index) == '.') {
                    secondDigit += str.charAt(i + index);
                    index++;
                    if (index >= str.length() - i)
                        break;
                }
                index = 1;
                first = Double.parseDouble(firstDigit);
                second = Double.parseDouble(secondDigit);
                    str = str.substring(0, i - firstDigit.length()) +
                            operation(first, second, operator) +
                            str.substring(i + secondDigit.length() + 1);
                firstDigit = "";
                secondDigit = "";
            }
        }
        return Double.parseDouble(str);
    }


    private void countSecond(String str){
        String firstDigit = "";
        String secondDigit = "";
        char operator = '0';
        double first, second;
        int index = 1;

        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) == '+' || str.charAt(i) == '-') && i != 0) {
                operator = str.charAt(i);
                while (Character.isDigit(str.charAt(i - index)) || str.charAt(i - index) == '.' ||
                        (str.charAt(i - index) == '-' && i == index)) {
                    firstDigit = str.charAt(i - index) + firstDigit;
                    index++;
                    if (index > i) break;
                }
                index = 1;
                while (Character.isDigit(str.charAt(i + index)) || str.charAt(i + index) == '.') {
                    secondDigit += str.charAt(i + index);
                    index++;
                    if (index >= str.length() - i)
                        break;
                }
                index = 1;
                first = Double.parseDouble(firstDigit);
                second = Double.parseDouble(secondDigit);
                str = str.substring(0, i - firstDigit.length()) +
                        operation(first, second, operator) +
                        str.substring(i + secondDigit.length() + 1);
                System.out.println(str);
                firstDigit = "";
                secondDigit = "";
            }
        }
    }







//    private double countSecond(String str){
//        String firstDigit = "";
//        String secondDigit = "";
//        char operator = '0';
//        double first, second;
//
//
//        for (int i = 0; i < str.length(); i++){
//            if (str.charAt(0) == '-' || Character.isDigit(str.charAt(i)) ||
//                    str.charAt(i) == '.'){
//                if (operator == '0')
//                    firstDigit += str.charAt(i);
//                else
//                    secondDigit += str.charAt(i);
//            }
//
//            if ((!Character.isDigit(str.charAt(i)) && operator != '0') ||
//                    (i + 1 >= str.length() && secondDigit != "")){
//                first = Double.parseDouble(firstDigit);
//                second = Double.parseDouble(secondDigit);
//                str = operation(first, second, operator) +
//                        str.substring(i + 1);
//                System.out.println(str);
//                return countSecond(str);
//            }
//
//            if (str.charAt(i) == '+' || str.charAt(i) == '-')
//                operator = str.charAt(i);
//        }
//        return Double.parseDouble(str);
//    }
}
