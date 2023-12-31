package animal;

import animalsInterfаce.Animals;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.Comparator;
import java.util.Random;

@Value
@Builder
@With
public class Dog implements Animals {
    String name;
    int age;
    int id;

    @Override
    public void voice() {
        System.out.println("Собака говорит Гаф-Гаф");
    }

    @Override
    public void moveAround() {
        System.out.println("Собака бегает куда глаза глядят ");
    }

    public Dog generateRandom() {
        Random dogRandom = new Random();
        return Dog.builder()
                .name("dog" + dogRandom.nextInt(100))
                .age(dogRandom.nextInt(100))
                .id(dogRandom.nextInt(100))
                .build();
    }

    @Override
    public String toString() {
        return "Dog:" + "Имя=" + name + ", Возраст = " + age + ";"+'}';
    }
}