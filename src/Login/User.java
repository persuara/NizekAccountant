package Login;

import java.util.UUID;

public class User {
    //ID variable to enable searching through Users!
    private String name;
    private String nationalID;
    private GroupType groupType; //needs to be overridden! we need to declare a type!
    private String address;
    private String phone;
    private String email;
    private String password;
    private  int id;
    private final String filePath = "userFile.txt";

    public User(String name, String nationalID, GroupType groupType, String address, String phone, String email, String password) {
        this.name = name;
        this.nationalID = nationalID;
        this.groupType = groupType;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.id++;
    }

    public void setEmail() {

    }

    public String getPassword() {
        return password;
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
