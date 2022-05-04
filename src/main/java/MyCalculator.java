import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс калькулятор
 * @author Ilyin Dmitry
 */
public class MyCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double num1, num2;
        String symbol;
        try {
            System.out.print("Введите первое число : ");
            num1 = Double.parseDouble(reader.readLine());
            System.out.print("Введите второе число : ");
            num2 = Double.parseDouble(reader.readLine());
            System.out.print("Введите операцию : ");
            symbol = reader.readLine();
            action(num1, num2, symbol);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Вы ввели не число");
        } catch (ArithmeticException e ) {
            System.out.println("Вы ввели неверный знак");
        }

    }

    /**
     * @param param1 первое число
     * @param param2 второе число
     * @param symbol знак операции
     * @throws ArithmeticException
     */
    public static void action(double param1, double param2, String symbol) throws ArithmeticException {
        double result;
        switch (symbol) {
            case "+":
                result = param1 + param2;
                break;
            case "-":
                result = param1 - param2;
                break;
            case "*":
                result = param1 * param2;
                break;
            case "/":
                result = param1 / param2;
                break;
            default:
                throw new IllegalArgumentException("Ошибка. Вы ввели некорректный знак");
        }
        System.out.printf("Результат : %.4f", result);
    }
}
