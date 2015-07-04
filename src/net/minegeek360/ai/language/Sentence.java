package net.minegeek360.ai.language;

import java.util.ArrayList;

public class Sentence
{
  public static final String QUESTION = "QUESTION";
  public static final String GREETING = "GREETING";
  public static final String STATEMENT = "STATEMENT";
  
  public static String whatSentenceTypeIsThis(String sent)
  {
    String[] temp = sent.split(" ");
    ArrayList<String> temp2 = Dictionary.getAllWordsWithTag("GREETING");
    for (int i = 0; i < temp2.size(); i++)
    {
      if (temp2.get(i) == null) {
        break;
      }
      if (((String)temp2.get(i)).equals(temp[0])) {
        return "GREETING";
      }
    }
    temp2 = Dictionary.getAllWordsWithTag("QUESTION");
    System.out.println(temp.length);
    if (temp.length > 1)
    {
      System.out.println("YES " + WordComManager.getRule(temp[0], temp[1]));
      if (WordComManager.getRule(temp[0], temp[1]).equals("QUESTION")) {
        return "QUESTION";
      }
    }
    for (int i = 0; i < temp2.size(); i++)
    {
      if (temp2.get(i) == null) {
        break;
      }
      if (((String)temp2.get(i)).equals(temp[0])) {
        return "QUESTION";
      }
    }
    return "UNKNOWN";
  }
}
