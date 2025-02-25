import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperator {
    private final String fileName;

    public FileOperator(String fileName) {
        this.fileName = fileName;
    }

    public String[] toStringArray(int arraySize) {
        String[] data = new String[arraySize];
        try {
            try (Scanner input = new Scanner(new File(fileName))) {
                int index = 0;
                while (input.hasNext() && index < arraySize) {
                    data[index++] = input.next();
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + fileName);
        }
        return data;
    }

    public int[] toIntArray(int arraySize) {
        int[] data = new int[arraySize];
        try {
            try (Scanner input = new Scanner(new File(fileName))) {
                int index = 0;
                while (input.hasNextInt() && index < arraySize) {
                    data[index++] = input.nextInt();
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + fileName);
        }
        return data;
    }

    public double[] toDoubleArray(int arraySize) {
        double[] data = new double[arraySize];
        try {
            try (Scanner input = new Scanner(new File(fileName))) {
                int index = 0;
                while (input.hasNextDouble() && index < arraySize) {
                    data[index++] = input.nextDouble();
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + fileName);
        }
        return data;
    }

        public ArrayList<Integer> toIntList() {
        ArrayList<Integer> data = new ArrayList<>();
        try {
            try (Scanner input = new Scanner(new File(fileName))) {
                while (input.hasNextInt()) {
                    data.add(input.nextInt());
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + fileName);
        }
        return data;
    }

    public ArrayList<String> toStringList() {
        ArrayList<String> data = new ArrayList<>();
        try {
            try (Scanner input = new Scanner(new File(fileName))) {
                while (input.hasNext()) {
                    data.add(input.next());
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + fileName);
        }
        return data;
    }

    public ArrayList<Double> toDoubleList() {
        ArrayList<Double> data = new ArrayList<>();
        try {
            try (Scanner input = new Scanner(new File(fileName))) {
                while (input.hasNextDouble()) {
                    data.add(input.nextDouble());
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + fileName);
        }
        return data;
    }

    public static void main(String[] args) {
        FileOperator fileOp = new FileOperator("albums.txt");

        int[] intData = fileOp.toIntArray(100);
        System.out.print("Integer Data: ");
        for (int num : intData) {
            System.out.print(num + " ");
        }
        System.out.println();

        double[] doubleData = fileOp.toDoubleArray(50);
        System.out.print("Double Data: ");
        for (double num : doubleData) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] stringData = fileOp.toStringArray(20);
        System.out.print("String Data: ");
        for (String str : stringData) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}

