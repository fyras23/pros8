package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private Aquatic[] aquaticAnimals;
    private String name;
    private String city;
    private int nbrCages;
    private int animalCount;
    private int aquaticCount;

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;

        if (nbrCages > 25) {
            System.out.println("Le nombre de cages ne peut pas dépasser 25. Initialisation à 25.");
            this.nbrCages = 25;
        } else {
            this.nbrCages = nbrCages;
        }
        this.animals = new Animal[this.nbrCages];
        this.aquaticAnimals = new Aquatic[10];
        this.animalCount = 0;
        this.aquaticCount = 0;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    public Aquatic[] getAquaticAnimals() {
        return aquaticAnimals;
    }

    public void setAquaticAnimals(Aquatic[] aquaticAnimals) {
        this.aquaticAnimals = aquaticAnimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Le nom du zoo ne peut pas être vide. Réinitialisation à 'Zoo par défaut'.");
            this.name = "Zoo par défaut";
        } else {
            this.name = name;
        }
    }

    public void addAnimal(Animal animal) {
        if (isZooFull()) {
            throw new ZooFullException("Impossible d'ajouter " + animal.getName() + ": le zoo est plein.");
        }

        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                System.out.println("L'animal " + animal.getName() + " est déjà présent dans le zoo.");
                return;
            }
        }

        animals[animalCount] = animal;
        animalCount++;
    }


    public boolean addAquaticAnimal(Aquatic aquatic) {
        if (aquaticCount >= 10) {
            System.out.println("Impossible d'ajouter " + aquatic.getName() + ": le tableau des animaux aquatiques est plein.");
            return false;
        }

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i].getName().equals(aquatic.getName())) {
                System.out.println("L'animal aquatique " + aquatic.getName() + " est déjà présent dans le zoo.");
                return false;
            }
        }

        aquaticAnimals[aquaticCount] = aquatic;
        aquaticCount++;
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                for (int j = i; j < animalCount - 1; j++) {
                    animals[j] = animals[j + 1];
                }
                animals[animalCount - 1] = null;
                animalCount--;
                return true;
            }
        }
        System.out.println("L'animal " + animal.getName() + " n'est pas trouvé dans le zoo.");
        return false;
    }

    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    public void displayAnimals() {
        System.out.println("Animaux dans le zoo :");
        for (Animal animal : animals) {
            if (animal != null) {
                System.out.println(animal);
            }
        }
    }

    public void displayAquaticAnimals() {
        System.out.println("Animaux aquatiques dans le zoo :");
        for (Aquatic aquatic : aquaticAnimals) {
            if (aquatic != null) {
                System.out.println(aquatic);
            }
        }
    }

    public void displayZooInfo() {
        System.out.println("Nom du zoo: " + name);
        System.out.println("Ville: " + city);
        System.out.println("Nombre de cages: " + nbrCages);
        System.out.println("Nombre d'animaux : " + animalCount);
        System.out.println("Nombre d'animaux aquatiques : " + aquaticCount);
        displayAnimals();
        displayAquaticAnimals();
    }
    public float maxPenguinSwimmingDepth() {
        float maxDepth = -1;

        for (Aquatic aquaticAnimal : aquaticAnimals) {
            if (aquaticAnimal instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimal;
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }}}
        return maxDepth;}
    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;

        for (Aquatic aquaticAnimal : aquaticAnimals) {
            if (aquaticAnimal instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimal instanceof Penguin) {
                penguinCount++;
            }
        }

        System.out.println("Number of Dolphins: " + dolphinCount);
        System.out.println("Number of Penguins: " + penguinCount);
    }
}

