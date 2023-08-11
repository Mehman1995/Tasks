package animal;

import animalsInterfаce.Animals;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.Random;

@Value
@Builder
@With
public class Bird implements Animals {
    private String name;
    private String age;
    private int id;

//    public Bird(BirdBuilder birdBuilder) {
//        this.name = birdBuilder.name;
//        this.age = birdBuilder.age;
//        this.id = birdBuilder.id;
//    }
//
//    public Bird() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public int getId() {
//        return id;
//    }

    @Override
    public void voice() {
        System.out.println("Птичка говорит Чирик- Чирик");
    }

    @Override
    public void moveAround() {
        System.out.println("Птичка летает по комнате ");
    }


    //    @Override
//    public String toString() {
//        return "Птичка " +
//                "с именем = " + name  +
//                ", возростом = " + age +
//                "лет, id=" + id;
//    }
    public Bird generateRandom() {
        Random birdRandom = new Random();
        return Bird.builder()
                .name("bird № " + birdRandom.nextInt(100))
                .age("Возраст" + birdRandom.nextInt(100))
                .id(birdRandom.nextInt(100))
                .build();

    }

//    public static class BirdBuilder {
//        private String name;
//        private int age;
//        private int id;
//
//
//        public BirdBuilder(String name, int age, int id) {
//            this.name = name;
//            this.age = age;
//            this.id = id;
//        }
//
//        public BirdBuilder() {
//        }
//
//        public BirdBuilder setAge(int age) {
//            this.age = age;
//            return this;
//        }
//
//        public BirdBuilder setName(String name) {
//            this.name = name;
//            return this;
//        }
//        public BirdBuilder setId(int id){
//            this.id = id;
//            return this;
//        }
//
//        public Bird build() {
//            return new Bird(this);
//        }
//    }
}
