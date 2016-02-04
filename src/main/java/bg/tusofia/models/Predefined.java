package bg.tusofia.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for predefined.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="predefined">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="int_8"/>
 *     &lt;enumeration value="int_16"/>
 *     &lt;enumeration value="int_32"/>
 *     &lt;enumeration value="uint_8"/>
 *     &lt;enumeration value="uint_16"/>
 *     &lt;enumeration value="uint_32"/>
 *     &lt;enumeration value="uint_64"/>
 *     &lt;enumeration value="float_32"/>
 *     &lt;enumeration value="float_64"/>
 *     &lt;enumeration value="string"/>
 *     &lt;enumeration value="enumerated"/>
 *     &lt;enumeration value="date_ref"/>
 *     &lt;enumeration value="time_ref"/>
 *     &lt;enumeration value="timestamp"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "predefined")
@XmlEnum
public enum Predefined implements java.io.Serializable{

    @XmlEnumValue("int_8")
    INT_8("int_8"),
    @XmlEnumValue("int_16")
    INT_16("int_16"),
    @XmlEnumValue("int_32")
    INT_32("int_32"),
    @XmlEnumValue("uint_8")
    UINT_8("uint_8"),
    @XmlEnumValue("uint_16")
    UINT_16("uint_16"),
    @XmlEnumValue("uint_32")
    UINT_32("uint_32"),
    @XmlEnumValue("uint_64")
    UINT_64("uint_64"),
    @XmlEnumValue("float_32")
    FLOAT_32("float_32"),
    @XmlEnumValue("float_64")
    FLOAT_64("float_64"),
    @XmlEnumValue("string")
    STRING("string"),
    @XmlEnumValue("enumerated")
    ENUMERATED("enumerated"),
    @XmlEnumValue("date_ref")
    DATE_REF("date_ref"),
    @XmlEnumValue("time_ref")
    TIME_REF("time_ref"),
    @XmlEnumValue("timestamp")
    TIMESTAMP("timestamp");
    private final String value;

    Predefined(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Predefined fromValue(String v) {
        for (Predefined c: Predefined.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public static List<String> valuesAsString(){
        List<String> result = new ArrayList<>();
        for(Predefined predefined : values()){
            result.add(predefined.value);
        }
        return result;
    }

}
