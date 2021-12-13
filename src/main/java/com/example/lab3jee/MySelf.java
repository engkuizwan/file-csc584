package com.example.lab3jee;

public class MySelf implements MyVehicle
{
    public String MyName;
    public String MyAge;
    public String MyHobbies;

    public MySelf(String myName, String myAge, String myHobbies) {
        MyName = myName;
        MyAge = myAge;
        MyHobbies = myHobbies;
    }

    public String getMyName() {
        return MyName;
    }

    public String getMyAge() {
        return MyAge;
    }

    public String getMyHobbies() {
        return MyHobbies;
    }

    public void setMyName(String myName) {
        MyName = myName;
    }

    public void setMyAge(String myAge) {
        MyAge = myAge;
    }

    public void setMyHobbies(String myHobbies) {
        MyHobbies = myHobbies;
    }

    public void printinfo()
    {
        System.out.println("Name : " + MyName + "\nAge: " + MyAge + "\nHobbies : " + MyHobbies + "\nVehicle Type : " +
                            MyVehicleType + "\nVehicle Brand : " + MyVehicleBrand + "\nVehicle ID : " + MyVehicleID);
    }


    protected String printMyVehicle()
    {
        String data = null;

        data = "<p>" + "Vehicle Brand : " + MyVehicleBrand + "</p>";
        data += "<p>" + "Vehicle Type : " + MyVehicleType + "</p>";
        data += "<p>" + "Vehicle Id : " + MyVehicleID + "</p>";

        return data;

    }

    public String printCar()
    {
        return "<p>" + "Vehicle Type :" + MyVehicleType + "</p>" +
                "<p>" + "Vehicle Brand : " + MyVehicleBrand + "</p>" +
                "<p>" + "Vehicle Id : " + MyVehicleID + "</p>";
    }
}

