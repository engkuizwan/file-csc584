package com.example.lab3jee;

import java.io.Serializable;

public class MyFamily extends MySelf implements MyVehicle, Serializable
{
    public String MyDad;
    public String MyMom;
    public String MySiblings;

    public MyFamily()
    {}


    public MyFamily(String id, String MyName, String MyAge, String MyHobbies, String MyDad, String MyMom, String MySiblings )
    {
        super(id,MyName, MyAge, MyHobbies);
        this.MyDad = MyDad;
        this.MyMom = MyMom;
        this.MySiblings = MySiblings;
    }

    public String getMyDad(){ return MyDad;}
    public String getMyMom(){ return MyMom;}
    public String getMySiblings(){ return MySiblings; }

    public void setMyMyDad( String newMyDad ){ MyDad = newMyDad;}
    public void setMyMom ( String newMyMom ){ MyMom = newMyMom;}
    public void setMySiblings ( String newMySiblings ) { MySiblings = newMySiblings;}

    public void printinfo()
    {
        super.printinfo();
        System.out.println("Father : " + MyDad + "\nMother : " + MyMom + "\nSibling : " + MySiblings);

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

