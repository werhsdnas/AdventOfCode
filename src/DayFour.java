import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayFour {

	public static void main(String[] args) {

		int count = 0;

		try {
			List<String> data = Arrays.stream(Files.readString(Path.of("input4.txt")).split("\\n"))
					.map(s -> s.strip())
					.collect(Collectors.toList());
			
			for(String s: data) {
				
				String[] ranges = s.split(",");
				
				String[] first = ranges[0].split("-");
				String[] second = ranges[1].split("-");
				
				int lower = Integer.parseInt(first[0]);
				int upper = Integer.parseInt(first[1]);
				
				int lower2 = Integer.parseInt(second[0]);
				int upper2 = Integer.parseInt(second[1]);
				
				boolean b = false;
				
				for(int i = lower; i <= upper; i++) {
					if(lower2 <= i && i <= upper2) {
						b = true;
					}
				}
				
				if(b) {
					count++;
				}
				
				//System.out.println(lower + ", " + upper);
				
//				if(lower <= Integer.parseInt(second[0]) && upper >= Integer.parseInt(second[1])) {
//					count++;
//				} else if(lower >= Integer.parseInt(second[0]) && upper <= Integer.parseInt(second[1])) {
//					count++;
//				}

			}
			
			
			System.out.println(count);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
