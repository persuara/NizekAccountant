package ConverterHelper;

import DocModels.CheckDoc;
import DocModels.NormalDoc;
import ModelManager.Manager;

public class Converter {
    public static Double convertToDouble(String text) {
        return Double.parseDouble(text);
    }

    public static void convertToNormalDocument(CheckDoc checkDoc) {
        Manager.addNormalDocument(new NormalDoc(
                checkDoc.getCost(),
                checkDoc.getDescription(),
                true,
                checkDoc.getDate(),
                checkDoc.getTime(),
                checkDoc.getUser()
        ));
        Manager.removeFromList(checkDoc);
    }
    public static boolean setBoolean(String text) {
        if (text.equals("وصول شده")) {
            return true;
        }
        return false;
    }
}
