package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    // Constructor myNumber
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }
    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(contacts);
    }

    // Getter metodlariii
    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    // contact eklemekk
    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return false; // listede mevcut diyoruz
        }
        myContacts.add(contact);
        return true;
    }

    // 2. Contact güncellemelerini yapiyoruz
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            return false;
        }
        // yeni icerik listede varsa update yapma
        if (findContact(newContact.getName()) != -1 && !oldContact.getName().equals(newContact.getName())) {
            return false;
        }
        myContacts.set(foundPosition, newContact);
        return true;
    }

    //  contackt silme
    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false;
        }
        myContacts.remove(foundPosition);
        return true;
    }

    // contact objesi ile contact bulma
    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    // isim ile contacvt bulma
    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // isim ile contact dondurme
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    // yazdirma methodu contactlari
    public void printContact() {
        System.out.println("Contact List:");
        for (Contact c : myContacts) {
            System.out.println(c.getName() + " -> " + c.getPhoneNumber());
        }
    }
}
