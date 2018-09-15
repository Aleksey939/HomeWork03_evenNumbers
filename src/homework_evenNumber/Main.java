package homework_evenNumber;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        File file = new File("number.txt");
        List<Integer> listintov = new ArrayList<Integer>();
        Scanner sc = null;

        try {

            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                Integer line = sc.nextInt();

                listintov.add(line);
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        float persent= sumeven/size;
        System.out.println(sumeven+" Четных "+persent*100+"%");
    }


    }


