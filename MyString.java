package uebung07;

public interface MyString {

	public int length();

	public boolean isEmpty();

	public char charAt(int idx);

	public MyString concat(MyString otherMyString);

	public MyString multiply(int m);

	public boolean equals(MyString o);

	public MyString subMyString(int startIdx);

	public MyString subMyString(int startIdx, int endIdx);

	public MyString reverse();

	public MyString toUpperCase();

	public MyString toLowerCase();

	public char[] toCharArray();

	public MyString trim();

	public char getFirstNonDup();

	public int indexOf(MyString s);

	public int indexOf(MyString s, int startIdx);

	public MyString[] split(MyString delimiter);

	public MyString removeUmlauts();

	public String toString();

	public void printFrequencyOfChars();
}
