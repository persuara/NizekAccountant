package DocModels;

import Date.DateNizek;
import Date.TimeNizek;
import Login.Costumer;

public class CheckDoc implements  Documentable{
    private Costumer costumer;
    private String cost;
    private String description;
    private DateNizek dateNizek;
    private TimeNizek timeNizek;
    private boolean isCashed;
    private String filePath = "checkFile.csv";
    private String cashedFilePath = "cashedCheck.csv";
    private String notCashedFilePath = "notCashedCheck.csv";



    private final int userID;


    public CheckDoc(String cost, String description, DateNizek dateNizek, TimeNizek timeNizek, boolean isCashed, Costumer costumer) {
        this.cost = cost;
        this.description = description;
        this.dateNizek = dateNizek;
        this.timeNizek = timeNizek;
        this.isCashed = isCashed;
        this.costumer = costumer;
        userID = costumer.getID();
    }

    public int getUserID() {
        return userID;
    }
    public boolean isCashed() {
        return isCashed;
    }


    public Costumer getUser() {
        return costumer;
    }

    public String getPayee() {
        return costumer.getName();
    }

    public String getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public DateNizek getDate() {
        return dateNizek;
    }

    public TimeNizek getTime() {
        return timeNizek;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getCashedFilePath() {
        return cashedFilePath;
    }

    public String getNotCashedFilePath() {
        return notCashedFilePath;
    }

    @Override
    public String toString() {
        return "CheckDoc{" +
                "costumer=" + costumer +
                ", cost='" + cost + '\'' +
                ", isCashed=" + isCashed +
                ", userID=" + userID +
                '}';
    }
}
