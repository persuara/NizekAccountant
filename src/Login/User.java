package Login;

import java.util.UUID;

public class User {
    //ID variable to enable searching through Users!
    private static String name;
    private static String nationalID;
    private static GroupType groupType; //needs to be overridden! we need to declare a type!
    private static String address;
    private static String phone;
    private static String email;
    private static int id;
    private final String filePath = "userFile.txt";

    public User(String name, String nationalID, GroupType groupType, String address, String phone, String email) {
        this.name = name;
        this.nationalID = nationalID;
        this.groupType = groupType;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.id++;
    }

    public void setEmail() {

    }

    public int getid() {
        return this.id;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getName() {
        return name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
