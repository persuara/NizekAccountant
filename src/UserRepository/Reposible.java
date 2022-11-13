package UserRepository;

import AdminModel.Admin;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.User;

public interface Reposible {

    // Read Implementations!
    String readFile(CheckDoc normalDoc, int id);
    String readFile(NormalDoc normalDoc, int id);
    String readFile(User normalDoc, String inputNationalID);
    String readAdmin(Admin admin);

    // Write Implementations!
   void writerToFile(User user);
   void writeToFile(NormalDoc normalDoc);
   void writeToFile(CheckDoc checkDoc);
   void writeToFile(Admin admin);

   // Read ALL IMPLEMENTATION
    void readAllNORMAL(User user );
    void readAllCHECK(User user);
    void readAllUSER();


}
