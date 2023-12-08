import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.OptionalDouble;

public class App {
    public static void main(String[] args) throws Exception {
        //OOP
        List<Dog> listDog = new ArrayList<Dog>();
        Dog dog1 = new Dog("Poodle", "Hammy", 20, 10);
        Dog dog2 = new Dog("Poodle", "Levy", 22, 12);
        Dog dog3 = new Dog("Bulldog", "Jimmy", 24, 30);
        Dog dog4 = new Dog("Poodle", "Swally", 18, 12);
        listDog.add(dog1);
        listDog.add(dog2);
        listDog.add(dog3);
        listDog.add(dog4);
        //Stream + Lambda expression
        Optional<Dog> dogMatch = listDog.stream().filter(dog -> dog.getName().equals("Jimmy")).findFirst();
        dogMatch.ifPresent(dog -> System.out.println("Found dog: " + dog.toString()));
        listDog.stream().filter(dog -> dog.getType().equals("Poodle")).forEach(dog -> System.out.println("Found dog: " + dog.toString()));
        listDog.stream().forEach((dog) -> dog.makeNoise());
        //2 ways to calculate sum
        double sumHeightDog = listDog.stream().mapToDouble(Dog::getHeight).reduce(0, (subTotalHeight, height) -> subTotalHeight + height);
        double sumWeightDog = listDog.stream().mapToDouble(Dog::getWeight).sum();
        System.out.println("Sum height: " + sumHeightDog);
        System.out.println("Sum weight: " + sumWeightDog);
        double sumWeightPoodle = listDog.stream().filter(dog -> dog.getType().equals("Poodle")).mapToDouble(Dog::getWeight).reduce(0, (subTotalWeight, weight) -> subTotalWeight + weight);
        System.out.println("Sum weight poodle: " + sumWeightPoodle);
        OptionalDouble maxWeightDog = listDog.stream().mapToDouble(Dog::getWeight).max();
        maxWeightDog.ifPresent(weight -> System.out.println("Max weight: " + maxWeightDog.getAsDouble()));
        OptionalDouble minWeightDog = listDog.stream().mapToDouble(Dog::getWeight).min();
        minWeightDog.ifPresent(weight -> System.out.println("Min weight: " + minWeightDog.getAsDouble()));
        listDog.stream().filter(dog -> dog.getType().equals("Poodle") && dog.getHeight() >= 20).forEach(dog -> System.out.println("Poodle match: " + dog.toString()));
        //Iterator
        System.out.println("=====================ITERATOR=====================");
        List<Dog> listDogCopy = new ArrayList<Dog>();
        listDog.forEach(dog -> listDogCopy.add(dog));

        Iterator<Dog> iterator = listDogCopy.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getName() == "Jimmy") {
                iterator.remove();
            }
        }
        listDogCopy.forEach(dogCopy -> System.out.println(dogCopy.toString()));
        //ListIterator
        System.out.println("=====================LIST ITERATOR=====================");
        List<Dog> listDogCopy2 = new ArrayList<Dog>();
        listDog.forEach(dog -> listDogCopy2.add(dog));
        ListIterator<Dog> listIterator = listDogCopy2.listIterator();
        while (listIterator.hasNext()) {
            if(listIterator.next().getName() == "Jimmy") {
                listIterator.add(new Dog("BullDog", "Weavy", 19, 16));
                listIterator.set(listIterator.next());
            }
        }
        listDogCopy2.forEach(dogCopy -> System.out.println(dogCopy.toString()));
        // =>Iterator only has remove() method, wherearea ListIterator has add() and set() method 
    }
}
