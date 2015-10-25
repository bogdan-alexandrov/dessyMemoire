package bg.tusofia.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element ref="{}component" maxOccurs="unbounded"/>
 *         &lt;element ref="{}layout_ref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}description" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dimension" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="coord_system">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *             &lt;enumeration value="cartesian"/>
 *             &lt;enumeration value="cylindrical"/>
 *             &lt;enumeration value="spherical"/>
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
    "component",
    "layoutRef",
    "description"
})
@XmlRootElement(name = "vector")
public class Vector implements java.io.Serializable{

    @XmlElement(required = true)
    protected List<Component> component;
    @XmlElement(name = "layout_ref")
    protected List<LayoutRef> layoutRef;
    protected Description description;
    @XmlAttribute(name = "dimension")
    protected Byte dimension;
    @XmlAttribute(name = "coord_system")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String coordSystem;

    /**
     * Gets the value of the component property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the component property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Component }
     * 
     * 
     */
    public List<Component> getComponent() {
        if (component == null) {
            component = new ArrayList<Component>();
        }
        return this.component;
    }

    /**
     * Gets the value of the layoutRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the layoutRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLayoutRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LayoutRef }
     * 
     * 
     */
    public List<LayoutRef> getLayoutRef() {
        if (layoutRef == null) {
            layoutRef = new ArrayList<LayoutRef>();
        }
        return this.layoutRef;
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
     * Gets the value of the dimension property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getDimension() {
        return dimension;
    }

    /**
     * Sets the value of the dimension property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setDimension(Byte value) {
        this.dimension = value;
    }

    /**
     * Gets the value of the coordSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordSystem() {
        return coordSystem;
    }

    /**
     * Sets the value of the coordSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordSystem(String value) {
        this.coordSystem = value;
    }

}
