package pl.edu.amu.advjava;

import java.util.*;
import java.util.stream.Collectors;

final class StreamExcercises {

    /*
         ZADANIE: dla podanej kolekcji zwróć sumę opakowanych liczb.
     */
    static int sum(Collection<CustomNumber> numbers) {
        return numbers.stream().reduce((x, y) -> new CustomNumber(x.number + y.number)).get().number;
    }

    /*
         ZADANIE: dla podanej kolekcji zwróć tylko te nieujemne.
     */
    static List<CustomNumber> positiveNumbers(Collection<CustomNumber> numbers) {
        return numbers.stream().filter(x -> !x.isNegative()).collect(Collectors.toList());
    }

    /*
         ZADANIE: dla podanej kolekcji zwróć kolekcję zawierającą kwadraty opakowanych liczb.
     */
    static List<Integer> squares(Collection<CustomNumber> numbers) {
        return numbers.stream().map(x -> x.number * x.number).collect(Collectors.toList());
    }

    /*
         ZADANIE: dla podanej kolekcji zwróć sumę liczb ujemnych z kolekcji.
     */
    static int sumOfNegativeNumbers(Collection<CustomNumber> numbers) {
        return numbers.stream()
                .filter(x -> x.isNegative())
                .reduce((x, y) -> new CustomNumber(x.number + y.number))
                .get().number;
    }

    /*
         ZADANIE: dla podanej kolekcji iloczyn liczb z wszystkich kolekcji.
     */
    static long productOfNumbers(Collection<CustomNumberCollection> customNumberCollection) {
        return customNumberCollection.stream()
                .flatMap(c -> c.getCustomNumbers().stream())
                .reduce((x, y) -> new CustomNumber(x.number * y.number))
                .get().number;
    }

    /*
         ZADANIE: zwracana mapa powinna zawierać jako klucz kwadrat liczby z kolekcji, a jako wartość - liczby,
         które są pierwiastkami kwadratowymi tej liczby.
     */
    static Map<Integer, Set<Integer>> squareRoots(Collection<CustomNumber> numbers) {

        Map<Integer, Set<Integer>> squareRoots = numbers.stream().collect(
                Collectors.toMap(
                    x -> x.number * x.number,
                    x -> new HashSet<>(),
                    (x, y) -> x
                )
        );
        numbers.stream().forEach(x -> squareRoots.get(x.number * x.number).add(x.number));
        return squareRoots;
    }

    static final class CustomNumber {
        int number;

        CustomNumber(int number) {
            this.number = number;
        }

        boolean isPositive() {
            return number >= 0;
        }

        boolean isNegative() {
            return !isPositive();
        }
    }

    static final class CustomNumberCollection {
        private Collection<CustomNumber> customNumbers;

        CustomNumberCollection(Collection<CustomNumber> customNumbers) {
            this.customNumbers = customNumbers;
        }

        Collection<CustomNumber> getCustomNumbers() {
            return customNumbers;
        }
    }
}
