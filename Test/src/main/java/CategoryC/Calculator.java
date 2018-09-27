package CategoryC;

import java.util.Scanner;

public class Calculator {
    private Scanner in;
    private String expression;
    private String digit;
    private double firstDigit;
    private double secondDigit;
    private char operator;

    public Calculator(){
        in = new Scanner(System.in);
        digit = "";
        expression = "";
    }

    public void run(){
        while (true) {
            System.out.print(">>");
            expression = in.nextLine();
            if (expression.equals("exit")) return;
            read();
            operate();
        }
    }

    private void count(){
        int position; //позиция на которой стоит открывающая скобка
        for (int i = 0; i < expression.length() - 1; i++) {
            if (expression.charAt(i) == '(') {

            }
        }
    }

    //читаем введенное выражение
    private void read(){
        for (int i = 0; i < expression.length(); i++){
            if (Character.isDigit(expression.charAt(i))){
                digit += expression.charAt(i);
            } else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' ||
                    expression.charAt(i) == '*' || expression.charAt(i) == '/'){
                operator = expression.charAt(i);
                firstDigit = Double.parseDouble(digit);
                digit = "";
            } else {
                System.out.println("Такой ввод не предусмотрен. Попробуйте: >>2+2");
                return;
            }
        }
        secondDigit = Double.parseDouble(digit);
        digit = "";
    }

    private void operate(){
        switch (operator){
            case '+' :
                System.out.println("= " + (firstDigit+secondDigit));
                break;
            case '-' :
                System.out.println("= " + (firstDigit-secondDigit));
                break;
            case '*' :
                System.out.println("= " + (firstDigit*secondDigit));
                break;
            case '/' :
                System.out.println("= " + (firstDigit/secondDigit));
                break;
        }
    }
}
