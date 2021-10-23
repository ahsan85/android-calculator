package com.example.ahsan;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    List<String> words = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = findViewById(R.id.value0);
        Button button1 = findViewById(R.id.value1);
        Button button2 = findViewById(R.id.value2);
        Button button3 = findViewById(R.id.value3);
        Button button4 = findViewById(R.id.value4);
        Button button5 = findViewById(R.id.value5);
        Button button6 = findViewById(R.id.value6);
        Button button7 = findViewById(R.id.value7);
        Button button8 = findViewById(R.id.value8);
        Button button9 = findViewById(R.id.value9);
        Button plus = findViewById(R.id.valuePlus);
        Button minus = findViewById(R.id.valueMinus);
        Button multiply = findViewById(R.id.valueMutiply);
        Button divide = findViewById(R.id.valueDivide);
        Button mod = findViewById(R.id.valueMod);
        Button dot = findViewById(R.id.valueDot);
        Button equal = findViewById(R.id.valueEqual);
        Button clear = findViewById(R.id.clear);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        mod.setOnClickListener(this);
        dot.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {



        switch (view.getId()) {
            case R.id.value0:
                words.add("0");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 0 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.value1:
                words.add("1");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.value2:
                words.add("2");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 0 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.value3:
                words.add("3");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.value4:
                words.add("4");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.value5:
                words.add("5");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.value6:
                words.add("6");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.value7:
                words.add("7");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.value8:
                words.add("8");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.value9:
                words.add("9");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.valuePlus:
                words.add("+");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.valueMinus:
                words.add("-");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.valueMutiply:
                words.add("*");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.valueDivide:
                words.add("/");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.valueMod:
                words.add("%");
                System.out.println("insert"+words);
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.valueEqual:
//               words.toString();

//                String daysArray[] = new String[words.size()];
//
//                  daysArray = words.toArray(daysArray);
//                for (String day : daysArray) {
//                    System.out.println("Day = " + day);
//                }

                StringBuffer sb = new StringBuffer();
                for (String word : words) {
                    sb.append(word);
                }
                String str = sb.toString();
                System.out.println(eval(str));
//                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;


        }
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}