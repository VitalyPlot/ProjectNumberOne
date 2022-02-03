package projekt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EncryptCaesar {
    static String rusAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    static String engAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String simbols = "/.!?:;-—\\ ";
    static String numbers = "123456789";
    static String cryptoAlphabet = rusAlphabet + engAlphabet + simbols + numbers;

    public static void encrypt() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь к файлу");

        String tmp = "";
        String src = scanner.nextLine();
        Path fileStart = Path.of(src);
        System.out.println("Enter your any digital key");
        int keyscaner = scanner.nextInt();
        int key = keyscaner%cryptoAlphabet.length();
        String strStart = Files.readString(fileStart);

        for (int i = 0; i < strStart.length(); i++) { //зашифровка работает
            for (int j = 0; j < cryptoAlphabet.length(); j++) {
                if ((strStart.charAt(i)) == (cryptoAlphabet.charAt(j))) {
                    if ((key + j) >= cryptoAlphabet.length()) {
                        int keyKorrekt = key + j - cryptoAlphabet.length();
                        tmp += cryptoAlphabet.charAt(keyKorrekt);
                    } else {
                        tmp += cryptoAlphabet.charAt(j + (key));
                    }
                }
            }
        }

        String fileFinishName = "encrypt_" +fileStart.getFileName()+".txt"; // create name a second file
        System.out.println("You new encrypted file:  " +fileFinishName);  // выводит имя созданного зашифрованного файла
        String fileSeparator = System.getProperty("file.separator");
        String fileFinish = (fileStart.getParent()+fileSeparator+fileFinishName).toString();
        Files.createFile(Path.of(fileFinish)); // создает зашифрованный файл в тойже директории
        //        Записать в файл из tmp!!!!!!
        Files.writeString(Paths.get(fileFinish), tmp);
        System.out.println("Путь к вашему зашифрованному файлу ");
        System.out.println(fileFinish); // выводит путь к вновь созданному зашифрорванному файлу
        System.out.println("Для завершения работы программы Введите - exit");
    }
}