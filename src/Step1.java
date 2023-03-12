import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Step1 {
    public ArrayList<String>[] storeEarthquakeData = new ArrayList[52];
    Scanner sc = new Scanner(System.in);

    public void storing() throws IOException {

        File file = new File("D:\\PBL\\Valid countries and cities.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        br.readLine();

        for (int i = 0; i < storeEarthquakeData.length; i++) {
            storeEarthquakeData[i] = new ArrayList<>();
        }

        int y = 1965, L = 0, i = 0;
        while ((line = br.readLine()) != null && L<1103) {

            String[] read= line.split("=");
            String[] eq1 = read[0].split(", ");

            int year = Integer.parseInt(eq1[0]);
            if(year!=y) {
                i++;
                y=year;
                storeEarthquakeData[i] = new ArrayList<>();
            }
            storeEarthquakeData[i].add(line);
            L++;
        }

    }
    public void getYearlyEarthquakes(){

        for (int i = 0; i < storeEarthquakeData.length; i++) {
            Object[] arr = storeEarthquakeData[i].toArray();
            System.out.println(Arrays.toString(arr));
        }

    }

    public void getAverageCountries(){
        System.out.println("\n\nEnter country name:");
        String country = sc.nextLine();
        int year = 1965;

        for (int i = 0; i < storeEarthquakeData.length; i++) {
            int numberOfEQ = 0;
            String[] arr = storeEarthquakeData[i].toArray(new String[0]);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].contains(country)){
                    numberOfEQ++;
                }
            }
            if(numberOfEQ==0){
                System.out.println("No earthquake in "+year);
            }else {
                System.out.println("Average number of Earthquake in year " + year + " is " + numberOfEQ);
            }
            year++;
        }

    }
}