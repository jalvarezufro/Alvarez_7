package Datos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Gestor {

    /**
     *
     * @param direccion
     */
    public String leerArchivo(String direccion) {
        Path archivo = Paths.get(direccion);
        String Contenido = "";
        try {
            Contenido = new String(Files.readAllBytes(archivo));
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo.");
        }
        return Contenido;
    }

    /**
     *
     * @param direccion
     * @param texto
     */
    public void escribirArchivo(String direccion, String texto) {
        Path file = Paths.get(direccion);
        try {
            Files.write(file, texto.getBytes());
        } catch (Exception e) {
            System.out.println("El archivo no puede ser reescrito");
        }

    }

}
