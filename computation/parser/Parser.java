import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import computation.contextfreegrammar.*;
import computation.parser.*;
import computation.parsetree.*;
import sun.print.resources.serviceui;
import computation.derivation.*;

public class Parser implements IParser {

  public boolean isInLanguage(ContextFreeGrammar cfg, Word w){

  //get the rules from the input grammar 
  List<Rule> rules = cfg.getRules();
  
  //create an empty arraylist of derivations
  ArrayList<Derivation> derivationList = new ArrayList<Derivation>();

  //create a derivation using the start variable
  Derivation d = new Derivation(new Word(cfg.getStartVariable())); 

  //add this derivation to our derivation list
  derivationList.add(d);

  //set n as the length of the input word
  int n = w.length();

  //initialise the length of the derivation
  int lengthOfDeriv;
  if(n == 0){
    lengthOfDeriv = 1; //as per the requirements
  } else {
    lengthOfDeriv = 2*n-1; //length of derivation that generates w is 2n-1 as per the Chomsky Normal Form theorem
  }
  //set the count as 0
  int count = 0;

  //only get the derivations that are of length 2n - 1 or less
  while(count < lengthOfDeriv){

  //set an empty list of the CURRENT derivation, which we will use to loop around
  ArrayList<Derivation> currentDerivation = new ArrayList<>();

        //for each derivation in initial list
        for(Derivation de : derivationList){
        
            //for each rule in our rules
            for(int r = 0; r < rules.size(); r++){
                
                //see if the rule applies to the latest word in the derivation
                for(int j = 0; j < de.getLatestWord().count(rules.get(r).getVariable()); j++){
                  

                  //set a new derivation from the latest word
                  Derivation newD = new Derivation(de);
                 
                  //add a step to this derivation, which replaces the symbol in the latest word of the derivation on the left hand side of the rule with the corresponding right hand side of the rule 
                  newD.addStep(de.getLatestWord().replace(de.getLatestWord().indexOfNth(rules.get(r).getVariable(), j), rules.get(r).getExpansion()), rules.get(r), de.getLatestWord().indexOfNth(rules.get(r).getVariable(), j));

                  //add this to our current derivation
                  currentDerivation.add(newD);
                }
              }   
            } 
            //add 1 to the count
            count +=1;

            //set the derivation list as the current derivation, and now we shall use this for the next loop to create a new derivation path
            derivationList = currentDerivation;    
        }

    //for every derivation in the list, 
    for(Derivation deriv : derivationList){

     //if the latest word in the derivation is equal to the input word w,
     if(deriv.getLatestWord().equals(w)){

       //then the grammar generates the word. So we return true.
       return true;

       //if not, then 
     } else {
     }
  }
  //return false.
  return false;
  }

  
}
