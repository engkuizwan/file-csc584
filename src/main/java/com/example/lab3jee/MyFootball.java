package com.example.lab3jee;

public class MyFootball extends MySelf  implements MyVehicle, java.io.Serializable
{
    public String MyTeam;
    public String MyCoach;
    public String MyPlayer;
    public String MyFormation;
    public String MyPosition;

    public MyFootball()
    {}

    public MyFootball(String id, String MyName, String MyAge, String MyHobbies, String myTeam, String myCoach, String myPlayer, String myFormation, String myPosition) {
        super(id, MyName, MyAge, MyHobbies);
        MyTeam = myTeam;
        MyCoach = myCoach;
        MyPlayer = myPlayer;
        MyFormation = myFormation;
        MyPosition = myPosition;
    }

    public String getMyTeam() {
        return MyTeam;
    }

    public void setMyTeam(String myTeam) {
        MyTeam = myTeam;
    }

    public String getMyCoach() {
        return MyCoach;
    }

    public void setMyCoach(String myCoach) {
        MyCoach = myCoach;
    }

    public String getMyPlayer() {
        return MyPlayer;
    }

    public void setMyPlayer(String myPlayer) {
        MyPlayer = myPlayer;
    }

    public String getMyFormation() {
        return MyFormation;
    }

    public void setMyFormation(String myFormation) {
        MyFormation = myFormation;
    }

    public String getMyPosition() {
        return MyPosition;
    }

    public void setMyPosition(String myPosition) {
        MyPosition = myPosition;
    }

    public void printinfo()
    {
        super.printinfo();
        System.out.println("Favourite Football Club : " + MyTeam + "\nFavourite Coach : " + MyCoach + "\nFavourite Player : " + MyPlayer +
                "\nFavourite Formation : " + MyFormation + "\nFavourite Position : " + MyPosition);

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
