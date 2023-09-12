package Annotations;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Vp.class)
public @interface VariationPoint {
	public enum FeatureSet {
		Or, Xor, And
	}
public FeatureSet vp () ;
public Class[] variants();

}
