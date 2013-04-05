import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		FileReader x = m.openFile(args[0]);
		BufferedReader y = new BufferedReader(x);

		String line;
		try {
			while((line = y.readLine()) != null){
				processLine(line);
			}
		} catch (IOException e) {
			System.out.println("Error reading line");
			e.printStackTrace();
		}
		m.closeFile(x);
	}
	
	private static void processLine(String line) {
		String[] xn = line.split(",");
		int x = Integer.parseInt(xn[0]);
		int n = Integer.parseInt(xn[1]);
		
		x = smallestMultiple(x,n);
		System.out.println(x);
	}

	private static int smallestMultiple(int x,int n) {
		//System.out.println("x:" + x + " n:" + n);
		while(x<=n){
			if(x==n){
				return x;
			} else x++;
		}
		n = n * 2;
		return smallestMultiple(x,n);
	}

	private FileReader openFile(String file) {
		FileReader x = null;
		try {
			x = new FileReader(new File(file));
		} catch (FileNotFoundException e) {
			System.out.println("Error reading file.");
			e.printStackTrace();
		}
		return x;
	}

	private void closeFile(FileReader x) {
		try {
			x.close();
		} catch (IOException e) {
			System.out.println("Error closing file.");
			e.printStackTrace();
		}
	}

}
