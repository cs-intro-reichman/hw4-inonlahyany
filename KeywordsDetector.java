import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the keywords, prints it.
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

    /** If str1 contains str2, returns true; otherwise returns false. */
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

        // initiazling an array big enough to contain the indexes of all appearances of string 1 first letter in string 2.
        char firstLetterOfStr2 = str2.charAt(0);
        int[] indexArr = new int[countLetters(str1, firstLetterOfStr2)];

        // checking if array length is 0, meaning no matches for first letter of str2 were found in str1 (countLetters returned 0)
        if (indexArr.length == 0) {
            return false;
        }
        
        int IndexPointer = 0;
        for (int w = 0; w < str1.length(); w++) {
            // setting the array elements, one by one, to the indexes of the occurences of the first letter of str1 in str2.
            if (str1.indexOf(firstLetterOfStr2, IndexPointer) != -1) { 
                indexArr[w] = str1.indexOf(firstLetterOfStr2, IndexPointer);
                // incrementing the pointer to the last index returned + 1, so in the next iteration we will skip it.
                IndexPointer = str1.indexOf(firstLetterOfStr2, IndexPointer) + 1;
            }
        }

        boolean isContained = false;
        int strLetterCount = 0;

        // each element in the array is an index of a potential match for str2, so we iterate over all elements and try to see if there's a match.
        for (int i = 0; (i < indexArr.length); i++) {
            strLetterCount = 0;
            // initalizing a variable that will contain the current index in str1 that we are going to start from, just for the sake of readability.
            int beginIndexOfStr1 = indexArr[i];
   
            // now we iterate over str2 and str1 and see if they match letter by letter.
            // we also increment a letter counter that we will use later on to check if there was a full match.r
            for (int s = 0; (s < str2.length()) && (s + beginIndexOfStr1 < str1.length()); s++) {
                if (str1.charAt(beginIndexOfStr1 + s) == str2.charAt(s)) {
                    strLetterCount++;
                }
            }

            if (strLetterCount == str2.length()) {
                isContained = true;
                break;
            }
        }
        return isContained;
    }   

    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int s = 0; s < sentences.length; s++) {
            boolean flagIsContain = false;
           
            for (int k = 0; k < keywords.length; k ++) {
                
                String lowerCaseSentence = lowerCase(sentences[s]);
                String lowerCaseKeyword = lowerCase(keywords[k]);
                flagIsContain = contains(lowerCaseSentence, lowerCaseKeyword);
                if (flagIsContain) {
                    System.out.println(sentences[s]);
                    break;
                }
            }
        }
    }

}