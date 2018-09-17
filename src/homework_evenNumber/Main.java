package homework_evenNumber;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        File file = new File("number.txt");

        Scanner sc = null;

        try {

            sc = new Scanner(file);
            evenNumbers(sc);
        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        finally {
            sc.close();

        }
    }



    public static void evenNumbers(Scanner scanner) throws FileNotFoundException {

        List<Integer> listintov = new ArrayList<Integer>();
        Scanner sc = scanner;

        try {



            while (sc.hasNextLine()) {
                Integer line = sc.nextInt();

                listintov.add(line);
                System.out.println(line);
            }

        } finally {
            sc.close();

        }


        int size=listintov.size();
        System.out.println("Общее количество чисел" + size);

        int sum = listintov.stream().mapToInt(Integer::intValue).sum();
        System.out.println("сумма чисел " + sum);
        int sumeven=0;
        for (Iterator<Integer> iterator = listintov.iterator(); iterator.hasNext();) {
            Integer number = iterator.next();

            if (number % 2 == 0) {
                sumeven+=1;

                iterator.remove();
            }

        }
        float persent= (float)sumeven/size;
        System.out.println(sumeven+" Четных "+persent*100+"%");

    }



}


