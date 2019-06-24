package domProblema;

import Datos.Gestor;

public class FormateoTexto {

    public String diferenciarArchivo(String direccion) {

        String textoFormat;
        if (direccion.contains("archivo1.txt")) {
            textoFormat = lineasPares(direccion);
        } else {
            textoFormat = separarSaltos(direccion);
        }
        return textoFormat;
    }

    private String lineasPares(String direccion) {
        String texto = leer(direccion);
        String[] separados = separarCondicion(texto, "\n");
        texto = "";
        for (int i = 0; i < separados.length / 2; i++) {
            texto = texto + separados[1 + 2 * i] + "\n";

        }
        return texto;
    }

    private String separarSaltos(String direccion) {
        String texto = leer(direccion);
        String[] separados = separarCondicion(texto, "\n");
        texto = "";
        for (int i = 0; i < separados.length; i++) {
            texto = texto + separados[i] + " ";

        }
        return texto;
    }

    public String leer(String direccion) {
        Gestor gest = new Gestor();
        String texto = gest.leerArchivo(direccion);
        return texto;
    }

    private String[] separarCondicion(String texto, String condicion) {
        String[] separacion = texto.split(condicion);
        return separacion;
    }
}
