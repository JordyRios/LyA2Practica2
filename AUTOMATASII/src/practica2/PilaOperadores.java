package practica2;

public class PilaOperadores {
    private int capacidad;
    private char[] array;
    private int cima;

    // Constructor para inicializar la pila con una capacidad específica
    public PilaOperadores(int capacidad) {
        this.capacidad = capacidad;
        this.array = new char[capacidad];
        this.cima = -1; // Pila vacía al inicio
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return (cima == -1);
    }

    // Método para verificar si la pila está llena
    public boolean estaLlena() {
        return (cima == capacidad - 1);
    }

    // Método para agregar un operador a la pila
    public void push(char operador) {
        if (estaLlena()) {
            System.out.println("Error: La pila está llena.");
            return;
        }
        array[++cima] = operador;
    }

    // Método para eliminar y devolver el operador en la cima de la pila
    public char pop() {
        if (estaVacia()) {
            System.out.println("Error: La pila está vacía.");
            return ' '; // Se podría modificar para lanzar una excepción en lugar de retornar un carácter vacío
        }
        return array[cima--];
    }

    // Método para obtener el operador en la cima de la pila sin eliminarlo
    public char peek() {
        if (estaVacia()) {
            System.out.println("Error: La pila está vacía.");
            return ' '; // Se podría modificar para lanzar una excepción en lugar de retornar un carácter vacío
        }
        return array[cima];
    }
}

