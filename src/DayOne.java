import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DayOne {

	public static void main(String[] args) throws IOException {
		
		List<Integer> elfs = Arrays
				.stream(Files.readString(Path.of("input.txt")).split("\\r\\n\\r\\n"))
	            .map(s -> Arrays.stream(s.split("\\r\\n"))
	            .mapToInt(Integer::parseInt).sum())
	            .sorted(Comparator.reverseOrder())
	            .collect(Collectors.toList());
		
		
	    System.out.println("Part 1:" + elfs.get(0));
	    System.out.println("Part 2:" + (elfs.get(0) + elfs.get(1) + elfs.get(2)));
	}
	

}
