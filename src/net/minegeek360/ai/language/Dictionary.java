package net.minegeek360.ai.language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dictionary
{
  private static Word[] knownWords = new Word[99999];
  private static Map<String, Integer> knownWordsKey = new HashMap<String,Integer>();
  public static final String[] presetGreetings = { "hello", "hi", "greetings", "hey", "howdy", "greetings", "hiya" };
  public static final String[] presetQuestions = { "what", "where", "who", "when", "why", "how", "do", "can", "does" };
  public static final String[] presetPropNouns = { "james", "noe", "evan", "oliver", "reilly", "keean", "aaron", "john", "ahna", "ged", "joe", "fiona", "emma", "i" };
  
  public static void addWord(Word word)
  {
    for (int i = 0; i < knownWords.length; i++) {
      if (knownWords[i] != null)
      {
        if (!knownWords[i].toString().equals(word.toString())) {}
      }
      else
      {
        knownWords[i] = word;
        knownWordsKey.put(word.toString(), i);
        return;
      }
    }
  }
  
  public static Word[] getKnownWords()
  {
    return knownWords;
  }
  
  public static Map<String, String> getWordTags(String string)
  {
    if (knownWordsKey.containsKey(string)) {
      return knownWords[((Integer)knownWordsKey.get(string)).intValue()].getTags();
    }
    return null;
  }
  
  public static String[] getWordTagsArray(String string)
  {
    return (String[])getWordTags(string).entrySet().toArray();
  }
  
  public static ArrayList<String> getAllWordsWithTag(String tag)
  {
    ArrayList<String> temp = new ArrayList<String>();
    for (int i = 0; i < knownWords.length; i++) {
      if ((knownWords[i] != null) && 
        (knownWords[i].getTags().containsKey(tag))) {
        temp.add(knownWords[i].toString());
      }
    }
    return temp;
  }
}
