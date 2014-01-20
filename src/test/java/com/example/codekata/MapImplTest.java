/**
 * 
 */
package com.example.codekata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author choesang
 *
 */
public class MapImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		MapImpl<String, String> mapImpl = new MapImpl<>();
		mapImpl.put("joe", "josef prantauer");
		mapImpl.put("choe", "choesang tenzin");
		
		assertTrue(mapImpl.containsKey("joe"));
		assertFalse(mapImpl.containsKey("kyle"));
		assertEquals("josef prantauer", mapImpl.get("joe") );
		mapImpl.put("joe", "prantauer");
		assertEquals("prantauer", mapImpl.get("joe") );
	}

}
