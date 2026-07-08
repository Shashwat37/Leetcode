import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char ch;

        for(int i = 0; i < s.length(); i++)
        {
            ch = s.charAt(i);
            if(map.containsKey(ch))
            {
                map.put(ch, map.get(ch) + 1);
            }
            else
            {
                map.put(ch, 1);
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < list.size(); i++)
        {
            char c = list.get(i);
            int freq = map.get(c);

            for(int j = 0; j < freq; j++)
            {
                result.append(c);
            }
        }

        return result.toString();
    }
}