package Comporator;

import animal.Patyh;

import java.util.Comparator;

public class PatyhComporator implements Comparator<Patyh> {
    @Override
    public int compare(Patyh a, Patyh b) {
        return a.getName().compareTo(b.getName());
    }
}


