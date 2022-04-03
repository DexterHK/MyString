package uebung07;
import static pr.MakeItSimple.*;



public class MyStringMain {

	public static void main(String[] args) throws Exception {
		char s = new MyStringImp("  000122234445").getFirstNonDup(); // Gibt '1' zur¨uck
		
		println(s);
		
	}

}