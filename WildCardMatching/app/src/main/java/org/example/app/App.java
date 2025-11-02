package org.example.app;

import java.util.ArrayList;
import java.util.List;

import org.example.utilities.WildCardMatcher;

/*


*/ 

public class App {
    public static void main(String[] args) {

	ArrayList<String>testStrings = new ArrayList<>();
	ArrayList<String>testParsers = new ArrayList<>();
	ArrayList<Boolean> testOutcomes = new ArrayList<>();
	
	wildCardTester(testStrings, testParsers, testOutcomes);
	
    }

    public static void arrayFillers (ArrayList<String> strs, ArrayList<String> prsrs, ArrayList<Boolean> booleans) {

	strs.addAll(List.of("aa", "aa", "cb", "nx4b", "Better", "Brain", "Brain", "adceb", "", "a", "abcabczzzde", "aaa", "aa", "a"));
	prsrs.addAll(List.of("a", "*", "?a", "?x4b", "*er", "?r*e", "?r*n", "*a*b", "*******", "aa", "*abc???de", "aa", "aaa", "a*"));
	booleans.addAll(List.of(false, true, false, true, true, false ,true ,true, true, false, true, true, false, true));

    } // filler command

    public static void wildCardTester (ArrayList<String> testStrings, ArrayList<String> testParsers, ArrayList<Boolean> testOutcomes) {
	
	boolean works = true;
	
	if (testStrings.size() == testParsers.size() && testStrings.size() == testOutcomes.size()) {
	    for (int i = 0; i < testOutcomes.size(); i++) {
		if (WildCardMatcher.isMatch(testStrings.get(i), testParsers.get(i)) != testOutcomes.get(i)) {
		    System.out.println("Failure at test " + (i + 1));
		    System.out.println("String: " + testStrings.get(i));
		    System.out.println("Parser: " + testParsers.get(i));
		    System.out.println("Expected outcome: " + testOutcomes.get(i));
		    System.out.println("Actual outcome: " + WildCardMatcher.isMatch(testStrings.get(i), testParsers.get(i)));
		    works = false;
		}
	    }
	} else {
	    System.out.println("Something isn't updated");
	    System.out.println("Strings: " + testStrings.size());
	    System.out.println("Parsers: " + testParsers.size());
	    System.out.println("Outcomes: " + testOutcomes.size());
	}

	if (works) {
	    System.out.println("Works in all test cases");
	}
	

    } // actual tester

    // public static void grep (String chunk, String query) {

    // 	String regex = "./"
    // 	String[] myStrings = chunk.split()
	
    // }
}
