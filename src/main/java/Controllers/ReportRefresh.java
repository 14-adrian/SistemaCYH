
package Controllers;

import Forms.Pedidos;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Leoni
 */
public class ReportRefresh extends Thread{
    
    private volatile boolean running = true;
    private volatile boolean paused = false;
    private Pedidos ped;
    
    public ReportRefresh(Pedidos _ped){
        this.ped = _ped;
    }

    public void detener() {
        running = false;
    }

    public void pausar() {
        paused = true;
    }

    public void reanudar() {
        paused = false;
    }


    @Override
    public void run() {
        while (running) {
            while (paused) {
                try {
                    // Espera activa para no consumir CPU innecesariamente
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Lógica del hilo de ejecución
            try {
                ped.generatePanels();
               

                // Dormir durante un período de tiempo antes de la siguiente verificación
                TimeUnit.SECONDS.sleep(5); // Verificar cada 5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
