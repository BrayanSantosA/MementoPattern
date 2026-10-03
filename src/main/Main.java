package main;

import caretaker.Historial;
import memento.Memento;
import originator.Editor;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Historial historial = new Historial();

        editor.setContenido("Hola");
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");
        historial.guardarEstado(editor.guardar());
        System.out.println("Se guarda el estado.");

        editor.setContenido("Hola, mundo");
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");
        historial.guardarEstado(editor.guardar());
        System.out.println("Se guarda el estado.");

        editor.setContenido("Hola, mundo. Adiós");
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");

        if (!historial.estaVacio()) {
            Memento ultimo = historial.obtenerUltimoEstado();
            editor.restaurar(ultimo);
            System.out.println("Se restaura el último estado guardado.");
        }
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");

        editor.setContenido(editor.getContenido() + ". Nuevo cambio");
        System.out.println("Contenido tras nueva modificación: \"" + editor.getContenido() + "\"");
    }
}
