package u3c12_ej6;
class nuevoHilo implements Runnable {  // Define una clase que implementa la interfaz Runnable para permitir la ejecución en un hilo separado.
    String nombre; // Nombre del hilo.
    Thread hilo; // Instancia del hilo.

    nuevoHilo(String nombreHilo) {  // Constructor que recibe el nombre del hilo.
        nombre = nombreHilo; 
     // Crea un nuevo objeto Thread con 'this' como el objeto Runnable y 'nombre' como el nombre del hilo
        hilo = new Thread(this, nombre);  
        System.out.println("Nuevo hilo: " + hilo);  
    }

    public void run() {  
        try {
            for (int i = 5; i > 0; i--) {  
                System.out.println(nombre + ": " + i);  
                Thread.sleep(1000);  // Hace que el hilo duerma por 1 segundo (1000 milisegundos).
            }
        } catch (InterruptedException e) { 
            System.out.println(nombre + " interrumpido.");  
        }
        System.out.println(nombre + " saliendo.");  
    }
}
public class ejemplo6 {	
	public static void main(String[] args) {
		nuevoHilo hilo1 = new nuevoHilo("Hilo 1");
        nuevoHilo hilo2 = new nuevoHilo("Hilo 2");
        nuevoHilo hilo3 = new nuevoHilo("Hilo 3");
        hilo1.hilo.start();
        hilo2.hilo.start();
        hilo3.hilo.start();
        // Imprime si los hilo 1,2 y 3 estan vivos.
        System.out.println("El hilo 1 está vivo: " + hilo1.hilo.isAlive());
        System.out.println("El hilo 2 está vivo: " + hilo2.hilo.isAlive());
        System.out.println("El hilo 3 está vivo: " + hilo3.hilo.isAlive());

     // Espera a que las hilos terminen
        try {
        	 System.out.println("Esperando a que terminen los hilos.");
        	 hilo1.hilo.join();
        	 hilo2.hilo.join();
        	 hilo3.hilo.join();
        	 } catch (InterruptedException e) {
        	 System.out.println("Main thread Interrupted");
        	 }
        System.out.println("El hilo Uno está vivo: " + hilo1.hilo.isAlive());
        System.out.println("El hilo Dos está vivo: " + hilo2.hilo.isAlive());
        System.out.println("El hilo Tres está vivo: " + hilo3.hilo.isAlive());
        System.out.println("Hilo principal saliendo.");
	}
}

