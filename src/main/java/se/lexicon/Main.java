package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

            boolean running = true;
            while(running){
                IO.println("WElOME TO CONTACT MANAGEMENT APP");
                IO.println("1- Create Contact");
                IO.println("2- Update Contact");
                IO.println("3- Delete Contact");
                IO.println("4- Search Contact");
                IO.println("5- Exit ");
                String choice = IO.readln("Enter your choice: ");
            switch (choice) {
                case "1"->IO.println("createContact();");
                case "2"->IO.println("updateContact();");
                case "3"->IO.println("deleteContact();");
                case "4"->IO.println("searchContact();");
                case "5"->{
                    IO.println("Thankyou for using app");
                    running = false;
                }
                default -> IO.println("Invalid choice.");
            }
            }
            }
    }

