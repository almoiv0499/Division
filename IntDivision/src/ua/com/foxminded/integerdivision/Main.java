package ua.com.foxminded.integerdivision;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        IntegerDivision resultDivision = new IntegerDivision();

        System.out.print("Input dividend: ");
        Integer dividend = inputDivindendAndDivider();

        System.out.print("Input divider: ");
        Integer divisor = inputDivindendAndDivider();

        String results = resultDivision.divide(dividend, divisor);
        System.out.println("The division result is: " + '\n');
        System.out.println(results);

    }

    public static int inputDivindendAndDivider() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}

