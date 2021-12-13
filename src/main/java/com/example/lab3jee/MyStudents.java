package com.example.lab3jee;

public class MyStudents extends MySelf implements MyVehicle
{
    public String MyMatricNo;
    public String MyProgramCode;
    public String MyCampus;

    public MyStudents(String myName, String myAge, String myHobbies, String myMatricNo, String myProgramCode, String myCampus) {
        super(myName, myAge, myHobbies);
        MyMatricNo = myMatricNo;
        MyProgramCode = myProgramCode;
        MyCampus = myCampus;
    }

    public String getMyMatricNo() {
        return MyMatricNo;
    }

    public String getMyProgramCode() {
        return MyProgramCode;
    }

    public String getMyCampus() {
        return MyCampus;
    }

    public void setMyMatricNo(String myMatricNo) {
        MyMatricNo = myMatricNo;
    }

    public void setMyProgramCode(String myProgramCode) {
        MyProgramCode = myProgramCode;
    }

    public void setMyCampus(String myCampus) {
        MyCampus = myCampus;
    }

    public void printinfo()
    {
        super.printinfo();
        System.out.println("Matric Number : " + MyMatricNo + "\nProgram Code : " + MyProgramCode + "\nCampus : " + MyCampus);
    }
    public String printMyVehicle()
    {
        return super.printMyVehicle();
    }

    public String printCar()
    {
        return super.printCar();
    }

}
