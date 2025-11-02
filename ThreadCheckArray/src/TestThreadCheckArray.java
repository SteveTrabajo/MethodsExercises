import java.util.ArrayList;
import java.util.Scanner;

/** 
 * Description of TestThreadCheckArray
 * @author Ahmad
 * @version 1.0
 */
public class TestThreadCheckArray
{
    /** 
     * Description of main(String[] args)
     * @param args      Command-line arguments
     * @throws InterruptedException    InterruptedException
     */
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in))
        {
            Thread thread1, thread2;

            // read array size
            System.out.println("Enter array size");
            int num = input.nextInt();

            // read array elements
            ArrayList<Integer> array = new ArrayList<>();
            System.out.println("Enter numbers for array");
            for (int index = 0; index < num; index++)
                array.add(input.nextInt());

            // read target number
            System.out.println("Enter number");
            num = input.nextInt();

            // create shared data
            SharedData sd = new SharedData(array, num);

            // start two threads
            thread1 = new Thread(new ThreadCheckArray(sd), "thread1");
            thread2 = new Thread(new ThreadCheckArray(sd), "thread2");
            thread1.start();
            thread2.start();

            // wait for both threads to complete
            try
            {
                thread1.join();
                thread2.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            // print results
            if (!sd.getFlag())
            {
                System.out.println("Sorry");
                return;
            }

            System.out.println("Solution for b : " + sd.getB() + ", n = " + sd.getArray().size());

            System.out.print("I:    ");
            for (int index = 0; index < sd.getArray().size(); index++)
                System.out.print(index + "    ");
            System.out.println();

            System.out.print("A:    ");
            for (int index : sd.getArray())
            {
                System.out.print(index);
                int counter = 5;
                while (true)
                {
                    index = index / 10;
                    counter--;
                    if (index == 0)
                        break;
                }
                for (int i = 0; i < counter; i++)
                    System.out.print(" ");
            }

            System.out.println();
            System.out.print("C:    ");
            for (boolean index : sd.getWinArray())
            {
                if (index)
                    System.out.print("1    ");
                else
                    System.out.print("0    ");
            }
        }
    }
}
