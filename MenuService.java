package pl.infoshare.ZadDomowe;

import java.io.IOException;

public class MenuService {

    private ConsoleInputReader cIR;
    private InputHandler iH;
    private UserService uS;

public MenuService() {

    cIR = new ConsoleInputReader();
    iH=new InputHandler();
    uS=new UserService();

    }

    public void printMenu() {

        System.out.println();
        System.out.println("----------- MENU -----------");
        System.out.println("1.\t Dodaj pracownika.");
        System.out.println("2.\t Wyswietl liste pracownikow.");
        System.out.println("3.\t Usun pracownika.");
        System.out.println();
        System.out.println("0.\t Wyjdz z programu.");
        System.out.println("Wybor: ");
    }

    public void start() throws IOException {

        printMenu();
        String userChoice = cIR.readUserInput();
        iH.handleUserChoice(userChoice);
}

    public void printSuccess() {
        System.out.println("WYKONANO POPRAWNIE!");
    }

    public void printError() {
        System.out.println("BLAD! Zly wybor. Zrestartuj program");
    }

    public void shouldAddAnotherUser() throws IOException {

        System.out.println("Wanna add another User? [Y/N]");
        String input = cIR.readUserInput();
        if (input.equals("Y")) {
            uS.createNewUser();
        } else if (input.equals("N")) {
            start();
        } else {
            System.out.println("WRONG INPUT!!!");
            shouldAddAnotherUser();
        }
    }
}
