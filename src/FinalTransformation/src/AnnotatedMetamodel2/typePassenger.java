package AnnotatedMetamodel2;
import Annotations.*;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
@Feature(typeFeature=Type.Mandatory, cardinality=Cardinality.Onetomany)
public class typePassenger {
public  Handicap handicap;
public Handicap2 han;
public typePassenger() {
	handicap=new Handicap();

}
}
