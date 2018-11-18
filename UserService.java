package pl.infoshare.ZadDomowe;

import java.io.IOException;
import java.util.List;

public class UserService {

    public User generateUserFromUserInput() {

        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        return new User(
                consoleInputReader.getFieldFromUserInput("name"),
                consoleInputReader.getFieldFromUserInput("last name"),
                consoleInputReader.getFieldFromUserInput("department")
        );
    }

    public void createNewUser() throws IOException {
        MenuService mS = new MenuService();
        User user = generateUserFromUserInput();
        new FileService().saveToFile(user);

        mS.printSuccess();
        mS.shouldAddAnotherUser();
    }

    public User[] generateUserArray(List<String> linesFromFile) {
        User[] userArray = new User[linesFromFile.size()];

        for (int i = 0; i < userArray.length; i++) {
            userArray[i] = generateUserFromFileInput(linesFromFile.get(i));
        }
        return userArray;
    }

    public User generateUserFromFileInput(String lineFromFile) {
        String[] userSplitted = lineFromFile.split(";");
        return new User(userSplitted[0], userSplitted[1], userSplitted[2]);
    }

    public void printUsersFromArray(User[] userArray) {
        for (User user : userArray) {
            System.out.println("Name: " + user.getName() + "\t" +
                    "Last name: " + user.getLastName() + "\t" +
                    "Department: " + user.getDepartment());
        }
    }

    public String createStringFromUserToRemove(){

        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        String userAsString=consoleInputReader.getFieldFromUserInput("name") + ";"+
                consoleInputReader.getFieldFromUserInput("last name")+";"+
                consoleInputReader.getFieldFromUserInput("department");
        return userAsString;
    }
}











