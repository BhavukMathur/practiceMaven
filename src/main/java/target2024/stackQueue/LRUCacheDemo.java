package target2024.stackQueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * CacheNode
 * Doubly linked list
 * HashMap pointing to the node
 */

@Getter
@AllArgsConstructor
class CacheNode {
	private int key;
	private int value;
}

class CacheNodeDLL {
	private int key;
	private int value;
	CacheNodeDLL prev;
	CacheNodeDLL next;
}

class LRUCache {
	Deque<CacheNode> dq;
	CacheNodeDLL dllHead;
	Map<Integer, CacheNode> nodeByKey;
	final Integer MAX_CACHE_SIZE = 3;

	LRUCache() {
		dq = new LinkedList<>();
		nodeByKey = new HashMap<>();
	}

	public Integer get(Integer key) {
		if(nodeByKey.containsKey(key)) {
			System.out.println("Found in the cache:" + key);
			//Updating the cache
			CacheNode node = nodeByKey.get(key);
			dq.remove(node);
			dq.addLast(node);
			return nodeByKey.get(key).getValue();
		} else {
			System.out.println("Not found in cache : " + key);
			return -1;
		}
	}

	//If not present in cacheMap --> create cacheNode and add
	//cacheNode to be the head of dq
	//Update dq
	//If present in cacheMap --> same as above with the existing cacheNode
	public void put(Integer key, Integer value) {
		if(nodeByKey.containsKey(key)) {
			System.out.println("Already present in cache.. updating the cache");
			CacheNode node = nodeByKey.get(key);
			dq.remove(node);
			dq.addLast(node);
		} else {
			if(dq.size() < MAX_CACHE_SIZE) {
				System.out.println("Adding in the cache");
			} else {
				System.out.println("Cache full.. updating the cache");
				CacheNode evicted = dq.poll();
				System.out.println("Evicting key:" + evicted.getKey());
				nodeByKey.remove(evicted.getKey());
			}
			CacheNode node = new CacheNode(key, value);
			dq.addLast(node);
			nodeByKey.put(key, node);
		}
	}
}

public class LRUCacheDemo {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache();
		System.out.println(cache.get(1));
		cache.put(1, 111);
		cache.put(2, 222);
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.put(3, 333);
		cache.put(4, 444);
		System.out.println(cache.get(2));
	}
}
