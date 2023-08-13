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
public class Bird implements Animals {
    String name;
    int age;
    int id;

//

    @Override
    public void voice() {
        System.out.println("Птичка говорит Чирик- Чирик");
    }

    @Override
    public void moveAround() {
        System.out.println("Птичка летает по комнате ");
    }


    public Bird generateRandom() {
        Random birdRandom = new Random();
        return Bird.builder()
                .name("bird" + birdRandom.nextInt(100))
                .age(birdRandom.nextInt(100))
                .id(birdRandom.nextInt(100))
                .build();

    }

    @Override
    public String toString() {
        return "Bird:" + "Имя=" + name + ", Возраст = " + age + ";"+'}';
    }
}
