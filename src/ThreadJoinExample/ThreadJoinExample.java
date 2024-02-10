//Создать три потока Т1, Т2 и Т3
//Реализовать выполнение поток в последовательности Т3 -> Т2 -> Т1
//Используя метод join
package ThreadJoinExample;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread T1 = new Thread(() -> {
            System.out.println("Thread T1 is running");
        });

        Thread T2 = new Thread(() -> {
            try {
                // Ждем завершения T1
                T1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread T2 is running");
        });

        Thread T3 = new Thread(() -> {
            try {
                // Ждем завершения T2
                T2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread T3 is running");
        });

        // Запускаем потоки в обратном порядке
        T3.start();
        T2.start();
        T1.start();
    }
}