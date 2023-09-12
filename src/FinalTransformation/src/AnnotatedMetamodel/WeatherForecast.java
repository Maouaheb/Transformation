package AnnotatedMetamodel;

import Annotations.Feature;
import Annotations.Variant;
import Annotations.VariationPoint.FeatureSet;
import Annotations.VariationPoint;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.Variant.FeatureSet2;

@Variant(variant = FeatureSet2.Or)
@Feature(cardinality = Cardinality.Zerotomany,typeFeature = Type.Optional)
public class WeatherForecast {

}
