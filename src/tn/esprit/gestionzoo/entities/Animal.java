package tn.esprit.gestionzoo.entities;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal() {
    }

    public Animal(String family, String name, int age, boolean isMammal) {
        if (age < 0) {
            throw new InvalidAgeException("L'âge d'un animal ne peut pas être négatif: " + name);
        }
        this.family = family;
        this.name = name;
        setAge(age);
        this.isMammal = isMammal;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("L'âge ne peut pas être négatif. Réinitialisation à 0.");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public boolean isMammal() {
        return isMammal;
    }

    @Override
    public String toString() {
        return String.format("Nom: %s, Famille: %s, Âge: %d, Mammifère: %s",
                name, family, age, isMammal ? "Oui" : "Non");
    }

}
