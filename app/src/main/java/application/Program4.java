package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import entities.enums.Color;
import entities.Circle;
import entities.Rectangle;
import entities.Shape;

public class Program4 {
    
    public static void main(String[] args) {
        
        limparTerminal();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Shape> listFigures = new ArrayList<>();

        System.out.print("Ebterbthe number of shapes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Shape #" + (i + 1) + " data:");
            System.out.print("Circle or Rectangle (c/r)? ");
            //sc.nextLine();
            char fig = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next());
            if (fig == 'c' || fig == 'C') {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                listFigures.add(new Circle(color, radius));
            } else {
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double heght = sc.nextDouble();
                listFigures.add(new Rectangle(color, width, heght));
            }
        }

        System.out.println("\nSHAPE AREAS:");
        for (Shape s : listFigures) {
            System.out.println(String.format("%.2f", s.area()));
        }

        System.out.println("\n");

        sc.close();

    }

    public static void limparTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
