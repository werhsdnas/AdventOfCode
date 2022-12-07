import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DayFive {
	
	public static final int NUM_STACKS = 9;
	public static List<Stack<Character>> piles;
	public static final File INPUT = new File("input5.txt");
	
	public static BufferedReader br;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		piles = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(INPUT));
			parseStacks();
			
			br.readLine();
			
			while (true) {
				String l = br.readLine();
				
				if(l == null) break;
				
				String[] arr = l.split("\\s");
				int numPiles = Integer.parseInt(arr[1]);
				int source = Integer.parseInt(arr[3]);
				int destination = Integer.parseInt(arr[5]);
				move(numPiles, source, destination);
				System.out.println(piles.toString());
			}
			
			String output = "";
			
			for(Stack<Character> s: piles) {
				output += s.peek();
			}
			
			System.out.println(output);
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("wat (o_0)?");
		}
		
		
	}
	
	public static void parseStacks(){
		
		List<List<Character>> temp = new ArrayList<>();
		
		for(int i = 0; i < NUM_STACKS; i++) {
			Stack<Character> s = new Stack<>();
			piles.add(s);
			temp.add(new ArrayList<Character>());
		}
		
		while(true) {
			try {
				String line = br.readLine();
				line += "\\s";
				
				if(line.indexOf('[') == -1) {
					break;
				} else {
					for(int i = 0; i < NUM_STACKS; i++) {
						String crate = line.substring(4 * i, 4 * (i + 1));
						if(!crate.isBlank()) {
							char c = crate.charAt(1);
							
							if(c != ' ') {
								temp.get(i).add(c);
							}
							
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("wat (o_0)?");
			}
			
		}
		
		for(int i = 0; i < temp.size(); i++) {
			Stack<Character> s = piles.get(i);
			List<Character> l = temp.get(i);
			for(int j = l.size() - 1; j >= 0; j--) {
				s.push(l.get(j));
			}
		}
		
	}
	
	public static void move(int numTimes, int source, int destination) {
		Stack<Character> start = piles.get(source - 1);
		Stack<Character> end = piles.get(destination - 1);
		
		Stack<Character> temp = new Stack<>();
		
		for(int i = 0; i < numTimes; i++) {
			char crate = start.pop();
			//end.push(crate);
			temp.push(crate);
		}
		
		while(!temp.empty()) {
			end.push(temp.pop());
		}
	}

}
