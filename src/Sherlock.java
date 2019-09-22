//In this problem, you are Sherlock Holmes and you want to know,
// what number of characters should you delete to get anagrams.
//
//        Note: anagrams are words which contain the same characters with the same frequencies.
//
//        For example: "bnkm" - delete(b,k) to get nm, "dnlm" - delete(d,l) to get nm. Answer - 4(b,k,d,l)
//
//        Remeber: anagrams are case-insensitive
//
//        Sample Input 1:
//
//        bnkm
//        dnlm

//        Sample Output 1:
//        4

import java.util.*;

class Sherlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.next().toLowerCase(Locale.US).split("");
        String[] second = scanner.next().toLowerCase(Locale.US).split("");

        Map<String, Integer> firstMap = createMap(first);
        Map<String, Integer> secondMap = createMap(second);

        int result = 0;

        result = countDiffValues(result, firstMap, secondMap);
        result = countDiffKeys(result, firstMap, secondMap);
        result = countDiffKeys(result, secondMap, firstMap);

        System.out.println(result);
    }

    private static Map<String, Integer> createMap(String[] letters) {
        Map<String, Integer> map = new TreeMap<>();
        for (String currentLetter : letters) {
            if (map.containsKey(currentLetter)) {
                map.put(currentLetter, map.get(currentLetter) + 1);
            } else {
                map.put(currentLetter, 1);
            }
        }
        return map;
    }

    private static int countDiffValues(int count, Map<String, Integer> firstM, Map<String, Integer> secondM) {
        for (Map.Entry<String, Integer> firstKV : firstM.entrySet()) {
            for (Map.Entry<String, Integer> secondKV : secondM.entrySet()) {
                String currentFirstMapKey = firstKV.getKey();
                String currentSecondMapKey = secondKV.getKey();
                Integer currentFirstMapValue = firstKV.getValue();
                Integer currentSecondMapValue = secondKV.getValue();
                if (currentFirstMapKey.equals(currentSecondMapKey)) {
                    count += Math.abs(currentFirstMapValue - currentSecondMapValue);
                }
            }
        }
        return count;
    }

    private static int countDiffKeys(int count, Map<String, Integer> firstM, Map<String, Integer> secondM) {
        for (Map.Entry<String, Integer> firstKV : firstM.entrySet()) {
            String currentFirstMapKey = firstKV.getKey();
            Integer currentFirstMapValue = firstKV.getValue();
            if (!secondM.containsKey(currentFirstMapKey)) {
                count += currentFirstMapValue;
            }
        }
        return count;
    }
}
