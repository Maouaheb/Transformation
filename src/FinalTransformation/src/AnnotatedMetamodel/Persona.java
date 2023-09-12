package AnnotatedMetamodel;
import Annotations.*;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.VariationPoint.FeatureSet;
@Feature(typeFeature=Type.Mandatory, cardinality=Cardinality.Onetomany)
@VariationPoint(vp = FeatureSet.Or,variants = {Young.class,Adult.class, Senior.class})
public class Persona {
public  Disability dis;	
public  TypePoI poi;


public Persona() {

}
}
