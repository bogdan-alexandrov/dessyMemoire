package bg.tusofia.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for struct_types.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="struct_types">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="simple"/>
 *     &lt;enumeration value="struct"/>
 *     &lt;enumeration value="array"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "struct_types")
@XmlEnum
public enum StructTypes implements java.io.Serializable{

    @XmlEnumValue("simple")
    SIMPLE("simple"),
    @XmlEnumValue("struct")
    STRUCT("struct"),
    @XmlEnumValue("array")
    ARRAY("array");
    private final String value;

    StructTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StructTypes fromValue(String v) {
        for (StructTypes c: StructTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
