package ui;

import Exceptions.InvalidItemException;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Model
{ DailyChecklist dailyChecklist = new DailyChecklist();
    RegularListEntries regularEntries=new RegularListEntries();
        Scanner scanner = new Scanner(System.in);
        ModelFunctions mf = new ModelFunctions();
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
            System.out.println("Please select an option: [1] Add an item  [2] Cross off an item [3] Show all items [4]Save List [5]Load List [6]Move an Item to Another List [6] Quit");
            option = scanner.nextLine();
            System.out.println("you selected: " + option);
            if (option.equals("1")) {
                try {
                    System.out.println("Enter the name of the item");
                    String addition = scanner.nextLine();
                    if (choice.equals("B")){
                    System.out.println("Enter the date the item is due in format YYYY-MM-DD");
                    String date= scanner.nextLine();
                    mf.enter(addition,date);
                    }
                    else mf.enter(addition);
                } catch (DateTimeParseException d) {
                    System.out.println("You entered the wrong date format");
                }
            }

            else if (option.equals("2")) {
                try {
                    System.out.println("What task are you done?");
                    String checkoff = scanner.nextLine();
                    mf.remove(choice, checkoff);
                } catch (InvalidItemException e) {
                    System.out.println(e.getMessage());

                }
                finally {
                    System.out.println("Please be careful when checking off items!");
                }
            }
            else if (option.equals("3")) {
                mf.printItems(choice);
                mf.sizeofList(choice);
            }
           else if (option.equals("4")) {
                System.out.println("Please write the name of the file you would like to save");
                String fileName = scanner.nextLine();
                mf.modelSave(choice, fileName);
            }
            else  if (option.equals("5")) {
                    System.out.println("Please write the name of the file you would like to load");
                    String loadName = scanner.nextLine();
                    mf.modelLoad(choice,loadName);
            }
            else if(option.equals("6")) {
                System.out.println("Please enter the name of the item you would like to move");
                System.out.println("Items on Daily CheckList:");
                dailyChecklist.print();
                System.out.println("Items on Regular ToDo List");
                regularEntries.print();
                String name= scanner.nextLine();
                mf.moveEntry(name);
            }
             else if (option.equals("7")|| option.equals("quit")) {
                System.out.println("This application will now shut down");
                break;
            }}}}





