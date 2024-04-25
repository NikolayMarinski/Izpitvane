import javax.xml.stream.events.EndDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws UnsuitableApartmentsException {
        List<Apartments> apInfo = new ArrayList<>();

        List<String> cities = Arrays.asList("София", "Варна", "Бургас");

        Map<String, Integer> cityApCounter = new HashMap<>();

        try {
            File file = new File("src/data.txt");

            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                String city = sc.next();
                int roomNum = sc.nextInt();
                int space = sc.nextInt();
                int price = sc.nextInt();
                String phone = sc.next();
                Apartments apartm = new Apartments(city, roomNum, space, price, phone);
                apInfo.add(apartm);


                if (cityApCounter.containsKey(city)) {
                    cityApCounter.put(city, cityApCounter.get(city) + 1);
                } else {
                    cityApCounter.put(city, 1);
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        apInfo.sort((a1, a2) -> Integer.compare(a1.getPrice(), a2.getPrice()));
        int counter = 0;
        Set<String> phoneNumbers = new HashSet<>();
        for(Apartments ap : apInfo){
            if(cities.contains(ap.getCity()) && ap.getSpace()>=100 && ap.getRoomNum()>=3){
                phoneNumbers.add(ap.getPhone());
                counter++;
            }
            if(counter == 5){
                break;
            }
        }

        List<String> topCity = new ArrayList<>(cityApCounter.keySet().stream().toList());
        topCity.sort((c1,c2) -> compareCity(c1,c2, cityApCounter));

        if(phoneNumbers.isEmpty()){
            throw new UnsuitableApartmentsException("No such apartments!");
        }

        File file2 = new File("src/output.txt");

        PrintWriter output = null;
        try {
            output = new PrintWriter(file2);

            for(String phoneNum : phoneNumbers){
                    output.println(phoneNum);
            }
            output.println("The city with the most apartments : " + topCity.get(0));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the file
            output.close();
        }
    }

    private static int compareCity(String ins1, String ins2, Map<String, Integer> map){
        return Integer.compare(map.get(ins2), map.get(ins1));
    }

}