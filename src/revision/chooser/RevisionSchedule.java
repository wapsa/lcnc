package revision.chooser;

import java.util.HashMap;
import java.util.Map;

public class RevisionSchedule {

	private static final Map<String, String> TOPICS = new HashMap<>();
	static {
		TOPICS.put("Monday", "Stack");
		TOPICS.put("Monday", "Linked List");

		TOPICS.put("Tuesday", "Binary Tree");

		TOPICS.put("Wednesday", "Graph");
		TOPICS.put("Wednesday", "Divide & Conquer");

		TOPICS.put("Thursday", "Backtracking");

		TOPICS.put("Friday", "Array/String");
		TOPICS.put("Friday", "Kadane's Algorithm");

		TOPICS.put("Saturday", "Matrix");
		TOPICS.put("Saturday", "HashMap");
		TOPICS.put("Saturday", "Intervals");

		TOPICS.put("Sunday", "Two Pointers");
		TOPICS.put("Sunday", "Sliding Window");
		TOPICS.put("Sunday", "Binary Search");

//		TOPICS.put("", "Heap");
//		TOPICS.put("", "Dynamic Programming 1");
//		TOPICS.put("", "Dynamic Programming 2");
//		TOPICS.put("", "Trie");
	}

}
