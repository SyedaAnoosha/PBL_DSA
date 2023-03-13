import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Step3 {
    public static Stack<Object>[] recentEQ = new Stack[110];
    Scanner sc = new Scanner(System.in);

    public static String[] countries = {"United States", "中国", "Indonesia", "ایران", "Philippines", "Chile", "Vanuatu", "臺灣", "Papua Niugini",
            "Ελλάς", "Argentina", "नेपाल", "日本", "México", "República Dominicana", "Solomon Islands", "South Georgia and the South Sandwich Islands",
            "Colombia", "Perú", "Antigua and Barbuda", "Zambia", "Guatemala", "မြန်မာ", "République démocratique du Congo", "New Zealand/Aotearoa",
            "Venezuela", "Монгол улс ᠮᠤᠩᠭᠤᠯ ᠤᠯᠤᠰ", "Bolivia", "Россия", "Türkiye", "Тоҷикистон", "France", "Brasil", "India", "Ecuador", "Tonga",
            "Viti", "Australia", "Panamá", "Belau", "Canada", "Ísland", "افغانستان", "پاکستان", "འབྲུགཡུལ་", "Costa Rica", "Nicaragua", "British Indian Ocean Territory",
            "Shqipëria", "ኢትዮጵያ", "مصر", "Italia", "South Africa", "El Salvador", "Bosna i Hercegovina / Босна и Херцеговина", "Кыргызстан",
            "Oʻzbekiston", "Djibouti جيبوتي", "Қазақстан", "România", "ประเทศไทย", "Madagasikara / Madagascar", "Gabon", "Norge", "Cuba", "España",
            "Tanzania", "België / Belgique / Belgien", "Malaysia", "Србија", "Crna Gora / Црна Гора", "ኤርትራ Eritrea إرتريا", "Algérie / ⵍⵣⵣⴰⵢⴻⵔ / الجزائر",
            "Việt Nam", "ປະເທດລາວ", "Polska", "Honduras", "العراق", "Türkmenistan", "Saint Kitts and Nevis", "Guinée", "اليمن", "საქართველო", "বাংলাদেশ", "Kalaallit Nunaat",
            "Malawi", "Portugal", "Kenya", "South Sudan", "Micronesia", "България", "Uganda", "Hrvatska", "Maroc / ⵍⵎⵖⵔⵉⴱ / المغرب", "Jamaica", "السودان", "Trinidad and Tobago",
            "Հայաստան", "Северна Македонија", "Paraguay / Paraguái", "Κύπρος - Kıbrıs", "السعودية", "Dominica", "Azərbaycan", "سوريا", "Soomaaliya الصومال",
            "Slovenija", "Kosova / Kosovo", "Moçambique", "Ayiti"};


    public int countryIndex(String country){
        for (int i = 0; i < countries.length; i++) {
            if(country.equalsIgnoreCase(countries[i])){
                return i;
            }
        }
        return -1;
    }

    public Stack<Object>[] getStack() throws IOException {

        for (int i = 0; i < recentEQ.length; i++) {
            recentEQ[i] = new Stack<>();
        }

        File file = new File("D:\\PBL\\Stack.txt");
        BufferedReader bf = new BufferedReader(new FileReader(file));
        int j = 0;
        String line = "";
        while ((line = bf.readLine()) != null) {
            String[] read = line.split(", ");
            for (int i = 0; i < read.length; i++) {
                recentEQ[j].push(read[i]);
            }
            j++;
        }
        return recentEQ;
    }

    public void getAllRecentEarthquake() throws IOException {

        System.out.println("Enter country name:");
        String country = sc.nextLine();
        int index = countryIndex(country);
        while(index == -1){
            System.out.println("Enter valid country name!");
            country = sc.nextLine();
            index = countryIndex(country);
        }

        Stack<Object>[] recentStack = getStack();
        Object[] arr = recentStack[index].toArray();
        System.out.println(Arrays.toString(arr));

    }
    public void problem3() throws IOException {

        System.out.println("\n\n        -------- Problem 3 -------- ");


        System.out.println("Enter country name:");
        String country = sc.nextLine();
        int index = countryIndex(country);

        while(index == -1){
            System.out.println("Enter valid country name!");
            country = sc.nextLine();
            index = countryIndex(country);
        }

        System.out.println("Number of recent Earthquakes you want to get: ");
        int recentNumber = sc.nextInt();

        Stack<Object>[] recentStack = getStack();
        Object[] arr = recentStack[index].toArray();

        int length = arr.length - recentNumber;
        for (int i = length; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }



}