package AnnotatedMetamodel2;

import Annotations.Feature;
import Annotations.Variant;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.Variant.FeatureSet2;

@Variant(variant=FeatureSet2.Xor)
@Feature(typeFeature=Type.Optional, cardinality=Cardinality.Zerotomany)

public class B {

}
