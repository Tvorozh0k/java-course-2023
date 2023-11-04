package edu.hw3.Task5;

import java.util.Comparator;

class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        // Сортировка по фамилии (по заданию) или используем имя, если нет фамилии

        String x = (a.lastName() != null) ? a.lastName() : a.firstName();
        String y = (b.lastName() != null) ? b.lastName() : b.firstName();

        return x.compareTo(y);
    }
}
