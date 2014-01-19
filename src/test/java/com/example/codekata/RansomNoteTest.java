package com.example.codekata;

import static org.junit.Assert.*;

import org.junit.Test;

public class RansomNoteTest {

	@Test
	public void testRansomFromText() {
		
		String ransom = "if you want to have your child, come and visit me behind the church at mid night";
		String magazine = "In January 2012, two Yale students named Harry Yu and Peter Xu built a replacement to Yale’s official course selection website. They it called YBB+ (Yale Bluebook Plus), a “plus” version of the Yale-owned site, called Yale Bluebook. YBB+ offered different functionality from the official site, allowing students to sort courses by average rating and workload. The official Yale Bluebook, rather, showed a visual graph of the distribution of student ratings as well as a list of written student reviews. YBB+ offered a more lightweight user interface and facilitated easier comparison of course statistics. Students loved it. A significant portion of the student body started using it.";
		
		RansomNote ransomNote = new RansomNote();
		assertTrue( ransomNote.isNotePossible(ransom, magazine) );
	}

}
