package island.com.Animals.Predators;

import island.com.Map.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Eagle extends Predators{
    private static final double BASE_WEIGHT = 6.0; // Базова вага виду
    private static final int MAX_COUNT_PER_CELL = 20; // Макс. на клітинці
    private static final int MAX_SPEED = 3; // Макс. швидкість (клітинок за хід)
    private static final double FOOD_CAPACITY = 1.0; // Потрібно їжі для насичення

    public Eagle(int startX, int startY){
        super(startX,startY);
        setInitialSaturation(getFoodCapacity() * (0.5 + ThreadLocalRandom.current().nextDouble() * 0.5));
    }


    public void eat(Location currentLocation){
        super.eat(currentLocation);
    }

    @Override
    public String getSymbol() {
        return "🦅";
    }

    @Override
    public double getFoodCapacity() {
        return FOOD_CAPACITY;
    }

    @Override
    public int getMaxCountPerCell() {
        return MAX_COUNT_PER_CELL;
    }

    @Override
    public double getWeight() {
        return BASE_WEIGHT;
    }

    @Override
    public String getSpeciesName() {
        return "Eagle";
    }

    @Override
    protected int getMaxSpeed() {
        return MAX_SPEED;
    }

    @Override
    protected double getReproductionChance() {
        return 0.2;
    }

}
