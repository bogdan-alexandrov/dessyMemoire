package bg.tusofia.models;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}ID" minOccurs="0"/>
 *         &lt;element ref="{}end" minOccurs="0"/>
 *         &lt;element ref="{}semantics_ref" minOccurs="0"/>
 *         &lt;element ref="{}constraints" minOccurs="0"/>
 *         &lt;element ref="{}description" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}typegroup"/>
 *       &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="num_system" default="decimal">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="roman"/>
 *             &lt;enumeration value="decimal"/>
 *             &lt;enumeration value="binary"/>
 *             &lt;enumeration value="octal"/>
 *             &lt;enumeration value="hexadecimal"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "end",
    "semanticsRef",
    "constraints",
    "description",
    "value"
})
@XmlRootElement(name = "simple_item")
public class SimpleItem implements java.io.Serializable{

    @XmlElement(name = "ID")
    protected ID id;
    protected SeparatorType end;
    @XmlElement(name = "semantics_ref")
    protected SemanticsRef semanticsRef;
    protected Constraints constraints;
    protected Description description;
    protected String value;
    @XmlAttribute(name = "unit")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String unit;
    @XmlAttribute(name = "length")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger length;
    @XmlAttribute(name = "format")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String format;
    @XmlAttribute(name = "num_system")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String numSystem;
    @XmlAttribute(name = "type")
    protected Predefined type;
    @XmlAttribute(name = "type_ref")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String typeRef;

    public SimpleItem(){}
    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link ID }
     *     
     */
    public ID getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link ID }
     *     
     */
    public void setID(ID value) {
        this.id = value;
    }

    /**
     * How ends the item
     * 
     * @return
     *     possible object is
     *     {@link SeparatorType }
     *     
     */
    public SeparatorType getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link SeparatorType }
     *     
     */
    public void setEnd(SeparatorType value) {
        this.end = value;
    }

    /**
     * Gets the value of the semanticsRef property.
     * 
     * @return
     *     possible object is
     *     {@link SemanticsRef }
     *     
     */
    public SemanticsRef getSemanticsRef() {
        return semanticsRef;
    }

    /**
     * Sets the value of the semanticsRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link SemanticsRef }
     *     
     */
    public void setSemanticsRef(SemanticsRef value) {
        this.semanticsRef = value;
    }

    /**
     * Gets the value of the constraints property.
     * 
     * @return
     *     possible object is
     *     {@link Constraints }
     *     
     */
    public Constraints getConstraints() {
        return constraints;
    }

    /**
     * Sets the value of the constraints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Constraints }
     *     
     */
    public void setConstraints(Constraints value) {
        this.constraints = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link Description }
     *     
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link Description }
     *     
     */
    public void setDescription(Description value) {
        this.description = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLength(BigInteger value) {
        this.length = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the numSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSystem() {
        if (numSystem == null) {
            return "decimal";
        } else {
            return numSystem;
        }
    }

    /**
     * Sets the value of the numSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSystem(String value) {
        this.numSystem = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Predefined }
     *     
     */
    public Predefined getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Predefined }
     *     
     */
    public void setType(Predefined value) {
        this.type = value;
    }

    /**
     * Gets the value of the typeRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeRef() {
        return typeRef;
    }

    /**
     * Sets the value of the typeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeRef(String value) {
        this.typeRef = value;
    }
    
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the typeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }
}
