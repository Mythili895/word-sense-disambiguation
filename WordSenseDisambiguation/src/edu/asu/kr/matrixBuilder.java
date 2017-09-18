package edu.asu.kr;

import java.util.Set;

public class matrixBuilder {
	public int[][] coOccurrenceMatrix(int[][] cMatrix,Set<String> words, String[] sentences)
	{	
		Set<String> keys = words;
		int outer = 0;
		for(String key : keys)
		{
			boolean start = false;
			for(String s : sentences)
			{
				String[] word = s.split(" ");
				for(String w : word)
				{
					w = w.toLowerCase();
					if(start)
					{ 
						/*if(key.equals("album"))
						{
							System.out.println("Hey i found album");
						}*/
						int index = getIndex(keys, w);
						int inner = cMatrix[outer][index];
						inner = inner + 1;
						cMatrix[outer][index] = inner;
					}
					if(w.equals(key))
					{
						//System.out.println("Found one " + w);
						start = true;
					}
					
				}
				start = false;
			}	
			outer = outer + 1;
		}
		
		return cMatrix;
	}
	
	public int getIndex(Set<String> keys, String w)
	{
		int count = 0;
		for(String s : keys)
		{
			if(s.equals(w))
			{
				/*if(s.equals("bitter"))
				{
					System.out.println("hey I found bitter");
				}*/
				return count;
			}
			count = count + 1;
		}
		return count;
	}

}
