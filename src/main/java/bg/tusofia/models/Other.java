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
 *         &lt;element ref="{}idd" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{}simple_cont"/>
 *           &lt;element ref="{}vector"/>
 *         &lt;/choice>
 *         &lt;element ref="{}layout_ref" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}description" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idd",
    "simpleCont",
    "vector",
    "layoutRef",
    "description"
})
@XmlRootElement(name = "other")
public class Other implements java.io.Serializable{

    protected Idd idd;
    @XmlElement(name = "simple_cont")
    protected SimpleCont simpleCont;
    protected Vector vector;
    @XmlElement(name = "layout_ref")
    protected List<LayoutRef> layoutRef;
    protected Description description;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String name;

    /**
     * Gets the value of the idd property.
     * 
     * @return
     *     possible object is
     *     {@link Idd }
     *     
     */
    public Idd getIdd() {
        return idd;
    }

    /**
     * Sets the value of the idd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Idd }
     *     
     */
    public void setIdd(Idd value) {
        this.idd = value;
    }

    /**
     * Gets the value of the simpleCont property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleCont }
     *     
     */
    public SimpleCont getSimpleCont() {
        return simpleCont;
    }

    /**
     * Sets the value of the simpleCont property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleCont }
     *     
     */
    public void setSimpleCont(SimpleCont value) {
        this.simpleCont = value;
    }

    /**
     * Gets the value of the vector property.
     * 
     * @return
     *     possible object is
     *     {@link Vector }
     *     
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * Sets the value of the vector property.
     * 
     * @param value
     *     allowed object is
     *     {@link Vector }
     *     
     */
    public void setVector(Vector value) {
        this.vector = value;
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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
