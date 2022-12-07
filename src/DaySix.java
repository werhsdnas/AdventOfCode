import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class DaySix {

	public static void main(String[] args) throws IOException {

		String s = Files.readString(Path.of("input6.txt"));
		int packetSize = 4;
		int startIndex = 0;
		
		
		while(true) {
			String str = s.substring(startIndex, startIndex + packetSize);
			int pos = firstDuplicate(str);
			if(pos == packetSize) {
				System.out.println(startIndex + packetSize);
				return;
			} else {
				startIndex += (pos + 1);
			}
		}	
	}
	
	public static int firstDuplicate(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int index = 0;
		while(index < s.length()) {
			char c = s.charAt(index);
			if(map.containsKey(c)) {
				return map.get(c);
			} else {
				map.put(c, index);
			}
			index++;
		}
		return index;
	}

}
