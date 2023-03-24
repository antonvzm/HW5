import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class twoTask {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        createAndSortLs(ls);
        nameCount(ls);
        Map<String, Integer> map = convert(ls);
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(sortedMap);
    }

    public static List<String> createAndSortLs(List<String> ls) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("name.txt"));
            String line = reader.readLine();
            while (line != null) {
                ls.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(ls);
        return ls;
    }

    public static List<String> nameCount(List<String> ls) {
        Integer temp = 0;

        for (int i = 0; i < ls.size(); i++) {
            String nameI = ls.get(i);
            nameI = nameI.split(" ")[0];
            for (int j = 0; j < ls.size(); j++) {
                String nameJ = ls.get(j);
                nameJ = nameJ.split(" ")[0];
                if (nameI.equals(nameJ)) {
                    temp++;

                }

            }
            ls.set(i, ls.get(i) + ":" + temp);
            temp = 0;
        }
        return ls;
    }

    public static Map<String, Integer> convert(List<String> ls) {
        Map<String, Integer> hashMapName = new LinkedHashMap<>();
        for (int i = 0; i < ls.size(); i++) {
            String name = ls.get(i);
            String str = name.split(":")[1];
            int value = Integer.parseInt(str);
            hashMapName.put(name.split(":")[0], value);
        }
        return hashMapName;
    }
}