package caretaker;

import memento.Memento;
import java.util.Stack;

public class Historial {
    private final Stack<Memento> estados = new Stack<>();

    public void guardarEstado(Memento memento) {
        estados.push(memento);
    }

    public Memento obtenerUltimoEstado() {
        if (estados.isEmpty()) {
            return null;
        }
        return estados.pop();
    }

    public boolean estaVacio() {
        return estados.isEmpty();
    }
}
