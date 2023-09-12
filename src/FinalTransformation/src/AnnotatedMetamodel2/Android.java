package AnnotatedMetamodel2;

import Annotations.*;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.VariationPoint.FeatureSet;
@VariationPoint(vp = FeatureSet.Xor,variants = {A.class,B.class})
@VariationPoint(vp = FeatureSet.Or,variants = {A1.class,B1.class})
@Feature(typeFeature=Type.Optional, cardinality=Cardinality.Zerotomany)
public class Android {

}
