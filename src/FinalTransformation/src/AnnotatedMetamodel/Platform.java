package AnnotatedMetamodel;

import Annotations.Feature;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.VariationPoint;
import Annotations.VariationPoint.FeatureSet;
@Feature(typeFeature=Type.Mandatory, cardinality=Cardinality.Manytomany)
@VariationPoint(vp = FeatureSet.Xor,variants = {Desktop.class,Phone.class, Tablet.class})
public class Platform {
public  HardFeature hardFeature;
public Platform() {
	
}
}
