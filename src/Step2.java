import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Step2 {

    public static Queue<Earthquake> maxEarthquake= new LinkedList<>();

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
            //System.out.println(country +" "+mag+" "+year);
            maxEarthquake.add(new Earthquake(country,mag,year));
        }
    }

    public void problem2(){
        System.out.println("\n\n        -------- Problem 2 -------- ");
        while(!maxEarthquake.isEmpty()){
            Earthquake e = maxEarthquake.poll();
            if(e.getYear() >= 2005 && e.getYear() <= 2015 ) {
                System.out.println("\nYear: "+e.getYear()+"\nHighest Magnitude: "+e.getMagnitude()+"  Country: "+e.getCountry());
            }
        }
    }
}
