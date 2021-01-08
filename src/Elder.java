import java.util.Scanner;

public class Elder {

    Scanner inputScan = new Scanner(System.in);
    static int nextId=100;//every elder will get a uniqe id

    //main attributes
    int id;
    String name;
    String phoneNum;
    String address;

    //language attributes
    boolean hebrew;
    boolean russian;


    public int getHelp() {
        return help;
    }

    public void setHelp() {
        this.help = makeRequest() ;
    }

    //helep needed? 0-no 1-tech 2-house 3-general
    int help;

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public boolean isHebrew() {
        return hebrew;
    }

    public boolean isRussian() {
        return russian;
    }

    public String getAddress() {
        return address;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRussian(boolean russian) {
        this.russian = russian;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setHebrew(boolean hebrew) {
        this.hebrew = hebrew;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //constractor
    public Elder(String name, String phoneNum, boolean hebrew, boolean russian, String address) {
        this.id = nextId;
        this.name = name;
        this.phoneNum = phoneNum;
        this.hebrew = hebrew;
        this.russian = russian;
        this.address = address;
        nextId++;

    }


    //make request to server
    public int makeRequest() {
        System.out.println("Hello dear : "+getName()+" Please choose in which field you need help :\n" +
                "1 - I need help with technical issue \n" +
                "2 - I need help with house repair \n" +
                "3 - I need help with a general issue \n ");

        int choice = inputScan.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Looking for volenteer to help with technical issue :)");
                break;
            case 2:
                System.out.println("Looking for volenteer to help with your house repair issue :)");
                break;
            case 3:
                System.out.println("Looking for volenteer to help with your issue :)");
                break;
        }
        return choice;

    }
}