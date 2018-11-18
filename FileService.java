package pl.infoshare.ZadDomowe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {

    public List<String> readLinesFromFile() throws IOException {
        return Files.readAllLines(Paths.get("./src/main/java/pl/infoshare/ZadDomowe/list.txt"));
    }


    public void saveToFile(User... users) throws IOException {
        for(User user : users){
            String line = user.getName() + ";" +
                    user.getLastName() + ";" +
                    user.getDepartment() + "\n";
            Path path = Paths.get("./src/main/java/pl/infoshare/ZadDomowe/list.txt");
            if (Files.exists(path)){
                Files.write(path,line.getBytes(), StandardOpenOption.APPEND);
            }
            else {
                Files.write(path, line.getBytes());
            }
        }

    }

    public void saveUsersFromArrayToFile(User... userArray) throws IOException {
        Files.delete(Paths.get("./src/main/java/pl/infoshare/ZadDomowe/list.txt"));
        for (User user : userArray) {
            new FileService().saveToFile(user);
        }
    }
}
