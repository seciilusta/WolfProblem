package secilusta;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static int uniqueWolfs(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int result = -1;

        for (int id : arr) {
            int count = map.getOrDefault(id, 0) + 1;
            map.put(id, count);

            if (count > maxFrequency || (count == maxFrequency && id < result)) {
                maxFrequency = count;
                result = id;
            }
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split("  ")).map(Integer::parseInt).collect(toList());
        int result = Result.uniqueWolfs(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}