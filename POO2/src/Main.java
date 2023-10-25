import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> strings = generateRandomStrings(10);

        // Cadenas generadas de manera aleatoria.
        System.out.println("cadenas generadas de manera aleatoria:");
        strings.forEach(System.out::println);

        // Contar cuantas cadenas vacias tiene la lista de cadenas.
        long emptyCount = strings.stream()
                .filter(String::isEmpty)
                .count();
        System.out.println("cadenas vacias: " + emptyCount);

        // Contabilizar cuantas cadenas tienen longitud superior a 5.
        long longStringsCount = strings.stream()
                .filter(s -> s.length() > 5)
                .count();
        System.out.println("cadenas con longitud superior a 5: " + longStringsCount);

        // Contabilizar cuántas cadenas comienzan con "s".
        long startsWithSCount = strings.stream()
                .filter(s -> s.startsWith("s") || s.startsWith("S"))
                .count();
        System.out.println("cadenas que comienzan con 's': " + startsWithSCount);

        // Eliminar todas las cadenas vacias de la lista.
        strings = strings.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        // Filtrar la lista anterior con cadenas de más de 5 caracteres.
        List<String> longStrings = strings.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());

        // Convertir las palabras a mayusculas y concatenarlas usando una coma ','.
        String result = longStrings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println("cadenas largas en mayusculas, separadas por comas: " + result);
    }

    // Metodo para generar cadenas aleatorias.
    public static List<String> generateRandomStrings(int count) {
        Random random = new Random();
        return IntStream.range(0, count)
                .mapToObj(i -> {
                    int length = random.nextInt(10) + 1;
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < length; j++) {
                        char c = (char) (random.nextInt(26) + 'a');
                        sb.append(c);
                    }
                    return sb.toString();
                })
                .collect(Collectors.toList());
    }
}
