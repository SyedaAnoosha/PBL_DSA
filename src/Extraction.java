import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Extraction {

    public void storing() throws IOException {
        NominatimReverseGeocodingJAPI n = new NominatimReverseGeocodingJAPI();

        File file = new File("D:\\PBL\\Valid countries and cities.csv");

        FileWriter writer = new FileWriter("D:\\PBL\\Valid countries and cities.txt", true);

        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        String line;
        br.readLine();

        while ((line = br.readLine()) != null) {

            String[] read = line.split(","); //csv file
            long d2 = Date.parse(read[1]);
            SimpleDateFormat d = new SimpleDateFormat("yyyy");
            int year = Integer.parseInt(d.format(d2));
            double latitude = Double.parseDouble(read[3]);
            double longitude = Double.parseDouble(read[4]);
            double magnitude = Double.parseDouble(read[9]);

            try {
                Address address = n.getAdress(latitude, longitude);
                String city="",country="";

                if (address != null) {
                    city = address.getCity();
                    country = address.getCountry();
                    System.out.println(city+"  "+country);
                    writer.write(year+", "+magnitude+"=["+country+": "+city+"]\n");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
