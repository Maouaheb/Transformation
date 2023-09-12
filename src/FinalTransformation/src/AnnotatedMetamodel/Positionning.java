package AnnotatedMetamodel;

import Annotations.Feature;
import Annotations.Variant;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.Variant.FeatureSet2;
import Annotations.VariationPoint.FeatureSet;
import Annotations.VariationPoint;
@Variant(variant = FeatureSet2.Xor)
@Feature(cardinality = Cardinality.Zerotomany,typeFeature = Type.Optional)
@VariationPoint(vp = FeatureSet.Or,variants = {Gps.class,Inside.class})
public class Positionning {

}
