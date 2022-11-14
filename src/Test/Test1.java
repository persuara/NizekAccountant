package Test;


import AccountingCalculations.Accounting;
import ConverterHelper.ConvertTime;
import ConverterHelper.Converter;
import Date.DateNizek;
import Date.TimeNizek;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.Costumer;
import Login.GroupType;
import ModelManager.Manager;
import UserRepository.UserRepository;

import java.io.File;
import java.util.Arrays;

public class Test1 {
    static NormalDoc normalDoc;
    static CheckDoc checkDoc;
    static Costumer costumer;
    public static void deleteFile(File file) {
        file.delete();
    }
    public static void main(String[] args)  {


        UserRepository userRepository = new UserRepository();

        Manager.addCostumer(new Costumer(
                "Amir",
                "123",
                new GroupType("Costumer"),
                "Tehran",
                "9031134516",
                "email@gmail.com"
                ));
        Manager.addCostumer(new Costumer(
                "Baran",
                "123223",
                new GroupType("Costumer"),
                "Tehran",
                "9031134513126",
                "email@gmail.com"
                ));
//
        Manager.addNormalDocument(new NormalDoc(
                "1000",
                "pay sth",
                true,
                new DateNizek(31,6,1320),
                new TimeNizek(),
                Manager.costumerList.get(1)
        ));
        Manager.addNormalDocument(new NormalDoc(
                "19000",
                "pay debt",
                true,
                new DateNizek(19,12,1390),
                new TimeNizek(),
                Manager.costumerList.get(1)
        ));
        Manager.addNormalDocument(new NormalDoc(
                "8000",
                "pay list",
                false,
                new DateNizek(5,9,1402),
                new TimeNizek(),
                Manager.costumerList.get(1)
        ));
        Manager.addNormalDocument(new NormalDoc(
                "5000",
                "pay sth",
                false,
                new DateNizek(1,3,1430),
                new TimeNizek(),
                Manager.costumerList.get(0)
                ));



        Manager.addCheckDocument(new CheckDoc(
                "500",
                "pay sth also",
                new DateNizek(12,11,1398),
                new TimeNizek(),
                true,
                Manager.costumerList.get(1)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "11000",
                "Diamond for Elly",
                new DateNizek(22,2,1301),
                new TimeNizek(),
                true,
                Manager.costumerList.get(0)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "12000",
                "Rolex",
                new DateNizek(1,2,1408),
                new TimeNizek(),
                false,
                Manager.costumerList.get(0)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "41000",
                "Hospital Bill",
                new DateNizek(1,2,1419),
                new TimeNizek(),
                false,
                Manager.costumerList.get(0)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "19000",
                "RangeRover",
                new DateNizek(1,2,1410),
                new TimeNizek(),
                false,
                Manager.costumerList.get(0)
        ));


//        System.out.println(userRepository.readWholeFile(new File(Manager.normalDocList.get(0).getIsCreditorFilePath())));
        String[] arrayDate = userRepository.readColumnWholeFile(4, new File(Manager.normalDocList.get(0).getIsCreditorFilePath()));
        for (int i = 0; i < arrayDate.length; i++) {
            System.out.println(ConvertTime.findDifferencesInDays(arrayDate[i]));
        }
        double notCashed = Accounting.calculateMoney(new File(Manager.checkDocList.get(0).getNotCashedFilePath()));


    }
}
