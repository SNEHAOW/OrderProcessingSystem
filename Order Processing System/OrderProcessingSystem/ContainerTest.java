
import static org.junit.Assert.*;

import java.io.File;
import java.util.*;

import org.junit.Test;

import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContainerTest {
	/*
	 * Note for students: these test cases are not comprehensive; you must add your
	 * test cases to test your solution for this lab thoroughly.
	 * 
	 */
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void test_01_01_() {
		List<String> expectedContent = Arrays.asList("1001, John Doe, Smartphone, 2, 100",
				"1023, Ethan Lewis, Gaming Chair, 1, 150", "1024, Mia Perez, Fitness Tracker, 2, 60",
				"1028, Sofia Martinez, Backpack, 1, 40", "1029, Jackson Green, Smart Thermostat, 1, 120",
				"1030, Emma Clark, Air Purifier, 1, 90");

		// Test reading the file
		List<String> actualContent = IOHandler.readFile("test1.txt");
		assertEquals(expectedContent, actualContent);
	}

	@Test
	public void test_01_02_() {
		List<String> expectedContent = Arrays.asList("1001, John Doe, Smartphone, 2, 1000",
				"1002, Jane Smith, Laptop, 1, 1500", "1023, Ethan Lewis, Gaming Chair, 1, 150",
				"1030, Emma Clark, Air Purifier, 1, 90");
		// Test writing content to the file
		IOHandler.writeFile("outputtest1.txt", expectedContent);

		// Test reading the file
		List<String> actualContent = IOHandler.readFile("outputtest1.txt");
		assertEquals(expectedContent, actualContent);

		// Clean up the test file
		File file = new File("outputtest1.txt");
		if (file.exists()) {
			file.delete();
		}
	}

	@Test
	public void test_02_01_() {
		Container container = new Queue("orders.txt");
		int expected = 7;
		int actual = container.getSize();
		assertEquals("The queue is not populated properly or getSize() method is not correct", expected, actual);

	}

	@Test
	public void test_02_02_() {
		Container container = new Queue("test1.txt");
		int expected = 0;
		int actual = container.getSize();
		assertEquals("The queue is not populated properly or getSize() method is not correct", expected, actual);

	}

	@Test
	public void test_02_03_() {
		Container container = new Queue("test1.txt");
		container.add(new Order(1015, "Brian Garcia", "Router", 2, 50.80));

		int expected = 0;
		int actual = container.getSize();
		assertEquals("The queue is not populated properly or getSize() method is not correct", expected, actual);

	}

	@Test
	public void test_02_04_() {
		Container container = new Queue("test1.txt");
		container.add(new Order(1015, "Brian Garcia", "Smartwatch", 20, 150.99));

		int expected = 1;
		int actual = container.getSize();
		assertEquals("The queue is not populated properly or getSize() method is not correct", expected, actual);

	}

	@Test
	public void test_02_05_() {
		Queue container = new Queue("test1.txt");
		Order ord1 = new Order(1015, "Brian Garcia", "Smartwatch", 20, 150.99);
		Order ord2 = new Order(1017, "Amanda Hernandez", "Wireless Earbuds", 40, 50.90);
		container.add(ord1);
		container.add(ord2);
		int expected = 2;
		int actual = container.getSize();
		assertEquals("The queue is not populated properly or getSize() method is not correct", expected, actual);

		Order aord1 = (Order) container.top();
		assertEquals("The queue's top() or add() is not correct", ord1, aord1);
	}

	@Test
	public void test_02_06_() {
		Queue container = new Queue("test1.txt");
		Order ord1 = new Order(1015, "Brian Garcia", "Smartwatch", 20, 150.99);
		Order ord2 = new Order(1017, "Amanda Hernandez", "Wireless Earbuds", 40, 50.90);
		container.add(ord1);
		container.add(ord2);

		Order aord1 = (Order) container.remove();
		assertEquals("The queue's remove(), add() or getSize() is not correct", ord1, aord1);
		int expected = 1;
		int actual = container.getSize();
		assertEquals("The queue is not populated properly or getSize() method is not correct", expected, actual);

	}

	@Test
	public void test_03_01_() {
		Container container = new Stack("orders.txt");
		int expected = 23;
		int actual = container.getSize();
		assertEquals("The stack is not populated properly or getSize() method is not correct", expected, actual);

	}

	@Test
	public void test_03_02_() {
		Container container = new Stack("test2.txt");
		int expected = 2;
		int actual = container.getSize();
		assertEquals("The stack is not populated properly or getSize() method is not correct", expected, actual);

	}

	@Test
	public void test_03_03_() {
		Container container = new Stack("test2.txt");
		Order ord1 = new Order(1085, "Brian Garcia", "Router", 85, 50.80);
		container.add(ord1);
		int expected = 2;
		int actual = container.getSize();
		assertEquals("The stack is not populated properly or getSize() method is not correct", expected, actual);

	}

	@Test
	public void test_03_04_() {
		Container container = new Stack("test2.txt");
		Order ord1 = new Order(1155, "Brian Garcia", "Keyboard", 50, 10.10);
		container.add(ord1);
		int expected = 3;
		int actual = container.getSize();
		assertEquals("The stack is not populated properly or getSize() method is not correct", expected, actual);

	}

	@Test
	public void test_03_05_() {
		Stack container = new Stack("test2.txt");
		Order ord1 = new Order(1155, "Brian Garcia", "Keyboard", 50, 10.10);
		Order ord2 = new Order(1156, "Melissa Adams", "Gaming Chair", 1, 250.00);
		container.add(ord1);
		container.add(ord2);
		int expected = 4;
		int actual = container.getSize();
		assertEquals("The stack is not populated properly or getSize() method is not correct", expected, actual);

		Order aord1 = (Order) container.top();
		assertEquals("The stack's top() or add() is not correct", ord2, aord1);

	}

	@Test
	public void test_03_06_() {
		Stack container = new Stack("test2.txt");
		Order ord1 = new Order(1155, "Brian Garcia", "Keyboard", 50, 10.10);
		Order ord2 = new Order(1156, "Melissa Adams", "Gaming Chair", 1, 250.00);
		container.add(ord1);
		container.add(ord2);

		Order aord1 = (Order) container.remove();
		assertEquals("The stack's remove(), add() or getSize() is not correct", ord2, aord1);
		int expected = 3;
		int actual = container.getSize();
		assertEquals("The stack is not populated properly or getSize() method is not correct", expected, actual);

	}



}
