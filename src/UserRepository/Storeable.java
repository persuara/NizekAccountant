package UserRepository;

import AdminModel.Admin;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.Costumer;

import java.io.File;
import java.util.List;

public interface Storeable {

    // Read Implementations!
    String readFile(CheckDoc normalDoc, int id);

    String readFile(NormalDoc normalDoc, int id);

    String readFile(Costumer normalDoc, String inputNationalID);

    String readAdmin(Admin admin);

    // Write Implementations!

    void writeToFileAdmin();

    void writeToFileCostumer(List<Costumer> costumerList);

    void writeToFileCheckDoc(List<CheckDoc> checkDocList);

    void writeToFileNormalDoc(List<NormalDoc> normalDocList);

    ///********** WRITE ADMIN

    // Read ALL IMPLEMENTATION
    List<String> readWholeFile(File file);

    void readAndAddCostumer(File file);

    void readAndAddCheckDoc(File file);

    void readAndAddNormalDoc(File file);
    void readAndAddAdmin(File file);


}
