import java.io.IOException;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws IOException {
                    String input;
            Scanner in = new Scanner(System.in);
            System.out.println("введите выражение");
            input = in.nextLine();
            Main.calc(input);

    }
}
class Main {
    public static String calc(String input) throws IOException {
        String itogStr = null;
        int itog = 0;
        int x;
        int y;

        String[] strArrays = input.split(" ");   // переводит строку в массив строк

        if (strArrays.length == 3) { //если длина ровна 3м

            boolean isRome = Number.isRome(strArrays[0]) && Number.isRome(strArrays[2]);

            if (isRome) {
                x = Number.valueOf(strArrays[0]).getTranslations();
                y = Number.valueOf(strArrays[2]).getTranslations();
            } else {
                try {
                    x = Integer.parseInt(strArrays[0]);
                    y = Integer.parseInt(strArrays[2]);
                } catch (NumberFormatException e) {
                    throw new IOException("не верный ввод");
                }
            }

            if (x > 0 && x <= 10 || x < 0 && x >= (-10)) {
                if (y > 0 && y <= 10 || y < 0 && y >= (-10)) {

                    switch (strArrays[1]) {
                        case ("+") -> itog = x + y;
                        case ("*") -> itog = x * y;
                        case ("/") -> itog = x / y;
                        case ("-") -> itog = x - y;
                        default -> {
                            System.out.println("некорректный ввод знака");
                            throw new IOException();
                        }
                    }
                }
            } else throw new IOException("некорректный ввод");

            if (isRome) {
                if (itog >= 0) {
                    itogStr = Number.toRome(itog);
                    System.out.println(itogStr);
                } else throw new IOException("результат в римской СС может быть только положительным");
            } else {
                itogStr = String.valueOf(itog);
                System.out.println(itogStr);
            }
        } else throw new IOException("некорректный ввод выражения ");
        return itogStr;
    }
}