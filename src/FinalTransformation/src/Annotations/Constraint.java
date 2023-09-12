package Annotations;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraint {
	public enum TypeConstraint {
		Mutex, Require
	}
public TypeConstraint constraint();
public  Class ConstrainedClass();
}
