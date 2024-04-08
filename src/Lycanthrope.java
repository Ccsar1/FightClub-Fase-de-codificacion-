public class Lycanthrope extends Character {
    public Lycanthrope(String name, int power, int hp, SpecialAbility specialAbility, int height, int weight) {
        super(name, power, hp, specialAbility, TCharacter.Lycanthrope);
        this.height = height;
        this.weight = weight;
    }
    private int height;
    private int weight;
    public int getHeight() {
        return this.height;
    }
    public int getWeight() {
        return this.weight;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }
}