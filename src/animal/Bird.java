package animal;

import animalsInterfаce.Animals;

public class Bird implements Animals {
    private String name;
    private int age;
    private int id;

    public Bird(BirdBuilder birdBuilder) {
        this.name = birdBuilder.name;
        this.age = birdBuilder.age;
        this.id = birdBuilder.id;
    }

    public Bird() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void voice() {
        System.out.println("Птичка говорит Чирик- Чирик");
    }

    @Override
    public void moveAround() {
        System.out.println("Птичка летает по комнате ");
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public static class BirdBuilder {
        private String name;
        private int age;
        private int id;


        public BirdBuilder(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public BirdBuilder() {
        }

        public BirdBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        public Bird build(){
            return new Bird(this);
        }
    }
}
