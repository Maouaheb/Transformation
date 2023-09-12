package AnnotatedMetamodel2;

import Annotations.Feature;
import Annotations.VariationPoint;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.VariationPoint.FeatureSet;
@VariationPoint(vp = FeatureSet.Or,variants = {Windows1.class,Windows2.class,Window3.class})
@Feature(typeFeature=Type.Mandatory, cardinality=Cardinality.Manytomany)

public class Windows {
	

}
