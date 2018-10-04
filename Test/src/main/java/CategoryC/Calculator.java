package CategoryC;

import CategoryC.files.ReadInput;
import CategoryC.files.Writer;
import CategoryC.impl.File;
import CategoryC.impl.Read;
import CategoryC.impl.Validation;
import CategoryC.validation.InputValidation;

import java.util.Scanner;

public class Calculator {
    private Scanner in;
    private CountFactory factory;//объединяет все расчеты в один метод

    private StringBuilder lines;//вводимые пользователем выражения будем хранить здесь
    private File writer;//загрузка, сохранение
    private Read input;//чтение команд пользователя

    private Validation test;//проверка ввода

     private  String userName;

    public Calculator(){
        in = new Scanner(System.in);
        factory = new CountFactory();

        lines = new StringBuilder();
        writer = new Writer();
        input = new ReadInput();

        test = new InputValidation();

        userName = writer.load("userName");
    }

    public void run(){
        greeting();
        while (true) {
            System.out.print(">>");

            String expression = in.nextLine();//читаем ввод пользователя

            if (expression.equals("exit")) return;//если ввод exit выходим из программы

            //проверяем не хочет ли пользователь загрузить или сохранить данные или что то третье..
            if (!input.read(expression, lines)) {//если на входе save или load возвращает true и блок if не выполняется

                if (test.validation(expression)) {//проверим правильность ввода

                    expression = expression.replaceAll(" ", "");//уберем все пробелы
                    lines.append(expression);//добавим в строку выражение

                    expression = factory.doAll(expression, factory);//выполним все подсчеты

                    lines.append(" = ").append(expression).append("\n");//добавим ответ в строку

                    System.out.println(expression);
                } else System.out.println("Oops.. Incorrect input!");//сообщаем, что что то не так!
            }
        }
    }

    private void greeting(){
        if (userName.isEmpty()){
            System.out.println("Greeting!!!");
            stopIt();
            System.out.println("Welcome to amazing Calculator!!!");
            stopIt();
            System.out.println("What is your name?");
            userName = in.nextLine();
            writer.save("userName", userName, true);
            System.out.println("And my name is Calculator v9 and 3/4!");
            stopIt();
            System.out.println("Nice to meet you, " + userName + "!");
            stopIt();
            System.out.println("You may type \"help\" for help!");
        } else {
            System.out.println("Welcome back, " + userName + "!");
            stopIt();
            System.out.println("Just remember, " + userName + ", you may type \"help\" for help!");
        }
    }

    private void stopIt(){
        try {
            Thread.sleep(700);
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
