package Test;


import AccountingCalculations.Accounting;
import Date.Date;
import Date.TimeNizek;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.Costumer;
import Login.GroupType;
import ModelManager.Manager;
import UserRepository.UserRepository;

import java.io.File;

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
//        Manager.addNormalDocument(new NormalDoc(
//                "1000",
//                "pay sth",
//                true,
//                new Date(1,1,1400),
//                new TimeNizek(),
//                Manager.costumerList.get(1)
//        ));
//        Manager.addNormalDocument(new NormalDoc(
//                "19000",
//                "pay debt",
//                true,
//                new Date(19,12,1420),
//                new TimeNizek(),
//                Manager.costumerList.get(1)
//        ));
//        Manager.addNormalDocument(new NormalDoc(
//                "8000",
//                "pay list",
//                false,
//                new Date(12,1,1400),
//                new TimeNizek(),
//                Manager.costumerList.get(1)
//        ));
//        Manager.addNormalDocument(new NormalDoc(
//                "5000",
//                "pay sth",
//                false,
//                new Date(5,1,1401),
//                new TimeNizek(),
//                Manager.costumerList.get(0)
//                ));



        Manager.addCheckDocument(new CheckDoc(
                "500",
                "pay sth also",
                new Date(1,2,1401),
                new TimeNizek(),
                true,
                Manager.costumerList.get(1)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "11000",
                "Diamond for Elly",
                new Date(1,2,1401),
                new TimeNizek(),
                true,
                Manager.costumerList.get(0)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "12000",
                "Rolex",
                new Date(1,2,1401),
                new TimeNizek(),
                false,
                Manager.costumerList.get(0)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "41000",
                "Hospital Bill",
                new Date(1,2,1401),
                new TimeNizek(),
                false,
                Manager.costumerList.get(0)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "19000",
                "RangeRover",
                new Date(1,2,1401),
                new TimeNizek(),
                false,
                Manager.costumerList.get(0)
        ));


        System.out.println("Cashed: " + Accounting.calculateMoney(new File(Manager.checkDocList.get(0).getCashedFilePath())));
        System.out.println("Not Cashed" + Accounting.calculateMoney(new File(Manager.checkDocList.get(0).getNotCashedFilePath())));
        System.out.println("all in one: " + Accounting.reportAllTransactionCHECK(new File(Manager.checkDocList.get(0).getFilePath())));



    }
}
