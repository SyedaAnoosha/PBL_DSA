public class Main {
    public static void main(String[] args) throws Exception {


//        //Getting countries from lan and lon
//        Extraction e = new Extraction();
//        e.storing();

        //-------Step1------
        Step1 store = new Step1();
        store.storing();

        //-------Step2------
        Step2 step2 = new Step2();
        step2.biggestMagnitudeEarthquake();

        //------Step3-------
        Step3 step3 = new Step3();
        step3.recentEarthquakes();

        //------Step4-------
        Step4 step4 = new Step4();
        step4.recentEarthquakesLL();




    }
}