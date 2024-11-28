public class Primes {
    public static void main(String[] args) {
        int upToNumber = Integer.parseInt(args[0]);
        boolean[] isPrime = new boolean[upToNumber + 1];
   
        for (int i = 2; i < isPrime.length; i++ ) {
            isPrime[i] = true;
        }

        for (int i = 2; i < isPrime.length; i++) {    // going into the loop only for potential primes
            
            if (isPrime[i] == true) {
                // setting current index to prime being checked, for ease of understanding.
                int currentPrimeChecked = i;
                // iterating from the current prime to the end of the array                                     
                for (int d = currentPrimeChecked; d < isPrime.length; d++) {
                    // checking if number is prime or not    
                    if (d % currentPrimeChecked == 0 && d / currentPrimeChecked != 1 ) {  
                        isPrime[d] = false;
                    }
                }
            }
        }

        System.out.println("Prime numbers up to " + upToNumber + ":");
        int counterOfPrimes = 0;

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i] == true) {
                System.out.println(i);
                counterOfPrimes++;
            }
        }

        double percentageOfPrimes = (double) counterOfPrimes/(isPrime.length - 1) * 100;

        System.out.print("There are " + counterOfPrimes + " primes between 2 and " + upToNumber);
        System.out.println(" (" + (int) percentageOfPrimes + "% are primes)");
    }
}