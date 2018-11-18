package pl.infoshare.ZadDomowe;

import java.nio.file.Files;
import java.util.List;
import java.io.IOException;

public class InputHandler {

    public void handleUserChoice (String choice) throws IOException {

        UserService US = new UserService();
        MenuService MS = new MenuService();
        List<String> fileLines;

        switch (choice) {
            case "1": {
                US.createNewUser();
                break;
            }
            case "2": {
                fileLines = new FileService().readLinesFromFile();
                User[] userArray = US.generateUserArray(fileLines);
                US.printUsersFromArray(userArray);

                MS.start();
                break;
            }
            case "3": {
                fileLines = new FileService().readLinesFromFile();
                fileLines.remove(US.createStringFromUserToRemove());

                User[] userArray = US.generateUserArray(fileLines);
                new FileService().saveUsersFromArrayToFile(userArray);

                MS.printSuccess();
                MS.start();
                break;
            }
            case "0": {
                break;
            }
            default: {
                MS.printError();
                break;
            }
        }
    }
}
