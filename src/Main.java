import animal.Bird;
import animal.Cat;
import animal.Dog;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat.CatBuilder("Степа",6).setAge(4).build();
        System.out.println(cat);
        Dog dog = new Dog.DogBuilder("Роберт", 3).setAge(10).builder();
        System.out.println(dog);
        Bird bird = new Bird.BirdBuilder("Ваня",143).setAge(2).build();
        System.out.println(bird);
    }
}