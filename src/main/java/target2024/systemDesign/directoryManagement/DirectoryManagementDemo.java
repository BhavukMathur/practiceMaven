package target2024.systemDesign.directoryManagement;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Imagine we have a system that stores files, and these files can be grouped into collections.
 * We are interested in knowing where our resources are being taken up.
 * For this system we would like to generate a report that lists:
 * The total size of all files stored; and
 * The top N collections (by file size) where N can be a user-defined value
 *
 * file1.txt (size: 100)
 * file2.txt (size: 200) in collection "collection1"
 * file3.txt (size: 200) in collection "collection1"
 * file4.txt (size: 300) in collection "collection2"
 * file5.txt (size: 10)
 */

class File {
	String name;
	Integer size;
	FileCollection fileCollection;

	public File(String name, Integer size, FileManager fileManager) {
		this.name = name;
		this.size = size;
		fileManager.updateFileSystem(this);
	}


	public File(String name, Integer size, FileCollection fileCollection, FileManager fileManager) {
		this.name = name;
		this.size = size;
		this.fileCollection = fileCollection;
		fileCollection.updateFileCollection(this);
		fileManager.updateFileSystem(this);
	}
}

class FileCollection implements Comparable<FileCollection> {
	String name;
	List<File> fileList;
	int size;

	FileCollection parentCollection;
	List<FileCollection> subCollections;

	public FileCollection(String name, FileManager fileManager) {
		this.name = name;
		this.fileList = new LinkedList<>();
		this.size = 0;

		fileManager.updateFileCollection(this);
	}

	public void updateFileCollection(File file) {
		fileList.add(file);
		this.size = this.size + file.size;
		updateFileCollectionSize(parentCollection);

	}

	void updateFileCollectionSize(FileCollection fc) {
		if(fc == null) {
			return;
		}
		else {
			//
		}
	}

	@Override
	public int compareTo(FileCollection o) {
		return Integer.compare(this.size, o.size);
	}
}

class FileManager {
	List<File> fileList;
	List<FileCollection> fileCollectionList;
	int size;

	public FileManager() {
		this.fileList = new LinkedList<>();
		this.fileCollectionList = new LinkedList<>();
		int size = 0;
	}

	public void updateFileSystem(File file) {
		fileList.add(file);
		this.size = this.size + file.size;
	}

	public void updateFileCollection(FileCollection fileCollection) {
		fileCollectionList.add(fileCollection);
	}

	public List<FileCollection> getTopFileCollections(int n) {
		PriorityQueue<FileCollection> pq = new PriorityQueue<>();
		fileCollectionList.forEach(fc -> {
			if(pq.size() < n) {
				pq.add(fc);
			} else {
				if(fc.size > pq.peek().size) {
					pq.poll();
					pq.add(fc);
				}
			}
		});

		List<FileCollection> topFC = new LinkedList<>();
		topFC.addAll(pq);
		Collections.sort(topFC, Collections.reverseOrder());
//		Collections.reverse(topFC);
		return topFC;
	}
}

/**
 * file1.txt (size: 100)
 * file2.txt (size: 200) in collection "collection1"
 * file3.txt (size: 200) in collection "collection1"
 * file4.txt (size: 300) in collection "collection2"
 * file5.txt (size: 10)
 */

public class DirectoryManagementDemo {
	public static void main(String[] args) {
		FileManager fileManager = new FileManager();

		FileCollection fc1 = new FileCollection("collection1", fileManager);
		FileCollection fc2 = new FileCollection("collection2", fileManager);
		FileCollection fc3 = new FileCollection("collection3", fileManager);

		//Do it via FileManager -- createFile
		File f1 = new File("file1.txt", 100, fileManager);
		File f2 = new File("file2.txt", 200, fc1, fileManager);
		File f3 = new File("file3.txt", 200, fc1, fileManager);
		File f4 = new File("file4.txt", 300, fc2, fileManager);
		File f5 = new File("file5.txt", 10, fileManager);
		File f6 = new File("file6.txt", 150, fc3, fileManager);

//		fc1.fileList.forEach(file -> {
//			System.out.println(file.name + " " + file.size);
//		});
//
//		fc2.fileList.forEach(file -> {
//			System.out.println(file.name + " " + file.size);
//		});
//
//		fc3.fileList.forEach(file -> {
//			System.out.println(file.name + " " + file.size);
//		});

//		System.out.println("Total file size = " + fileManager.size);
		System.out.println("Collection size = " + fc1.size + " " + fc2.size + " " + fc3.size);

		//Getting top N collections
		int n = 2;
		List<FileCollection> topFC = fileManager.getTopFileCollections(n);
		topFC.forEach(fc -> {
			System.out.println(fc.name + " " + fc.size);
		});

	}
}
