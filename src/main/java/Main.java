

import animal.*;

import java.io.*;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Animals.txt");

        Cat cat = Cat.builder().build().generateRandom();
        Dog dog = Dog.builder().build().generateRandom();
        Bird bird = Bird.builder().build().generateRandom();
        Patyh patyh = Patyh.builder().build().generateRandom();

//        System.out.println(cat);
//        System.out.println(dog);
//        System.out.println(bird);
//        System.out.println(patyh);


        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {   //чтение файла

//            writer.println(map);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Map<String, String> map = new TreeMap<>();
            map.put(cat.getAge(), cat.getName());
//            map.put(dog.getAge(), dog.getName());
//            map.put(bird.getAge(), bird.getName());
//            map.put(patyh.getAge(), patyh.getName());
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

//        boolean res = sortMethod.SortLinesInFile("Animals.txt",false);
//
//        if (res) {
//            System.out.println("OK");
//        }else {
//            System.out.println("Fail");
//        }

//    public static List<Cat> sorted (List<Cat> cats){                ПОПЫТКА №5
//        List<Cat> sort = cats.stream()
//                .sorted(Comparator.comparing(Cat::getAge))
//                .sorted(Comparator.comparing(Cat::getName))
//                .collect(Collectors.toList());
//        return sort;
//    }
//        ArrayList<String> rows = new ArrayList<String>();            ПОПЫТКА №4
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//
//        String s;
//        while ((s = reader.readLine()) != null)
//            rows.add(s);
//
//        Collections.sort(rows);
//
//        FileWriter writer = new FileWriter(file,true);
//        for (String cur : rows)
//            writer.write(cur + "\n");
//
//        reader.close();
//        writer.close();
//        BufferedReader reader = null;                                 ПОПЫТКА №3
//        PrintWriter outputStream = null;
//        ArrayList<String> rows = new ArrayList<String>();
//
//        try {
//            reader  = new BufferedReader(new FileReader(file));
//            outputStream = new PrintWriter(new FileWriter(file,true));
//
//            String files;
//            while ((files = reader .readLine()) != null) {
//                rows.add(files);
//            }
//            Collections.sort(rows);
//            String[] strArr= rows.toArray(new String[0]);
//            for (String cur : strArr)
//                outputStream.println(cur);
//        } finally {
//            if (reader  != null) {
//                reader.close();
//            }
//            if (outputStream != null) {
//                outputStream.close();
//            }
//    Comparator<Patyh> catComparator = new PatyhComporator().thenComparing(new PatyhComporatorAge());     ПОПЫТКА №2
//    TreeSet<Patyh> patyhs = new TreeSet<>(catComparator);
//    String line;
//
//        while ((line = reader.readLine()) != null) {
//                for (Patyh p : patyhs){
//                System.out.println(p.getName() + " " + p.getAge());
//                System.out.println(line);
//                }
//        }
//    }

