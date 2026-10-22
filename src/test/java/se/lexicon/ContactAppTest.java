package se.lexicon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactAppTest {

    @Test
    @DisplayName("Add Valid contact (Happy Path)")
    void testAddValidContact(){
        //Arrange
        ContactApp app = new ContactApp();
        Contact contact = new Contact();
        contact.name= "Ali";
        contact.email = "ali@gmail.com";
        contact.address = "Skövde";
        contact.phone = "0701234567";
        boolean expected = true;

        //Act
        boolean actual = app.addContact(contact);

        //Assert
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Add duplicate email")
    void testAddDuplicateContact(){
        //Arrange
        ContactApp app = new ContactApp();
        Contact contact = new Contact();
        contact.name= "Ali";
        contact.email = "ali@gmail.com";
        contact.address = "Skövde";
        contact.phone = "0701234567";

        app.addContact(contact);
        boolean expected = false;

        //Act
        boolean actual = app.addContact(contact);

        //Assert
        assertEquals(expected,actual);
    }


    @Test
    @DisplayName("Updating existing contact (Happy Path)")
    void testUpdatingExistingContact(){
        //Arrange
        ContactApp app = new ContactApp();

        Contact contact = new Contact();
        contact.name= "Ali";
        contact.email = "ali@gmail.com";
        contact.address = "Skövde";
        contact.phone = "0701234567";
        app.addContact(contact);
        Contact updatedContact = new Contact();
        updatedContact.name="Ahmed";
        updatedContact.email="ali@gmail.com";
        updatedContact.address="Stockholm";
        updatedContact.phone="0709876254";

        boolean expected = true;

        //Act
        boolean actual = app.editContact(updatedContact);

        //Assert
        assertEquals(expected,actual);
        Contact savedContact = app.contacts.get("ali@gmail.com");
        assertEquals("Ahmed",savedContact.name);
        assertEquals("0709876254",savedContact.phone);

    }
    @Test
    @DisplayName("Updating non existing contact")
    void testUpdateNonExistingContact(){
        //Arrange
        ContactApp app = new ContactApp();

        Contact contact = new Contact();
        contact.name= "Ali";
        contact.email = "ali@gmail.com";
        contact.address = "Skövde";
        contact.phone = "0701234567";

        boolean expected = false;

        //Act
        boolean actual = app.editContact(contact);

        //Assert
        assertEquals(expected,actual);
        assertEquals(false,app.contacts.containsKey(contact.email));


    }
    @Test
    @DisplayName("Search existing contact")
    void testSearchExistingContact(){
        //Arrange
        ContactApp app = new ContactApp();
        Contact contact = new Contact();
        contact.name= "Ali";
        contact.email = "ali@gmail.com";
        contact.address = "Skövde";
        contact.phone = "0701234567";
        app.addContact(contact);
        Contact expected = contact;
        //Act
        Contact actual = app.findContactByEmail("ali@gmail.com");
        //Assert
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Search non existing contact")
    void testSearchNonExistingContact(){
        //Arrange
        ContactApp app = new ContactApp();
        String email = "ali@gmail.com" ;
        Contact expected = null;
        //Act
        Contact actual = app.findContactByEmail(email);
        //Assert
        assertEquals(expected,actual);

    }
    @Test
    @DisplayName("Delete existing contact(happy path)")
    void testDeleteExistingContact(){
        //Arrange
        ContactApp app = new ContactApp();
        Contact contact = new Contact();
        contact.name= "Ali";
        contact.email = "ali@gmail.com";
        contact.address = "Skövde";
        contact.phone = "0701234567";
        app.addContact(contact);
        boolean expected = true;

        //Act
        boolean actual = app.removeContact(contact.email);

        //Assert (verify)
        assertEquals(expected,actual);
        assertEquals(false,app.contacts.containsKey(contact.email));


    }
    @Test
    @DisplayName("Delete non existing contact(happy path)")
    void testDeleteNonExistingContact(){
        //Arrange
        ContactApp app = new ContactApp();
        String email = "ali@gmail.com" ;
        boolean expected = false;
        //Act
        boolean actual = app.removeContact(email);
        //Assert
        assertEquals(expected,actual);
        assertEquals(false,app.contacts.containsKey(email));

    }
    }


