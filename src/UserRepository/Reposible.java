package UserRepository;

import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.User;

public interface Reposible {
    void readFile(CheckDoc normalDoc, String id, String filePath);
    void readFile(NormalDoc normalDoc, String id, String filePath);
    void readFile(User normalDoc, String id, String filePath);
   void writerToFile(User user, String filePath);
   void writeToFile(NormalDoc normalDoc, String filePath);
   void writeToFile(CheckDoc checkDoc, String filePath);

}
