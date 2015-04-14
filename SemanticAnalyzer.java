package semantic.analyzer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SemanticAnalyzer extends Lexer{
    
    public SemanticAnalyzer(){}
    
    public SemanticAnalyzer(String filename) throws IOException{
        
        File file = new File(filename);
        ArrayList<String> lst = new ArrayList<String>();

        Lexer lexer = new Lexer(file);

        while(lexer.token().type != Token.EOI){
            lexer.next();
                if(lexer.token().type == Token.INT){
                    lexer.next();
                        if(checkForDuplicates(lst, lexer.token().lexeme) == false)
                            lst.add(lexer.token().lexeme);
                        else if(checkForDuplicates(lst, lexer.token().lexeme) == true)
                            System.out.println(lexer.token().lexeme + " has already been declared.");
                        
                    lexer.next();
                    
                        if(lexer.token().type == Token.COMMA){
                            lexer.next();
                                if(checkForDuplicates(lst, lexer.token().lexeme) == false)
                                    lst.add(lexer.token().lexeme);
                        }
                }else if(lexer.token().type == Token.ID){
                    if(checkForDuplicates(lst, lexer.token().lexeme) == false)
                        System.out.println(lexer.token().lexeme + " never declared\n"); 
                  }
        }
        printLst(lst);
    }
    
public static boolean checkForDuplicates(ArrayList<String> lst, String lexeme){
    boolean hasDuplicate = false;
    
    for(int i = 0; i < lst.size(); i++){
        if(lexeme.equals(lst.get(i)))
            hasDuplicate = true;
    }
        return hasDuplicate;  
}

public static void printLst(ArrayList<String> lst){
    Collections.sort(lst);
    System.out.println("Variables");
    System.out.println("---------");
    for(int i = 0; i < lst.size(); i++)
            System.out.println(lst.get(i) + " : " + lst.get(i) );
}
}
