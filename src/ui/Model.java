package ui;

import Exceptions.InvalidItemException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Model
{ DailyChecklist dailyChecklist = new DailyChecklist();
    RegularEntries regularEntries=new RegularEntries();
        Scanner scanner = new Scanner(System.in);
//Requires: String input
//Modifies: this, listSize, numdone
//Effects: Using user input creates new entries and changes entries in the list
    public Model() throws IOException {
        String option;
        String choice;

        while (true) {
            System.out.println("Please select a list: [A] Daily Health Checklist [B]Normal ToDo" );
            choice = scanner.nextLine();
            if (choice.equals("A")){
                System.out.println("Welcome to Your Daily Checklist");
            }
            if (choice.equals("B")) {
                System.out.println("Welcome to Your Todo List"); }
            System.out.println("Please select an option: [1] Add an item  [2] Cross off an item [3] show all items [4]Save List [5]Load List [6] quit");
            option = scanner.nextLine();
            System.out.println("you selected: " + option);
            if (option.equals("1")) {
                try {
                    enter(choice);
                } catch (DateTimeParseException d) {
                    System.out.println("You entered the wrong date format");
                }
            }

            else if (option.equals("2")) {
                try { remove(choice);
                } catch (InvalidItemException e) {
                    System.out.println(e.getMessage());

                }
                finally {
                    System.out.println("Please be careful when checking off items!");
                }
            }
            else if (option.equals("3")) {
                printItems(choice);
                if (choice.equals("A")) {
                    System.out.println("These are the number of items on your list");
                    System.out.println(dailyChecklist.listentries.size());}
              else  if (choice.equals("B")) {
                    System.out.println("These are the number of items on your list");
                    System.out.println(regularEntries.listentries.size());}}
           else if (option.equals("4")) {
                System.out.println("Please write the name of the file you would like to save");
                String fileName = scanner.nextLine();
                if (choice.equals("B")){
                regularEntries.save(fileName+".txt");}
               else if (choice.equals("A")) {
                    dailyChecklist.save(fileName+".txt");
                }}
              else  if (option.equals("5")) {
                    System.out.println("Please write the name of the file you would like to load");
                    String loadName = scanner.nextLine();
                    if (choice.equals("B")){
                        regularEntries.load(loadName+".txt");
                        System.out.println("ToDo List Loaded");}
                 else   if (choice.equals("A")) {
                        dailyChecklist.load(loadName+".txt");
                        System.out.println("Daily Checklist Loaded");
                    }}
             else if (option.equals("6")|| option.equals("quit")) {
                System.out.println("This application will now shut down");
                break;
            }}}





//REQUIRES: Non empty list, date must be in format YYYY-MM-DD
//MODIFIES: this
//EFFECTS: Takes the user input and adds it to the TODOList
        private void enter (String choice) throws DateTimeParseException{
        System.out.println("Enter the name of the item");
        String addition = scanner.nextLine();
        if (choice.equals("B")){
            System.out.println("Enter the date the item is due in format YYYY-MM-DD");
        String date= scanner.nextLine();
        LocalDate localDate = LocalDate.parse(date); //this line is referenced from mkyong.com
        regularEntries.newEntry(addition, localDate);
        System.out.println("Item Added");}
       else if (choice.equals("A")) {
            dailyChecklist.newEntry(addition);

    }}

//REQUIRES: non empty list, task already in listofentries
//MODIFIES: this
//EFFECTS: Removes the value
        private void remove (String choice) throws InvalidItemException {
        System.out.println("What task are you done?");
            if (choice.equals("B")) {
        regularEntries.print();
        String checkoff = scanner.nextLine();
                for (Entry e: regularEntries.listentries){
                if (e.getName().equals(checkoff)){
                    regularEntries.takeoutEntries(checkoff);
                    System.out.println("These are the tasks that are done:");
                    regularEntries.numdone();
                    regularEntries.printDone();
                    return;
                }
            }
            throw new InvalidItemException("To Do List Does Not Contain Item");
            }


        if (choice.equals("A")) {
            dailyChecklist.print();
            String checkoff = scanner.nextLine();
            for (Entry e: dailyChecklist.listentries) {
                if (e.getName().equals(checkoff)) {
                    dailyChecklist.takeoutEntries(checkoff);
                    System.out.println("These are the tasks that you no longer need to worry about for today");
                    dailyChecklist.printDone();
                    dailyChecklist.numdone();
                    return;
                }
            }

            throw new InvalidItemException("To Do List Does Not Contain Item");
                    }

            }



//EFFECTS: prints the list of entries
        private void printItems (String choice){
    if (choice.equals("B")) {
        regularEntries.print();
    }
    if (choice.equals("A")) {
        dailyChecklist.print();
    }}}


