import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContentReaderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContentReader() {
		//Cont
		testEquals();
		fail("Not yet implemented");
	}
	
	@Test(expected=Exception.class)
	public void testFilePathNullException() throws Exception {
		ContentReader cr = new ContentReader(null);
		//assertEquals(cr.getClass(), ContenReader random);
		//Assert.assertEquals("", expected, actual, delta);
	}
	@Test
	public void testGetContent() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetContent() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}



}
