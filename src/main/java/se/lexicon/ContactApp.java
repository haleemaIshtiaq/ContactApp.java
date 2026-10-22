package se.lexicon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

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
            IO.println("5- View all Contacts");
            IO.println("6- Exit ");
            String choice = IO.readln("Enter your choice: ");
            switch (choice) {
                case "1" -> createContact();
                case "2" -> updateContact();
                case "3" -> deleteContact();
                case "4" -> searchContact();
                case "5" -> sortContacts();
                case "6" -> {
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
         String name = IO.readln("Enter name: ").trim();
         String address = IO.readln("Enter address: ").trim();
         String phone = IO.readln("Enter  phone: ").trim();


        //Create a new contact object
         Contact contact = new Contact();
         contact.email = email;
         contact.name = name;
         contact.address = address;
         contact.phone = phone;
         //Store contact using email as the key
         if(addContact(contact)) {
             IO.println("Contact created successfully");
         }
         else{
             IO.println("Invalid information or email already exist.");
         }


     }
     void updateContact(){
         String email = IO.readln("Enter email for update: ").trim();

         //Check if contact exists
         if(!contacts.containsKey(email)){
             IO.println("A contact with this email does not exist");
             return;
         }

         String name = IO.readln("Enter new name: ").trim();
         String address = IO.readln("Enter new address: ").trim();
         String phone = IO.readln("Enter new phone: ");


         //Get the existing contact
         Contact contact = new Contact();

         //Update contact information
         contact.email = email;
         contact.name = name;
         contact.address = address;
         contact.phone = phone;

         if(editContact(contact) ){
         IO.println("Contact updated successfully");}
         else{
             IO.println("Information is invalid.");
         }
     }

     void deleteContact(){
         String email = IO.readln("Enter email for deletion: ").trim();

         if(removeContact(email)) {
             IO.println("Contact deleted successfully!");

         }
         else{
             IO.println("A contact with this email does not exist");
         }

     }
     void searchContact(){
         String email = IO.readln("Enter email for searching: ").trim();
         Contact contact = findContactByEmail(email);
         //Check if contact exists
         if(contact == null){
             IO.println("A contact with this email does not exist");
             return;
         }

         //Display contact information
         IO.println("\n=========Contact Details=========");
         IO.println("Name: " +contact.name);
         IO.println("Email: " +contact.email);
         IO.println("Address: " +contact.address);
         IO.println("Phone: " +contact.phone);


     }
     boolean isValidName(String name){
         return !name.isBlank();
     }
     boolean isValidEmail(String email){
        return email.matches( "^[A-Za-z0-9-%+-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$");
     }
     boolean isValidAddress(String address){
         return !address.isBlank();

     }
     boolean isValidPhone(String phone){
         return phone.matches("\\+?[0-9 ]{7,20}");
     }

     void sortContacts(){
         //Check if there is any contact
         if(contacts.isEmpty()){
             IO.println("No contacts available.");
             return;
         }
         //sort all the contact names
         ArrayList<String> names = new ArrayList<>();
         for(Contact contact : contacts.values()){
             names.add(contact.name);
         }
         //Sort names alphabetically
         Collections.sort(names,String.CASE_INSENSITIVE_ORDER);

         //To prevent duplicate printing
         HashSet<String> displayedEmails = new HashSet<>();
         //Display all contacts in alphabetical order
         for (String name : names){
             for(Contact contact : contacts.values()){
                 if(contact.name.equals(name)&& displayedEmails.add(contact.email)){
                     IO.println("Name: " +contact.name);
                     IO.println("Email: " +contact.email);
                     IO.println("Address: " +contact.address);
                     IO.println("Phone: " +contact.phone);
                     IO.println("-----------------------------");

                 }
             }
         }




     }

     boolean addContact(Contact contact){
         if(contact == null){
             return false;
         }
         if(!isValidName(contact.name)||!isValidEmail(contact.email)||!isValidAddress(contact.address)||!isValidPhone(contact.phone)){
            return false;
         }
         if(contacts.containsKey(contact.email)){
             return false;
         }
         contacts.put(contact.email,contact);
         return true;
     }

    boolean editContact(Contact contact){
        if(contact == null){
            return false;
        }
        if(!contacts.containsKey(contact.email)){
            return false;
        }
        if(!isValidName(contact.name)||!isValidAddress(contact.address)||!isValidPhone(contact.phone)){
            return false;
        }

        contacts.put(contact.email,contact);
        return true;
    }

    Contact findContactByEmail(String email){
         return contacts.get(email);
    }

    boolean removeContact(String email) {

        if (!contacts.containsKey(email)) {
            return false;
        }
        contacts.remove(email);
        return true;
    }

}

