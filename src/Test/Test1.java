package Test;


import AccountingCalculations.Accounting;
import AdminModel.Admin;
import Date.DateNizek;
import Date.TimeNizek;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.Costumer;
import Login.GroupType;
import ModelManager.Manager;
import UserRepository.UserRepository;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
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
//        userRepository.writerToFile(Manager.costumerList.get(0));
//        userRepository.writerToFile(Manager.costumerList.get(1));
////
//        Manager.addNormalDocument(new NormalDoc(
//                "100",
//                "pay him",
//                true,
//                new DateNizek(31, 6, 1402),
//                new TimeNizek(),
//                Manager.costumerList.get(1)
//        ));
//        Manager.addNormalDocument(new NormalDoc(
//                "100",
//                "pay her",
//                true,
//                new DateNizek(12, 9, 1402),
//                new TimeNizek(),
//                Manager.costumerList.get(1)
//        ));
        Manager.addNormalDocument(new NormalDoc(
                "200",
                "pay list",
                false,
                new DateNizek(5, 9, 1402),
                new TimeNizek(),
                Manager.costumerList.get(1)
        ));
        Manager.addNormalDocument(new NormalDoc(
                "900",
                "pay sth",
                false,
                new DateNizek(1, 3, 1402),
                new TimeNizek(),
                Manager.costumerList.get(0)
        ));
//
//
//        Manager.addCheckDocument(new CheckDoc(
//                "666",
//                "pay sth also",
//                new DateNizek(24, 8, 1401),
//                new TimeNizek(),
//                false,
//                Manager.costumerList.get(1)
//        ));
//        Manager.addCheckDocument(new CheckDoc(
//                "11000",
//                "Diamond for Elly",
//                new DateNizek(24, 8, 1401),
//                new TimeNizek(),
//                false,
//                Manager.costumerList.get(0)
//        ));
//
//
//        Manager.addCheckDocument(new CheckDoc(
//                "400",
//                "Rolex",
//                new DateNizek(29, 9, 1401),
//                new TimeNizek(),
//                false,
//                Manager.costumerList.get(0)
//        ));
        Manager.addCheckDocument(new CheckDoc(
                "200",
                "Hospital Bill",
                new DateNizek(1, 9, 1401),
                new TimeNizek(),
                false,
                Manager.costumerList.get(1)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "500",
                "RangeRover",
                new DateNizek(1, 9, 1401),
                new TimeNizek(),
                false,
                Manager.costumerList.get(1)
        ));
//        Manager.addAdmin(new Admin(
//                "persuara",
//                "eram@gmail.com",
//                "abcfg"
//                ));
//        Manager.addAdmin(new Admin(
//                "baran",
//                "baran@gmail.com",
//                "abcde"
        // ));
//        Manager.addAdmin(new Admin(
//                "amir",
//                "julia@gmail.com",
//                "ab123"
//        ));
        userRepository.readAndAddAdmin(new File("adminFile.csv"));
        System.out.println(Manager.adminList.size());
        System.out.println(userRepository.validateAdmin("julia@gmail.com", "ab123"));


//        userRepository.readAndAddNormalDoc(new File("normalFile.csv"));
//        System.out.println(userRepository.readFilterBasedOnCostCheck(200, 500));
//        System.out.println(userRepository.readFilterBasedOnCostNormal(200,900));
    }
}
