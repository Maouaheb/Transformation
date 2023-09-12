package AnnotatedMetamodel2;

import Annotations.Feature;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.VariationPoint;
import Annotations.VariationPoint.FeatureSet;
@Feature(typeFeature=Type.Mandatory, cardinality=Cardinality.Onetomany)
public class Plateform {
public  ComputerApplication computer;
public  Android android;

}
