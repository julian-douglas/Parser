import computation.contextfreegrammar.*;
import java.util.ArrayList;
import java.util.List;

public class MyGrammar {
	public static ContextFreeGrammar makeGrammar() {

		// Declare and initialise our variables:
    Variable s = new Variable('S');
    Variable t = new Variable('T');
    Variable f = new Variable('F');
    Variable s0 = new Variable("S0");
    Variable s1 = new Variable("S1");
    Variable f1 = new Variable("F1");
    Variable t1 = new Variable("T1");
    Variable p = new Variable('P');
    Variable m = new Variable('M');
    Variable l = new Variable('L');
    Variable r = new Variable('R');

    //Declare and initialise our terminals:
    Terminal plus = new Terminal('+');
    Terminal times = new Terminal('*');
    Terminal leftBracket = new Terminal('(');
    Terminal rightBracket = new Terminal(')');
    Terminal one = new Terminal('1');
    Terminal zero = new Terminal('0');
    Terminal x = new Terminal('x');

    //Declare and initialise our rules:
    Rule r1 = new Rule(s0, new Word(s, s1));
    Rule r2 = new Rule(s0, new Word(t, t1));
    Rule r3 = new Rule(s0, new Word(l, f1));
    Rule r4 = new Rule(s0, new Word(one));
    Rule r5 = new Rule(s0, new Word(zero));
    Rule r6 = new Rule(s0, new Word(x));
    Rule r7 = new Rule(s, new Word(s, s1));
    Rule r8 = new Rule(s, new Word(t, t1));
    Rule r9 = new Rule(s, new Word(l, f1));
    Rule r10 = new Rule(s, new Word(one));
    Rule r11 = new Rule(s, new Word(zero));
    Rule r12 = new Rule(s, new Word(x));
    Rule r13 = new Rule(t, new Word(t, t1));
    Rule r14 = new Rule(t, new Word(l, f1));
    Rule r15 = new Rule(t, new Word(one));
    Rule r16 = new Rule(t, new Word(zero));
    Rule r17 = new Rule(t, new Word(x));
    Rule r18 = new Rule(f, new Word(l, f1));
    Rule r19 = new Rule(f, new Word(one));
    Rule r20 = new Rule(f, new Word(zero));
    Rule r21 = new Rule(f, new Word(x));
    Rule r22 = new Rule(f1, new Word(s, r));
    Rule r23 = new Rule(t1, new Word(m, f));
    Rule r24 = new Rule(s1, new Word(p, t));
    Rule r25 = new Rule(l, new Word(leftBracket));
    Rule r26 = new Rule(r, new Word(rightBracket));
    Rule r27 = new Rule(p, new Word(plus));
    Rule r28 = new Rule(m, new Word(times));

    //create a list of rules:
    List<Rule> rules = new ArrayList<Rule>();

    //add each rule, one by one:
    rules.add(r1);
    rules.add(r2);
    rules.add(r3);
    rules.add(r4);
    rules.add(r5);
    rules.add(r6);
    rules.add(r7);
    rules.add(r8);
    rules.add(r9);
    rules.add(r10);
    rules.add(r11);
    rules.add(r12);
    rules.add(r13);
    rules.add(r14);
    rules.add(r15);
    rules.add(r16);
    rules.add(r17);
    rules.add(r18);
    rules.add(r19);
    rules.add(r20);
    rules.add(r21);
    rules.add(r22);
    rules.add(r23);
    rules.add(r24);
    rules.add(r25);
    rules.add(r26);
    rules.add(r27);
    rules.add(r28);
    

    ContextFreeGrammar cfg = new ContextFreeGrammar(rules);
		return cfg;
	}
}
