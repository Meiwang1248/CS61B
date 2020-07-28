public class Palindrome {

    /** This method is to convert word to deque. */
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> wordInDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordInDeque.addLast(word.charAt(i));
        }
        return wordInDeque;
    }

    /** This method is to see if a word is Palindrome. */
    public static boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    /** This is a helper method to determine if a word is Palindrome by
     * converting it to a deque. */
    public static boolean isPalindrome(Deque<Character> wordInDeque) {
        if (wordInDeque.size() == 0 || wordInDeque.size() == 1){
            return true;
        }
        boolean n_case = wordInDeque.removeFirst() == wordInDeque.removeLast();
        boolean n_1_case = isPalindrome(wordInDeque);
        return n_case && n_1_case;

    }

    /** This is a method to determin if a word is Palindrome off by one, converting it to a deque. */
    public static boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word), cc);
    }

    public static boolean isPalindrome(Deque<Character> wordInDeque,CharacterComparator cc) {
        if (wordInDeque.size() == 0 || wordInDeque.size() == 1) {
            return true;
        }
        boolean n_case = cc.equalChars(wordInDeque.removeFirst(), wordInDeque.removeLast());
        boolean n_1_case = isPalindrome(wordInDeque, cc);
        return n_case && n_1_case;
    }





}
