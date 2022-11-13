package AccountingCalculations;

import ConverterHelper.Converter;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.User;
import ModelManager.Manager;
import UserRepository.UserRepository;

public class Accounting {
    static UserRepository userRepository = new UserRepository();

//    public static double calculateDebt(CheckDoc checkDoc, NormalDoc normalDoc) {
//        double resultNormal = 0;
//        double resultCheck = 0;
//
//        for (NormalDoc normalDoc1 : Manager.normalDocList) {
//            resultNormal += Accounting.calculateDebtWithOutChecks(normalDoc1);
//        }
//        for (CheckDoc checkdoc1: Manager.checkDocList) {
//            resultCheck += Accounting.calculateDebtWithOutNormalDoc(checkdoc1);
//        }
//        if (checkDoc.isCashed()) {
//            return resultCheck + resultNormal;
//        }
//        return resultNormal;
//    }

    public static double calculateDebtWithOutChecks(NormalDoc normalDoc) {
        return Converter.convertToDouble(
                userRepository.readCostFromFile(
                        normalDoc,
                        String.valueOf(normalDoc.getUserID())
                ));
    }

    public static double calculateDebtWithOutNormalDoc(CheckDoc checkDoc) {
        return Converter.convertToDouble(
                userRepository.readCostFromFile(
                        checkDoc,
                        String.valueOf(checkDoc.getUserID())
                ));
    }
}
