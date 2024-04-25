import javax.xml.stream.events.EndDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Apartments> apInfo = new ArrayList<>();

        try {
            File file = new File("src/data.txt");

            Scanner sc = new Scanner(file);


            Map<String, Integer> cityApCounter = new HashMap<>();
            //VIN, owners
            Map<String, Set<String>> phoneNum = new HashMap<>();
            //Map<String, Integer>


            while (sc.hasNext()) {
                String city = sc.next();
                int roomNum = sc.nextInt();
                int space = sc.nextInt();
                int price = sc.nextInt();
                String phone = sc.next();
                Apartments apartm = new Apartments(city, roomNum, space, price, phone);
                apInfo.add(apartm);


                if (phoneNum.get(city) == null) {
                    phoneNum.put(city, new HashSet<>());
                }
                phoneNum.get(city).add(phone);

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

        Collections.sort(apInfo);
        if (!apInfo.get(0).getCity().equals("София") && !apInfo.get(0).getCity().equals("Бургас") && !apInfo.get(0).getCity().equals("Варна")) {
            try {
                throw new UnsuitableApartmentsException("No Apartmentss matching the descrtiption");
            } catch (UnsuitableApartmentsException e) {
                e.printStackTrace();
            }
        } else {
            if (apInfo.get(0).getRoomNum() != 3 || apInfo.get(0).getSpace() <= 100) {
                try {
                    throw new UnsuitableApartmentsException("No Apartmentss matching the descrtiption");
                } catch (UnsuitableApartmentsException e) {
                    e.printStackTrace();
                }
            } else {
                File file2 = new File("src/output.txt");

                PrintWriter output = null;
                try {
                    output = new PrintWriter(file2);

                    for (int i = 0; i < 5; i++) {
                        Apartments p = apInfo.get(i);
                        if (!p.getCity().equals("София") && !p.getCity().equals("Бургас") && !p.getCity().equals("Варна") || (p.getPrice() <= 100 || p.getPrice() != 3)) {
                            break;
                        }
                        boolean fl = true;
                        for (int j = i - 1; j >= 0; j--) {
                            if (apInfo.get(j).getPhone().equals(p.getPhone())) {
                                fl = false;
                            }
                        }
                        if (fl) {
                            output.append(p.getPhone() + '\n');
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    output.close();
                }
            }
        }
    }
}