/**
 * 
 */
package com.exer.M8.Y2016;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * @author Davide
 *
 */
public class Go {

	public static void main(String[] args) {

		String filtro = "davide";
		String pathLeggi = "C:\\Users\\Davide\\Downloads\\realhuman_phill.txt";
		String pathScrivi = "C:\\Users\\Davide\\Downloads\\parole.txt";
		char set2[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Y', 'Z',' ' };

		int k = 6 ;
		//printAllKLength(set2, k, pathScrivi);
leggiFiltra(pathLeggi, filtro);
	}

	// The method that prints all possible strings of length k. It is
	// mainly a wrapper over recursive function printAllKLengthRec()
	static void printAllKLength(char set[], int k, String pathScrivi) {
		int n = set.length;
		printAllKLengthRec(set, "", n, k, pathScrivi);
		
	}

	// The main recursive method to print all possible strings of length k
	static  void printAllKLengthRec(char set[], String prefix, int n, int k, String pathScrivi) {

		// Base case: k is 0, print prefix
		if (k == 0) {
			File file = new File(pathScrivi);
			
			try {
				FileUtils.writeStringToFile(file,prefix+"\n",true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
			return;
		}

		// One by one add all characters from set and recursively
		// call for k equals to k-1
		for (int i = 0; i < n; ++i) {

			// Next character of input added
			String newPrefix = prefix + set[i];

			// k is decreased, because we have added a new character
			printAllKLengthRec(set, newPrefix, n, k - 1, pathScrivi);
		}
		
	}

	static void leggiFiltra(String path, String filtro) {

		File file = new File(path);
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(file, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BigInteger w = new BigInteger("0");
			while (it.hasNext()) {
				String line = it.nextLine();
				if (line.toUpperCase().contains(filtro))
					System.out.println(line);
			}
		} finally {
			it.close();
		}
	}

}
