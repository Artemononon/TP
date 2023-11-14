package org.example;

public interface SuperRunner{
    default boolean isSuperRun(String name) {
        if (Cat.superRun > 0) {
            Cat.superRun = Cat.superRun - 1;
            System.out.println(name + " использует суперран, осталось " + Cat.superRun);
            return true;
        }
        return false;
    }
}
