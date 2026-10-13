package cs1632;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    //general add to list thing for all tests
    private ArrayList<Token> tokens(Token... toks) {
        ArrayList<Token> list = new ArrayList<>();
        for (Token t : toks) {
            list.add(t);
        }
        return list;
    }
    @Test
    void testAdd() {
        Calculator calc = new Calculator();
        ArrayList<Token> equation = tokens(new OpToken('+'), new NumToken("2"), new NumToken("3"));
        assertEquals(5.0, calc.calcPrefix(equation));
    }
    @Test
    void testSubtract() {
        Calculator calc = new Calculator();
        ArrayList<Token> equation = tokens(new OpToken('-'), new NumToken("4"), new NumToken("3"));
        assertEquals(1.0, calc.calcPrefix(equation));
    }
    @Test
    void testMultiplication() {
        Calculator calc = new Calculator();
        ArrayList<Token> equation = tokens(new OpToken('*'), new NumToken("2"), new NumToken("3"));
        assertEquals(6.0, calc.calcPrefix(equation));
    }
    @Test
    void testDivision() {
        Calculator calc = new Calculator();
        ArrayList<Token> equation = tokens(new OpToken('/'), new NumToken("2"), new NumToken("4"));
        assertEquals(0.5, calc.calcPrefix(equation));
    }
}