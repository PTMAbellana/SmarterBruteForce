package SmarterBruteForce;

public class CrackerRunnable implements Runnable{

    public static boolean found = false;
    public static String password;
    private final int vowel_position;
    private final char vowel;
    public CrackerRunnable(char vowel, int vowel_position){
        this.vowel = vowel;
        this.vowel_position = vowel_position;
    }
    private String check(String atk){
        return atk.substring(0,vowel_position) + vowel + atk.substring(vowel_position);
    }
    public void run(){
        int len = password.length(); //
        String atk = "a".repeat(len-1);
        while (!found && !check(atk).equals(password)) {
            System.out.println(Thread.currentThread().getName() + ": "+ check(atk));
            int i;
            for (i = atk.length()-1; i >= 0 && atk.charAt(i) == 'z'; i--);
            if (i < 0) return;
            String first = atk.substring(0, i);
            char next = (char) (atk.charAt(i) + 1);
            String after = "a".repeat(len - i - 2);
            atk = first + next + after;
        }
        if (check(atk).equals(password)) {
            found = true;
            System.out.println(Thread.currentThread().getName() + " Found: " + check(atk));
        }

    }
}