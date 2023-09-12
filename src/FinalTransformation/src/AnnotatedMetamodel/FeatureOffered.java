package AnnotatedMetamodel;

import Annotations.*;
import Annotations.Constraint.TypeConstraint;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.VariationPoint.FeatureSet;
@Constraint(constraint = TypeConstraint.Require,ConstrainedClass = Totaly.class)
@Feature(typeFeature=Type.Optional, cardinality=Cardinality.Manytomany)
@VariationPoint(vp = FeatureSet.Xor,variants = {RoutePlanning.class,MicroSocNet.class, WeatherForecast.class, Positionning.class})
public class FeatureOffered {
	
public FeatureOffered() {
	
}
}
