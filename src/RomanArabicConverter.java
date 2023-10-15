import java.util.List;

class RomanArabicConverter {
    public static int romanToArabic(String input) {
        String inputRoman = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getList();

        int i = 0;

        while ((inputRoman.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (inputRoman.equals(symbol.name())) {
                result = symbol.getValue();
                if (result > 10){
                    try {
                        throw new IllegalArgumentException();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Калькулятор умеет работать только с римскими цифрами от 1 до 10 включительно.");
                        System.exit(0);
                    }
                }
                break;
            } else {
                i++;
            }
        }
        return result;
    }

    public static String arabicToRoman(int number) {
        if (number <= 0) {

        try {
            throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Результатом работы калькулятора с римскими числами могут быть только положительные числа.");
                System.exit(0);
            }
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getList();

        int i = 0;
        String s = "";

        while (number > 0 && i < romanNumerals.size()) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() < number) {
                i++;
            } else {
                return currentSymbol.toString();
            }
        }
        return s;
    }
}
