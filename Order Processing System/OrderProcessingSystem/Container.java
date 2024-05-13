import java.io.*;
import java.util.*;

public class Container {
    private ArrayList<Object> objects;

    public Container() {
        objects = new ArrayList<>();
    }

    public void add(Object object) {
        objects.add(object);
    }

    public Object remove() {
        if (!objects.isEmpty()) {
            return objects.remove(objects.size() - 1);
        } else {
            return null;
        }
    }

    public int getSize() {
        return objects.size();
    }
}

class Queue extends Container {
    private ArrayList<Order> queue;

    public Queue(String fileName) {
        super();
        queue = new ArrayList<>();
        List<String> lines = IOHandler.readFile(fileName);
        for (String line : lines) {
            String[] parts = line.split(",");
            int orderId = Integer.parseInt(parts[0].trim());
            String customerName = parts[1].trim();
            String productName = parts[2].trim();
            int quantity = Integer.parseInt(parts[3].trim());
            double unitPrice = Double.parseDouble(parts[4].trim());
            Order order = new Order(orderId, customerName, productName, quantity, unitPrice);
            if (order.getTotalAmount() >= 1500) {
                add(order);
            }
        }
    }

    @Override
    public void add(Object object) {
        if (((Order) object).getTotalAmount() >= 1500) {
            queue.add((Order) object);
        }
    }

    public Order remove() {
        if (!queue.isEmpty()) {
            return queue.remove(0);
        } else {
            return null;
        }
    }

    public Order top() {
        if (!queue.isEmpty()) {
            return queue.get(0);
        } else {
            return null;
        }
    }

    @Override
    public int getSize() {
        return queue.size();
    }
}

class Stack extends Container {
    private ArrayList<Order> stack;

    public Stack(String fileName) {
        super();
        stack = new ArrayList<>();
        List<String> lines = IOHandler.readFile(fileName);
        for (String line : lines) {
            String[] parts = line.split(",");
            int orderId = Integer.parseInt(parts[0].trim());
            String customerName = parts[1].trim();
            String productName = parts[2].trim();
            int quantity = Integer.parseInt(parts[3].trim());
            double unitPrice = Double.parseDouble(parts[4].trim());
            Order order = new Order(orderId, customerName, productName, quantity, unitPrice);
            if (order.getTotalAmount() < 1500) {
                add(order);
            }
        }
    }

    @Override
    public void add(Object object) {
        if (((Order) object).getTotalAmount() < 1500) {
            stack.add((Order) object);
        }
    }

    public Order remove() {
        if (!stack.isEmpty()) {
            return stack.remove(stack.size() - 1);
        } else {
            return null;
        }
    }

    public Order top() {
        if (!stack.isEmpty()) {
            return stack.get(stack.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public int getSize() {
        return stack.size();
    }
}

class IOHandler {
    public static List<String> readFile(String fileName) {
        List<String> content = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                content.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
        return content;
    }

    public static void writeFile(String fileName, List<String> content) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String line : content) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}

class Order {
    private int orderId;
    private String customerName;
    private String productName;
    private int quantity;
    private double unitPrice;

    public Order(int orderId, String customerName, String productName, int quantity, double unitPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getTotalAmount() {
        return Math.round(quantity * unitPrice * 100.0) / 100.0; // Round to two decimal places
    }

    @Override
    public String toString() {
        return "[" + orderId + ", " + customerName + ", " + productName + ", " + quantity + ", " + unitPrice + "]";
    }
}

	
