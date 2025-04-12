package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders
{
    @DataProvider//add some contacts
    public Iterator<Object[]> addNewContact()
    {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Teddy","Black","1234567890","qwerty@gmail.com","Holon","QA"});
        list.add(new Object[]{"Meddy","Black","1234567894","qwerty@gmail.com","Holon","QA"});
        list.add(new Object[]{"Keddy","Black","1234567895","qwerty@gmail.com","Holon","QA"});
        return list.iterator();
    }


    @DataProvider//add some contacts from csv file
    public Iterator<Object[]>addNewContactWithCsv() throws IOException {
        List<Object[]>list=new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/ContactData.csv")));
        String line = reader.readLine();

        while (line!=null)
        {
        String[] split = line.split(",");
        list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setPhone(split[2]).setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
        line=reader.readLine();
        }

        return list.iterator();
    }




}
