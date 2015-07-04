package net.minegeek360.ai.language;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordComManager
{
  private static HashMap<List<String>, String> wordCombinations = new HashMap<List<String>,String>();
  
  public static String getRule(String w1, String w2)
  {
    if (wordCombinations.containsKey(Arrays.asList(new String[] { w1, w2 }))) {
      return (String)wordCombinations.get(Arrays.asList(new String[] { w1, w2 }));
    }
    return "UNKNOWN";
  }
  
  public static void createRule(String w1, String w2, String rule)
  {
    if (!wordCombinations.containsKey(Arrays.asList(new String[] { w1, w2 }))) {
      wordCombinations.put(Arrays.asList(new String[] { w1, w2 }), rule);
    }
  }
}
