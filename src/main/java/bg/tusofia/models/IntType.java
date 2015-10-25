package bg.tusofia.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for int_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="int_type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="int_8"/>
 *     &lt;enumeration value="int_16"/>
 *     &lt;enumeration value="int_32"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "int_type")
@XmlEnum
public enum IntType implements java.io.Serializable{

    @XmlEnumValue("int_8")
    INT_8("int_8"),
    @XmlEnumValue("int_16")
    INT_16("int_16"),
    @XmlEnumValue("int_32")
    INT_32("int_32");
    private final String value;

    IntType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IntType fromValue(String v) {
        for (IntType c: IntType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
