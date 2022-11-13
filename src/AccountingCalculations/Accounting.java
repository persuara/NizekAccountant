package AccountingCalculations;

import ConverterHelper.Converter;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import UserRepository.UserRepository;

import java.io.File;

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

    public static double calculateDebtWithOutChecks(File file) {
        double result = 0;
        String[] cost = userRepository.readColumnWholeFile(1, file);
        for (int i = 0; i < cost.length; i++) {
            result += Converter.convertToDouble(cost[i]);
        }
        return result;
    }

    public static double calculateDebtWithOutNormalDoc(CheckDoc checkDoc) {
        return Converter.convertToDouble(
                userRepository.readCostFromFile(
                        checkDoc,
                        checkDoc.getUserID()
                ));
    }
}
