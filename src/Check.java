/**
 * Do not modify this file
 */


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.gui.TestRig;
import static java.lang.System.out;
import java.io.*;

public class Check {
    public static class ErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(
                Recognizer<?,?> recognizer,
                Object offendingSymbol,
                int line,
                int pos,
                String msg,
                RecognitionException e) throws ParseCancellationException {
            throw new ParseCancellationException(
                String.format("%s on line \"%d\" position \"%s\"",
                    msg, line, pos));
        }
    }

    public static void check (String filename) throws Exception {
        CharStream input = CharStreams.fromFileName(filename);
        Lexer lexer = new ProgLangLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ErrorListener());

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ProgLangParser parser = new ProgLangParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());

        try {
            parser.program();
        } catch(Exception e) {
            System.out.println("[FAILED]\n" + e.getMessage());
        }
    }
    public static void main(String[] args) throws Exception {
        check(args[0]);
    }
}
