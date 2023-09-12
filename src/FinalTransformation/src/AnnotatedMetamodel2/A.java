package AnnotatedMetamodel2;

import Annotations.*;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.Variant.FeatureSet2;

@Variant(variant=FeatureSet2.Xor)
@Feature(cardinality = Cardinality.Zerotomany,typeFeature = Type.Optional)
public class A {
}
