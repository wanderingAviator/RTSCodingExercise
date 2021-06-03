public class RTSCodingExercise {

    /**
     * Handles all questions via command line.
     * 
     * q1: allows negative numbers, allows empty integer arrays (single comma on the command line), 
     *     no spaces between integers, only commas
     * q2: no quotes necessary if there are no spaces, if there are spaces, use quotes eg. 
     *     "Hello World" vs, HelloWorld, no negative shift value allowed
     * q3: no command-line args necessary.
     *     
     * @param args command-line args
     */
    public static void main( String[] args ) {
        boolean validRead = true;
        
        if(args.length == 3) { //handles q1 + q2
            if(args[0].equals( "q1" ) || args[0].equals( "Q1" )) { //handle question 1
                String[] nums = args[1].split( "," ); //gets all numbers from input string
                int[] in = new int[nums.length];
                int limit = 0;
                    
                try {
                    for(int i = 0; i < nums.length && validRead; i++) { //sets up input array
                        in[i] = Integer.parseInt( nums[i] );
                    }
                        
                    limit = Integer.parseInt( args[2] );
                } catch ( NumberFormatException e) {
                    System.out.println("Invalid integer array input.");
                    validRead = false;
                }
                if(validRead) {
                    System.out.println(aboveOrBelow(in, limit));
                }
                
            } else if (args[0].equals( "q2" ) || args[0].equals( "Q2" )) { //handle question 2
                String rotate = args[1]; //gets input string
                int shift = 0;
                
                try {
                    shift = Integer.parseInt( args[2] );
                    if(shift < 0) { //shift must be positive/zero
                        throw new NumberFormatException();
                    }
                } catch ( NumberFormatException e) {
                    System.out.println("Invalid character shift quantity.");
                    validRead = false;
                }
                if(validRead) {
                    System.out.println(rotatedText(rotate, shift));
                }
            } else {
                usage();
            }
        } else if (args.length == 1 && (args[0].equals( "q3" ) || args[0].equals( "Q3" ))) { 
            printAnswerThree(); //handles question 3: must not have extra command-line args attached.
        } else {
            usage();
        }
    }
    

    /**
     * Prints out q3, and my answer to it.
     */
    private static void printAnswerThree() {
        System.out.println("Question: If you could change 1 thing about your favorite "
                + "framework/language/platform (pick one), what would it be?");
        System.out.println("");
        System.out.println("Answer: This question makes me think of the professor that taught me C, "
                + "who had a particular gripe with Java that it \"held your hand\" too much, "
                + "with things like garbage collection.");
        System.out.println("While I hear languages like C++ "
                + "bridge the gap between Java and C, with features like usage of references "
                + "and pointers both, I think such a way to experiment with manually");
        System.out.println("such features as pointers and garbage collection in an "
                + "environment as easy and beginner-friendly as Java could benefit "
                + "both people newer to programming, looking to get into");
         System.out.println("technicalities Java handles, and people more experienced "
                + "with programming in languages like C, who could want that "
                + "familiarity in Java.");
    }



    /**
     * Prints the number of integers in a given array that are above or below a given number.
     * Excludes numbers that are equal to the given number.
     * 
     * @param list the list of numbers
     * @param input the given number to be compared against
     * @return a string listing the number of integers in a 
     *         given array that are above or below a given number.
     */
    private static String aboveOrBelow(int[] list, int input) {
        int above = 0;
        int below = 0;
        
        if(list != null) {
            for(int i = 0; i < list.length; i++) {
                if(list[i] > input) { // above
                    above++;
                } else if (list[i] < input) { //below
                    below++;
                }
            }
        }
        
        return "above: " + above + ", below: " + below;
    }
    
    /**
     * Rotates the characters of a given String by a given input, 
     * wrapping around to the beginning of the string.
     * 
     * @param text the text to shift
     * @param shift how many characters to shift by
     * @return the shifted string
     */
    private static String rotatedText(String text, int shift) {
        //mod by text length to allow larger numbers than the text length.
        String splitEnd = text.substring( text.length() - (shift % text.length()) );
        String splitStart = text.substring( 0, text.length() - (shift % text.length()) );
        return splitEnd + splitStart;
    }
    
    /**
     * Prints out a usage guide, with examples.
     */
    private static void usage() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Usage: ");
        System.out.println("    java RTSCodingExercise <q1/q2/q3> <parameters (if needed)>");
        System.out.println("    ex. java RTSCodingExercise q1 1,5,2,1,10 6");
        System.out.println("    ex. java RTSCodingExercise q2 \"MyString\" 2");
        System.out.println("    ex. java RTSCodingExercise q3");
        System.out.println("------------------------------------------------------------------------------------");
        
    }

}
