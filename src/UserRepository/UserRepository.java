package UserRepository;

import AdminModel.Admin;
import ConverterHelper.ConverterTime;
import ConverterHelper.Converter;
import DocModels.CheckDoc;
import DocModels.NormalDoc;
import Login.Costumer;
import java.util.*;
import java.io.*;


public class UserRepository implements Storeable {
    static String costNormal;
    static String costCheck;
    static boolean isEmailUser;
    static String tempUser;
    static String tempNORMAL;
    static String tempCHECk;
    static String tempAdmin;
    static boolean isPasswordUser;




    @Override
    public String readFile(CheckDoc checkDoc, int id) {
        String name;
        String cost;
        String description;
        String date;
        String time;
        String userID;
        try {
            Scanner x = new Scanner(new File(checkDoc.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                name = x.next();
                cost = x.next();
                description = x.next();
                date = x.next();
                time = x.next();
                userID = x.next();
                if (id == checkDoc.getUserID()) {
                    tempCHECk = String.format("%s, %s, %s, %s,  %s, %s", name, cost, description, ConverterTime.convertToPersian(date), time, userID);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempCHECk;
    }
    //$$$$$$$$$$$$$$$$$---------$$$$$$$$$$ FINAL $$$$$$$$$$---------$$$$$$$$$$$$$$$$$
    @Override
    public String readFile(NormalDoc normalDoc, int id) {
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
            while (x.hasNext()) {
                name = x.next();
                cost = x.next();
                description = x.next();
                isCreditor = x.next();
                date = x.next();
                time = x.next();
                userID = x.next();
                if (id == normalDoc.getUserID()) {
                    tempNORMAL = String.format("%s, %s, %s, %s, %s, %s, %s", name, cost, description, isCreditor, ConverterTime.convertToPersian(date), time, userID);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempNORMAL;
    }
    public String readCostumerBasedOnNationalID(List<Costumer> costumerList, String inputNationalID) {
        for (Costumer costumer: costumerList) {
            if (inputNationalID.equals(costumer.getNationalID())) {
                return String.format("%s, %s, %s, %s, %s, %s",
                        costumer.getName(),
                        costumer.getNationalID(),
                        costumer.getGroupType(),
                        costumer.getEmail(),
                        costumer.getAddress(),
                        costumer.getPhone());
            }
        }
        return "Not Found";
    }
    public String readCostumerBasedOnName(List<Costumer> costumerList, String name) {
        for (Costumer costumer: costumerList) {
            if (name.equals(costumer.getName())) {
                return String.format("%s, %s, %s, %s, %s, %s",
                        costumer.getName(),
                        costumer.getNationalID(),
                        costumer.getGroupType(),
                        costumer.getEmail(),
                        costumer.getAddress(),
                        costumer.getPhone());
            }
        }
        return "Not Found";
    }
    public List<NormalDoc> readBasedOnDay(List<NormalDoc> normalDocList, int day, int month, int year) {
        List<NormalDoc> filteredList = new ArrayList<>();
        for (NormalDoc object: normalDocList) {
            if (day == object.getDate().getDay() && month == object.getDate().getMonth() && year == object.getDate().getYear()) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }
    public List<NormalDoc> readBasedOnMonth(List<NormalDoc> normalDocList,  int month, int year) {
        List<NormalDoc> filteredList = new ArrayList<>();
        for (NormalDoc object: normalDocList) {
            if (month == object.getDate().getMonth() && year == object.getDate().getYear()) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }
    public List<NormalDoc> readBasedOnYear(List<NormalDoc> normalDocList,int year) {
        List<NormalDoc> filteredList = new ArrayList<>();
        for (NormalDoc object: normalDocList) {
            if (year == object.getDate().getYear()) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }
    public List<CheckDoc> readBasedOnDayCheck(List<CheckDoc> checkDocList, int day, int month, int year) {
        List<CheckDoc> filteredList = new ArrayList<>();
        for (CheckDoc object: checkDocList) {
            if (day == object.getDate().getDay() && month == object.getDate().getMonth() && year == object.getDate().getYear()) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }
    public List<CheckDoc> readBasedOnMonthCheck(List<CheckDoc> checkDocList,  int month, int year) {
        List<CheckDoc> filteredList = new ArrayList<>();
        for (CheckDoc object: checkDocList) {
            if (month == object.getDate().getMonth() && year == object.getDate().getYear()) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }
    public List<CheckDoc> readBasedOnYearCheck(List<CheckDoc> checkDocList,int year) {
        List<CheckDoc> filteredList = new ArrayList<>();
        for (CheckDoc object: checkDocList) {
            if (year == object.getDate().getYear()) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }

    @Override
    public String readFile(Costumer costumer, String inputNationalID) {
        boolean isFound = false;
        String name;
        String nationalID;
        String groupType;
        String address;
        String phone;
        String email;
        try {
            Scanner x = new Scanner(new File(costumer.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !isFound) {
                name = x.next();
                nationalID = x.next();
                groupType = x.next();
                address = x.next();
                phone = x.next();
                email = x.next();
                if (inputNationalID.equals(costumer.getNationalID())) {
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
    public void writerToFile(Costumer costumer) {
        try {
            FileWriter fileWriter = new FileWriter(costumer.getFilePath(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.printf("%s , %s, %s, %s, %s, %s, %d\n",
                    costumer.getName(),
                    costumer.getNationalID(),
                    costumer.getGroupType(),
                    costumer.getAddress(),
                    costumer.getPhone(),
                    costumer.getEmail(),
                    costumer.getID());
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
                    normalDoc.getUser().getName(),
                    normalDoc.getCost(),
                    normalDoc.getDescription(),
                    normalDoc.isCreditor(),
                    ConverterTime.convertToGregorian(normalDoc.getDate()),
                    normalDoc.getTime(),
                    normalDoc.getUserID()
            );
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeIFCreditorToFile(NormalDoc normalDoc) {
        try {
            if (normalDoc.isCreditor()) {
                FileWriter fileWriter = new FileWriter(normalDoc.getIsCreditorFilePath(), true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.printf("%s, %s, %s, %b, %s, %s, %d \n",
                        normalDoc.getUser().getName(),
                        normalDoc.getCost(),
                        normalDoc.getDescription(),
                        normalDoc.isCreditor(),
                        ConverterTime.convertToGregorian(normalDoc.getDate()),
                        normalDoc.getTime(),
                        normalDoc.getUserID()
                );
                printWriter.flush();
                printWriter.close();
            } else {
                try {
                    FileWriter fileWriter = new FileWriter(normalDoc.getNotCreditorFilePath(), true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);
                    printWriter.printf("%s, %s, %s, %b, %s, %s, %d \n",
                            normalDoc.getUser().getName(),
                            normalDoc.getCost(),
                            normalDoc.getDescription(),
                            normalDoc.isCreditor(),
                            ConverterTime.convertToGregorian(normalDoc.getDate()),
                            normalDoc.getTime(),
                            normalDoc.getUserID()
                    );
                    printWriter.flush();
                    printWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
                    checkDoc.getUser().getName(),
                    checkDoc.getCost(),
                    checkDoc.getDescription(),
                    ConverterTime.convertToGregorian(checkDoc.getDate()),
                    checkDoc.getTime(),
                    checkDoc.getUserID());
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeIFCashedToFile(CheckDoc checkDoc) {
        try {
            if (checkDoc.isCashed()) {
                FileWriter fileWriter = new FileWriter(checkDoc.getCashedFilePath(), true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.printf("%s, %s, %s, %s, %s, %d\n",
                        checkDoc.getUser().getName(),
                        checkDoc.getCost(),
                        checkDoc.getDescription(),
                        ConverterTime.convertToGregorian(checkDoc.getDate()),
                        checkDoc.getTime(),
                        checkDoc.getUserID());
                printWriter.flush();
                printWriter.close();
            } else {
                FileWriter fileWriter = new FileWriter(checkDoc.getNotCashedFilePath(), true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.printf("%s, %s, %s, %s, %s, %d\n",
                        checkDoc.getUser().getName(),
                        checkDoc.getCost(),
                        checkDoc.getDescription(),
                        ConverterTime.convertToGregorian(checkDoc.getDate()),
                        checkDoc.getTime(),
                        checkDoc.getUserID());
                printWriter.flush();
                printWriter.close();
            }
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
    // &&&&&&&&&&&&& READ ALL Method &&&&&&&&&&&&&&&
    @Override
    public List<String> readWholeFile(File file) {
        List<String> arraylist = new ArrayList<>();
        try {
            InputStream ips = new FileInputStream(file.getPath());
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] emp = line.split(",");
//                emp[1] = ConvertTime.convertToPersian(emp[1]);
                String a = Arrays.toString(emp);
                arraylist.add(a);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arraylist;
    }

    /////////   READ COST FROM BOTH NORMAL DOC AND CHECK DOC!!!!!
    public String readCostFromFile(NormalDoc normalDoc, int id) {
        String cost;
        try {
            Scanner x = new Scanner(new File(normalDoc.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                x.next();
                cost = x.next();
                x.next();
                x.next();
                x.next();
                x.next();
                if (id == normalDoc.getUserID()) {
                    costNormal = cost;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.toString();
        }
        return costNormal;
    }
    public String readCostFromFile(CheckDoc checkDoc, int id) {
        String cost;
        try {
            Scanner x = new Scanner(new File(checkDoc.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                x.next();
                cost = x.next();
                x.next();
                x.next();
                x.next();
                if (id == checkDoc.getUserID()) {
                    costCheck = cost;
                    break;
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
        try {
            Scanner x = new Scanner(new File(admin.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !isFound) {
                x.next();
                x.next();
                x.next();
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
    public String[] readColumnWholeFile(int column, File file) {
        String[] data;
        String currentLine;
        List<String> listColumn = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file.getPath());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((currentLine = bufferedReader.readLine()) != null) {
                data = currentLine.split(", ");
                listColumn.add(data[column]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listColumn.toArray(new String[0]);
    }
    // Method to Read Date from CHECKDOC
    public List<String> readDateFromCheck(List<CheckDoc> checkDocList) {

        List<String> arrayDate = new ArrayList<>();
        for (CheckDoc checkDoc : checkDocList) {
            if (!(checkDoc.isCashed())) {
                arrayDate.add(ConverterTime.convertToGregorian(checkDoc.getDate()));
            }
        }
        return arrayDate;
    }
    public List<Double> readCostFromCheck(List<CheckDoc> checkDocList) {

        List<Double> arrayCost = new ArrayList<>();
        for (CheckDoc checkDoc : checkDocList) {
            if (!(checkDoc.isCashed())) {
                arrayCost.add(Converter.convertToDouble(checkDoc.getCost()));
            }
        }
        return arrayCost;
    }
}