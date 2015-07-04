package net.minegeek360.ai.language;

import java.util.ArrayList;
import java.util.Random;
import net.minegeek360.ai.GeneticAI;
import net.minegeek360.ai.interaction.Output;

public class LanguageInterpreter
{
  private static Random rand = new Random();
  
  public static void greet()
  {
    ArrayList<String> temp2 = Dictionary.getAllWordsWithTag("GREETING");
    Output.aiSay((String)temp2.get(rand.nextInt(temp2.size())));
  }
  
  private static void answerQuestion(String sent)
  {
    Output.aiSay("let me answer that question with another question");
    Output.aiSay("what are you talking about");
  }
  
  public static void respond(String lastSaid, String sentType)
  {
    if (sentType.equals("GREETING"))
    {
      greet();
      GeneticAI.setConfused(false);
    }
    else if (sentType.equals("QUESTION"))
    {
      GeneticAI.setConfused(false);
      answerQuestion(lastSaid);
    }
    else
    {
      GeneticAI.setConfused(true);
    }
    if (GeneticAI.isConfused()) {
      Output.aiSay("what");
    }
  }
  
  private static String removePunc(String string)
  {
    return string.replaceAll("[^a-z 1-9]", "");
  }
  
  public static void interperate(String string)
  {
    if (string == null) {
      return;
    }
    string = string.toLowerCase();
    string = removePunc(string);
    Output.userSay(string);
    String[] temp = string.split(" ");
    for (int i = 0; i < temp.length; i++)
    {
      temp[i].replaceAll(" ", "");
      Dictionary.addWord(new Word(temp[i]).addTag("UNKNOWN", "NA"));
    }
    respond(string, Sentence.whatSentenceTypeIsThis(string));
  }
}
