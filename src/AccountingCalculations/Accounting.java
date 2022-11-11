package AccountingCalculations;

import ConverterHelper.Converter;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.User;
import UserRepository.UserRepository;

public class Accounting {
    static double sumCheck;
    static double sumNormal;
    static UserRepository userRepository = new UserRepository();

    public static double calculateDebt(User user, CheckDoc checkDoc, NormalDoc normalDoc) {
        double costNormal = Converter.convertToDouble(userRepository.readCostFromFile(
                normalDoc,
                user.getid(),
                normalDoc.getFilePath()
        ));
//        double costCheck = Converter.convertToDouble(userRepository.readCostFromFile(checkDoc,
//                user.getid(),
//                checkDoc.getFilePath()
//        ));
//        if (checkDoc.isCashed()) {
//            return costCheck + costNormal;
//        }
        return costNormal;
    }
}
