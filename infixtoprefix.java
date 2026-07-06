import java.util.stack;

public class infixtoprefix {
    static int prec(char c){
        if(c == '^')
            return 3;
        else if(c == '*' || c == '/')
            return 2;
        else if(c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    static boolean isRightAssociative(char c){
        if(c == '^')
    }
    
}