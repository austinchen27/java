public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 4.0;
        double lattePrice = 4.5;
        double cappuccinoPrice = 5.0;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        // Cindhuri
        if (isReadyOrder1 == true) {
        System.out.println(customer1 + pendingMessage);
        }
        else {
            System.out.println(customer1 + readyMessage);
            System.out.println(displayTotalMessage + dripCoffeePrice);
        }

        // Noah
        System.out.println(generalGreeting + customer4);
        if (isReadyOrder4 == true) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }

        // Sam
        System.out.println(generalGreeting + customer2);
        double customer2total = (lattePrice + lattePrice);
        System.out.println(displayTotalMessage + customer2total);
        if (isReadyOrder2 == true) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + customer2total);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }

        // Jimmy
        System.out.println(generalGreeting + customer3);
        double customer3total = (lattePrice - dripCoffeePrice);
        System.out.println(displayTotalMessage + customer3total);



    }
}