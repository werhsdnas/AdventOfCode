package day_seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory extends File {
	
	List<File> contents;

	public Directory(String name) {
		super(name);
		contents = new ArrayList<>();
	}
	
	public void addFile(File f) {
		contents.add(f);
	}
	
	public int getSize() {
		int sum = 0;
		
		for(File f: contents) {
			sum += f.getSize();
		}
		
		return sum;
	}
	
	public int getSize(int max) {
		
		int sum = 0;
		if(getSize() < max) {
			sum += getSize();
		}
		
		for(File f: contents) {
			if(f instanceof Directory) {
				sum += f.getSize(max);
			}
		}
		
		return sum;
		
	}
	
	public Map<Directory, Integer> getAllSizes(){
		Map<Directory, Integer> map = new HashMap<>();
		
		
		map.put(this, getSize());
		
		for(File f: contents) {
			if(f instanceof Directory) {
				
				Directory d = (Directory) f;
				
				map.put(d, d.getSize());
				
				Map<Directory, Integer> temp = d.getAllSizes();
				
				for(Directory key: temp.keySet()) {
					map.put(key, temp.get(key));
				}
			}
		}
		
		return map;
	}
	

}
