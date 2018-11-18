package pl.infoshare.ZadDomowe;

import java.util.Scanner;

public class ConsoleInputReader {

    public String getFieldFromUserInput(String field){
        System.out.println("Podaj " + field + ": ");
        return readUserInput();
        }

    public String readUserInput() {
        Scanner sc=new Scanner(System.in);
        return sc.nextLine();
    }
}
