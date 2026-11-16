import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Калькулятор запущен ===");
        System.out.println("Введите 'C' для сброса, 'S' для выхода.");

        double currentResult = readNumber(scanner, "Введите первое число: ");

        while (true) {
            System.out.println("\nТекущий результат: " + currentResult);
            
            System.out.print("Введите операцию (+, -, *, /, C, S): ");
            String operation = scanner.nextLine().trim();

            if (operation.equalsIgnoreCase("S")) {
                System.out.println("Выключение калькулятора. До свидания!");
                break;
            }

            if (operation.equalsIgnoreCase("C")) {
                currentResult = readNumber(scanner, "Введите новое первое число: ");
                continue;
            }

            if (!operation.equals("+") && !operation.equals("-") && 
                !operation.equals("*") && !operation.equals("/")) {
                System.out.println("Ошибка: неподдерживаемая операция!");
                continue;
            }

            double operand = readNumber(scanner, "Введите второе число: ");

            double result = currentResult;
            switch (operation) {
                case "+":
                    result = currentResult + operand;
                    break;
                case "-":
                    result = currentResult - operand;
                    break;
                case "*":
                    result = currentResult * operand;
                    break;
                case "/":
                    if (operand == 0) {
                        System.out.println("Ошибка: деление на ноль! Результат не изменен.");
                        continue; 
                    }
                    result = currentResult / operand;
                    break;
            }

            currentResult = result;
            System.out.println("Результат: " + currentResult);
        }

        scanner.close();
    }

    static double readNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: пожалуйста, введите корректное число.");
            }
        }
    }
}