package Test;


import AccountingCalculations.Accounting;
import ConverterHelper.Converter;
import Date.Date;
import Date.Time;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.GroupType;
import Login.User;
import UserRepository.UserRepository;

public class Test1 {
    public static void main(String[] args) {
         UserRepository userRepository = new UserRepository();
        User user = new User("amir",
                "123",
                new GroupType("Employee"),
                "tehran",
                "09034948371",
                 "eramabadiamir@nizek.com");
        NormalDoc normalDoc = new NormalDoc("ali",
                "1000",
                "pay rent",
                true,
                new Date(20,5,1401),
                new Time(), user);
        System.out.println(normalDoc.getId());
        CheckDoc checkDoc = new CheckDoc("kosar",
                "2000",
                "pay house rent",
                new Date(11,2,1402),
                new Time(), true
        );
        //All Write Methods
        userRepository.writerToFile(user, user.getFilePath());
        userRepository.writeToFile(normalDoc, normalDoc.getFilePath());
        userRepository.writeToFile(checkDoc, checkDoc.getFilePath());

        //All Read Methods
        userRepository.readFile(user, "1", user.getFilePath());
        userRepository.readFile(checkDoc,"1", checkDoc.getFilePath());
        userRepository.readFile(normalDoc, "1", normalDoc.getFilePath());

//        // Calculate!
//        Accounting.calculateDebt(user, checkDoc, normalDoc);

    }
}
