package bg.tusofia.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
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
 *         &lt;element ref="{}idd"/>
 *         &lt;choice>
 *           &lt;element ref="{}vertex" maxOccurs="unbounded"/>
 *           &lt;element ref="{}edge" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *         &lt;element ref="{}description" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="surf-type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="triangle"/>
 *             &lt;enumeration value="quadrilateral"/>
 *             &lt;enumeration value="polygon"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="descr_type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="vertexes"/>
 *             &lt;enumeration value="edges"/>
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
    "idd",
    "vertex",
    "edge",
    "description"
})
@XmlRootElement(name = "surface")
public class Surface implements java.io.Serializable{

    @XmlElement(required = true)
    protected Idd idd;
    protected List<Vertex> vertex;
    protected List<Edge> edge;
    protected Description description;
    @XmlAttribute(name = "surf-type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String surfType;
    @XmlAttribute(name = "descr_type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String descrType;

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
     * Gets the value of the vertex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vertex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVertex().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Vertex }
     * 
     * 
     */
    public List<Vertex> getVertex() {
        if (vertex == null) {
            vertex = new ArrayList<Vertex>();
        }
        return this.vertex;
    }

    /**
     * Gets the value of the edge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the edge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Edge }
     * 
     * 
     */
    public List<Edge> getEdge() {
        if (edge == null) {
            edge = new ArrayList<Edge>();
        }
        return this.edge;
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
     * Gets the value of the surfType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurfType() {
        return surfType;
    }

    /**
     * Sets the value of the surfType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurfType(String value) {
        this.surfType = value;
    }

    /**
     * Gets the value of the descrType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrType() {
        return descrType;
    }

    /**
     * Sets the value of the descrType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrType(String value) {
        this.descrType = value;
    }

}
