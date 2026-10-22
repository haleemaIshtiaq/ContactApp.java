package se.lexicon;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ContactApp {
    HashMap<String, Contact> contacts = new HashMap<>();

     void main() {

        boolean running = true;
        while (running) {
            IO.println("WElOME TO CONTACT MANAGEMENT APP");
            IO.println("1- Create Contact");
            IO.println("2- Update Contact");
            IO.println("3- Delete Contact");
            IO.println("4- Search Contact");
            IO.println("5- Exit ");
            String choice = IO.readln("Enter your choice: ");
            switch (choice) {
                case "1" -> createContact();
                case "2" -> IO.println("updateContact();");
                case "3" -> IO.println("deleteContact();");
                case "4" -> IO.println("searchContact();");
                case "5" -> {
                    IO.println("Thankyou for using app");
                    running = false;
                }
                default -> IO.println("Invalid choice.");
            }
        }
    }

     //Creating create contact method
     void  createContact()  {
        String email = IO.readln("Enter email: ").trim();
        //Check if email is empty
         if(email.isEmpty()){
             IO.println("Email cannot be empty");
             return;
         }
         //Check if email already exists
         if(contacts.containsKey(email)){
             IO.println("A contact with this email already exist");
         }

         //Create a new contact object
         Contact contact = new Contact();
         contact.email = email;
         contact.name = IO.readln("Enter name: ");
         contact.address = IO.readln("Enter address: ");
         contact.phone = IO.readln("Enter phone: ");

         //Store contact using email as the key
         contacts.put(email,contact);
         IO.println("Contact created successfully");



     }
}

