package Model;

import Exceptions.InvalidItemException;
import WebsiteParser.InspirationalQuotes;
import org.json.JSONException;
import ui.EntryManager;
import ui.FileManager;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Model {
//    DailyChecklist dailyChecklist = new DailyChecklist();
//    RegularEntries regularEntries = new RegularEntries();
    Scanner scanner = new Scanner(System.in);
    ModelFunctions mf = new ModelFunctions();
    FileManager fileManager= new FileManager();
    EntryManager em;

    //Requires: String input
//Modifies: this, listSize, numdone
//Effects: Using user input creates new entries and changes entries in the list
    public Model() throws IOException, JSONException {
        String option;
        String choice;

        while (true) {
            System.out.println("Please select an option: [A] Daily Health Checklist [B]Normal ToDo List [C]Inspirational Quote");
            choice = scanner.nextLine();
            if (choice.equals("A")) {
                System.out.println("Welcome to Your Daily Checklist");
               em = mf.dailyChecklist;
            }
            if (choice.equals("B")) {
                System.out.println("Welcome to Your Todo List");
                em = mf.regularEntries;
            }
            if (choice.equals("C")){
                InspirationalQuotes quote = new InspirationalQuotes();
                quote.inspiration();
            }
            System.out.println("Please select an option: [1] Add an item  [2] Cross off an item [3] Show all items [4]Save List [5]Load List [6]Move an Item to Another List [6] Quit");
            option = scanner.nextLine();
            System.out.println("you selected: " + option);
            if (option.equals("1")) {
            try {
                System.out.println("Enter the name of the item");
                String addition = scanner.nextLine();
                if (choice.equals("B")) {
                    System.out.println("Enter the date the item is due in format YYYY-MM-DD");
                    String date = scanner.nextLine();
                    mf.enter(addition, date);
                } else mf.enter(addition);
            } catch (DateTimeParseException d) {
                System.out.println("You entered the wrong date format");
            }
        }

        else if (option.equals("2")) {
                try {
                    System.out.println("What task are you done?");
                    em.print();
                    String checkoff = scanner.nextLine();
                    em.remove(checkoff);

                } catch (InvalidItemException e) {
                    System.out.println(e.getMessage());

                } finally {
                    System.out.println("Please be careful when checking off items!");
                }
            } else if (option.equals("3")) {
                mf.printItems(choice);
                mf.sizeofList(choice);
            } else if (option.equals("4")) {
                System.out.println("Please write the name of the file you would like to save");
                String fileName = scanner.nextLine();
                fileManager.modelSave(choice, fileName);
            } else if (option.equals("5")) {
                System.out.println("Please write the name of the file you would like to load");
                String loadName = scanner.nextLine();
                fileManager.modelLoad(choice, loadName);
            } else if (option.equals("6")) {
                System.out.println("Please enter the name of the item you would like to move");
                System.out.println("Items on Daily CheckList:");
                mf.dailyChecklist.print();
                System.out.println("Items on Regular ToDo List");
                mf.regularEntries.print();
                String name = scanner.nextLine();
                mf.moveEntry(name);
            } else if (option.equals("7") || option.equals("quit")) {
                System.out.println("This application will now shut down");
                break;
            }
        }
    }
}





