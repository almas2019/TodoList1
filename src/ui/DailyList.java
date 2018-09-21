package ui;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;

public class DailyList {



    ArrayList<String> listentries = new ArrayList<>();

    ArrayList<String> crossofflist = new ArrayList<>();


    public void addtoList(String value) {
        if (listentries.contains(value))
            System.out.println("List already contains the value");
        else {
            listentries.add(value);
            System.out.println("Item Added");
        }
    }




    public void takeoutEntries(String value) {
        listentries.remove(value);
        crossofflist.add(value);
        System.out.println("Item Moved to Done!");
    }


    public void print(ArrayList<String> listentries) {
        System.out.println("These are the tasks currently on your lists:");
        System.out.println("Not Done");
        System.out.println(listentries);
        System.out.println("Done");
        System.out.println(crossofflist);
    }


}





