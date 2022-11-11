package UserRepository;

import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserRepository implements Reposible {
    List<User> userList = new ArrayList<>();
    List<NormalDoc> normalDocs = new ArrayList<>();
    List<CheckDoc> checkDocs = new ArrayList<>();
    static String costNormal;
    static String costCheck;


    public void addUser(User user) {
        userList.add(user);
    }
    public List<User> getUserList() {
        return userList;
    }
//    public void deleteUser(User user) {
//        userList.remove(user);
//    }
    public void addNormaldoc(NormalDoc normalDoc) {
        normalDocs.add(normalDoc);
    }
    public List<NormalDoc> getNormalDocs() {
        return normalDocs;
    }
    public void addCheckDoc(CheckDoc checkDoc) {
        checkDocs.add(checkDoc);
    }
    public List<CheckDoc> getCheckDocs() {
        return checkDocs;
    }

    // Edit Read Files so that it reads it data from arrayLists.

    @Override
    public void readFile(CheckDoc checkDoc, String id, String filePath) {
        boolean isFound = false;
        String name;
        String cost;
        String description;
        String date;
        String time;
        try {
            Scanner x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !isFound) {
                name = x.next();
                cost = x.next();
                description = x.next();
                date = x.next();
                time = x.next();
                if (id.equals(String.valueOf(checkDoc.getId()))) {
                    isFound = true;
                    costNormal = cost;
                    System.out.println(name + cost + description + date + time);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile(NormalDoc normalDoc, String id, String filePath) {
        boolean isFound = false;
        String name;
        String cost;
        String description;
        String isCreditor;
        String date;
        String time;
//        String userID;
        try {
            Scanner x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !isFound) {
                name = x.next();
                cost = x.next();
                description = x.next();
                isCreditor = x.next();
                date = x.next();
                time = x.next();
//                userID = x.next();
                if (id.equals(String.valueOf(normalDoc.getId()))) {
                    isFound = true;
                    System.out.println(name + cost + description + isCreditor + date+ time );
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile(User user, String id, String filePath) {
        boolean isFound = false;
        String name;
        String nationalID;
        String groupType;
        String address;
        String phone;
        String email;
        try {
            Scanner x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !isFound) {
                name = x.next();
                nationalID = x.next();
                groupType = x.next();
                address = x.next();
                phone = x.next();
                email = x.next();

                if (id.equals(String.valueOf(user.getid()))) {
                    isFound = true;
                    System.out.println(name + nationalID + groupType + address + phone + email);
                } else {
                    System.out.println("No Such file exist");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writerToFile(User user, String filePath) {
        try {
            addUser(user);
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.printf("%s , %s, %s, %s, %s, %s",
                    user.getName(),
                    user.getNationalID(),
                    user.getGroupType(),
                    user.getAddress(),
                    user.getPhone(),
                    user.getEmail());
            printWriter.flush();
            printWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(NormalDoc normalDoc, String filePath) {
        try {
            addNormaldoc(normalDoc);
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.printf("%s, %s, %s, %b, %s, %s",
                    normalDoc.getPayee(),
                    normalDoc.getCost(),
                    normalDoc.getDescription(),
                    normalDoc.isCreditor(),
                    normalDoc.getDate(),
                    normalDoc.getTime());
            printWriter.flush();
            printWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(CheckDoc checkDoc, String filePath) {
        try {
            addCheckDoc(checkDoc);
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.printf("%s, %s, %s, %s, %s",
                    checkDoc.getPayee(),
                    checkDoc.getCost(),
                    checkDoc.getDescription(),
                    checkDoc.getDate(),
                    checkDoc.getTime());
            printWriter.flush();
            printWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public  String readCostFromFile(NormalDoc normalDoc, double id, String filePath) {
        boolean isFound = false;
        String name;
        String cost;
        String description;
        String isCreditor;
        String date;
        String time;
        try {
            Scanner x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !isFound) {
                name = x.next();
                cost = x.next();
                description = x.next();
                isCreditor = x.next();
                date = x.next();
                time = x.next();
                if ( id == normalDoc.getUserID()) {
                    isFound = true;
                    costNormal = cost;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.toString();
        }
        return costNormal;
    }
    public  String readCostFromFile(CheckDoc checkDoc, double id, String filePath) {
        boolean isFound = false;
        String name;
        String cost;
        String description;
        String date;
        String time;
        try {
            Scanner x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !isFound) {
                name = x.next();
                cost = x.next();
                description = x.next();
                date = x.next();
                time = x.next();
                if (String.valueOf(id).equals(String.valueOf(checkDoc.getId()))) {
                    isFound = true;
                    costCheck = cost;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return costCheck;
    }
}
