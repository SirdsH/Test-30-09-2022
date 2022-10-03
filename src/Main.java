import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("world.csv"));
            String line;
            List<Data> listCities = new ArrayList<>();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] split = line.replace("\"", "").split(";");

                listCities.add(new Data(split[0], split[1], Long.parseLong(split[3].replace("NA", "0")), Long.parseLong(split[4].replace("NA", "0"))));
            }

            long usa = listCities.stream().filter(i -> i.getName().equals("United Kingdom")).findFirst().get().getGdp();
            List first = listCities.stream().filter(i -> i.getContinent().equals("Europe")).filter(i -> i.getGdp() < usa).map(i -> i.getName() + "-" + i.getGdp()).collect(Collectors.toList());

            List second = listCities.stream().filter(i -> i.getContinent().equals("South America") || i.getContinent().equals("Oceania")).map(i -> i.getName()).collect(Collectors.toList());

            long thirdusa = listCities.stream().filter(i -> i.getContinent().equals("Europe")).sorted(((i, j) -> Long.compare(j.getGdp(), i.getGdp()))).findFirst().get().getGdp();
            List third = listCities.stream().filter(i -> i.getGdp() > thirdusa).map(i -> i.getName()).collect(Collectors.toList());

            System.out.println(third);
            System.out.println(first);
            System.out.println(second);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}