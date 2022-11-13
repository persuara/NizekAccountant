package DocModels;

import Date.Date;
import Date.Time;
import Login.User;
import ModelManager.Manager;

public class CheckDoc implements  Documentable{
    private User user;
    private String payee;
    private String cost;
    private String description;
    private Date date;
    private Time time;
    private boolean isCashed;
    private String filePath = "checkFile.csv";

    private final int userID;


    public CheckDoc(String payee, String cost, String description, Date date, Time time, boolean isCashed, User user) {
        this.payee = payee;
        this.cost = cost;
        this.description = description;
        this.date = date;
        this.time = time;
        this.isCashed = isCashed;
        this.user = user;
        userID = user.getid();
    }

    public int getUserID() {
        return userID;
    }
    public boolean isCashed() {
        return isCashed;
    }

    public String getFilePath() {
        return filePath;
    }

    public User getUser() {
        return user;
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

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

}
