import java.util.*;

public class SpeechGenerator
{
   ArrayList<Word> dictionary;

   public static void main(String args[])
   {
      SpeechGenerator runner = new SpeechGenerator();
      runner.dictionary = new ArrayList<Word>();
      runner.loadWords();
      runner.generateSpeech();
   }
   
   public void generateSpeech()
   {
      Word noun = null;
      Word adjective = null;
      Word verb = null;
      Word pronoun = null;
      Word interjection = null;
      
      int sentenceStructure = (int)(Math.random()*3);
      
      while(noun == null || adjective == null || verb == null || pronoun == null || interjection == null)
      {
         Word temp = dictionary.get((int)(Math.random()*dictionary.size()-1));
         if(temp.getPOS() == "noun")
         {noun = temp;}
         
         if(temp.getPOS() == "interjection")
         {interjection = temp;}
         
         if(temp.getPOS() == "adjective")
         {adjective = temp;}
         
         if(temp.getPOS() == "pronoun")
         {pronoun = temp;}
         
         if(temp.getPOS() == "verb")
         {verb = temp;}
         
      }
      
      System.out.print("Computer" + " : ");
      
      switch(sentenceStructure) 
      {
         case 0:
         System.out.println(noun + " " + verb + " " + noun + ".");
         break;
         
         case 1:
         System.out.println(pronoun + " " + verb + " " + noun + ".");
         break;
         
         case 2:
         System.out.println(interjection + ", " + pronoun + " " + verb + " " + noun + "!" );
         break;
         
         default:
         System.out.println();
      }
      //String mainCharacter = ;
      
   }
   
   public void loadWords()
   {
      dictionary.add(new Word("hey","interjection","neutral","1980-present","informal"));
      dictionary.add(new Word("cat","noun","neutral","1800-present","neutral"));
      dictionary.add(new Word("dog","noun","neutral","1800-present","neutral"));
      dictionary.add(new Word("money","noun","neutral","1800-present","neutral"));
      dictionary.add(new Word("I","pronoun","neutral","1800-present","neutral"));
      dictionary.add(new Word("frog","noun","neutral","1800-present","neutral"));
      dictionary.add(new Word("red","adjective","neutral","1800-present","neutral"));
      dictionary.add(new Word("blue","adjective","neutral","1800-present","neutral"));
      dictionary.add(new Word("ate","verb","neutral","1800-present","neutral"));
      dictionary.add(new Word("hit","verb","neutral","1800-present","neutral"));
      
   }
   
}