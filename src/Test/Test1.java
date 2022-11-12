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
                "eramabadiamir@nizek.com", "helloApp");
        /// NORMAL DOC
        NormalDoc normalDoc = new NormalDoc("David",
                "1000",
                "pay rent",
                true,
                new Date(20, 5, 1401),
                new Time(), user);
        // CHECK DOC
        CheckDoc checkDoc = new CheckDoc("kosar",
                "1000",
                "pay house rent",
                new Date(11, 2, 1402),
                new Time(), true, user
        );
    }
}
