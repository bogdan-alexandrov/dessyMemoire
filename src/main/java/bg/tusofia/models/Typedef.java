package bg.tusofia.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;choice>
 *           &lt;element ref="{}structure"/>
 *           &lt;element ref="{}simple_item"/>
 *           &lt;element ref="{}array"/>
 *           &lt;element ref="{}literal"/>
 *         &lt;/choice>
 *         &lt;element ref="{}description" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="typename" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "structure",
    "simpleItem",
    "array",
    "literal",
    "description"
})
@XmlRootElement(name = "typedef")
public class Typedef implements java.io.Serializable{

    protected Structure structure;
    @XmlElement(name = "simple_item")
    protected SimpleItem simpleItem;
    protected Array array;
    protected String literal;
    protected Description description;
    @XmlAttribute(name = "typename", required = true)
    protected String typename;

    /**
     * Gets the value of the structure property.
     * 
     * @return
     *     possible object is
     *     {@link Structure }
     *     
     */
    public Structure getStructure() {
        return structure;
    }

    /**
     * Sets the value of the structure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Structure }
     *     
     */
    public void setStructure(Structure value) {
        this.structure = value;
    }

    /**
     * Gets the value of the simpleItem property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleItem }
     *     
     */
    public SimpleItem getSimpleItem() {
        return simpleItem;
    }

    /**
     * Sets the value of the simpleItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleItem }
     *     
     */
    public void setSimpleItem(SimpleItem value) {
        this.simpleItem = value;
    }

    /**
     * Structure containing items  of  the same type
     * 
     * @return
     *     possible object is
     *     {@link Array }
     *     
     */
    public Array getArray() {
        return array;
    }

    /**
     * Sets the value of the array property.
     * 
     * @param value
     *     allowed object is
     *     {@link Array }
     *     
     */
    public void setArray(Array value) {
        this.array = value;
    }

    /**
     * Gets the value of the literal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Sets the value of the literal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiteral(String value) {
        this.literal = value;
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
     * Gets the value of the typename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypename() {
        return typename;
    }

    /**
     * Sets the value of the typename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypename(String value) {
        this.typename = value;
    }

}
