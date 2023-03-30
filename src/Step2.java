import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Step2 {

    public Queue<Earthquake> maxEarthquake= new LinkedList<>();

    public void highestMagnitude() throws IOException {

        File f = new File("D:\\PBL\\Max Magnitude.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = "";

        while((line=br.readLine()) != null){

            String[] read = line.split(": ");
            String country = read[0];
            String[] data= read[1].split(",");
            double mag = Double.parseDouble(data[0]);
            int year = Integer.parseInt(data[1]);
            maxEarthquake.add(new Earthquake(country,mag,year));
        }
    }

    public void problem2(){
        Earthquake[] arr = maxEarthquake.toArray(new Earthquake[0]);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getYear() >= 2005 && arr[i].getYear() <= 2015 ) {
                System.out.println("Magnitude: "+arr[i].getMagnitude()+"  Country: "+arr[i].getCountry());
            }
        }
    }
}
