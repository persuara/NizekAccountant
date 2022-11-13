package DocModels;

import Date.Date;
import Date.TimeNizek;
import Login.Costumer;

public class NormalDoc implements Documentable {
    private Costumer costumer;
    private String payee;
    private String cost;
    private String description;
    private boolean isCreditor;
    private Date date;
    private TimeNizek timeNizek;

    private int userID;
    private final String filePath = "DataBase/NormalDocuments/normalDoc.csv";
    private final String isCreditorFilePath = "DataBase/NormalDocuments/creditor.csv";
    private final String notCreditorFilePath = "DataBase/NormalDocuments/notCreditor.csv";

    public NormalDoc(String cost, String description, boolean isCreditor, Date date, TimeNizek timeNizek, Costumer costumer) {
        this.cost = cost;
        this.description = description;
        this.isCreditor = isCreditor;
        this.date = date;
        this.timeNizek = timeNizek;
        this.costumer = costumer;
        userID = costumer.getID();

    }

    public Costumer getUser() {
        return costumer;
    }
//public NormalDoc() {}


    public void setUser(Costumer costumer) {
        this.costumer = costumer;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreditor(boolean creditor) {
        isCreditor = creditor;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(TimeNizek timeNizek) {
        this.timeNizek = timeNizek;
    }


    public int getUserID() {
        return userID;
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

    public boolean isCreditor() {
        return isCreditor;
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

    public String getNotCreditorFilePath() {
        return notCreditorFilePath;
    }
    public String getIsCreditorFilePath() {
        return isCreditorFilePath;
    }

}
