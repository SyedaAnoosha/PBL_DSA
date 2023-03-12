package extract;

import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class ExtractMaxMagnitude {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/eqdata";
        String uname = "root";
        String pass = "Paglotkhan03!";

        NominatimReverseGeocodingJAPI n = new NominatimReverseGeocodingJAPI();
        FileWriter writer = new FileWriter("D:\\PBL\\Max Magnitude.txt", true);
        String country = "";
        int year = 1965;

        while(year!=2017) {
            String query = "SELECT latitude, longitude, magnitude, Date FROM earthquake WHERE Date LIKE '%"+year+"%'\n" +
                    "ORDER BY SUBSTR(Date, -4), magnitude DESC;\n";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection com = DriverManager.getConnection(url, uname, pass);
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                double lat = rs.getDouble("latitude");
                double lon = rs.getDouble("longitude");
                double mag = rs.getDouble("magnitude");

                Address address = n.getAdress(lat, lon);
                if (address != null) {
                    country = address.getCountry();
                    if (!country.equals("")) {
                        writer.write(country + ": " + mag +","+year+"\n");
                        year++;
                        break;
                    }
                }

            }
        }
        writer.close();
    }
}