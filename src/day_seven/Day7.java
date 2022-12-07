package day_seven;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7 {
	
	static int MAX_SIZE = 100000;
	static int SYSTEM_MAX = 70000000;
	static int UNUSED_SPACE = 30000000;
	static int MAX_DIRECTORY_SIZE = SYSTEM_MAX - UNUSED_SPACE;

	public static void main(String[] args) throws IOException {
		

		List<String> data = Files.readAllLines(Path.of("input.txt"));
		List<String> testData = Files.readAllLines(Path.of("test.txt"));
		
		System.out.println(partOne(testData));
		System.out.println(partOne(data));
		System.out.println(partTwo(testData));
		System.out.println(partTwo(data));
		
	}
	
	public static int partOne(List<String> data) {
		
		Directory fullDirectory = new Directory("/");
		Map<String, Directory> map = new HashMap<>();
		
		map.put("/", fullDirectory);
		
		Map<Directory, Directory> prevDirectories = new HashMap<>();
		
		prevDirectories.put(fullDirectory, null);
		
		Directory current = fullDirectory;
		
		int idx = 1;
		
		while(idx < data.size()) {
			String[] line = data.get(idx).split(" ");
			
			if(line[1].equals("cd")) {
				
				if(line[2].equals("..")) {
					Directory prev = prevDirectories.get(current);
					
					current = prev;
				} else {
					Directory next = map.get(line[2]);
					current = next;
				}
				
				idx++;
			} else {
				//listing
				
				idx++;
				line = data.get(idx).split(" ");
				
				while(!line[0].equals("$")) {
					
					if(line[0].equals("dir")) {
						
						String dirName = line[1];
						Directory d = new Directory(dirName);
						map.put(dirName, d);
						current.addFile(d);
						prevDirectories.put(d, current);
						
					} else {
						
						int fileSize = Integer.parseInt(line[0]);
						String fileName = line[1];
						File f = new File(fileName, fileSize);
						current.addFile(f);
						
					}
					
					idx++;
					
					if(idx >= data.size()) {
						break;
					}
					line = data.get(idx).split(" "); 
				}
			}
		}
		
		
		
		
		return fullDirectory.getSize(MAX_SIZE);
		
	}

	public static int partTwo(List<String> data) {
		
		Directory fullDirectory = new Directory("/");
		Map<String, Directory> map = new HashMap<>();
		
		map.put("/", fullDirectory);
		
		Map<Directory, Directory> prevDirectories = new HashMap<>();
		
		prevDirectories.put(fullDirectory, null);
		
		Directory current = fullDirectory;
		
		int idx = 1;
		
		while(idx < data.size()) {
			String[] line = data.get(idx).split(" ");
			
			if(line[1].equals("cd")) {
				
				if(line[2].equals("..")) {
					Directory prev = prevDirectories.get(current);
					
					current = prev;
				} else {
					Directory next = map.get(line[2]);
					current = next;
				}
				
				idx++;
			} else {
				//listing
				
				idx++;
				line = data.get(idx).split(" ");
				
				while(!line[0].equals("$")) {
					
					if(line[0].equals("dir")) {
						
						String dirName = line[1];
						Directory d = new Directory(dirName);
						map.put(dirName, d);
						current.addFile(d);
						prevDirectories.put(d, current);
						
					} else {
						
						int fileSize = Integer.parseInt(line[0]);
						String fileName = line[1];
						File f = new File(fileName, fileSize);
						current.addFile(f);
						
					}
					
					idx++;
					
					if(idx >= data.size()) {
						break;
					}
					line = data.get(idx).split(" "); 
				}
			}
		}
		
		Map<Directory, Integer> m = fullDirectory.getAllSizes();

		int size = fullDirectory.getSize();
		
		int targetSize = UNUSED_SPACE - (SYSTEM_MAX - size);
		
		int currBest = Integer.MAX_VALUE;
		
		for(Integer i: m.values()) {
			if(i >= targetSize && i < currBest) {
				currBest = i;
			}
		}
		
		return currBest;
	}
}
