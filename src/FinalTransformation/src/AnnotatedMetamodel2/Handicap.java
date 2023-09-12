package AnnotatedMetamodel2;

import Annotations.Constraint;
import Annotations.Feature;
import Annotations.VariationPoint;
import Annotations.Constraint.TypeConstraint;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.VariationPoint.FeatureSet;
@VariationPoint(vp = FeatureSet.Or,variants = {Blind.class,Deaf.class})
@Constraint(constraint = TypeConstraint.Mutex,ConstrainedClass =AdaptedTrain.class)
@Feature(typeFeature=Type.Mandatory, cardinality=Cardinality.Manytomany)

public class Handicap  {
	
}
