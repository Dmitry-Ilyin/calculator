import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double num1, num2;
        try {
            System.out.print("Введите первое число : ");
            num1 = Double.parseDouble(reader.readLine());
            System.out.print("Введите второе число : ");
            num2 = Double.parseDouble(reader.readLine());
            addition(num1, num2);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Вы ввели не число");
        }
    }

    public static void addition(double param1, double param2) {
        System.out.printf("Сумма равна : %.4f", param1 + param2);
    }
}
