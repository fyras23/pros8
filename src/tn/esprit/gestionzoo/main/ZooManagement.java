package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

import java.util.Scanner;

public class ZooManagement {
    private String zooName;
    private int nbrCages;

    public static void main(String[] args) {
        ZooManagement zooManagement = new ZooManagement();
        zooManagement.getUserInput();

        // Reduce number of cages to 3 explicitly
        Zoo myZoo = new Zoo(zooManagement.zooName, "Paris", 3);

        try {
            Animal lion = new Animal("Felidae", "Lion", 5, true);
            myZoo.addAnimal(lion);
            System.out.println("Ajout de l'animal lion : succès.");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        myZoo.displayZooInfo();

        try {
            Animal tiger = new Animal("Felidae", "Tigre", 4, true);
            myZoo.addAnimal(tiger);
            System.out.println("Ajout de l'animal tigre : succès.");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        myZoo.displayZooInfo();

        try {
            Animal elephant = new Animal("Elephantidae", "Éléphant", -10, true);
            myZoo.addAnimal(elephant);
            System.out.println("Ajout de l'animal éléphant : succès.");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        myZoo.displayZooInfo();

        try {
            Animal bear = new Animal("Ursidae", "Bear", 3, true);
            myZoo.addAnimal(bear);
            System.out.println("Ajout de l'animal ours : succès.");
        } catch (ZooFullException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        myZoo.displayZooInfo();


        System.out.println("Le zoo est plein : " + myZoo.isZooFull());



        Aquatic aquaticAnimal = new Aquatic("Pisces", "Shark", 8, false, "Ocean") {
            @Override
            public void swim() {

            }
        };
        Terrestrial terrestrialAnimal = new Terrestrial("Mammal", "Elephant", 15, true, 4);
        Dolphin dolphin = new Dolphin("Mammal", "Dolphin", 10, true, "Ocean", 25.5f);
        Penguin penguin = new Penguin("Bird", "Penguin", 3, false, "Antarctica", 100.0f);
        Dolphin dolphin1 = new Dolphin("Mammal", "Dolphin1", 10, true, "Ocean", 25.5f);
        Dolphin dolphin2 = new Dolphin("Mammal", "Dolphin2", 12, true, "Ocean", 30.5f);
        Penguin penguin1 = new Penguin("Bird", "Penguin1", 3, false, "Antarctica", 100.0f);
        Penguin penguin2 = new Penguin("Bird", "Penguin2", 4, false, "Antarctica", 120.0f);
        myZoo.addAquaticAnimal(dolphin);
        myZoo.addAquaticAnimal(dolphin1);
        myZoo.addAquaticAnimal(dolphin2);
        myZoo.addAquaticAnimal(penguin);
        myZoo.addAquaticAnimal(penguin1);
        myZoo.addAquaticAnimal(penguin2);

        System.out.println("Ajout d'un deuxième Dolphin : " + myZoo.addAquaticAnimal(dolphin));
        System.out.println("Aquatic Animal: " + aquaticAnimal);
        System.out.println("Terrestrial Animal: " + terrestrialAnimal);
        System.out.println("Dolphin: " + dolphin);
        System.out.println("Penguin: " + penguin);
        dolphin.swim();
        penguin.swim();
        aquaticAnimal.swim();
        System.out.println("Max Penguin Swimming Depth: " + myZoo.maxPenguinSwimmingDepth() + " meters");
        myZoo.displayNumberOfAquaticsByType();
        myZoo.displayZooInfo();
    }
    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("Entrez le nom du zoo : ");
            zooName = scanner.nextLine();
            if (zooName.trim().isEmpty()) {
                System.out.println("Le nom du zoo ne peut pas être vide. Veuillez entrer un nom valide.");
            } else {
                break;
            }
        }
        System.out.print("Entrez le nombre de cages (max 25) : ");
        while (true) {
            nbrCages = scanner.nextInt();
            if (nbrCages > 25) {
                System.out.println("Le nombre maximum de cages est 25. Veuillez entrer à nouveau.");
            } else {
                break;
            }
        }

        scanner.close();
    }

}
