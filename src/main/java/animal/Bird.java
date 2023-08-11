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
public class Bird implements Animals, Comparator<Bird> {
    String name;
    String age;
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
                .name("bird № " + birdRandom.nextInt(100))
                .age("Возраст " + birdRandom.nextInt(100))
                .id(birdRandom.nextInt(100))
                .build();

    }
    @Override
    public int compare(Bird a, Bird b) {
        return a.getName().compareTo(b.getName());
    }
}
