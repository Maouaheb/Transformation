package Annotations;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Variant {
	public enum FeatureSet2 {
		Or, Xor, And
	}
	public FeatureSet2 variant ();

}
