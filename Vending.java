/** Vending.java
    Emulate a vending machine that sells bus tickets.
    @author    Alice E. Fischer
    @author	   Jeremiah Wright
    @version   February 18, 2014
*/
//  ----------------------------------------------------------------------------
import java.util.*;

public class Vending {
    private final double adult;             // Price of one regular ticket.
    private final double child;             // Child's ticket is half price.
    private final double senior;            // Senior ticket is 80%

    private Scanner sc = new Scanner(System.in);

    /** Initialize a vending machine to sell tickets at a fixed base price. 
     *     Tickets for children are half price, and seniors are 80%.
     *  @param price  The base ticket price, for an adult rider.
     */
    public Vending( double price ){
        adult = price;
        child  = Math.ceil( 100 *( 0.5 * price)) / 100;      // Round the fraction up.
        senior = Math.ceil( 100 *( 0.8 * price)) / 100;      // Round the fraction up.
    }

    /** Dispense bus tickets to be paid for by a credit card. Adult, child, and 
	    senior tickets may be purchased.
     */
    public void go() {
        double price=0; // If there is no default below, use   price = 0;
        int choice, quantity=0;
        int[] count=new int[3];
			for(;;){
				//write loop here
				System.out.println("\nBus Ticket Vending Machine");
				System.out.printf(
						"   \t1. Adult %.2f\n    \t2. Child under 12 %.2f\n",
						adult, child);
				System.out.printf("    \t3. Senior Citizen %.2f\n", senior);
				System.out.printf("\t4. Finish and Pay\n");
				System.out.printf("\t5. Cancel\n");
				for (;;) {
					System.out.println("Please select 1, 2, 3 and enter the quantity.\n");
					choice = sc.nextInt();
					if (choice > 0 && choice < 6)break;
					String junk = sc.nextLine(); // Discard chars to end of line.
					System.out.printf("Bad menu choice:  %s %s\n", choice, junk);
				}
				if(choice == 4 || choice == 5)break;
						
				for (;;) {
					quantity = sc.nextInt(); // Should be validated!
					if (quantity > 0 && quantity < 11)
						break;
					String junk = sc.nextLine(); // Discard chars to end of line.
					System.out.printf("Bad menu choice:  %s %s\n", quantity,
							junk);
					System.out.printf("Please select a quantity between 1-10");
					
				}
				count[choice - 1] +=quantity;
			}
			
			price=(count[0]*adult)+(count[1]*child)+(count[2]*senior);
			
			if(choice == 5){
			System.out.printf("Cancelling your order.");
			System.exit(0);
			}
			
		System.out.printf("You have ordered %d of adult, %d of kids, "
				+ "%d of senior ticket(s).\n", count[0],count[1],count[2]);
        System.out.printf("Total price: %.2f", price);
        System.out.println("\nPlease swipe your credit card, then take your tickets.");
    }

    //    -------------------------------------------------------------------------------------------
    public static void main (String args[]) {
        Vending V = new Vending( 2.25 );
        V.go();
    }
}


/* -----------------------------------------------------------------------------


Bus Ticket Vending Machine
   	1. Adult 2.25
    	2. Child under 12 1.13
    	3. Senior Citizen 1.80
	4. Finish and Pay
	5. Cancel
Please select 1, 2, 3 and enter the quantity.

1 8

Bus Ticket Vending Machine
   	1. Adult 2.25
    	2. Child under 12 1.13
    	3. Senior Citizen 1.80
	4. Finish and Pay
	5. Cancel
Please select 1, 2, 3 and enter the quantity.

3 5

Bus Ticket Vending Machine
   	1. Adult 2.25
    	2. Child under 12 1.13
    	3. Senior Citizen 1.80
	4. Finish and Pay
	5. Cancel
Please select 1, 2, 3 and enter the quantity.

2 6

Bus Ticket Vending Machine
   	1. Adult 2.25
    	2. Child under 12 1.13
    	3. Senior Citizen 1.80
	4. Finish and Pay
	5. Cancel
Please select 1, 2, 3 and enter the quantity.

4
You have ordered 8 of adult, 6 of kids, 5 of senior ticket(s).
Total price: 33.78
Please swipe your credit card, then take your tickets.
===========================

Bus Ticket Vending Machine
   	1. Adult 2.25
    	2. Child under 12 1.13
    	3. Senior Citizen 1.80
	4. Finish and Pay
	5. Cancel
Please select 1, 2, 3 and enter the quantity.

3 1

Bus Ticket Vending Machine
   	1. Adult 2.25
    	2. Child under 12 1.13
    	3. Senior Citizen 1.80
	4. Finish and Pay
	5. Cancel
Please select 1, 2, 3 and enter the quantity.

5
Cancelling your order.

------------------------------------------------------------------------------*/