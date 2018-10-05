import CategoryC.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Hello, there!");
        while (true) {
            System.out.println("1- Category A\n" +
                    "2 - Category B\n" +
                    "3 - Category C\n" +
                    "0 - exit\n" +
                    "Enter the category number:");
            switch (in.nextInt()){
                case 1 : while (true) {
                    System.out.println("\n\n1- task 1\n" +
                            "2 - task 2\n" +
                            "3 - task 3\n" +
                            "4 - task 4\n" +
                            "5 - task 5\n" +
                            "0 - exit\n" +
                            "Enter the category number:");
                    switch (in.nextInt()){
                        case 1 : CategoryA.task1(); break;
                        case 2 : CategoryA.task2(); break;
                        case 3 : CategoryA.task3(); break;
                        case 4 : CategoryA.task4(); break;
                        case 5 : CategoryA.task5(); break;
                        case 0 : return;
                    }
                }
                case 2 : while (true) {
                    System.out.println("\n\n1- task 1\n" +
                            "2 - task 2\n" +
                            "3 - task 3\n" +
                            "0 - exit\n" +
                            "Enter the category number:");
                    switch (in.nextInt()){
                        case 1 : CategoryB.task1(); break;
                        case 2 : CategoryB.task2(); break;
                        case 3 : CategoryB.task3(); break;
                        case 0 : return;
                    }
                }
                case 3 :
                    System.out.println("\n\n");
                    calc.run(); break;
                case 0 : return;
            }
        }
    }
}
