package Model;

import Exceptions.InvalidItemException;
import Exceptions.InvalidListException;
import WebsiteParser.InspirationalQuotes;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import ui.EntryManager;
import ui.FileManager;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Model {

    Scanner scanner = new Scanner(System.in);
    ModelFunctions mf = new ModelFunctions();
    FileManager fileManager= new FileManager();
    EntryManager em;
private String DAILY_CHECKLIST = mf.dailyChecklist.getListName();
private String REGULAR_LIST = mf.regularEntries.getListName();
    //Requires: String input
//Modifies: this, listSize, numdone
//Effects: Using user input creates new entries and changes entries in the list
    public Model() throws IOException, JSONException, ParseException {
        String option;
        String choice;

        while (true) {
            System.out.println("Please select an option: [A] Daily Checklist [B]Normal ToDo List [C]Inspirational Quote");

                try {
                    choice = scanner.nextLine();

                    if (choice.equals("A")) {
                        System.out.println("Welcome to Your Daily Checklist");
                        em = mf.dailyChecklist;
                    } else if (choice.equals("B")) {
                        System.out.println("Welcome to Your Todo List");
                        em = mf.regularEntries;
                    } else if (choice.equals("C")) {
                        InspirationalQuotes quote = new InspirationalQuotes();
                        quote.inspiration();
                        throw new InvalidListException("Now onto the Lists!");

                    } else if (!(choice.equals("A")) || !(choice.equals("B"))) {
                        throw new InvalidListException("This is not a valid list choice");
                    }
                }
            catch (InvalidListException i) {
                System.out.println(i.getMessage());
                continue;
            }

            System.out.println("Please select an option: [1] Add an item  [2] Cross off an item [3] Show all items [4]Save List [5]Load List [6]Move an Item to Another List [7] Quit");
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
                   em.whatDone();
                    String checkoff = scanner.nextLine();
                    if (em.getListName().equals(DAILY_CHECKLIST)){
                    mf.dailyChecklist.checkOffDL(checkoff);}
                    if(em.getListName().equals(REGULAR_LIST)){
                        mf.regularEntries.checkOffRL(checkoff);
                    }
                    em.taskDonePrint();

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
                fileManager.save(fileName,em);

            } else if (option.equals("5")) {
                System.out.println("Please write the name of the file you would like to load");
                String loadName = scanner.nextLine();
                fileManager.parse(loadName,em);
            } else if (option.equals("6")) {
                System.out.println("Please enter the name of the item you would like to move");
                System.out.println("Items on Daily CheckList:");
                mf.dailyChecklist.print();
                System.out.println("Items on Regular ToDo List");
                mf.regularEntries.print();
                String name = scanner.nextLine();
                    try {
                        mf.moveEntry(name);
                    } catch (InvalidItemException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (option.equals("7") || option.equals("quit")) {
                System.out.println("This application will now shut down");
                break;
            }

        }
    }
}





