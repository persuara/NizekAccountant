package DocModels;

import Date.DateNizek;
import Date.TimeNizek;
import Login.Costumer;

public class NormalDoc implements Documentable {
    private Costumer costumer;
    private String payee;
    private String cost;
    private String description;
    private boolean isCreditor;
    private DateNizek dateNizek;
    private TimeNizek timeNizek;

    private int userID;
    private final String filePath = "normalDoc.csv";
    private final String isCreditorFilePath = "creditor.csv";
    private final String notCreditorFilePath = "notCreditor.csv";

    public NormalDoc(String cost, String description, boolean isCreditor, DateNizek dateNizek, TimeNizek timeNizek, Costumer costumer) {
        this.cost = cost;
        this.description = description;
        this.isCreditor = isCreditor;
        this.dateNizek = dateNizek;
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

    public void setDate(DateNizek dateNizek) {
        this.dateNizek = dateNizek;
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

    public DateNizek getDate() {
        return dateNizek;
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
