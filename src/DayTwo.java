import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DayTwo {

	public static void main(String[] args) throws IOException {
		
		int part1 = Files.readAllLines(Path.of("input2.txt"))
				.stream()
				.mapToInt(s -> match(s))
				.sum();
		
		int part2 = Files.readAllLines(Path.of("input2.txt"))
				.stream()
				.mapToInt(s -> match2(s))
				.sum();
		
		System.out.println("Part 1: " + part1);
		System.out.println("Part 2: " + part2);
		
		

	}
	
	public static int match(String game) {

		int opp = game.charAt(0) - 'A' + 1;
		int you = game.charAt(2) - 'X' + 1;
		
		int winValue = ((you - opp) % 3);
		
		if(winValue < 3) winValue += 3;
		
		winValue = 3 * ((winValue + 1) % 3);
		
		return you + winValue;
		
	}
	
	public static int match2(String game) {
		
		int opp = game.charAt(0) - 'A' + 1;
		int you = game.charAt(2) - 'X';
		
		int bonus = (opp + (game.charAt(2) - 'Y'));
		
		if(bonus <= 0) bonus += 3;
		
		if(bonus > 3) bonus %= 3;
		
		return bonus + you * 3;
		

		
	}

}
