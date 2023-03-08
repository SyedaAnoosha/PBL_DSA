import java.io.IOException;
import java.util.*;

public class Step2 {

    HashMap<Integer, List<Earthquake>>[] yearlyEQS = Step1.yearlyEQS;

    public void biggestMagnitudeEarthquake() throws IOException {
        Queue<Earthquake>[] earthquakeQueue = new Queue[52];
        int years = 1965;

        for (int i = 0; i < earthquakeQueue.length; i++) {
            earthquakeQueue[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < yearlyEQS.length; i++) {

            double maxMag = 0;
            Earthquake maxEQ = null;

            HashMap<Integer, List<Earthquake>> yearMap = yearlyEQS[i];
            List<Earthquake> eqList = yearMap.get(years);

            //System.out.println("Year " + years + ": " + eqList.size() + " earthquakes");
            Collections.sort(eqList);

            for (Earthquake eq : eqList) {
                if (eq.getMagnitude() > maxMag) {
                    maxMag = eq.getMagnitude();
                    maxEQ = eq;
                }
            }

            earthquakeQueue[i].offer(maxEQ); //offer is used to insert earthquake of possible otherwise return false
            years++;
        }

        for (int i = 0; i < earthquakeQueue.length; i++) {
            Earthquake e = earthquakeQueue[i].peek();
            if (e != null) {
                System.out.println(e.getMagnitude()+" "+e.getYear());
            }

        }
    }
}
