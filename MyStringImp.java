package uebung07;

import static pr.MakeItSimple.println;

import pr.MakeItSimple.PR1Exception;

public class MyStringImp implements MyString {

	/*
	 * In den Konstruktoren durfen keine Methoden der Klasse Â¨ String verwendet
	 * werden, die â€œunerlaubte Erleichterungenâ€� darstellen; d.h. nur length und
	 * charAt sind erlaubt. Ebenfalls ist die Umwandlung von einem int in einen
	 * String im Konstruktor nicht erlaubt.
	 */
	// Einziges Instanz-Attribut, welches in der MyString-Klasse sein darf
	// (Konstante)
	private final char[] myString;

	// constructor
	public MyStringImp() {
		myString = new char[0];
	}

	public MyStringImp(String s) {
		if (s == null)
			throw new PR1Exception("Invalid input!");
		myString = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			this.myString[i] = s.charAt(i);
		}
	}

	public MyStringImp(MyString s) {
		if (s == null)
			throw new PR1Exception("Invalid input!");
		myString = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			myString[i] = s.charAt(i);
		}
	}

	public MyStringImp(char c) {
		myString = new char[1];
		myString[0] = c;
	}

	public MyStringImp(char[] c) {
		myString = new char[c.length];
		for (int i = 0; i < c.length; i++) {
			myString[i] = c[i];
		}
	}

	public MyStringImp(int i) {
	        int length = 0;      
	        String iString = i + "";
	        length  = iString.length();
	        myString = new char[length];
	       
	       for(int f = 0;f<myString.length;f++)
	        {
	        
	        	myString[f] =iString.charAt(f);
	        }
	}

	// methods
	public char charAt(int idx) {
		int length = new MyStringImp(myString).length();
		if (idx >= length || idx < 0)
			throw new PR1Exception("Invalid input!");
		else
			return myString[idx];
	}

	public int length() {
		int count = 0;
		for (int i : myString) {
			count++;
		}
		return count;
	}

	public boolean isEmpty() {
		int length = new MyStringImp(myString).length();
		if (length == 0)
			return true;
		return false;
	}

	public MyString concat(MyString otherMyString) {
		if (otherMyString == null)
			throw new PR1Exception("Invalid input!");
		char[] firsthalf = new MyStringImp(myString).toCharArray();
		char[] secondHalf = otherMyString.toCharArray();
		int firsthalfLength = new MyStringImp(firsthalf).length();
		int seconhalfLength = new MyStringImp(secondHalf).length();
		char[] completeChar = new char[firsthalfLength + seconhalfLength];
		int completeStringLength = new MyStringImp(completeChar).length();
		int counter = 0;
		for (int i = 0; i < firsthalfLength; i++) {
			completeChar[i] = firsthalf[i];
		}
		for (int i = firsthalfLength; i < completeStringLength; i++) {
			completeChar[i] = secondHalf[counter++];
		}

		MyString completeMyString = new MyStringImp(completeChar);
		return completeMyString;
	}

	public MyString multiply(int m) {
		if (m < 0)
			throw new PR1Exception("Invalid input!");
		char[] fixedValue = new MyStringImp(myString).toCharArray();
		int fixedValueLength = new MyStringImp(fixedValue).length();
		char[] multiplyedString = new char[fixedValueLength * m];
		int multiplyedStringLength = new MyStringImp(multiplyedString).length();
		int reputation = 0;
		if (m == 0) {
			for (int i = 0; i < multiplyedStringLength; i++) {
				multiplyedString[i] = ' ';
			}
		} else {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < fixedValueLength ; j++) {

					multiplyedString[reputation++] = fixedValue[j];
				}
			}
		}
		MyString returnedValue = new MyStringImp(multiplyedString);
		return returnedValue;
	}

	public boolean equals(MyString o) {
		if (o == null)
			throw new PR1Exception("Invalid input!");
		char[] comperedvalue = o.toCharArray();
		int oLength = new MyStringImp(o).length();

		for (int i = 0; i < oLength; i++) {
			char selectedValue = comperedvalue[i];
			if (myString[i] != selectedValue)
				return false;
		}
		return true;
	}

	public MyString subMyString(int startIdx) {
		if (0 >= startIdx)
			throw new PR1Exception("Invalid input!");
		int counter = 0;
		int myStringLength = new MyStringImp(myString).length(); 
		if (myStringLength < startIdx)
			throw new PR1Exception("Invalid input!");
		char[] subedArray = new char[myStringLength - startIdx]; 
		for (int i = startIdx; i < myStringLength; i++) {
			char selectedValue = new MyStringImp(myString).charAt(i);
			subedArray[counter++] = selectedValue;
		}
		MyString subedMyString = new MyStringImp(subedArray);
		return subedMyString;
	}

	public MyString subMyString(int startIdx, int endIdx) {
		if (0 >= startIdx)
			throw new PR1Exception("Invalid input!");
		if (0 >= endIdx)
			throw new PR1Exception("Invalid input!");
		int counter = 0;
		int myStringLength = new MyStringImp(myString).length();
		if (myStringLength < startIdx || startIdx > endIdx)
			throw new PR1Exception("Invalid input!");
		char[] subedArray = new char[endIdx - startIdx];
		for (int i = startIdx; i < endIdx; i++) {
			char selectedValue = new MyStringImp(myString).charAt(i);
			subedArray[counter++] = selectedValue;
		}
		MyString subedMyString = new MyStringImp(subedArray);
		return subedMyString;
	}

	public MyString reverse() {
		int length = new MyStringImp(myString).length();
		int reversedCounter = length;
		char[] reversed = new char[length];
		for (int i = 0; i < length; i++) {
			reversed[--reversedCounter] = myString[i];
		}
		MyString reversedValue = new MyStringImp(reversed);
		return reversedValue;
	}

	public MyString toUpperCase() {
		int length = new MyStringImp(myString).length();
		char[] upperCased = new char[length];
		for (int i = 0; i < length; i++) {
			if (myString[i] >= 'a' && myString[i] <= 'z')
				upperCased[i] = (char) (myString[i] - 32);
			else
				upperCased[i] = myString[i];
		}
		MyString upperCasedValue = new MyStringImp(upperCased);
		return upperCasedValue;
	}

	public MyString toLowerCase() {
		int length = new MyStringImp(myString).length();
		char[] lowerCased = new char[length];
		for (int i = 0; i < length; i++) {
			if (myString[i] >= 'A' && myString[i] <= 'Z')
				lowerCased[i] = (char) (myString[i] + 32);
			else
				lowerCased[i] = myString[i];
		}
		MyString lowerCasedValue = new MyStringImp(lowerCased);
		return lowerCasedValue;

	}

	public char[] toCharArray() {
		return myString;
	}

	public MyString trim() {
		int length = new MyStringImp(myString).length();
		int counter = 0;
		int reversedCounter = 0;
		for (int i = 0; i < length; i++) {
			if (myString[i] != ' ')
				break;
			else
				counter++;
		}
		for (int i = length - 1; i >= 0; i--) {
			if (myString[i] != ' ')
				break;
			else
				reversedCounter++;
		}
		int trimedLength = length - (counter + reversedCounter);
		if (trimedLength <= 0) {
			char completedArray = ' ';
			MyString trimedValue = new MyStringImp(completedArray);
			return trimedValue;
		}
		char[] completedArray = new char[trimedLength];
		int zeroCounter = 0;
		for (int i = counter; i < length - reversedCounter; i++) {
			completedArray[zeroCounter++] = myString[i];
		}

		MyString trimedValue = new MyStringImp(completedArray);

		return trimedValue;
	}

	public char getFirstNonDup() {
		int length = new MyStringImp(myString).length();
		char First = '\0';
		boolean unique = false;
		if (length == 1)
			return myString[0];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i != j) {
					if (myString[i] != myString[j]) {
						First = myString[i];
						unique = true;
					} else {
						First = '\0';
						unique = false;
						break;
					}
				}
			}
			if (unique)
				return First;
		}
		return First;
	}

	public int indexOf(MyString s) {
		if (s == null)
			throw new PR1Exception("Invalid input!");
		char[] resultedArray = new MyStringImp(s).toCharArray();
		int length = new MyStringImp(myString).length();
		int counter = 0;
		int lastmatch = 0;
		int resultedArrayLength = new MyStringImp(resultedArray).length();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < resultedArrayLength; j++) {
				if (myString[i] == resultedArray[j]) {
					lastmatch = i;
					counter++;
					i++;
				}
				if (counter == resultedArrayLength) {
					return (lastmatch - resultedArrayLength + 1);
				}
			}
			counter = 0;
		}

		return -1;
	}

	public int indexOf(MyString s, int startIdx) {
		if (0 > startIdx)
			throw new PR1Exception("Invalid input!");
		char[] resultedArray = new MyStringImp(s).toCharArray();
		int length = new MyStringImp(myString).length();
		int counter = 0;
		int lastmatch = 0;
		int resultedArrayLength = new MyStringImp(resultedArray).length();
		for (int i = startIdx; i < length; i++) {
			for (int j = 0; j < resultedArrayLength; j++) {
				if (myString[i] == resultedArray[j]) {
					lastmatch = i;
					counter++;
					i++;
				}
				if (counter == resultedArrayLength) {
					return (lastmatch - resultedArrayLength + 1);
				}
			}
			counter = 0;
		}

		return -1;
	}

	public MyString[] split(MyString delimiter) {
		if (delimiter == null)
			throw new PR1Exception("Invalid input! ");
		int length = new MyStringImp(myString).length();
		char[] difference = new MyStringImp(delimiter).toCharArray();
		int differenceLength = new MyStringImp(difference).length();
		char[] copy = new MyStringImp(myString).toCharArray();
		int counter = 0;
		int miniCounter = 0;
		for (int i = 0; i < length; i++) {
			if (miniCounter == differenceLength) {
				miniCounter = 0;
			}
			if (difference[miniCounter] == copy[i]) {
				counter++;
				miniCounter++;
			} else {
				counter = 0;
			}
			if (counter == differenceLength) {
				int starter = i - differenceLength + 1;
				if (starter < 0)
					starter++;
				for (int j = starter; j < i + 1; j++) {
					copy[j] = ' ';
				}
				counter = 0;
			}
		}

		for (int i = 0; i < length; i++) {
			if (copy[i] != ' ') {
				counter++;
			}
		}

		// everything done there!
		MyString[] returnedValue = new MyString[counter];
		counter = 0;
		int zeroCounter = 0;
		boolean notNegative = false;
		char[] addingSpace = new char[length + 1];
		int lengthWithSpace = new MyStringImp(addingSpace).length();
		for (int i = 0; i < copy.length; i++) {
			addingSpace[i] = copy[i];
		}
		addingSpace[length] = ' ';
		int zeroCounterTwo = 0;
		for (int i = 0; i < lengthWithSpace; i++) {

			if (addingSpace[i] != ' ' && lengthWithSpace != i + 1) {
				counter++;
				notNegative = false;
			} else {
				if (counter > 0) {
					char[] tempChar = new char[counter];
					for (int j = i - counter; j < i; j++) {
						tempChar[zeroCounterTwo++] = addingSpace[j];
						notNegative = true;
					}
					returnedValue[zeroCounter++] = new MyStringImp(tempChar);
					zeroCounterTwo = 0;
				}
			}

			if (notNegative) {
				counter = 0;
			}

		}
		MyString[] nullFilter = new MyString[zeroCounter];
		for (int i = 0; i < zeroCounter; i++) {
			nullFilter[i] = returnedValue[i];
		}
		return nullFilter;
	}

	public MyString removeUmlauts() {
		int length = new MyStringImp(myString).length();
		char[] copy = new MyStringImp(myString).toCharArray();
		char[] modifiedCopy = new char[length * 2];
		int modifiedLength = new MyStringImp(modifiedCopy).length();
		if (length == 1)
			modifiedCopy = new char[length + 2];
		for (int i = 0; i < length; i++) {
			modifiedCopy[i] = copy[i];
		}
		for (int i = 0; i < modifiedLength; i++) {
			switch (modifiedCopy[i]) {
			case 'ö':
				for (int j = modifiedLength - 2; j > i; j--) {
					modifiedCopy[j + 1] = modifiedCopy[j];
				}
				modifiedCopy[i] = 'o';
				modifiedCopy[++i] = 'e';
				break;
			case 'Ö':
				for (int j = modifiedLength - 2; j > i; j--) {
					modifiedCopy[j + 1] = modifiedCopy[j];
				}
				modifiedCopy[i] = 'O';
				modifiedCopy[++i] = 'e';
				break;
			case 'ä':

				for (int j = modifiedLength - 2; j > i; j--) {
					modifiedCopy[j + 1] = modifiedCopy[j];
				}
				modifiedCopy[i] = 'a';
				modifiedCopy[++i] = 'e';
				break;
			case 'Ä':
				for (int j = modifiedLength - 2; j > i; j--) {
					modifiedCopy[j + 1] = modifiedCopy[j];
				}
				modifiedCopy[i] = 'A';
				modifiedCopy[++i] = 'e';
				break;
			case 'ü':
				for (int j = modifiedLength - 2; j > i; j--) {
					modifiedCopy[j + 1] = modifiedCopy[j];
				}
				modifiedCopy[i] = 'u';
				modifiedCopy[++i] = 'e';
				break;
			case 'Ü':
				for (int j = modifiedLength - 2; j > i; j--) {
					modifiedCopy[j + 1] = modifiedCopy[j];
				}
				modifiedCopy[i] = 'U';
				modifiedCopy[++i] = 'e';
				break;
			default:
				break;

			}
		}
		int counter = 0;
		for (int i = 0; i < modifiedLength; i++) {
			if (modifiedCopy[i] == '\0')
				counter++;
		}
		char[] noSpaces = new char[modifiedLength - counter];
		for (int i = 0; i < modifiedLength - counter; i++) {
			noSpaces[i] = modifiedCopy[i];
		}
		MyString trimedValue = new MyStringImp(noSpaces);
		return trimedValue;

	}

	public String toString() {
		String value = new String(myString);
		return value;
	}

	public void printFrequencyOfChars() {
		int length = new MyStringImp(myString).length();
		MyString loweredMyString = new MyStringImp(myString).toLowerCase();
		char[] resultedArray = new MyStringImp(loweredMyString).toCharArray();
		int spaceCounter = 0;
		for (int i = 0; i < length; i++) {
			if (resultedArray[i] == ' ')
				spaceCounter++;
		}
		char[] noSpaces = new char[length - spaceCounter];
		for (int i = 0; i < length - spaceCounter; i++) {
			if (resultedArray[i] != ' ')
				noSpaces[i] = resultedArray[i];
		}
		char[] finalArray = new MyStringImp(noSpaces).toCharArray();
		length = new MyStringImp(finalArray).length();
		char[] savedLetter = new char[length];
		double[] counter = new double[length];

		for (int i = 0; i < length; i++) {
			boolean contains = false;
			for (char c : savedLetter) {
				if (c == finalArray[i]) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				savedLetter[i] = finalArray[i];
			}
		}
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (finalArray[i] == savedLetter[j]) {

					counter[j]++;
				}
			}
		}

		for (int i = 0; i < length; i++) {
			for (int j = 1; j < (length - i); j++) {
				if (counter[j - 1] < counter[j]) {
					double temp = counter[j - 1];
					char temp2 = savedLetter[j - 1];
					savedLetter[j - 1] = savedLetter[j];
					savedLetter[j] = temp2;
					counter[j - 1] = counter[j];
					counter[j] = temp;
				}

			}
		}
		for (int i = 0; i < length; i++) {
			for (int j = 1; j < (length - i); j++) {
				if (counter[j - 1] == counter[j]) {
					if (savedLetter[j - 1] > savedLetter[j]) {
						double temp = counter[j - 1];
						char temp2 = savedLetter[j - 1];
						savedLetter[j - 1] = savedLetter[j];
						savedLetter[j] = temp2;
						counter[j - 1] = counter[j];
						counter[j] = temp;
					}
				}

			}
		}
		println("|Buchstabe|Häufigkeit   |");
		for (int i = 0; i < length; i++) {
			if (counter[i] > 0) {
				double frequency = counter[i] / length * 100;
				println("|    " + savedLetter[i] + "    |   " + frequency + "%     |");
			}
		}

	}
}
