package UserRepository;

import AdminModel.Admin;
import Date.Date;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.User;
import ModelManager.Manager;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserRepository implements Reposible {

    static String costNormal;
    static String costCheck;
    static boolean isEmailUser;
    static String tempUser;
    static String tempNORMAL;
    static String tempCHECk;
    static String tempAdmin;
    static boolean isPasswordUser;
    static Date dateUser;


    // Edit Read Files so that it reads it data from arrayLists.

    @Override
    public String readFile(CheckDoc checkDoc, int id) {
        boolean isFound = false;
        String name;
        String cost;
        String description;
        String date;
        String time;
        try {
            Scanner x = new Scanner(new File(checkDoc.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !isFound) {
                name = x.next();
                cost = x.next();
                description = x.next();
                date = x.next();
                time = x.next();
                for (int i = 0; i <= checkDoc.getId(); i++) {
                    if (i == id) {
                        isFound = true;
                        tempCHECk = String.format("%s, %s, %s, %s,  %s", name, cost, description, date, time);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempCHECk;
    }

    @Override
    public String readFile(NormalDoc normalDoc, int id) {
        boolean isFound = false;
        String name;
        String cost;
        String description;
        String isCreditor;
        String date;
        String time;
        String userID;
        try {
            Scanner x = new Scanner(new File(normalDoc.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !isFound) {
                name = x.next();
                cost = x.next();
                description = x.next();
                isCreditor = x.next();
                date = x.next();
                time = x.next();
                userID = x.next();
                if (id == normalDoc.getId()) {
                    isFound = true;
                    tempNORMAL = String.format("%s, %s, %s, %b, %s, %s, %s", name, cost, description, isCreditor, date, time, userID);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempNORMAL;
    }

    @Override
    public String readFile(User user, String inputNationalID) {
        boolean isFound = false;
        String name;
        String nationalID;
        String groupType;
        String address;
        String phone;
        String email;
        try {
            Scanner x = new Scanner(new File(user.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !isFound) {
                name = x.next();
                nationalID = x.next();
                groupType = x.next();
                address = x.next();
                phone = x.next();
                email = x.next();

                if (inputNationalID.equals(user.getNationalID())) {
                    isFound = true;
                    tempUser = String.format("%s , %s, %s, %s, %s, %s", name, nationalID, groupType, address, phone, email);
                } else {
                    System.out.println("No Such file exist");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempUser;
    }
    @Override
    public String readAdmin(Admin admin) {
        String name;
        String email;
        String password;
        try {
            Scanner x = new Scanner(new File(admin.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                name = x.next();
                email = x.next();
                password = x.next();
                tempAdmin = String.format("%s , %s, %s", name, email, password);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempAdmin;
    }

    // *************** WRITE METHODS

    @Override
    public void writerToFile(User user) {
        try {
            FileWriter fileWriter = new FileWriter(user.getFilePath(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.printf("%s , %s, %s, %s, %s, %s, %s, %d\n",
                    user.getName(),
                    user.getNationalID(),
                    user.getGroupType(),
                    user.getAddress(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getid());
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(NormalDoc normalDoc) {
        try {
            FileWriter fileWriter = new FileWriter(normalDoc.getFilePath(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.printf("%s, %s, %s, %b, %s, %s, %d \n",
                    normalDoc.getPayee(),
                    normalDoc.getCost(),
                    normalDoc.getDescription(),
                    normalDoc.isCreditor(),
                    normalDoc.getDate(),
                    normalDoc.getTime(),
                    normalDoc.getId()
            );
            printWriter.flush();
            printWriter.close();
            System.out.println("Successfully added to data base" + normalDoc.getCost());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(CheckDoc checkDoc) {
        try {
            FileWriter fileWriter = new FileWriter(checkDoc.getFilePath(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.printf("%s, %s, %s, %s, %s, %d\n",
                    checkDoc.getPayee(),
                    checkDoc.getCost(),
                    checkDoc.getDescription(),
                    checkDoc.getDate(),
                    checkDoc.getTime(),
                    checkDoc.getId());
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ///********** WRITE ADMIN
    @Override
    public void writeToFile(Admin admin) {
        try {
            FileWriter fileWriter = new FileWriter(admin.getFilePath());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.printf("%s, %s, %s \n",
                    admin.getName(),
                    admin.getEmail(),
                    admin.getPassword());
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // &&&&&&&&&&&&& READ ALL METHODS &&&&&&&&&&&&&&&
    @Override
    public void readAllNORMAL(User user) {
        for (NormalDoc normalDoc : Manager.normalDocList) {
            System.out.println(readFile(normalDoc, normalDoc.getId()));
        }
    }

    @Override
    public void readAllCHECK(User user) {
        for (CheckDoc checkDoc : Manager.checkDocList) {
            System.out.println(readFile(checkDoc, checkDoc.getId()));
        }
    }

    @Override
    public void readAllUSER() {
        for (User user : Manager.userList) {
            System.out.println(readFile(user, user.getNationalID()));
        }
    }

    /////////   READ COST FROM BOTH NORMAL DOC AND CHECK DOC!!!!!

    public String readCostFromFile(NormalDoc normalDoc, String id) {
        boolean isFound = false;
        String name;
        String cost;
        String description;
        String isCreditor;
        String date;
        String time;

        try {
            Scanner x = new Scanner(new File(normalDoc.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !isFound) {
                name = x.next();
                cost = x.next();
                description = x.next();
                isCreditor = x.next();
                date = x.next();
                time = x.next();
//                temp = name + cost + description + isCreditor + date + time;

                if (id.equals(String.valueOf(normalDoc.getUserID()))) {
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

    public String readCostFromFile(CheckDoc checkDoc, String id) {
        boolean isFound = false;
        String name;
        String cost;
        String description;
        String date;
        String time;
        try {
            Scanner x = new Scanner(new File(checkDoc.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !isFound) {
                name = x.next();
                cost = x.next();
                description = x.next();
                date = x.next();
                time = x.next();
                if (id.equals(String.valueOf(checkDoc.getUserID()))) {
                    isFound = true;
                    costCheck = cost;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.toString();
        }
        return costCheck;
    }

    //**********************  READ EMAIL AND PASSWORD CREDENTIONAl IT WITH USER INPUT **********************

    public boolean readValidateAdmin(Admin admin, String inputEmail, String inputPassword) {
        boolean isFound = false;
        String name;
        String email;
        String password;
        try {
            Scanner x = new Scanner(new File(admin.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !isFound) {
                name = x.next();
                email = x.next();
                password = x.next();
                if (inputEmail.equals(admin.getEmail()) && inputPassword.equals(admin.getPassword())) {
                    isFound = true;
                    isEmailUser = true;
                    isPasswordUser = true;
                } else {
                    isEmailUser = false;
                    isPasswordUser = false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Email Not found");
        } catch (NoSuchElementException e) {
            e.toString();
        }
        return isEmailUser && isPasswordUser;
    }


    public String[] readBasedOnDateFromFile(CheckDoc checkDoc, Date inputDate, String filePath) {
        boolean isFound = false;
        String[] array = new String[5];
        String name;
        String cost;
        String description;
        String date;
        String time;
        try {
            Scanner x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !isFound) {
                name = x.next();
                cost = x.next();
                description = x.next();
                date = x.next();
                time = x.next();
                if (inputDate.equals(checkDoc.getDate())) {
                    isFound = true;
                    array[0] = name;
                    array[1] = cost;
                    array[2] = description;
                    array[3] = date;
                    array[4] = time;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.toString();
        }
        return array;
    }

    public String[] readBasedOnDateFromFile(NormalDoc normalDoc, Date inputDate, String filePath) {
        boolean isFound = false;
        String[] array = new String[5];
        String name;
        String cost;
        String description;
        String date;
        String time;
        try {
            Scanner x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !isFound) {
                name = x.next();
                cost = x.next();
                description = x.next();
                date = x.next();
                time = x.next();
                if (inputDate.equals(normalDoc.getDate())) {
                    isFound = true;
                    array[0] = name;
                    array[1] = cost;
                    array[2] = description;
                    array[3] = date;
                    array[4] = time;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.toString();
        }
        return array;
    }

    public void removeIdFromDataBase(NormalDoc normalDoc, int deleteLine) { //changed delete line to delete id!
        String tempFileAddress = "temp.csv";
        File oldFile = new File(normalDoc.getFilePath());
        File newFile = new File(tempFileAddress);

        String currentLine;
        int line = 0;
        try {
            FileWriter fileWriter = new FileWriter(tempFileAddress, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            FileReader fileReader = new FileReader(normalDoc.getFilePath());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((currentLine = bufferedReader.readLine()) != null) {
                line++;
                if (deleteLine != line) {
                    printWriter.println(currentLine);
                }
            }
            printWriter.flush();
            printWriter.close();
            fileReader.close();
            bufferedReader.close();
            bufferedWriter.close();
            fileWriter.close();
            oldFile.delete();
            File dump = new File(normalDoc.getFilePath());
            newFile.renameTo(dump);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't write a new file!" + normalDoc.getFilePath());
        }
    }
}
