package Module_4.BowlingShopApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

// ProductDB class
public class ProductDB {
    // Method to get products based on the code
    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> products = new GenericQueue<>(); // Create a new queue to hold products

        if (code.equalsIgnoreCase("b")) { // Check if code is 'b' for balls
            Ball ball1 = new Ball(); // Create first Ball object
            ball1.setCode("B100"); // Set the product code
            ball1.setDescription("Black Widow 2.0"); // Set the product description
            ball1.setPrice(144.95); // Set the product price
            ball1.setColor("Black and Red"); // Set the product color

            Ball ball2 = new Ball(); // Create second Ball object
            ball2.setCode("B200"); // Set the product code
            ball2.setDescription("Axiom Pearl"); // Set the product description
            ball2.setPrice(154.95); // Set the product price
            ball2.setColor("Blue and Red"); // Set the product color
            
            Ball ball3 = new Ball(); // Create third Ball object
            ball3.setCode("B300"); // Set the product code
            ball3.setDescription("Proton Physix"); // Set the product description
            ball3.setPrice(174.95); // Set the product price
            ball3.setColor("Pink and Purple"); // Set the product color
            
            Ball ball4 = new Ball(); // Create fourth Ball object
            ball4.setCode("B400"); // Set the product code
            ball4.setDescription("Force Unleashed"); // Set the product description
            ball4.setPrice(139.99); // Set the product price
            ball4.setColor("Red and White"); // Set the product color

            Ball ball5 = new Ball(); // Create fifth Ball object
            ball5.setCode("B500"); // Set the product code
            ball5.setDescription("Phaze III"); // Set the product description
            ball5.setPrice(154.99); // Set the product price
            ball5.setColor("Purple and Green"); // Set the product color

            // Create a queue to hold the ball products
            GenericQueue<Product> balls = new GenericQueue<Product>();  
            balls.enqueue(ball1); // Add the first ball to the queue
            balls.enqueue(ball2); // Add the second ball to the queue
            balls.enqueue(ball3); // Add the third ball to the queue
            balls.enqueue(ball4); // Add the fourth ball to the queue
            balls.enqueue(ball5); // Add the fifth ball to the queue
            return balls; // Return the queue of balls

        } else if (code.equalsIgnoreCase("s")) { // Check if code is 's' for shoes
            Shoe shoe1 = new Shoe(); // Create first Shoe object
            shoe1.setCode("S100"); // Set the product code
            shoe1.setDescription("Men's Ram Black"); // Set the product description
            shoe1.setPrice(39.99); // Set the product price
            shoe1.setSize(10.5); // Set the product size
            
            Shoe shoe2 = new Shoe(); // Create second Shoe object
            shoe2.setCode("S200"); // Set the product code
            shoe2.setDescription("Women's Rise Black/Hot Pink"); // Set the product description
            shoe2.setPrice(39.99); // Set the product price
            shoe2.setSize(7.0); // Set the product size
            
            Shoe shoe3 = new Shoe(); // Create third Shoe object
            shoe3.setCode("S300"); // Set the product code
            shoe3.setDescription("Women's Path Lite Seamless Mesh");
            shoe3.setPrice(54.99); // Set the product price
            shoe3.setSize(6.0); // Set the product size
            
            Shoe shoe4 = new Shoe(); // Create fourth Shoe object
            shoe4.setCode("S400"); // Set the product code
            shoe4.setDescription("Men's Tribal White"); // Set the product description
            shoe4.setPrice(26.99); // Set the product price
            shoe4.setSize(8.5); // Set the product size

            Shoe shoe5 = new Shoe(); // Create fifth Shoe object
            shoe5.setCode("S500"); // Set the product code
            shoe5.setDescription("Youth Skull Green/Black"); // Set the product description
            shoe5.setPrice(39.99); // Set the product price
            shoe5.setSize(3.0); // Set the product size
            
            // Create a queue to hold the shoe products
            GenericQueue<Product> shoes = new GenericQueue<Product>();  
            shoes.enqueue(shoe1); // Add the first shoe to the queue
            shoes.enqueue(shoe2); // Add the second shoe to the queue
            shoes.enqueue(shoe3); // Add the third shoe to the queue       
            shoes.enqueue(shoe4); // Add the fourth shoe to the queue
            shoes.enqueue(shoe5); // Add the fifth shoe to the queue
            return shoes; // Return the queue of shoes

        } else if (code.equalsIgnoreCase("a")) { // Check if code is 'a' for bags
            Bag bag1 = new Bag(); // Create first Bag object
            bag1.setCode("A100"); // Set the product code
            bag1.setDescription("Path Pro Deluxe"); // Set the product description
            bag1.setPrice(34.99); // Set the product price
            bag1.setType("Single"); // Set the product type

            Bag bag2 = new Bag(); // Create second Bag object
            bag2.setCode("A200"); // Set the product code
            bag2.setDescription("Prime Roller Black/Royal Blue"); // Set the product description
            bag2.setPrice(54.99); // Set the product price
            bag2.setType("Double"); // Set the product type

            Bag bag3 = new Bag(); // Create third Bag object
            bag3.setCode("A300"); // Set the product code
            bag3.setDescription("Silver/Royal Blue"); // Set the product description
            bag3.setPrice(74.99); // Set the product price
            bag3.setType("Triple"); // Set the product type

            // Create a queue to hold the bag products
            GenericQueue<Product> bags = new GenericQueue<Product>();  
            bags.enqueue(bag1); // Add the first bag to the queue
            bags.enqueue(bag2); // Add the second bag to the queue
            bags.enqueue(bag3); // Add the third bag to the queue
            return bags; // Return the queue of bags

        }
        return products; // Return empty queue if code is invalid
    } // End of getProducts method
} // End of ProductDB class