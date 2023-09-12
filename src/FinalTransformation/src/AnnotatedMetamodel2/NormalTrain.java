package AnnotatedMetamodel2;

import java.lang.reflect.Field;
import java.util.HashMap;

import Annotations.Feature;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.VariationPoint;
import Annotations.VariationPoint.FeatureSet;

@Feature(cardinality = Cardinality.Manytomany,typeFeature = Type.Mandatory)
public class NormalTrain {

}
