/*
 *  Programa para almacenar notas y calcular promedios
 *  Autor: Emmanuel Murillo Usuga
 *  Fecha: Febrero 2026
 *  Licencia: GNU GPL v3
 */

package app;

import javax.swing.*;

public class TallerCalificacion {

    public static void main(String[] args) {

        int cantidadNotas = Integer.valueOf(JOptionPane.showInputDialog
                (null,"Ingrese el numero de notas"));

        double[] notas = new double[cantidadNotas];

        boolean inicializado = false;
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                                    "MENU DE NOTAS   \n\n" +
                                            "1. Ingresar notas\n" +
                                            "2. Mostrar notas\n" +
                                            "3. Calcular nota definitiva\n" +
                                            "4. Obtener nota mayor\n" +
                                            "5. Obtener nota menor\n" +
                                            "6. Ordenar notas (Burbuja)\n" +
                                            "7. Mostrar resumen\n" +
                                            "8. Estado (Aprobado/Reprobado)\n" +
                                            "0. Salir"));

            switch (opcion) {
            case 1:
                ingresarNotas(notas);
                inicializado = true;
                break;

                case 2:
                    if (inicializado) {

                        mostrarNotas(notas);

                    } else {
                        mostrarError();
                    }
                    break;

                case 3:
                    if (inicializado) {
                        double notaDefinitiva = calcularNotaDefinitiva(notas);
                        JOptionPane.showMessageDialog(null, "Nota Definitiva" + notaDefinitiva);
                    } else {
                        mostrarError();
                    }
                    break;

                case 4:
                    if (inicializado) {
                    JOptionPane.showMessageDialog(null, "Nota Mayor: " + obtenerMayor(notas));
                    } else {
                        mostrarError();
                    }
                    break;

                case 5:
                    if (inicializado) {
                        JOptionPane.showMessageDialog(null, "Nota menor: " + obtenerMenor(notas));
                    } else {
                        mostrarError();
                    }
                    break;

                case 6:
                    if (inicializado) {
                        ordenarBurbuja(notas);
                    JOptionPane.showMessageDialog(null, "Notas Ordenadas correctamente");
                    } else {
                        mostrarError();
                    }
                    break;

                case 7:
                    if (inicializado) {
                        double prom = calcularNotaDefinitiva(notas);
                        double may = obtenerMayor(notas);
                        double men = obtenerMenor(notas);
                        mostrarResumen(notas, prom, may, men);
                    } else {
                        mostrarError();
                    }
                    break;

                case 8:
                    if (inicializado) {
                        mostrarAprobacion(calcularNotaDefinitiva(notas));
                    } else {
                        mostrarError();
                    }
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "programa Finalizado");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 0);
    }

    //FUNCIONES

    public static void ingresarNotas(double[] notas) {
        for (int i = 0; i < notas.length; i++) {
            notas[i] = Double.parseDouble(
                    JOptionPane.showInputDialog("Ingrese la nota #" + (i + 1))
            );
        }
    }

    public static void mostrarNotas(double[] notas ) {
        String msg = "NOTAS\n\n";
        for (int i = 0; i < notas.length; i++) {
            msg += "Nota " + (i + 1) + ": " + notas[i] + "\n";
        }

        JOptionPane.showMessageDialog(null, msg);
    }

    public static double calcularNotaDefinitiva(double[] notas) {
        double prom = 0;
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        prom = suma / notas.length;
        return prom;
    }

    public static double obtenerMayor(double[] notas) {
            double mayor = 0;
            for (int i = 0; i < notas.length; i++) {
                if (notas[i] > mayor) {
                    mayor = notas[i];
                }
            }
            return mayor;
    }


    public static double obtenerMenor(double[] notas) {
        double menor = notas[0];
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }
        return menor;
    }

    public static void ordenarBurbuja(double[] notas) {
        for (int i = 0; i < notas.length - 1; i++) {
            for (int j = 0; j < notas.length - 1 - i; j++) {
                if (notas[j] > notas[j + 1]) {
                    double naux = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = naux;
                }
            }
        }
    }

    public static void mostrarResumen(double[] notas, double prom, double may, double men) {
        String msg = "RESUMEN\n\n";
        for (int i = 0; i < notas.length; i++) {
            msg += "Nota " + (i + 1) + ": " + notas[i] + "\n";
        }
        msg += "\nPromedio: " + prom;
        msg += "\nMayor: " + may;
        msg += "\nMenor: " + men;

        JOptionPane.showMessageDialog(null, msg);
    }

    public static void mostrarAprobacion(double prom) {
        if (prom >= 3.0)
            JOptionPane.showMessageDialog(null, "APROBADO ✓");
        else
            JOptionPane.showMessageDialog(null, "REPROBADO X");
    }

    public static void mostrarError() {
        JOptionPane.showMessageDialog(null,
                "Primero debe ingresar las notas");
    }
}


