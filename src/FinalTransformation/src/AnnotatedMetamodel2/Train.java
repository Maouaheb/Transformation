package AnnotatedMetamodel2;

import Annotations.*;
import Annotations.Constraint.TypeConstraint;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.VariationPoint.FeatureSet;
@Constraint(constraint = TypeConstraint.Require,ConstrainedClass = Totaly.class)
@Feature(typeFeature=Type.Mandatory, cardinality=Cardinality.Manytomany)
public class Train {
public NormalTrain normalTrain;

	
public Train() {
	
	normalTrain=new NormalTrain();
}
}
