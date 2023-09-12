package AnnotatedMetamodel2;

import Annotations.Feature;
import Annotations.Variant;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.Variant.FeatureSet2;

@Variant(variant=FeatureSet2.Or)
@Feature(cardinality = Cardinality.Zerotomany,typeFeature = Type.Optional)

public class Deaf {
public CompleteDef deff;
public Deaf() {
	
}
}
