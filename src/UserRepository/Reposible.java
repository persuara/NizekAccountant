package UserRepository;

import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.User;

public interface Reposible {

    // Read Implementations!
    void readFile(CheckDoc normalDoc, String id);
    void readFile(NormalDoc normalDoc, String id);
    void readFile(User normalDoc, String id);

    // Write Implementations!
   void writerToFile(User user);
   void writeToFile(NormalDoc normalDoc);
   void writeToFile(CheckDoc checkDoc);

}
