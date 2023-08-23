package com.example.calculator;

import java.util.*;
public class Infixevaluation {
    public static boolean isnumber(String str){
        for(int i = 0; i < str.length(); i++){
            if((str.charAt(i)>='0' && str.charAt(i)<='9')||str.charAt(i)=='.')
                continue;
            else
                return false;
        }
        return true;
    }
    public static int priority(char ch){
        if(ch=='%' || ch=='*' || ch=='/')
            return 2;
        return 1;
    }
    public static double calculate(double val1,double val2,char op){
        switch(op){
            case '+': return val2+val1;
            case '-': return val2-val1;
            case '*':return val2*val1;
            case '/': return val2/val1;
            case '%': return val2%val1;
        }
        return 0;

    }
    public double infix(String exp,int length){
        Stack<Character> operator = new Stack<Character>();
        Stack<Double> values = new Stack<Double>();
        int i;
        StringTokenizer st = new StringTokenizer(exp,"*+-/%()",true);
        while(st.hasMoreTokens()) {

            String var=st.nextToken();
            if(isnumber(var)==true){
                values.push(Double.parseDouble(var));
            }
            else{
                if(var.equals("("))
                    operator.push(var.charAt(0));
                else if(operator.size()==0||((var.equals("+")||var.equals("-")|var.equals("*")||var.equals("/")||
                        var.equals("%")) && priority(operator.peek())<priority(var.charAt(0)))||operator.peek()=='('){
                    operator.push(var.charAt(0));
                }
                else if(var.equals(")")){
                    while(operator.peek()!='('){
                        values.push(calculate(values.pop(),values.pop(),operator.pop()));
                    }
                    operator.pop();
                }
                else{
                    while(operator.size()!=0 && priority(operator.peek())>priority(var.charAt(0))){
                        values.push(calculate(values.pop(),values.pop(),operator.pop()));
                    }
                    operator.push(var.charAt(0));
                }
            }

        }
        while(operator.size()!=0){
            values.push(calculate(values.pop(),values.pop(),operator.pop()));
        }
        return values.pop();
    }

}
