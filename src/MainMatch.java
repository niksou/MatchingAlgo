import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class MainMatch {


    //function in order to return two d array with boolean values in order to use it to find
    //MBM in main function that takes 2 d array and returns max matches it can make
    public static boolean [] [] twoDBoolean(Volenteer [] volList , Elder [] elderList){

        boolean [][] twoDBool = new boolean [volList.length][elderList.length];

        for (int i=0; i < volList.length;i++) {//volenteers
            for(int j=0; j < elderList.length; j++){//elders
                if (volList[i] == null)//the array has ended return the bool 2D arr
                    return twoDBool;

                if(elderList[j].isRussian()&&!volList[i].isRussian()) {//making sure they speaking the same lang
                    twoDBool[i][j] = false;
                }

                else {
                    int help = elderList[j].getHelp();//getting
                    switch (help) {
                        case 0:
                            twoDBool[i][j] = false;//no call was made
                            break;
                        case 1://technical call
                            if (!volList[i].isTech()) {
                                twoDBool[i][j] = false;//cannot make match
                            } else {
                                twoDBool[i][j] = true;//match was made
                            }
                            break;
                        case 2://house repair call
                            if (!volList[i].isHouseRepair()) {
                                twoDBool[i][j] = false;//cannot make match
                            } else {
                                twoDBool[i][j] = true;//match was made
                            }
                            break;
                        case 3://general call
                            twoDBool[i][j] = true;//match was made
                            break;
                    }

                }
            }
        }

        return twoDBool;
    }



    public static void printVol(Volenteer [] volList){//function to print all volenteers
        if(volList[0] == null)
            return;
        System.out.println("List of volenteers : ");
         for(int j = 0 ; j < volList.length;j++){
             if(volList[j] == null)
                 return;
             System.out.println("Name :" + volList[j].getName() +
                     "\nPhone Number : "+ volList[j].getPhoneNum() +
                     "\nID : "+volList[j].getId() +
                     "\nList number : "+ j);
             if(volList[j].isRussian())
                System.out.println("Speaks hebrew and russian");

             if(volList[j].isTech()&&volList[j].isHouseRepair())
                 System.out.print("speciallity : Technical , and house repair \n ");
             else if (volList[j].isTech())
                 System.out.print("speciallity : Technical \n");
             else if (volList[j].isHouseRepair())
                 System.out.print("speciallity : House repair \n");
             else
                 System.out.println("No speciality \n");

         }

    }

    public static void printElder(Elder [] elderList){//function to print all Elders
        if(elderList[0] == null)
            return;
        System.out.println("List of Elders : ");

        for(int j = 0 ; j < elderList.length;j++){
            if(elderList[j] == null)
                return;

            System.out.println("Name :" + elderList[j].getName() +
                    "\nPhone Number : "+ elderList[j].getPhoneNum() +
                    "\nID : "+elderList[j].getId() +
                    "\nAdress of elder : "+elderList[j].getAddress() +
                    "\nList number : " + j);

            if(elderList[j].isRussian()&&elderList[j].isHebrew())
                System.out.println("Speaks hebrew and russian");
            else
                System.out.println("Speaks only russian ");




        }

    }

    public static void makeMatch(Elder elder, int call , Volenteer [] volList) {


        for (int i = 0; i <= volList.length; i++) {
            if (volList[i] == null)
                return;

            if (elder.isRussian() && !volList[i].isRussian()) {//making sure they are speaking same lang
                System.out.println("hello : " + volList[i].getName() + " we cannot make match because lang differ");
            } else if (call == 1 && !volList[i].isTech()) {//making sure right knowledge exists
                System.out.println("hello : " + volList[i].getName() + " cannot make match because lack of knowledge (tech) ");
            } else if (call == 2 && !volList[i].isHouseRepair()) {
                System.out.println("cannot make match because lack of knowledge (house repair) ");
            } else {
                System.out.println(volList[i].getName() + " you have been assigned to help " + elder.getName() + " he lives in : " +
                        elder.getAddress() + " and his phone number is : " + elder.getPhoneNum());
            }

        }


    }

    public static void main(String[] args) throws Exception {





       // int choise=0;

//        while(choise!=4){//main menu
//
//            System.out.println("Welcome to our elder-vol Project ! \n"+
//                    "Please select what action would you like to take : \n"+
//                    "1 - Add new volnteer to list \n"+
//                    "2 - Add new elder to list \n"+
//                    "3 - Make request for elder \n"+
//                    "4 - EXIT ");
//            choise=inputScan.nextInt();
//            inputScan.nextLine();//this line has been added to correct scanner skipping first nextline request
//
//
//            switch(choise){
//                case 1://adding a volenteer
//                    String name;
//                    String phoneNum;
//                    boolean russian;
//                    boolean tech;
//                    boolean houseRepair;
//
//                    System.out.println("You have selected to add new vol for our list \n"+
//                            "please enter volnteer full name : ");
//                    name=inputScan.nextLine();
//
//                    System.out.println("please enter volnteer phone number  : ");
//                    phoneNum=inputScan.nextLine();
//
//                    System.out.println("does the volenteer speaks russian ?  Y/N ");
//                    char ans = inputScan.next().charAt(0);
//                    if(ans=='y'||ans=='Y')
//                        russian=true;
//                    else
//                        russian=false;
//
//                    System.out.println("Does the volenteer has technical knowledge ? Y/N ");
//                    ans = inputScan.next().charAt(0);
//                    if(ans=='y'||ans=='Y')
//                        tech=true;
//                    else
//                        tech=false;
//
//                    System.out.println("Does the volenteer has House repair knowledge ? Y/N ");
//                    ans = inputScan.next().charAt(0);
//                    if(ans=='y'||ans=='Y')
//                        houseRepair=true;
//                    else
//                        houseRepair=false;
//
//                    volList[nextList]= new Volenteer(name,phoneNum,russian,tech,houseRepair);
//                    nextList++;//setting next place in vol array availiblle for next entry
//                    break;
//                 case(2) : //add new elder to list
//                     String elderName;
//                     String elderPhoneNum;
//                     String adress;
//                     boolean elderRussian;
//                     boolean hebrew;
//
//
//
//                     System.out.println("You have selected to add new elder for our list \n"+
//                             "please enter elder full name : ");
//                     elderName=inputScan.nextLine();
//
//                     System.out.println("please enter elder phone number  : ");
//                     elderPhoneNum=inputScan.nextLine();
//
//                     System.out.println("does the elder speaks hebrew ?  Y/N ");
//                     char eldAns = inputScan.next().charAt(0);
//                     if(eldAns=='y'||eldAns=='Y')
//                         hebrew=true;
//                     else
//                         hebrew=false;
//                     inputScan.nextLine();//this line has been added to correct scanner skipping first nextline request
//                     System.out.println("does the elder speaks russian ?  Y/N ");
//                     eldAns = inputScan.next().charAt(0);
//                     if(eldAns=='y'||eldAns=='Y')
//                         elderRussian=true;
//                     else
//                         elderRussian=false;
//                     inputScan.nextLine();//this line has been added to correct scanner skipping first nextline request
//
//                     System.out.println("where does the elder lives ? please provide full adress of elder :");
//                     adress=inputScan.nextLine();
//
//                     elderList[elderNextList]= new Elder(elderName,elderPhoneNum,hebrew,elderRussian,adress);
//                     elderNextList++;//setting next place in vol array availiblle for next entry
//                     break;
//
//
//            }
//
//
//
//        }

//        printVol(volList);
//        printElder(elderList);
    }



}
