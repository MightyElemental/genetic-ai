package net.minegeek360.ai;

import net.minegeek360.ai.emotion.Emotion;
import net.minegeek360.ai.interaction.Input;
import net.minegeek360.ai.interaction.Output;
import net.minegeek360.ai.language.Dictionary;
import net.minegeek360.ai.language.LanguageInterpreter;
import net.minegeek360.ai.language.Word;
import net.minegeek360.ai.language.WordComManager;

public class GeneticAI
{
  public static String[] settings;
  public static boolean hasGUI = true;
  public static Input input = new Input();
  
  public GeneticAI()
  {
    handleSettings();
    if (hasGUI) {
      AIFrame.setup();
    }
    for (int i = 0; i < Dictionary.presetGreetings.length; i++) {
      Dictionary.addWord(new Word(Dictionary.presetGreetings[i]).addTag("GREETING", "DEFINATE"));
    }
    for (int i = 0; i < Dictionary.presetQuestions.length; i++) {
      Dictionary.addWord(new Word(Dictionary.presetQuestions[i]).addTag("QUESTION", "DEFINATE"));
    }
    for (int i = 0; i < Dictionary.presetPropNouns.length; i++) {
      Dictionary.addWord(new Word(Dictionary.presetPropNouns[i]).addTag("PROP-NOUN", "DEFINATE"));
    }
    WordComManager.createRule("may", "i", "QUESTION");
    
    Output.consoleSay("Hello there!");
    Output.consoleSay("You are about to talk to a chat bot that learns from the users!");
    Output.consoleSay("It has been named '" + name + "' by its master user");
    Output.consoleSay("Type something in and It will try to respond correctly...");
    Output.newLine();
    for (;;)
    {
      LanguageInterpreter.interperate(input.getInputText());
      try
      {
        Thread.sleep(300L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args)
  {
    settings = args;
    new GeneticAI();
  }
  
  public void handleSettings()
  {
    try
    {
      for (int i = 0; i < settings.length; i++) {
        if (settings[i] != null)
        {
          if (settings[i].equals("-p")) {
            this.overallKindness = Integer.parseInt(settings[(i + 1)]);
          }
          if (settings[i].equals("-name")) {
            setName(settings[(i + 1)].replaceAll("_", " "));
          }
          if (settings[i].equals("-confuse")) {
            canBeConfused = Boolean.parseBoolean(settings[(i + 1)]);
          }
          if (settings[i].equals("-gui")) {
            hasGUI = Boolean.parseBoolean(settings[(i + 1)]);
          }
        }
      }
    }
    catch (Exception localException) {}
  }
  
  public int overallKindness = 5;
  private Emotion currentEmotion;
  private static String name = "Gaiben";
  private static boolean isConfused = false;
  private static boolean canBeConfused = true;
  
  public static void setName(String newName)
  {
    name = newName;
  }
  
  public Emotion getCurrentEmotion()
  {
    return this.currentEmotion;
  }
  
  public void setCurrentEmotion(Emotion newEmotion)
  {
    this.currentEmotion = newEmotion;
  }
  
  public static boolean isConfused()
  {
    return (isConfused) && (canBeConfused);
  }
  
  public static void setConfused(boolean conf)
  {
    isConfused = conf;
  }
  
  public static String getName()
  {
    return name;
  }
}
