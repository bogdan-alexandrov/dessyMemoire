package bg.tusofia.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element ref="{}item"/>
 *         &lt;element ref="{}separator" minOccurs="0"/>
 *         &lt;element ref="{}end_criteria" minOccurs="0"/>
 *         &lt;element ref="{}index" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "item",
    "separator",
    "endCriteria",
    "index"
})
@XmlRootElement(name = "array")
public class Array implements java.io.Serializable {

    @XmlElement(required = true)
    protected ArrayList<Item> item;
    protected SeparatorType separator;
    @XmlElement(name = "end_criteria")
    protected SeparatorType endCriteria;
    protected Index index;
    @XmlAttribute(name = "length")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String length;

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Array(){}
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }

    /**
     * Gets the value of the separator property.
     * 
     * @return
     *     possible object is
     *     {@link SeparatorType }
     *     
     */
    public SeparatorType getSeparator() {
        return separator;
    }

    /**
     * Sets the value of the separator property.
     * 
     * @param value
     *     allowed object is
     *     {@link SeparatorType }
     *     
     */
    public void setSeparator(SeparatorType value) {
        this.separator = value;
    }

    /**
     * Gets the value of the endCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link SeparatorType }
     *     
     */
    public SeparatorType getEndCriteria() {
        return endCriteria;
    }

    /**
     * Sets the value of the endCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link SeparatorType }
     *     
     */
    public void setEndCriteria(SeparatorType value) {
        this.endCriteria = value;
    }

    /**
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link Index }
     *     
     */
    public Index getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link Index }
     *     
     */
    public void setIndex(Index value) {
        this.index = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLength(String value) {
        this.length = value;
    }

}
