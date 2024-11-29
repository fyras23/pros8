package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatic {
    float swimmingSpeed;

    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed >= 0 ? swimmingSpeed : 0.0f;
    }

    @Override
    public String toString() {
        return super.toString() + ", Swimming Speed=" + swimmingSpeed + " km/h";
    }
    @Override
    public void swim() {
        System.out.println("The dolphin is swimming at " + swimmingSpeed + " km/h.");

}
}
