package ModelManager;

import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.User;
import UserRepository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static List<NormalDoc> normalDocList = new ArrayList<>();
    public static List<CheckDoc> checkDocList = new ArrayList<>();
    public static List<User> userList = new ArrayList<>();
    public static UserRepository userRepository = new UserRepository();

    public static void addListNORMAL(NormalDoc normalDoc) {
        normalDocList.add(new NormalDoc(normalDoc.getPayee(),
                normalDoc.getCost(),
                normalDoc.getDescription(),
                normalDoc.isCreditor(),
                normalDoc.getDate(),
                normalDoc.getTime(),
                normalDoc.getUser()
        ));
        userRepository.writeToFile(normalDoc);
    }

    public static void addListCHECK(CheckDoc checkDoc) {
        checkDocList.add(new CheckDoc(
                checkDoc.getPayee(),
                checkDoc.getCost(),
                checkDoc.getDescription(),
                checkDoc.getDate(),
                checkDoc.getTime(),
                checkDoc.isCashed(),
                checkDoc.getUser()
        ));
        userRepository.writeToFile(checkDoc);
    }

    public static void addListUSER(User user) {
        userList.add(new User(
                user.getName(),
                user.getNationalID(),
                user.getGroupType(),
                user.getAddress(),
                user.getPhone(),
                user.getEmail(),
                user.getPassword()
        ));
        userRepository.writerToFile(user);
    }

    public static void removeFromList(NormalDoc normalDoc) {
        normalDocList.remove(normalDoc);
    }

    public static void removeFromList(CheckDoc checkDoc) {
        checkDocList.remove(checkDoc);
    }

    public static void removeFromList(User user) {
        userList.remove(user);
    }

}
