import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayThree {

	public static void main(String[] args) {
		
		int sum = 0;
		
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		try {
			List<String> data = Arrays.stream(Files.readString(Path.of("input3.txt")).split("\\n"))
					.map(s -> s.strip())
					.collect(Collectors.toList());
			
			for(int ind = 0; ind < data.size() / 3; ind++) {
				String first = data.get(3 * ind);
				String second = data.get(3 * ind + 1);
				String third = data.get(3 * ind + 2);
				
				for(int i = 0; i < alphabet.length(); i++) {
					char c = alphabet.charAt(i);
					
					if(first.indexOf(c) != -1 && second.indexOf(c) != -1 && third.indexOf(c) != -1) {
						sum += (i + 1);
						break;
					}
				}
			}
			
			System.out.println(sum);
			
			//System.out.println(data.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
