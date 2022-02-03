package projekt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DecryptCaesar {
    static String rerusAlphabet = "ЯЮЭЬЫЪЩШЧЦХФУТСРПОНМЛКЙИЗЖЁЕДГВБАяюэьыъщшчцхфутсрпонмлкйизжёедгвба";
    static String reengAlphabet = "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";
    static String resimbols = " \\—-;:?!./";
    static String renumbers = "987654321";
    static String recryptoAlphabet = renumbers + resimbols + reengAlphabet + rerusAlphabet;

    public static void decrypt() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь к файлу");

        String src = scanner.nextLine();
        Path fileStart = Path.of(src);
        System.out.println("Enter your digital key");
        int keyscaner = scanner.nextInt();
        int key = keyscaner%recryptoAlphabet.length();
        String strStart = Files.readString(fileStart);
        String tmp = "";

        for (int i = 0; i < strStart.length(); i++) { // расшифровка работает
            for (int j = 0; j < recryptoAlphabet.length(); j++) {
                if ((strStart.charAt(i)) == (recryptoAlphabet.charAt(j))) {
                    if((key+j)>=recryptoAlphabet.length()){
                        int keyKorrekt = key + j - recryptoAlphabet.length();
                        tmp += recryptoAlphabet.charAt(keyKorrekt);
                    } else {
                        tmp += recryptoAlphabet.charAt(j + (key));
                            }
                }
            }
        }
        System.out.println();

        String fileFinishName = "decrypt_file"+".txt"; // create name a second file
        System.out.println("Имя вашего расшифрованного файла");
        System.out.println(fileFinishName);  // выводит имя созданного расшифрованного файла
        String fileSeparator = System.getProperty("file.separator");
        String fileFinish = (fileStart.getParent()+fileSeparator+fileFinishName).toString();
        Files.createFile(Path.of(fileFinish)); // создает зашифрованный файл в тойже директории
        Files.writeString(Paths.get(fileFinish), tmp);//Записать в файл из tmp
        System.out.println("Путь к вашему расшифрованному файлу ");
        System.out.println(fileFinish); // выводит путь к вновь созданному зашифрорванному файлу
        System.out.println("Для завершения работы программы Введите - exit");
    }

}

