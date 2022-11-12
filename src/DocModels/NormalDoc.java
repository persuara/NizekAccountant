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
    public  static int id;
    private int userID;
    private final String filePath = "normalDoc.txt";

    public NormalDoc(String payee, String cost, String description,  boolean isCreditor, Date date, Time time, User user) {
        this.payee = payee;
        this.cost = cost;
        this.description = description;
        this.isCreditor = isCreditor;
        this.date = date;
        this.time = time;
        this.user = user;
        userID = user.getid();
    }

    public User getUser() {
        return user;
    }
//public NormalDoc() {}


    public void setUser(User user) {
        this.user = user;
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

    public void setTime(Time time) {
        this.time = time;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getUserID() {
        return userID;
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
