package se.lexicon;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ContactApp {
    HashMap<String, Contact> contacts = new HashMap<>();

     void main() {

        boolean running = true;
        while (running) {
            IO.println("\n\nWElOME TO CONTACT MANAGEMENT APP");
            IO.println("1- Create Contact");
            IO.println("2- Update Contact");
            IO.println("3- Delete Contact");
            IO.println("4- Search Contact");
            IO.println("5- Exit ");
            String choice = IO.readln("Enter your choice: ");
            switch (choice) {
                case "1" -> createContact();
                case "2" -> updateContact();
                case "3" -> deleteContact();
                case "4" -> searchContact();
                case "5" -> {
                    IO.println("Thank you for using app");
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
             return;
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
     void updateContact(){
         String email = IO.readln("Enter email for update: ").trim();
         //Check if contact exists
         if(!contacts.containsKey(email)){
             IO.println("A contact with this email does not exist");
             return;
         }
         //Get the existing contact
         Contact contact = contacts.get(email);

         //Update contact information
         contact.name = IO.readln("Enter new name: ");
         contact.address = IO.readln("Enter new address: ");
         contact.phone = IO.readln("Enter new phone: ");

         IO.println("Contact updated successfully");
     }

     void deleteContact(){
         String email = IO.readln("Enter email for deletion: ").trim();
         //Check if contact exists
         if(!contacts.containsKey(email)){
             IO.println("A contact with this email does not exist");
             return;
         }
         //Delete contact from HashMap
         contacts.remove(email);
         IO.println("Contact deleted successfully!");

     }
     void searchContact(){
         String email = IO.readln("Enter email for searching: ").trim();
         //Check if contact exists
         if(!contacts.containsKey(email)){
             IO.println("A contact with this email does not exist");
             return;
         }
         //Retrieve contact from HashMap
         Contact contact = contacts.get(email);
         //Display contact information
         IO.println("\n=========Contact Details=========");
         IO.println("Name: " +contact.name);
         IO.println("Email: " +contact.email);
         IO.println("Address: " +contact.address);
         IO.println("Phone: " +contact.phone);


     }
}

