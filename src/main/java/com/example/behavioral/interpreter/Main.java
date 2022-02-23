package com.example.behavioral.interpreter;

import com.example.behavioral.interpreter.expression.Expression;

/*

El patrón de interpretación especifica cómo evaluar sentencias
en un lenguaje, de forma programada. Ayuda a construir una
gramática para un lenguaje simple, de modo que las sentencias
del lenguaje puedan ser interpretadas.

Context
Expression
    AExpression
    BExpression
Main

Caso de uso: SQL
 */
//interface Expression {
//    public void interpret(Stack<Integer> s);
//}
//
//class TerminalExpression_Number implements Expression {
//    private int number;
//    public TerminalExpression_Number(int number)       { this.number = number; }
//    public void interpret(Stack<Integer> s)  { s.push(number); }
//}
//
//class TerminalExpression_Plus implements Expression {
//    public void interpret(Stack<Integer> s)  { s.push( s.pop() + s.pop() ); }
//}
//
//class TerminalExpression_Minus implements Expression {
//    public void interpret(Stack<Integer> s)  { int tmp = s.pop(); s.push( s.pop() - tmp ); }
//}
//
//class Parser {
//    private ArrayList<Expression> parseTree = new ArrayList<Expression>(); // only one NonTerminal Expression here
//
//    public Parser(String s) {
//        for (String token : s.split(" ")) {
//            if      (token.equals("+")) parseTree.add( new TerminalExpression_Plus() );
//            else if (token.equals("-")) parseTree.add( new TerminalExpression_Minus() );
//                // ...
//            else                        parseTree.add( new TerminalExpression_Number(Integer.valueOf(token)) );
//        }
//    }
//
//    public int evaluate() {
//        Stack<Integer> context = new Stack<Integer>();
//        for (Expression e : parseTree) e.interpret(context);
//        return context.pop();
//    }
//}

public class Main {
    public static void main(String[] args) {

        String formula = "45 + 38 - 13 + 1 - 5";
        Parser parser = new Parser(formula);

        while (!parser.isEmptyOperators()) {
                Expression operator = parser.popOperator();
                System.out.println(operator.interpret(parser));
        }
//        System.out.println(operazione + " = " + risultato );
    }
}