//package extract;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class ExtraCode {
//    public static HashMap<Integer, List<Earthquake>>[] yearlyEQS = new HashMap[52];
//    public ArrayList<Object>[] storeEarthquakeData = new ArrayList[52];
//    public void storing() throws IOException {
//
//        File file = new File("D:\\PBL\\Valid countries and cities.txt");
//
//        FileReader fileReader = new FileReader(file);
//        BufferedReader br = new BufferedReader(fileReader);
//        String line;
//        br.readLine();
//
//        List<Earthquake>[] list = new List[52];
//        for (int i = 0; i < yearlyEQS.length; i++) {
//            yearlyEQS[i]=new HashMap<>();
//            list[i] = new ArrayList<>();
//            storeEarthquakeData[i] = new ArrayList<>();
//
//        }
//
//        int y = 1965, L = 0;
//        int j = 0, i = 0;
//        while ((line = br.readLine()) != null && L<1103) {
//
//            String[] read= line.split("=");
//            String[] eq1 = read[0].split(", ");
//            String[] eq2 = read[1].split(": ");
//
//            int year = Integer.parseInt(eq1[0]);
//            double magnitude = Double.parseDouble(eq1[1]);
//            String country = eq2[0].trim().replace("[","");
//            String city = eq2[1].trim().replace("]", "");
//
//            if(year!=y) {
//                j++;
//                i++;
//                y=year;
//                list[i] = new ArrayList<>();
//                storeEarthquakeData[i] = new ArrayList<>();
//            }
//            storeEarthquakeData[i].add(line);
//            list[i].add(new Earthquake(country, city, magnitude, year));
//            // System.out.println("Year: " + year + "\nMagnitude: " + magnitude + "\nCountry: " + country + "\nCity: " + city+"\n");
//
//            yearlyEQS[j].put(year,list[i]);
//            L++;
//        }
//
//    }
//    public void getYearlyEarthquakes(){
//        /*int u = 1965;
//        for (int k = 0; k < yearlyEQS.length; k++) {
//            HashMap<Integer, List<Earthquake>> recent = yearlyEQS[k];
//            for (int l = 0; l < recent.size(); l++) {
//                List<Earthquake> eqlist = recent.get(u);
//                for (int m = 0; m < eqlist.size(); m++) {
//                    Earthquake eq = eqlist.get(m);
//                    System.out.println("\nYear: "+eq.getYear()+"\nMagnitude: "+eq.getMagnitude()+"\nCity: "+eq.getCity()+"\nCountry: "+eq.getCountry());
//                }
//            }
//            u++;
//
//        }*/
//
//        for (int i = 0; i < storeEarthquakeData.length; i++) {
//            Object[] arr = storeEarthquakeData[i].toArray();
//            for (int j = 0; j < arr.length; j++) {
//                System.out.println(storeEarthquakeData[i].get(j));
//            }
//        }
//
//    }
//
//}