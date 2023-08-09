package animal;

import animalsInterfаce.Animals;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Value
@Builder
@With
public class Patyh implements Animals {
    String name;
    int age;
    int id;

    public Patyh generateRandom() {  //метод для генирации случайных чисел
        Random patyhRandom = new Random();
        return Patyh.builder()
                .name("patyh №" + patyhRandom.nextInt(100))
                .age(patyhRandom.nextInt(100))
                .id(patyhRandom.nextInt(100))
                .build();
    }

    @Override
    public void voice() {
        System.out.println("Пятух кричит ку-кареку маза фака с добрым утром");
    }

    @Override
    public void moveAround() {
        System.out.println("идет по жизни куда глаза глидят ведь он пятух");
    }



}
