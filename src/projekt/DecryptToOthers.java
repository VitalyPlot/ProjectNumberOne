package projekt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class DecryptToOthers {
    static String rerusAlphabet = "ЯЮЭЬЫЪЩШЧЦХФУТСРПОНМЛКЙИЗЖЁЕДГВБАяюэьыъщшчцхфутсрпонмлкйизжёедгвба";
    static String reengAlphabet = "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";
    static String resimbols = " \\—-;:?!./";
    static String renumbers = "987654321";
    static String recryptoAlphabet = renumbers + resimbols + reengAlphabet + rerusAlphabet;


    public static void decryptTO() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь к файлу");

        System.out.println(recryptoAlphabet); //вывел криптоалфав
        System.out.println(recryptoAlphabet.length()); // вывод длины алфавита

        String src = scanner.nextLine();
        Path fileStart = Path.of(src);
        //System.out.println("Enter your digital key");
//        int keyscaner = scanner.nextInt();
//        int key = keyscaner%recryptoAlphabet.length();
//        System.out.println(key); // выводит реальный ключ
        System.out.println(fileStart.getParent()); // берет директорию файла
        System.out.println(fileStart.getFileName()); // берет имя файла
        String strStart = Files.readString(fileStart);
        String tmp = "";

//        for (int i = 0; i < recryptoAlphabet.length(); i++) { // расшифровка работает
//            System.out.print(recryptoAlphabet.charAt(i));  // вводные данные проверка

        int key = 1;
        for (int j = 0; j < strStart.length(); j++) {
                if ((strStart.charAt(j)) == (strStart.charAt(j+key))) {
                    System.out.println(key);
                    break;
                                    }
            key= (++key)%137;
        }
        }
//        String fileFinishName = "decrypt_file"+".txt"; // create name a second file
//        System.out.println(fileFinishName);  // выводит имя созданного зашифрованного файла
//        String fileSeparator = System.getProperty("file.separator");
//        String fileFinish = (fileStart.getParent()+fileSeparator+fileFinishName).toString();
//        Files.createFile(Path.of(fileFinish)); // создает зашифрованный файл в тойже директории
//        Files.writeString(Paths.get(fileFinish), tmp);//Записать в файл из tmp!!!!!!
//        System.out.println("Путь к вашему зашифрованному файлу ");
//        System.out.println(fileFinish); // выводит путь к вновь созданному зашифрорванному файлу
//        System.out.println("Для завершения программы Введите - exit");

    //}
}
