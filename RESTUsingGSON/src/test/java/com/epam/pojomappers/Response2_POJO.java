package com.epam.pojomappers;

public class Response2_POJO
{
    private Details[] Details;

    public Details[] getState ()
    {
        return Details;
    }

    public void setState (Details[] Details)
    {
        this.Details = Details;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Details = "+Details+"]";
    }
}
			
			