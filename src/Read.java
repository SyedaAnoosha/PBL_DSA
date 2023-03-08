import java.io.*;

public class Read {
    public static void main(String[] args) throws FileNotFoundException {

        String line;

        File file = new File("C:\\Users\\Syeda Anoosha\\Downloads\\temp.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        try{
            while ((line = reader.readLine()) != null) {
                String[] read= line.split("=");
                String[] eq1 = read[0].split(", ");
                String[] eq2 = read[1].split(":, ");
                int year = Integer.parseInt(eq1[0]);
                double magnitude = Double.parseDouble(eq1[1]);
                String country = eq2[0].substring(1).trim();
                String city = eq2[1].trim().replace("]", "").replace(",","");
                System.out.println("Year: " + year + "\nMagnitude: " + magnitude + "\nCountry: " + country + "\nCity: " + city+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
