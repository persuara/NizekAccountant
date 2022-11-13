package AccountingCalculations;

import ConverterHelper.Converter;
import ModelManager.Manager;
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

    public static double calculateMoney(File file) {
        double result = 0;
        String[] cost = userRepository.readColumnWholeFile(1, file);
        for (int i = 0; i < cost.length; i++) {
            result += Converter.convertToDouble(cost[i]);
        }
        return result;
    }
    public static double reportAllTransactionNORMAL(File file) {
        double creditorSum = calculateMoney(new File(Manager.normalDocList.get(0).getIsCreditorFilePath()));
        double notCreditorSum = calculateMoney(new File(Manager.normalDocList.get(0).getNotCreditorFilePath()));
        return creditorSum + notCreditorSum;
    }
    public static double reportAllTransactionCHECK(File file) {
        double cashedSum = calculateMoney(new File(Manager.checkDocList.get(0).getCashedFilePath()));
        double notCashedSum = calculateMoney(new File(Manager.checkDocList.get(0).getNotCashedFilePath()));
        return cashedSum + notCashedSum;
    }
}
