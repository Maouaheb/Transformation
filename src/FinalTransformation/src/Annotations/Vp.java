package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import Annotations.VariationPoint.FeatureSet;
@Retention(RetentionPolicy.RUNTIME)
public @interface Vp {
	VariationPoint[] value()default {};
}
