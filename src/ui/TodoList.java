package ui; //name of package//

import java.util.ArrayList;
import java.util.Scanner;


public class TodoList {
    Scanner scanner = new Scanner(System.in);
    DailyList list = new DailyList();

    public TodoList() {
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
                System.out.println(list.crossofflist.size());
            }
            if (option.equals("3")) {
                printItems(list);
                int lengths = listSize(list.listentries, list.crossofflist);
                System.out.println(lengths);
            } else if (option.equals("quit")) {
                System.out.println("This application will now shut down");
                break;
            }


        }
    }


    public void enter(DailyList list) {
        System.out.println("Enter the item text");
        String addition = scanner.nextLine();
        list.addtoList(addition);

    }


    public void remove(DailyList list) {
        System.out.println("What task are you done?");
        list.print(list.listentries);
        String checkoff = scanner.nextLine();
        list.takeoutEntries(checkoff);
    }


    public void printItems(DailyList list) {
        list.print(list.listentries);
    }

    public int listSize(ArrayList<String> list1, ArrayList<String> list2) {
        System.out.println("These are the total number of tasks from both lists");
        int a = list1.size();
        int b = list2.size();
        return a + b;
    }

    public static void main(String[] args) {
        new TodoList();
    }


}
//code reference from Logging Calculator
