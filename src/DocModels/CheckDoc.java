package DocModels;

import Date.Date;
import Date.TimeNizek;
import Login.Costumer;

public class CheckDoc implements  Documentable{
    private Costumer costumer;
    private String cost;
    private String description;
    private Date date;
    private TimeNizek timeNizek;
    private boolean isCashed;
    private String filePath = "DataBase/CheckDocuments/checkFile.csv";
    private String cashedFilePath = "DataBase/CheckDocuments/cashedCheck.csv";
    private String notCashedFilePath = "DataBase/CheckDocuments/notCashedCheck.csv";



    private final int userID;


    public CheckDoc( String cost, String description, Date date, TimeNizek timeNizek, boolean isCashed, Costumer costumer) {
        this.cost = cost;
        this.description = description;
        this.date = date;
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

    public Date getDate() {
        return date;
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
