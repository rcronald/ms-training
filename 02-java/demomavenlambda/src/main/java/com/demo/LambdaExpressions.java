package com.demo;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by rcronald on 11/1/17.
 */
public class LambdaExpressions {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Juan", "Pulido", 35, new Address("Los olivos"), "Male"));
        personList.add(new Person("Ronald", "Requena", 30, new Address("San isidro"), "Male"));
        personList.add(new Person("Angello", "Manrique", 20, new Address("San martin"), "Male"));
        personList.add(new Person("Angel", "Encalada", 22, new Address("Los olivos"), "Male"));
        personList.add(new Person("David", "Truzita", 36, new Address("chorrillos"), "Female"));


        ArrayList<Person> filterList = personList.stream()
                                                 .filter(n -> n.getAge() > 30)
                                                 .collect(Collectors.toCollection(() -> new ArrayList<>()));
        for (Person person : filterList) {
            System.out.println("->" + person.getName());
        }

        ArrayList<Person> filterList1 = personList.stream()
                .filter(n -> n.getAddress().getName().equalsIgnoreCase("Los olivos")
                        && n.getAge() > 30)
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        for (Person person : filterList1) {
            System.out.println("->" + person.getName());
        }

        Optional<Person> personFilter = personList.stream().findFirst();
        if(personFilter.isPresent())
        {
            System.out.println("Filtrado:" + personFilter.get().getName() );
        }


        // Agrupamiento con streams
        Map<String , List<Person>> byGender = personList.stream()
                            .collect(Collectors.groupingBy(Person::getGender));
        // Thread  (100 ms)

        // Agrupamiento con parallel streams
        Map<String , List<Person>> byGenderParllel = personList.parallelStream()
                .collect(Collectors.groupingByConcurrent(Person::getGender));
        // Thread (10ms)


        System.out.println("");


        //ejemploListas();
    }


    public static void ejemploListas() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // sin lambda
        for (Integer number : list) {
            System.out.println("number: " + number);
        }

        System.out.println("-------");

        // con lambda
        list.forEach(
                n -> System.out.println("number: " + n)
        );

        //filtrar sin lambda
        ArrayList<Integer> mayor5 = new ArrayList<>();
        for (Integer number : list) {
            if (number > 5)
                mayor5.add(number);
        }

        for (Integer number : mayor5) {
            System.out.println("mayor a 5: " + number);
        }

        //filtrar con lambda
        ArrayList<Integer> mayores5 = list.stream()
                .filter(x -> x > 5)
                .collect(Collectors.toCollection(() -> new ArrayList<>()));
        mayores5.forEach(x -> System.out.println("Mayores a 5 con lambda: " + x));
    }
}
