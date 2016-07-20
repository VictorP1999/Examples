package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by BOSS on 17.07.2016.
 */
public class Examples {
    public static void Examples(String fileName) {
        try {
            Scanner scanner = new Scanner(Paths.get(fileName));
            PrintWriter writer = new PrintWriter("result.txt");
            while (scanner.hasNext()) { //пока не конец файлы, считываем строки построчно
                String temp = scanner.nextLine();
                String[] mass = temp.split(" ");
                try {
                    double a = Double.valueOf(mass[0]);
                    double b = Double.valueOf(mass[2]);
                    char op = mass[1].charAt(0);
                    double r = 0;
                    switch (op) {
                        case '+':
                            r = a+b;
                            break;
                        case '-':
                            r = a-b;
                            break;
                        case '*':
                            r = a*b;
                            break;
                        case '/':
                            r = a/b;
                            break;
                    }
                    writer.println(r);
                }
                catch (NumberFormatException e) {
                    System.out.println("Неверно введены данные");
                }
            }
            scanner.close();
            writer.close();
        }
        catch(IOException e){
            System.out.println("Файл не найден");
            //e.printStackTrace();
        }

    }
}
