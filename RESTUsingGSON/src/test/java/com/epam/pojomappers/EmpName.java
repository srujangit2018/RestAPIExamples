package com.epam.pojomappers;

public class EmpName
{
    private String lastName;

    private String name;

    public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lastName = "+lastName+", name = "+name+"]";
    }
}
