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

        Manager.addNormalDocument(new NormalDoc(
                "1000",
                "pay sth",
                true,
                new Date(1,1,1400),
                new TimeNizek(),
                Manager.costumerList.get(1)
        )); Manager.addNormalDocument(new NormalDoc(
                "8000",
                "pay sth",
                false,
                new Date(1,1,1400),
                new TimeNizek(),
                Manager.costumerList.get(1)
        ));
        Manager.addNormalDocument(new NormalDoc(
                "5000",
                "pay sth",
                false,
                new Date(1,1,1400),
                new TimeNizek(),
                Manager.costumerList.get(0)
                ));

        Manager.addCheckDocument(new CheckDoc(
                "2000",
                "pay sth also",
                new Date(1,2,1401),
                new TimeNizek(),
                true,
                Manager.costumerList.get(0)
        ));
        Manager.addCheckDocument(new CheckDoc(
                "4000",
                "pay sth also",
                new Date(1,2,1401),
                new TimeNizek(),
                true,
                Manager.costumerList.get(0)
        ));

//        System.out.println(userRepository.readWholeFile(new File(Manager.checkDocList.get(0).getFilePath())));
//        System.out.println(userRepository.readWholeFile(new File(Manager.normalDocList.get(0).getFilePath())));
//        System.out.println(userRepository.readWholeFile(new File(Manager.costumerList.get(0).getFilePath())));

        System.out.println(Accounting.calculateDebtWithOutChecks(new File(Manager.normalDocList.get(0).getFilePath())));

    }
}
