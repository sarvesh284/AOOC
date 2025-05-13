import java.io.*;

public class DataStorage {
    private static final String FILE_NAME = "data.txt";

    public static void saveData(double saving, double income) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(saving + "," + income);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[] loadData() {
        double[] data = {0.0, 0.0}; // Default values
        File file = new File(FILE_NAME);
        if (!file.exists()) return data;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                data[0] = Double.parseDouble(parts[0]);
                data[1] = Double.parseDouble(parts[1]);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return data;
    }
}
