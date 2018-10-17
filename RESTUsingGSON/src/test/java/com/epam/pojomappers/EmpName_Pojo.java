package com.epam.pojomappers;
public class EmpName_Pojo
{
    private EmpName[] Name;

    public EmpName[] getName ()
    {
        return Name;
    }

    public void setName (EmpName[] Name)
    {
        this.Name = Name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Name = "+Name+"]";
    }
}
