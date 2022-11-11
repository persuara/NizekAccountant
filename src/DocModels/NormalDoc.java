package DocModels;

import Date.Date;
import Date.Time;
import Login.User;

public class NormalDoc implements Documentable {
    private User user;
    private String payee;
    private String cost;
    private String description;
    private boolean isCreditor;
    private Date date;
    private Time time;
    private int id;
    private final int userID;
    private String filePath = "normalDoc.txt";

    public NormalDoc(String payee, String cost, String description,  boolean isCreditor, Date date, Time time, User user) {
        this.payee = payee;
        this.cost = cost;
        this.description = description;
        this.isCreditor = isCreditor;
        this.date = date;
        this.time = time;
        this.user = user;
        userID = user.getid();
        id++;

    }

    public String getFilePath() {
        return filePath;
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public Date setDate() {
        // VALIDATE THIIIIIIIIIIIIIIS
        return null;
    }

    public int getId() {
        return id;
    }

    public String getPayee() {
        return payee;
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

    public Time getTime() {
        return time;
    }
}
