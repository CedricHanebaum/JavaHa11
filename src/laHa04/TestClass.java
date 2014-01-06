package laHa04;

import java.util.Arrays;

public class TestClass {
	
	
	public static void main(String args[]){
		VektorRn a = new VektorRn(0, 0, 0, 0);
		VektorRn b = new VektorRn(3, 1, 4);
		try{
			System.out.println(Arrays.toString(a.bestimmeSenkrechteVektoren()));
		}catch (RuntimeException e){
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(b.bestimmeSenkrechteVektoren()));
	}
}
