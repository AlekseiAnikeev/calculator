import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numb1;
        int numb2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение типа 1 + 1 или IX * IX: ");
        String input = sc.nextLine();
        char[] operFind = new char[10];
        char operator = 0;
        Calk calc = new Calk();
        RomToArabConvert con = new RomToArabConvert();
        for (int i = 0; i < input.length(); i++) {
            operFind[i] = input.charAt(i);
            if (operFind[i] == '+') {
                operator = '+';
            }
            if (operFind[i] == '-') {
                operator = '-';
            }
            if (operFind[i] == '*') {
                operator = '*';
            }
            if (operFind[i] == '/') {
                operator = '/';
            }
        }
        String[] number = input.split("\\s[+-/*]\\s");
        String rom1 = number[0];
        String rom2 = number[1];
        numb1 = con.romToArab(rom1);
        numb2 = con.romToArab(rom2);
        int resultRom = 0;

        if (numb1 > 0 && numb2 > 0) {
            if (numb1 <= 10 && numb2 <= 10) {

                switch (operator) {
                    case '+' -> resultRom = numb1 + numb2;
                    case '-' -> resultRom = (numb1 - numb2);
                    case '/' -> resultRom = (numb1 / numb2);
                    case '*' -> resultRom = (numb1 * numb2);
                    default -> System.out.println("Неверный математический символ");
                }
                if (resultRom > 0) {
                    System.out.println(ArabToRome.values()[resultRom]);
                } else
                    System.out.println("в римской системе нет отрицательных чисел...");
            } else
                System.out.println("Вы ввели число меньше 1, либо больше 10!");

        } else {

            int number1 = Integer.parseInt(number[0]);
            int number2 = Integer.parseInt(number[1]);

            calc.setOp(number1, number2, operator);
            calc.calcul();
        }


    }
}

class Calk {
    int num1;
    int num2;
    char op;

    public void setOp(int number1, int number2, char operator) {
        num1 = number1;
        num2 = number2;
        op = operator;
    }

    void calcul() {
        if (num1 > 0 && num1 <= 10 && num2 > 0 && num2 <= 10) {
            switch (op) {
                case '+' -> System.out.println(num1 + num2);
                case '-' -> System.out.println(num1 - num2);
                case '/' -> System.out.println(num1 / num2);
                case '*' -> System.out.println(num1 * num2);
                default -> System.out.println("Неверный математический символ");
            }

        } else
            System.out.println("Вы ввели число меньше 1, либо больше 10!");

    }

}

class RomToArabConvert {
    int romToArab(String romans) {
        try {
            if (romans.equalsIgnoreCase("I")) {
                return 1;
            }
            if (romans.equalsIgnoreCase("II")) {
                return 2;
            }
            if (romans.equalsIgnoreCase("III")) {
                return 3;
            }
            if (romans.equalsIgnoreCase("IV")) {
                return 4;
            }
            if (romans.equalsIgnoreCase("V")) {
                return 5;
            }
            if (romans.equalsIgnoreCase("VI")) {
                return 6;
            }
            if (romans.equalsIgnoreCase("VII")) {
                return 7;
            }
            if (romans.equalsIgnoreCase("VIII")) {
                return 8;
            }
            if (romans.equalsIgnoreCase("IX")) {
                return 9;
            }
            if (romans.equalsIgnoreCase("X")) {
                return 10;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
