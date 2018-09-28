package ui;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Model
    {
        Scanner scanner = new Scanner(System.in);
        ListEntries list = new ListEntries();
//Requires: String input
//Modifies: this, listSize, numdone
//Effects: Using user input creates new entries and changes entries in the list
    public Model() {
        String option = "";


        while (true) {

            System.out.println("Please select an option: [1] Add an item  [2] Cross off an item [3] show all items");
            option = scanner.nextLine();
            System.out.println("you selected: " + option);
            if (option.equals("1")) {
                enter(list);
                System.out.println("The number of tasks left to do:");
                System.out.println(list.listentries.size());
            }
            if (option.equals("2")) {
                remove(list);
                System.out.println("The Number of things that are done");
                System.out.println(list.numdone());
            }
            if (option.equals("3")) {
                printItems();
                int lengths = listSize(list.listentries);
                System.out.println(lengths);
            } else if (option.equals("quit")) {
                System.out.println("This application will now shut down");
                break;
            }


        }
    }

//REQUIRES: Non empty list, date must be in format YYYY-MM-DD
//MODIFIES: this
//EFFECTS: Takes the user input and adds it to the TODOList
        private void enter (ListEntries list){
        System.out.println("Enter the name of the item");
        String addition = scanner.nextLine();
        System.out.println("Enter the date the item is due in format YYYY-MM-DD");
        String date= scanner.nextLine();
        LocalDate localDate = LocalDate.parse(date); //this line is referenced from mkyong.com
        list.newEntry(addition, localDate);
        System.out.println("Item Added");

    }

//REQUIRES: non empty list, task already in listofentries
//MODIFIES: this
//EFFECTS: Removes the value
        private void remove (ListEntries list){
        System.out.println("What task are you done?");
        list.print();
        String checkoff = scanner.nextLine();
        list.takeoutEntries(checkoff);
    }

//EFFECTS: prints the list of entries
        private void printItems (){
        list.print();
    }
//EFFECTS: prints the size of the list of entries
        private int listSize (ArrayList < Entry > list1){
        System.out.println("These are the total number of tasks that are on your list");
        return list1.size();
    }
    }
