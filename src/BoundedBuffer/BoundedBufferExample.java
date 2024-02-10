//многопоточный ограниченный буфер с использованием
//ReentrantLock
package BoundedBuffer;

public class BoundedBufferExample {
    public static void main(String[] args) {
        BoundedBuffer boundedBuffer = new BoundedBuffer(5);

        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    boundedBuffer.produce(i);
                    Thread.sleep(100); // Имитация производственной деятельности
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    boundedBuffer.consume();
                    Thread.sleep(200); // Имитация потребительской деятельности
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}