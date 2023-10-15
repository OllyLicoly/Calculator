import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");
        String input = scanner.nextLine();

        System.out.println("Результат вычисления: " + calc(input));
    }

    public static String calc(String input){
        String s = " ";
        char[] symbol = new char[9];
        char operator = '+';
        for (int i=1; i < input.length(); i++) {
            symbol[i] = input.charAt(i);
            if ( symbol[i] == '+'){
                operator = '+';
                s = "\\+";
            }
            if ( symbol[i] == '-'){
                operator = '-';
                s = "-";
            }
            if ( symbol[i] == '*'){
                operator = '*';
                s = "\\*";
            }
            if ( symbol[i] == '/'){
                operator = '/';
                s = "/";
            }
        }

        int num1 = 0;
        int num2 = 0;
        int resultArab;
        String[] numbers = input.split(s);
        if (numbers.length > 2) {
            System.out.println("Операции возможны только с двумя числами.");
            System.exit(0);
        }

        try{
            num1 = RomanArabicConverter.romanToArabic(numbers[0]);
            num2 = RomanArabicConverter.romanToArabic(numbers[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Нет символа для выполнения операции или отсутствует вторая переменная.");
            System.exit(0);
        }

        if (num1 == 0 | num2 == 0) {
            try {
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[1]);
                if (num1 > 10 | num2 > 10 | num1 < 1 | num2 < 1) {
                    System.out.println("Калькулятор умеет работать только с целыми арабскими цифрами от 1 до 10.");
                    System.exit(0);
                }
                resultArab = calculate(num1, num2, operator);
                return String.valueOf(resultArab);
            } catch (NumberFormatException e) {
                System.out.println("Калькулятор умеет работать только с целыми арабскими или римскими цифрами от 1 до 10 одновременно.");
                System.exit(0);
            }
        } else {
            resultArab = calculate(num1, num2, operator);
            return RomanArabicConverter.arabicToRoman(resultArab);
        }
        return s;
    }

    public static int calculate(int x1, int x2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = x1 + x2;
                break;
            case '-':
                result = x1 - x2;
                break;
            case '*':
                result = x1 * x2;
                break;
            case '/':
                result = x1 / x2;
                break;
            default:
                break;
        }
        return result;
    }
}