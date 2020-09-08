package VistorDesignPattern;


/*
 * According to Wikipedia, 
 * the visitor design pattern is a way of separating an algorithm from an object structure on
 * which it operates. A practical result of this separation is the ability to add new operations
 * to existing object structures without modifying those structures. It is one way to follow the
 *  open/closed principle (one of SOLID design principles).
 *  
 *  
 *  Above design flexibility allows to add methods to any object hierarchy without modifying
 *  the code written for hierarchy. Rather double dispatch mechanism is used to implement this
 *  facility. Double dispatch is a special mechanism that dispatches a function call to
 *  different concrete functions depending on the runtime types of two objects involved
 *  in the call.
 * */

public interface Visitor {

	public double visit(Liquor liquorItem);
	public double visit(Tobacco liquorItem);
	public double visit(Necessity liquorItem);
}
