package island.com.Animals.Predators;

import island.com.Animals.Animal;
import island.com.Config;
import island.com.Map.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predators extends Animal {
    public Predators(int startX, int startY) {
        super(startX, startY);
    }

//    public void eat(Location currentLocation){
//        if(!this.isAlive() || getCurrentSaturation() >= getFoodCapacity()){
//            return;
//        }
//
//        Map<String, Integer> predatorEatingMap = Config.EAT_PROBABILITIES.get(this.getSpeciesName());
//        if(predatorEatingMap  == null || predatorEatingMap .isEmpty()){
//            return;
//        }
//        List<Animal> potentialPrey = new ArrayList<>();
//        for(Animal animal : currentLocation.getAnimals()) {
//            if (animal.isAlive() && animal != this && predatorEatingMap.containsKey(animal.getSpeciesName())){
//                potentialPrey.add(animal);
//            }
//        }
//        if(!potentialPrey.isEmpty()) {
//            Animal target = potentialPrey.get(ThreadLocalRandom.current().nextInt(potentialPrey.size()));
//            String targetSpecies = target.getSpeciesName();
//
//            int probability = predatorEatingMap.get(targetSpecies);
//            if(ThreadLocalRandom.current().nextInt(100) < probability) {
//                double foodWeight = target.getWeight();
//                double neededSaturation = getFoodCapacity() - getCurrentSaturation();
//                double gainedSaturation = Math.min(neededSaturation, foodWeight);
//                addSaturation(gainedSaturation);
//                target.die();
//                System.out.println(this.getSymbol() + " ate " + target.getSymbol() + " at (" + this.x + "," + this.y + ")");
//            }
//        }
//    }
public void eat(Location location){
    if (!this.isAlive() || getCurrentSaturation() >= getFoodCapacity()) {
        return;
    }
    Map<String, Integer> predatorEatingMap = Config.EAT_PROBABILITIES.get(this.getSpeciesName());
    List<Animal> animalsLoc = location.getAnimals();
    List<Animal> potentialPrey = new ArrayList<>(animalsLoc);
    for(Animal target : potentialPrey) {
        if(this != target && predatorEatingMap.containsKey(target.getSpeciesName())) {
            int probability = predatorEatingMap.get(target.getSpeciesName());
            if (ThreadLocalRandom.current().nextInt(100) < probability) {
                double foodWeight = target.getWeight();
                double neededSaturation = getFoodCapacity() - getCurrentSaturation();
                double gainedSaturation = Math.min(neededSaturation, foodWeight);
                addSaturation(gainedSaturation);
                target.die();
                return;
            }
        }
    }
}
}