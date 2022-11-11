package DocModels;

import Date.Date;
import Date.Time;

public class CheckDoc implements  Documentable{
    private String payee;
    private String cost;
    private String description;
    private Date date;
    private Time time;
    private int id = 0;
    private boolean isCashed;
    private String filePath = "checkFile.txt";


    public CheckDoc(String payee, String cost, String description, Date date, Time time, boolean isCashed) {
        this.payee = payee;
        this.cost = cost;
        this.description = description;
        this.date = date;
        this.time = time;
        this.isCashed = isCashed;
        this.id ++;
    }
    public boolean isCashed() {
        return isCashed;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public Date setDate() {
        return null;
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

    public int getId() {
        return id;
    }
}
