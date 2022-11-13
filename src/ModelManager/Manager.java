package ModelManager;

import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.Costumer;
import UserRepository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static List<NormalDoc> normalDocList = new ArrayList<>();
    public static List<CheckDoc> checkDocList = new ArrayList<>();
    public static List<Costumer> costumerList = new ArrayList<>();
    public static UserRepository userRepository = new UserRepository();

    public static void addNormalDocument(NormalDoc normalDoc) {
        normalDocList.add(normalDoc);
        userRepository.writeToFile(normalDoc);
        userRepository.writeIFCreditorToFile(normalDoc);
    }

    public static void addCheckDocument(CheckDoc checkDoc) {
        checkDocList.add(checkDoc);
        userRepository.writeToFile(checkDoc);
        userRepository.writeIFCashedToFile(checkDoc);
    }

    public static void addCostumer(Costumer costumer) {
        costumerList.add(costumer);
        userRepository.writerToFile(costumer);
    }

    public static void removeFromList(NormalDoc normalDoc) {
        normalDocList.remove(normalDoc);
    }

    public static void removeFromList(CheckDoc checkDoc) {
        checkDocList.remove(checkDoc);
    }

    public static void removeFromList(Costumer costumer) {
        costumerList.remove(costumer);
    }


}
