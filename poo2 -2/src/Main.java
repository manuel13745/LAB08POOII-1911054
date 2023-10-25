import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = generateRandomNumbers(10);

        //Obtener recuento, mínimo, máximo, suma y promedio de números.
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("Recuento: " + stats.getCount());
        System.out.println("Minimo: " + stats.getMin());
        System.out.println("Maximo: " + stats.getMax());
        System.out.println("Suma: " + stats.getSum());
        System.out.println("Promedio: " + stats.getAverage());
    }

    public static List<Integer> generateRandomNumbers(int count) {
        Random random = new Random();
        return IntStream.range(0, count)
                .mapToObj(i -> random.nextInt(100)) // Numeros aleatorios entre 0 y 99
                .collect(Collectors.toList());
    }
}
