package cs1632;

import cs1632.NumToken;
import cs1632.OpToken;
import cs1632.Token;
import cs1632.Tokenizer;

import java.util.ArrayList;


public class Calculator {
    private ArrayList<Token> tokens;
    private int index;

    public double calcPrefix(ArrayList<Token> tokenSequence) {
        tokens = tokenSequence;
        index = 0;
        double result = calcNext();

        return result;
    }
    private double calcNext() {
        if (index >= tokens.size()) {
            throw new IllegalArgumentException("out of bounds");
        }
        Token tok = tokens.get(index);
        index++;

        if (tok instanceof NumToken) {
            NumToken numTok = (NumToken) tok;
            return numTok.value;
        }
        if (tok instanceof OpToken) {
            OpToken opTok = (OpToken) tok;
            char operator = (char) opTok.getOperator();

            double operand1 = calcNext();
            double operand2 = calcNext();

            switch (operator) {
                case '+':
                    return operand1 + operand2;
                case '-':
                    return operand1 - operand2;
                case '*':
                    return operand1 * operand2;
                case '/':
                    if (operand2 ==0) {
                        throw new ArithmeticException("division by zero");
                    }
                    return operand1 / operand2;
                default:
                    throw new IllegalArgumentException("not valid operator: " + tok.getTokenString());
            }
        }
        throw new IllegalArgumentException("not valid token: " + tok.getTokenString());
    }

}
