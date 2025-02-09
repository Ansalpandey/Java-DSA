package Blind75;

import java.util.Arrays;

public class IsAnagram {
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
	}
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();

		Arrays.sort(sChars);
		Arrays.sort(tChars);
		return Arrays.equals(sChars, tChars);
	}
}
