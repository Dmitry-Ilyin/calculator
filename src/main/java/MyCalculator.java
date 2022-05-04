import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс калькулятор
 *
 * @author Ilyin Dmitry
 */
public class MyCalculator {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите номер задания (1 - запустить выполнение калькулятора, 2 - поиск максимального слова в массиве) : ");
            boolean condition = switch (reader.readLine()) {
                case "1" -> true;
                case "2" -> false;
                default -> throw new Exception("Ввели неверное число");
            };

            if (condition) {
                double num1, num2;
                String symbol;
                System.out.print("Введите первое число : ");
                num1 = Double.parseDouble(reader.readLine());
                System.out.print("Введите второе число : ");
                num2 = Double.parseDouble(reader.readLine());
                System.out.print("Введите операцию : ");
                symbol = reader.readLine();
                action(num1, num2, symbol);
            } else {
                System.out.print("Введите количество слов : ");
                int sizeArray = Integer.parseInt(reader.readLine());
                String[] array = new String[sizeArray];
                for (int i = 0; i < sizeArray; i++) {
                    System.out.print("Введите слово №" + (i + 1) + " : ");
                    array[i] = reader.readLine();
                }
                String word = Arrays.stream(array)
                        .max(Comparator.comparingInt(String::length))
                        .orElseThrow();
                System.out.println("Самое длинное слово" + word);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Вы ввели не число");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка! На ноль делить нельзя");
        } catch (Exception e) {
            e.printStackTrace();
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
                if (param2 == 0)
                    throw new ArithmeticException();
                result = param1 / param2;
                break;
            default:
                throw new IllegalArgumentException("Ошибка! Вы ввели некорректный знак");
        }
        System.out.printf("Результат : %.4f", result);
    }
}
