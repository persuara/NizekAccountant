package AccountingCalculations;

import ConverterHelper.Converter;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import ModelManager.Manager;
import UserRepository.UserRepository;

import java.io.File;
import java.util.List;

public class Accounting {
    static UserRepository userRepository = new UserRepository();
    public static double calculateMoney(File file) {
        double result = 0;
        String[] cost = userRepository.readColumnWholeFile(1, file);
        for (int i = 0; i < cost.length; i++) {
            result += Converter.convertToDouble(cost[i]);
        }
        return result;
    }


    public static double reportAllTransactionNORMAL(List<NormalDoc> normalDocList) {
        double creditorSum = calculateMoney(new File(normalDocList.get(0).getIsCreditorFilePath()));
        double notCreditorSum = calculateMoney(new File(normalDocList.get(0).getNotCreditorFilePath()));
        return creditorSum + notCreditorSum;
    }
    public static double reportAllTransactionCHECK(List<CheckDoc> checkDocList) {
        double cashedSum = calculateMoney(new File(checkDocList.get(0).getCashedFilePath()));
        double notCashedSum = calculateMoney(new File(checkDocList.get(0).getNotCashedFilePath()));
        return cashedSum + notCashedSum;
    }
    public static String determineStatusNormal(List<NormalDoc> normalDocList) {
        String result = " ";
        double creditorSum = calculateMoney(new File(normalDocList.get(0).getIsCreditorFilePath()));
        double notCreditorSum = calculateMoney(new File(normalDocList.get(0).getNotCreditorFilePath()));
        if (creditorSum - notCreditorSum > 0) {
            result = "بستانکر";
        } else if (creditorSum - notCreditorSum < 0) {
            result = "بدهکار";
        } else {
            result = "سر به سر";
        }
        return  result;
    }
}
