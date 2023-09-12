package AnnotatedMetamodel2;

import Annotations.Constraint;
import Annotations.Feature;
import Annotations.Variant;
import Annotations.Constraint.TypeConstraint;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.Variant.FeatureSet2;
//@Variant(variant=FeatureSet2.Or)
@Feature(cardinality = Cardinality.Zerotomany,typeFeature = Type.Optional)
public class Blind {
public Deficiency deficience;
public Blind() {
	
}
}
