package projekt;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class EncryptDecryptFiles {

    public static void main(String[] args) throws IOException {
        InputStream stream = System.in;
        Scanner console = new Scanner(stream);
        startDialog(null, console);
    }

    static void startDialog(String choice, Scanner console) throws IOException {
        if (choice == null) {
            System.out.println("what do you want to do");
            System.out.println("Encrypt file - enter 1");
            System.out.println("Decrypt file - enter 2");
            System.out.println("Decrypt file - enter 3  if you forgot your password ");

        }else if (choice.toLowerCase().equals("exit")){
            return;
        }else if (choice.equals("1") || choice.toLowerCase().equals("one")) {
            EncryptCaesar.encrypt();

        }else if (choice.equals("2") || choice.toLowerCase().equals("two")) {
            DecryptCaesar.decrypt();

        }else if (choice.equals("3") || choice.toLowerCase().equals("three")) {
                DecryptToOthers.decryptTO();

        }else System.out.println("enter the number or enter the exit");

        choice = console.nextLine();

        try {
            startDialog(choice, console);
        } catch (Exception e) {
            System.out.println(choice);
            throw e;
        }

    }
}