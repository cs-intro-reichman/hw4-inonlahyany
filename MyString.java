public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("shotgun", "")); // false
        System.out.println(contains("", "")); // false
        System.out.println(contains("shotgun", "flower")); // false
        System.out.println(contains("hhhhsh", "happy")); // false
        System.out.println(contains("unhappy", "unhappy")); // true
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }


    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String lowerCaseString = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90 ) {
                lowerCaseString += (char) (str.charAt(i) + 32);
            } else {
                lowerCaseString += str.charAt(i);
            }
        }
        return lowerCaseString;
    }

    /** Returns the number of times a given string contains a given letter */
    public static int countLetters(String str1, char letter) {
        int letterCounter = 0;
       
        for (int l = 0; l < str1.length(); l++) {
            if (str1.charAt(l) == letter) {
                letterCounter++;
            }
        }

        return letterCounter;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {

        if (str2.length() == 0) {
            return true;
        }

        int firstCharOfStr2 = str2.charAt(0);
        int indexOfStr2InStr1 = str1.indexOf(firstCharOfStr2);

        while (indexOfStr2InStr1 != -1) {
            // checks if the substring starting at 'index' matches str2
            boolean isMatch = true;

            for (int i = 0; i < str2.length(); i++) {
                if (indexOfStr2InStr1 + i >= str1.length() || str1.charAt(indexOfStr2InStr1 + i) != str2.charAt(i)) {
                    isMatch = false;
                    break;
                }
            }

            // only if full match was found we will return true, otherwise we will continue checking the next appearance. 
            if (isMatch) {
                return true;
            }

            indexOfStr2InStr1 = str1.indexOf(firstCharOfStr2, indexOfStr2InStr1 + 1);
        }

        // if no match was found, return false
        return false;

    }
}






// old version of contains function:

// public static boolean contains(String str1, String str2) {

//     // initiazling an array big enough to contain the indexes of all appearances of string 1 first letter in string 2.
//     if (str2.length() == 0) {
//         return true;
//     }
//     char firstLetterOfStr2 = str2.charAt(0);
//     int[] indexArr = new int[countLetters(str1, firstLetterOfStr2)];

//     // checking if array length is 0, meaning no matches for first letter of str2 were found in str1 (countLetters returned 0)
//     if (indexArr.length == 0) {
//         return false;
//     }
    
//     int indexOfStr1Letter = str1.indexOf(firstLetterOfStr2);
//     int arrIndex = 0; 
//     while (indexOfStr1Letter != -1 && arrIndex < indexArr.length) {
//         indexArr[arrIndex++] = indexOfStr1Letter;
//         indexOfStr1Letter = str1.indexOf(firstLetterOfStr2, indexOfStr1Letter + 1);  
//     }

//     boolean isContained = false;
//     int strLetterCount = 0;

//     // each element in the array is an index of a potential match for str2, so we iterate over all elements and try to see if there's a match.
//     for (int i = 0; (i < indexArr.length); i++) {
//         strLetterCount = 0;
//         // initalizing a variable that will contain the current index in str1 that we are going to start from, just for the sake of readability.
//         int beginIndexOfStr1 = indexArr[i];

//         // now we iterate over str2 and str1 and see if they match letter by letter.
//         // we also increment a letter counter that we will use later on to check if there was a full match.r
//         for (int s = 0; (s < str2.length()) && (s + beginIndexOfStr1 < str1.length()); s++) {
//             if (str1.charAt(beginIndexOfStr1 + s) == str2.charAt(s)) {
//                 strLetterCount++;
//             }
//         }

//         if (strLetterCount == str2.length()) {
//             isContained = true;
//             break;
//         }
//     }
//     return isContained;
// }   