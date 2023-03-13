import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Step4 {
    Step3 step3 = new Step3();
    Stack<Object>[] newStack = step3.getStack();

    Scanner sc = new Scanner(System.in);
    LinkedList<Object> mostRecentEQ = new LinkedList<>();

    public Step4() throws IOException {}
    public void storeMostRecentEarthquake(){
        for (int i = 0; i <  newStack.length; i++) {
            if(newStack[i] != null) {
                mostRecentEQ.add(newStack[i].peek());
            }
        }
    }
    public void getMostRecentEarthquake() throws IOException {

        System.out.println("Enter the country for getting its record");
        String country = sc.nextLine();
        int index = step3.countryIndex(country);

        while(index == -1){
            System.out.println("Enter the valid country for getting its record");
            country = sc.nextLine();
            index = step3.countryIndex(country);
        }

        System.out.println("Most recent Earthquake in "+ mostRecentEQ.get(index));

    }
    public void problem4() {

        System.out.println("\n\n        -------- Problem 4 -------- ");

        System.out.println("All the Most Recent Earthquakes in all the countries above 6 Magnitude: \n");
        double maxMag = 6.0;
        for (int i = 0; i < mostRecentEQ.size(); i++) {
            String data = mostRecentEQ.get(i).toString();
            String[] read = data.split(": ");
            double mag = Double.parseDouble(read[2]);
            if(mag > maxMag){
                System.out.println(data);
            }
        }



    }
}