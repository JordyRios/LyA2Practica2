package practica2;

public class PilaEstatus {
    private int capacidad;
    private int[] array;
    private int cima;

    // Constructor para inicializar la pila con una capacidad específica
    public PilaEstatus(int capacidad) {
        this.capacidad = capacidad;
        this.array = new int[capacidad];
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

    // Método para agregar un elemento a la pila
    public void push(int elemento) {
        if (estaLlena()) {
            System.out.println("Error: La pila está llena.");
            return;
        }
        array[++cima] = elemento;
    }

    // Método para eliminar y devolver el elemento en la cima de la pila
    public int pop() {
        if (estaVacia()) {
            System.out.println("Error: La pila está vacía.");
            return -1;
        }
        return array[cima--];
    }

    // Método para obtener el elemento en la cima de la pila sin eliminarlo
    public int peek() {
        if (estaVacia()) {
            System.out.println("Error: La pila está vacía.");
            return -1;
        }
        return array[cima];
    }
}


