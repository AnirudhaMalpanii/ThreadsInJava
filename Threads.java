class ThreadClassDemo extends Thread {
   private int number;
   //creating a class constructor
   public ThreadClassDemo(int number) {
      this.number = number;
   }
   //creating a run method for the execution code for thread
   public void run() {
      int counter = 0;
      int numInt = 0;
      //below function prints the number till specified number is reached, starting from 10
      do {
         numInt = (int) (counter + 10);
         System.out.println(this.getName() + " prints " + numInt);
         counter++;
      } while(numInt != number);
      System.out.println("** Correct! " + this.getName() + "printed " + counter + " times.**");
   }
}
public class Main {
   public static void main(String [] args) {
      System.out.println("Starting thread_1...");
      //create a thread class instance
      Thread thread_1 = new ThreadClassDemo(15);
      //start the thread thread_1
      thread_1.start();
      try {
          //wait for thread_1 to die
         thread_1.join();
      } catch (InterruptedException e) {
         System.out.println("Thread interrupted.");
      }
   System.out.println("Starting thread_2...");
      Thread thread_2 = new ThreadClassDemo(20);
      //start thread_2      
      thread_2.start();
      System.out.println("main() is ending...");
   }
}