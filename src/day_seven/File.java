package day_seven;


public class File {
	
	String _name;
	int _size;

	public File(String name) {
		_name = name;
		_size = 0;
	}
	
	public File(String name, int size) {
		_name = name;
		_size = size;
	}
	
	public int getSize() {
		return _size;
	}
	
	public int getSize(int max) {
		return _size <= max ? _size : 0;
	}

}
