package org.example.utilities;

/*

while search index is less than the length of the string:

  if the parsechar and searchchar are equal and we haven't reached the end of the parse index
    increment both
  
  if the parsechar is equal to wildcard and we haven't reached the end:
    increment both

  if the parsechar is equal to *
    save the positions we need to return to in failure
    increment parsechar

  if the positions to return to are in the vectors
    we need parsekey to go back to the saved position
    we need saved search to go up, and to move search there

  else: return false

  if the parseIndex is equal to the length of p, return true, else return false
  
*/

public class WildCardMatcher {
    public static boolean isMatch(String s, String p) {

	// System.out.println();
	// System.out.println("Word is " + s + "=============");
	// System.out.println("The parse is " + p);
	
	int searchIndex = 0; int parseIndex = 0; // searchIndex s pos and parse is p pos
	int reStart = -1; int starIndex = -1; // reStart is search and star is parse
	int iteration = 1;

	if (p.length() == 0 && !(s.length() == 0)) { return false; }
	
	if (s.length() == 0) {
	    for (int i = 0; i < p.length(); i++) {
		if (p.charAt(i) != '*') { return false; }
	    }
	    return true;
	}

	if (s.length() == 1 && p.length() == 1) { 
	    if (s.length() == p.length() && s.charAt(searchIndex) == p.charAt(parseIndex)) {
		return true;
	    } else if (p.charAt(parseIndex) == '?') { return true;
	    } else if ('*' == p.charAt(parseIndex)) {
		return true;
	    } else {return false;}
	} // handles single letter strings
	
	
	while (searchIndex < s.length()) {

	    // System.out.println("Iteration " + iteration + "========");
	    // System.out.println("Search index is " + searchIndex);
	    // System.out.println("parse index is " + parseIndex);
	    // System.out.println("reStart is " + reStart);
	    // System.out.println("starIndex is " + starIndex);
	    // iteration++;
	    
	    if (parseIndex < p.length() && (s.charAt(searchIndex) == p.charAt(parseIndex))) {
		// System.out.println("Base Equivalence");
		searchIndex++; parseIndex++; // base equivalence
		
	    } else if (parseIndex < p.length() && (p.charAt(parseIndex) == '?')) {
		// System.out.println("Wildcard");
		searchIndex++; parseIndex++; // wildcard
		
	    } else if (parseIndex < p.length() && (p.charAt(parseIndex) == '*')) {
		// System.out.println("Star");
		starIndex = parseIndex; reStart = searchIndex;
		parseIndex++;
		
	    } else if (-1 < reStart && reStart < s.length()) {
		// System.out.println("Starguarded");
		parseIndex = starIndex + 1;
		reStart++; searchIndex = reStart;
		
	    } else { /*System.out.println("caught by the bell")*/ ;return false; }

	}

	while (parseIndex < p.length() && p.charAt(parseIndex) == '*') { parseIndex++; }
	
	// System.out.println("Reached the end");
	return parseIndex == p.length();
    }
}





