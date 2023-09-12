package AnnotatedMetamodel2;

import Annotations.Feature;
import Annotations.VariationPoint;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.VariationPoint.FeatureSet;
@VariationPoint(vp = FeatureSet.Xor,variants = {Platforme1.class, Platforme2.class})
@VariationPoint(vp = FeatureSet.Or,variants = {Platforme4.class, Platforme3.class})
@Feature(typeFeature=Type.Mandatory, cardinality=Cardinality.Manytomany)
public class ComputerApplication {
public Windows applicationWindows;
}
