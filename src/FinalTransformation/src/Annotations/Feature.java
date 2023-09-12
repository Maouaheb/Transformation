package Annotations;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Feature {
	public enum Type {
		Mandatory, Optional
	}
	enum Cardinality {
		Onetomany ,Manytoone ,Manytomany,Zerotomany
	}
public Cardinality cardinality();
public Type typeFeature ();



}
