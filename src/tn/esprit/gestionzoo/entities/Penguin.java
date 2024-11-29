package tn.esprit.gestionzoo.entities;

public class Penguin extends Aquatic {
    float swimmingDepth;

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth >= 0 ? swimmingDepth : 0.0f;
    }
    public float getSwimmingDepth() {
        return swimmingDepth;
    }
    @Override
    public void swim() {
        System.out.println("The penguin is swimming at a depth of " + swimmingDepth + " meters.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Swimming Depth=" + swimmingDepth + " meters";
    }
}
