import java.util.Set;
import java.util.TreeSet;

// Jerry Huang
// APCS
// Period 2
// MathSet HW Assignment


/**
 * MathSet Program
 * 
 * A MathSet that implements the Set interface, with union and intersection methods
 * 
 * @author Jerry Huang
 */
public class MathSet<T> extends TreeSet<T> implements Set<T> {
	
	
	/**
	 * A union method that combines the elements of 
	 * both sets and adds them to a retval MathSet
	 * 
	 * @param values; values to be combined with
	 * @return retval; the unioned MathSet
	 */
	public MathSet<T> union(MathSet<T> values) {
		MathSet<T> retval = new MathSet<>();
		
		// Adds(combines) all the values into retval MathSet
		retval.addAll(values);
		retval.addAll(this);
		return retval;
	}
	
	/**
	 * An intersection method that adds elements to a retval MathSet
	 * only if they are in both MathSets
	 * 
	 * @param values; values to test for intersection
	 * @return retval; the intersected MathSet
	 */
	public MathSet<T> intersection(MathSet<T> values) {
		MathSet<T> retval = new MathSet<T>();
		
		for (int i = 0; i < values.size(); i++) {
			
			// If both sets share an element, add it to retval
			if (values.contains(this.first())) retval.add(this.first());
			
			// Then removes the shared element to prevent possible repetition
			values.remove(this.first());
			this.remove(this.first());
		}
		return retval;
	}
}
