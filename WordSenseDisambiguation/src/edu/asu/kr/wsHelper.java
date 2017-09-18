package edu.asu.kr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import edu.cmu.lti.lexical_db.ILexicalDatabase;
import edu.cmu.lti.lexical_db.NictWordNet;
import edu.cmu.lti.ws4j.RelatednessCalculator;
import edu.cmu.lti.ws4j.impl.HirstStOnge;
import edu.cmu.lti.ws4j.impl.JiangConrath;
import edu.cmu.lti.ws4j.impl.LeacockChodorow;
import edu.cmu.lti.ws4j.impl.Lesk;
import edu.cmu.lti.ws4j.impl.Lin;
import edu.cmu.lti.ws4j.impl.Path;
import edu.cmu.lti.ws4j.impl.Resnik;
import edu.cmu.lti.ws4j.impl.WuPalmer;
import edu.cmu.lti.ws4j.util.WS4JConfiguration;
public class wsHelper {

private static ILexicalDatabase db = new NictWordNet();
public int findCluster(HashMap<Integer, ArrayList<String>> arrayLists, String word)
{
	Set<Integer> keys = arrayLists.keySet();
	for(int i : keys)
	{
		for(String s : arrayLists.get(i))
		{
			if(s.equals(word))
			{
				return i;
			}
		}
	}
	
	return -1;
	
}

public double findSimilarity(ArrayList<String> keywords, ArrayList<String> cluster)
{
	double score = 0.0;
	double count=0.0;
	System.out.println("Computing scores");
	for(String k : keywords)
	{
		for(String c : cluster)
		{
			score += compute(k, c);
			count = count + 1.0;
		}
	}
	
	return score/count;
}

// borrowed from http://www.programcreek.com/2014/01/calculate-words-similarity-using-wordnet-in-java/
public double compute(String word1, String word2) {
	WS4JConfiguration.getInstance().setMFS(true);
	double s = new WuPalmer(db).calcRelatednessOfWords(word1, word2);
	return s;
}
}
