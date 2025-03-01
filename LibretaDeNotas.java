import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibretaDeNotas {

    private HashMap<String, ArrayList<Double>> calificaciones;

    public LibretaDeNotas() {
        calificaciones = new HashMap<>();
    }

    public static void main(String[] args) {
        LibretaDeNotas libreta = new LibretaDeNotas();
        libreta.ejecutar();
    }

    private int leerEntero(Scanner scanner, String mensaje, int min, int max) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim().replace(",", ".");
            try {
                double valor = Double.parseDouble(input);
                numero = (int) valor;
                if (numero < min || numero > max) {
                    System.out.printf("❌ El número debe estar entre %d y %d.%n", min, max);
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor, ingrese un número válido.");
            }
        }
        return numero;
    }

    private double leerDouble(Scanner scanner, String mensaje, double min, double max) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim().replace(",", ".");
            try {
                valor = Double.parseDouble(input);
                if (valor < min || valor > max) {
                    System.out.printf("❌ El valor debe estar entre %.1f y %.1f.%n", min, max);
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor, ingrese un número válido.");
            }
        }
        return valor;
    }

    private double leerNotaValida(Scanner scanner, ArrayList<Double> notas, String mensaje, double min, double max) {
        int intentos = 0;
        double nota;
        while (intentos < 3) {
            nota = leerDouble(scanner, mensaje, min, max);
            if (notas.contains(nota)) {
                return nota;
            } else {
                intentos++;
                System.out.printf("❌ La nota ingresada no pertenece al alumno (%d/3 intentos).%n", intentos);
            }
        }
        return -1;
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        int numAlumnos = leerEntero(scanner,
                "🔎 Ingrese la cantidad de alumnos (máximo 50): ", 1, 50);
        int numNotas = leerEntero(scanner,
                "🔎 Ingrese la cantidad de notas por alumno (máximo 10): ", 1, 10);

        for (int i = 0; i < numAlumnos; i++) {
            System.out.print("📘 Ingrese el nombre del alumno: ");
            String nombreAlumno = scanner.nextLine();

            ArrayList<Double> notasAlumno = new ArrayList<>();
            for (int j = 0; j < numNotas; j++) {
                double nota = leerDouble(scanner,
                        String.format("🏅 Ingrese la nota %d para %s (entre 0 y 7 Ejemplo: 5,5 - 5.5 o 5): ",
                                j + 1, nombreAlumno),
                        0, 7);
                notasAlumno.add(nota);
            }
            calificaciones.put(nombreAlumno, notasAlumno);
        }

        System.out.println("\n📘==================== Resultados de cada alumno ====================");
        HashMap<String, Double> promediosCurso = new HashMap<>();
        double sumaTotalCurso = 0;
        int totalNotasCurso = 0;

        for (Map.Entry<String, ArrayList<Double>> entry : calificaciones.entrySet()) {
            String nombre = entry.getKey();
            ArrayList<Double> notas = entry.getValue();

            double notaMax = Collections.max(notas);
            double notaMin = Collections.min(notas);
            double suma = notas.stream().mapToDouble(Double::doubleValue).sum();
            double promedio = suma / notas.size();

            sumaTotalCurso += suma;
            totalNotasCurso += notas.size();
            promediosCurso.put(nombre, promedio);

            System.out.println("🏅 Alumno: " + nombre);
            System.out.printf("   🔎 Promedio: %.1f%n   ⬆️ Nota Máxima: %.1f%n   ⬇️ Nota Mínima: %.1f%n",
                    promedio, notaMax, notaMin);
        }

        double promedioCurso = sumaTotalCurso / totalNotasCurso;
        System.out.printf("📌 Promedio del curso: %.1f%n", promedioCurso);

        final double NOTA_APROBACION = 4.0;
        int opcion;
        do {
            System.out.println("\n📌==================== Menú de Opciones ====================");
            System.out.println("📘 1. Mostrar el Promedio de Notas por Estudiante.");
            System.out.println("🏅 2. Evaluar si la Nota es Aprobatoria o Reprobatoria por Estudiante.");
            System.out.println("🔎 3. Comparar Nota con el Promedio del Curso por Estudiante.");
            System.out.println("❌ 0. Salir del Menú.");
            System.out.print("👉 Seleccione una opción: ");

            String opcionInput = scanner.nextLine().trim();
            try {
                opcion = Integer.parseInt(opcionInput.replace(",", ""));
            } catch (NumberFormatException e) {
                System.out.println("❌ Ingrese una opción válida.");
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    mostrarPromediosEstudiantes(promediosCurso);
                    break;
                case 2:
                    evaluarAprobacion(scanner, calificaciones, NOTA_APROBACION);
                    break;
                case 3:
                    compararNotaConPromedio(scanner, calificaciones, promedioCurso);
                    break;
                case 0:
                    System.out.println("❌ Saliendo del menú. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    private void mostrarPromediosEstudiantes(HashMap<String, Double> promediosCurso) {
        System.out.println("\n📘--- Promedio de Notas por Estudiante ---");
        promediosCurso.forEach((alumno, prom) ->
                System.out.printf("🏅 Alumno: %s, Promedio: %.1f%n", alumno, prom)
        );
    }

    private void evaluarAprobacion(Scanner scanner, HashMap<String, ArrayList<Double>> calificaciones, double NOTA_APROBACION) {
        System.out.print("\n📘 Ingrese el nombre del alumno a evaluar: ");
        String alumnoEvaluar = scanner.nextLine();
        if (!calificaciones.containsKey(alumnoEvaluar)) {
            System.out.println("❌ El alumno no existe.");
            return;
        }
        ArrayList<Double> notas = calificaciones.get(alumnoEvaluar);
        System.out.println("📝 Las notas de " + alumnoEvaluar + " son: " + notas);
        double notaEvaluar = leerNotaValida(scanner, notas,
                "🏅 Ingrese la nota a evaluar (debe estar en el listado anterior): ", 0, 7);
        if (notaEvaluar == -1) {
            System.out.println("❌ Se excedieron los intentos. Volviendo al menú...");
            return;
        }
        if (notaEvaluar >= NOTA_APROBACION) {
            System.out.println("✅ La nota es Aprobatoria.");
        } else {
            System.out.println("❌ La nota es Reprobatoria.");
        }
    }

    private void compararNotaConPromedio(Scanner scanner, HashMap<String, ArrayList<Double>> calificaciones, double promedioCurso) {
        System.out.print("\n📘 Ingrese el nombre del alumno a evaluar: ");
        String alumno = scanner.nextLine();
        if (!calificaciones.containsKey(alumno)) {
            System.out.println("❌ El alumno no existe.");
            return;
        }
        ArrayList<Double> notas = calificaciones.get(alumno);
        System.out.println("📝 Las notas de " + alumno + " son: " + notas);
        double notaAlumno = leerNotaValida(scanner, notas,
                "🏅 Ingrese la nota a evaluar (debe estar en el listado anterior): ", 0, 7);
        if (notaAlumno == -1) {
            System.out.println("❌ Se excedieron los intentos. Volviendo al menú...");
            return;
        }
        if (notaAlumno > promedioCurso) {
            System.out.println("✅ La nota está por sobre el promedio del curso.");
        } else if (notaAlumno < promedioCurso) {
            System.out.println("❌ La nota está por debajo del promedio del curso.");
        } else {
            System.out.println("📌 La nota es igual al promedio del curso.");
        }
    }
}
