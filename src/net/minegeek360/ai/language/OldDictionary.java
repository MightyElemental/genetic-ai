package net.minegeek360.ai.language;

import java.util.HashMap;
import java.util.Map;

public class OldDictionary
{
  private static Map<String, String> knownWords = new HashMap<String,String>();
  public static final String[] presetGreetings = { "hello", "hi", "greetings", "hey", "howdy", "greetings", "hiya" };
  public static final String[] presetQuestions = { "what", "where", "who", "when", "why", "how", "do", "can" };
  
  public static void addWord(String string, String catagory)
  {
    if (!knownWords.containsKey(string)) {
      knownWords.put(string, catagory);
    }
  }
  
  public static Object[] getWordMapAsArray()
  {
    return knownWords.keySet().toArray();
  }
  
  public static Object[] getWordMeaningMapAsArray()
  {
    Object[] temp = knownWords.entrySet().toArray();
    for (int i = 0; i < temp.length; i++) {
      temp[i] = temp[i].toString().split("=")[1];
    }
    return temp;
  }
  
  public static Map<String, String> getKnownWords()
  {
    return knownWords;
  }
  
  public static String getWordType(String string)
  {
    return (String)knownWords.get(string);
  }
}
