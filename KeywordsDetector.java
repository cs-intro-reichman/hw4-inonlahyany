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