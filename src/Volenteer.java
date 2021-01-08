public class Volenteer {

    static int nextId=1000; //every vol will get a uniqe id
    //main attributes
    int id;
    String name;
    String phoneNum;

    //language attribute
    boolean russian;

    //ability attributes
    boolean tech;
    boolean houseRepair;

    //getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhoneNum() {return phoneNum; }
    public boolean isRussian() { return russian; }
    public boolean isTech() {return tech; }
    public boolean isHouseRepair() { return houseRepair; }
    //setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }
    public void setTech(boolean tech) { this.tech = tech; }
    public void setRussian(boolean russian) { this.russian = russian; }
    public void setHouseRepair(boolean houseRepair) { this.houseRepair = houseRepair; }



    //constractor
    public Volenteer(String name, String phoneNum,boolean russian, boolean tech, boolean houseRepair) {
        this.id = nextId;
        this.name = name;
        this.phoneNum = phoneNum;
        this.russian = russian;
        this.tech = tech;
        this.houseRepair = houseRepair;
        nextId++;
    }
}
