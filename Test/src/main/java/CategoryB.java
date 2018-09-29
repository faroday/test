import java.util.Arrays;
import java.util.Random;

public class CategoryB {

    public static Random random = new Random();

    //строка из скобок для 1 задания. будем изменять непосредственно ее
    public static String expression = "([][{}]) [({})] ({[]}) {[()]}";

    //скобочное выражение
    public static void task1(){
        expression = expression.replaceAll(" ", "");
        System.out.println(expression);
        task1loop();
        if (expression.length() == 0)
            System.out.println("SUCCESS");
        else
            System.out.println("FAIL");
    }

    //удалим все парные скобки
    public static void task1loop(){
        //если длина массива 0 выходим из рекурсии
        if (expression.length() != 0) {
            String st = expression;
            for (int i = 0; i < expression.length() - 1; i++) {
                //проверяем стоят ли открывающая и закрывающая скобки рядом ()
                if (expression.charAt(i) == '(' && expression.charAt(i + 1) == ')' ||
                        expression.charAt(i) == '[' && expression.charAt(i + 1) == ']' ||
                        expression.charAt(i) == '{' && expression.charAt(i + 1) == '}') {
                    expression = expression.substring(0, i) + expression.substring(i + 2);
                }
            }
            //если за цикл for ничего не изменилось, значит есть не парные скобки или ошибка расстановки
            if (!st.equals(expression))
                task1loop();
        }
    }

    //вывод массива по спирали
    public static void task2(){
        int n = 5;
        int p = n / 2;
        int j, l = 0;
        int [] numbers = new int[n * n];
        int[][] arr = new int[n][n];
        for (int i = 0; i<n * n; i++){
            numbers[i]= random.nextInt(9) + 1;
        }

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        for(int k=1;k<=p;k++){
            for (j=k-1;j<n-k+1;j++) arr[k-1][j] = numbers[l++];
            for (j=k;j<n-k+1;j++) arr[j][n-k] = numbers[l++];
            for (j=n-k-1;j>=k-1;--j) arr[n-k][j] = numbers[l++];
            for (j=n-k-1;j>=k;j--) arr[j][k-1] = numbers[l++];
        }
        if (n % 2 ==1)
            arr[p][p] = numbers[l];
        for (int i = 0; i<n; i++){
            for (int m = 0; m<n; m++) {
                System.out.print(arr[i][m] + " ");
            }
            System.out.print("\n");
        }
    }


    public static void task3(){
        int n = 4;
        int[][] arr = new int[n][n];
        int[][] origin = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                arr[i][j] = random.nextInt(100);
                origin[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i<n; i++){
            for (int m = 0; m<n; m++) {
                System.out.print(origin[i][m] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        for (int i =1; i < n; i++) {
            arr[0][i] = arr[0][i - 1] + arr[0][i];
            arr[i][0] = arr[i - 1][0] + arr[i][0];
        }

        for (int i =1; i < n; i++) {
            for (int j =1; j < n; j++) {
                arr[i][j] += (arr[i - 1][j] > arr[i][j - 1]) ? arr[i][j - 1] : arr[i - 1][j];
            }
        }

        int x = n - 1, y = n - 1;
        while (x > 0 || y > 0){
            if (x <= 0) y--;
            else if (y <= 0) x--;
            else if (arr[x - 1][y] > arr[x][y - 1]) y--;
                else x--;
            origin[x][y] = -1;
        }

        for (int i = 0; i<n; i++){
            for (int m = 0; m<n; m++) {
                if (i == 0 && m == 0)
                    System.out.print("  A");
                else if (i == n - 1 && m == n - 1)
                    System.out.print("  B");
                else if (origin[i][m] == -1)
                    System.out.print("  *");
                else if (origin[i][m] / 10 > 0)
                    System.out.print(" " + origin[i][m]);
                else System.out.print("  " + origin[i][m]);
            }
            System.out.print("\n");
        }
    }
}
