import java.util.*;

public class CategoryA {

    public static Scanner in = new Scanner(System.in);


    //принадлежность точки треугольнику ( векторный метод)
    public static void task1(){
        int[] triangle = new int[8];
        System.out.println("Принадлежность точки треугольнику\n" +
                "     B\n" +
                "    /|\n" +
                "  /  |\n" +
                "A ---| C\n" +
                "Введите координаты вершин треугольника\n А x:");
        triangle[0] = in.nextInt();
        System.out.println("y:");
        triangle[1] = in.nextInt();
        System.out.println("B x:");
        triangle[2] = in.nextInt();
        System.out.println("y:");
        triangle[3] = in.nextInt();
        System.out.println("C x:");
        triangle[4] = in.nextInt();
        System.out.println("y:");
        triangle[5] = in.nextInt();
        System.out.println("Введите координаты точки\nP x:");
        triangle[6] = in.nextInt();
        System.out.println("y:");
        triangle[7] = in.nextInt();

        int Bx, By, Cx, Cy, Px, Py;  //координаты треугольника и точки, когда т А лежит в начале координат

        //переносим т А треугольника в начало координат
        Bx = triangle[2] - triangle[0];
        By = triangle[3] - triangle[1];
        Cx = triangle[4] - triangle[0];
        Cy = triangle[5] - triangle[1];
        Px = triangle[6] - triangle[0];
        Py = triangle[7] - triangle[1];

        int m = (Px * By - Bx * Py) / (Cx * By - Bx * Cy);
        if(m >= 0 && m <= 1) {
            int l = (Px - m * Cx) / Bx;
            if (l >= 0 && (m + l) <= 1)
                System.out.println("IN");
        }
        System.out.println("OUT");
    }

    //разница диагоналей матрицы
    public static void task2(){
        int[][] matrix = new int[3][3];
        System.out.println("Разница диагоналей матрицы\n" +
                "Введите матрицу 3х3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }

        //[1][1] для обоих диагоналей совпадает
        System.out.println(Math.abs((matrix[0][0] + matrix[2][2])) -
                Math.abs((matrix[2][0] + matrix[0][2])));
    }

    //нарисуем лестницу из символов #
    public static void task3(){
        System.out.println("Лестница из #\n Введите высоту:");
        int n = in.nextInt();
        for (int i = 0; i < n; i++){
            //количество пробелов в начале строки
            for (int j = n - 1; j > i; j--) {
                System.out.print(" ");
            }
            //количество символов
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println("\n");
        }
    }

    //поиск пар
    public static void task4(){
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int k = 4;
        System.out.println("Поиск пар\n" +
                "массив " + Arrays.toString(numbers) +
                "\nключ " + k);
        int result = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                if ((numbers[i] + numbers[j]) % k == 0)
                    result++;
            }
        }
        System.out.println("Результат "+result);
    }


    public static void task5(){
        Random random = new Random();
        int n = 4; //строки
        int m = 5; // столбцы
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
            arr[i][j]=random.nextInt(9) + 1;
            }
        }

        System.out.println("Поиск окна");
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        //если матрица 2х2 вложенной матрицы удовлетворяющей условиям нет
        if (n < 3 || m < 3)
            System.out.println("FAIL");
        else {
            System.out.println("(1,1)");
        }
    }
}
