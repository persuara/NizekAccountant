package Test;


import AccountingCalculations.Accounting;
import Date.DateNizek;
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
//
        Manager.addNormalDocument(new NormalDoc(
                "51000",
                "pay sth",
                true,
                new DateNizek(31, 6, 1402),
                new TimeNizek(),
                Manager.costumerList.get(1)
        ));
        Manager.addNormalDocument(new NormalDoc(
                "5000",
                "pay debt",
                true,
                new DateNizek(12,9,1402),
                new TimeNizek(),
                Manager.costumerList.get(1)
        ));
        Manager.addNormalDocument(new NormalDoc(
                "5000",
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
                new DateNizek(1,3,1402),
                new TimeNizek(),
                Manager.costumerList.get(0)
                ));


        Manager.addCheckDocument(new CheckDoc(
                "666",
                "pay sth also",
                new DateNizek(24, 8, 1401),
                new TimeNizek(),
                false,
                Manager.costumerList.get(1)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "11000",
                "Diamond for Elly",
                new DateNizek(24, 8, 1401),
                new TimeNizek(),
                false,
                Manager.costumerList.get(0)
        ));


        Manager.addCheckDocument(new CheckDoc(
                "400",
                "Rolex",
                new DateNizek(29, 9, 1401),
                new TimeNizek(),
                false,
                Manager.costumerList.get(0)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "200",
                "Hospital Bill",
                new DateNizek(1, 9, 1401),
                new TimeNizek(),
                false,
                Manager.costumerList.get(0)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "500",
                "RangeRover",
                new DateNizek(1, 9, 1401),
                new TimeNizek(),
                false,
                Manager.costumerList.get(0)
        ));
        System.out.println(
                Accounting.calculateTheResultOfNormalDoc() +
                " Status: " + Accounting.getTheStatusOfNormalDoc());
        System.out.println(Accounting.calculateWeight());
    }
}
