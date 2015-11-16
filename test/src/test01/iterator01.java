package test01;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class iterator01 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		File file = new File("/Users/isanghoon");
		for (String files : file.list())
			set.add(files);
		Iterator<String> iter = set.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
		
	}

}
