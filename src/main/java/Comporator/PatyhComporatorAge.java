package Comporator;

import animal.Patyh;

import java.util.Comparator;

public class PatyhComporatorAge implements Comparator<Patyh> {

    @Override
    public int compare(Patyh a, Patyh b) {
        if (a.getAge() > b.getAge())
            return 1;
        else if (a.getAge() < b.getAge())
            return -1;
        else
            return 0;
    }
}