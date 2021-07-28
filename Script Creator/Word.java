public class Word
{
   private String word;
   private String POS;
   private String tone;
   private String timePeriod;
   private String formality;
   private boolean isName;
   private boolean isPlace;
   
   public Word(String word, String POS, String tone, String timePeriod, String formality)
   {
      this.word = word;
      this.POS = POS;
      this.tone = tone;
      this.timePeriod = timePeriod;
      this.formality = formality;
      isName = false;
      isPlace = false;
   }
   
   public Word(String word, String POS, String tone, String timePeriod, String formality, boolean isName, boolean isPlace)
   {
      this.word = word;
      this.POS = POS;
      this.tone = tone;
      this.timePeriod = timePeriod;
      this.formality = formality;
      this.isName = isName;
      this.isPlace = isPlace;
   }
   
   public String getPOS()
   {return POS;}
   
   public String getTone()
   {return tone;}
   
   public String getTimePeriod()
   {return timePeriod;}
   
   public String getFormality()
   {return formality;}
   
   public void setIsName(boolean isName)
   {this.isName = isName;}
   
   public void setIsPlace()
   {this.isPlace = isPlace;}
   
   public String toString()
   {
      return word;
   }
   
}