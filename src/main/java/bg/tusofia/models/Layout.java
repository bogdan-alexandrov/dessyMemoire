package bg.tusofia.models;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}typedef" maxOccurs="unbounded"/>
 *         &lt;element ref="{}cluster" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="coding" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="ASCII"/>
 *             &lt;enumeration value="Unicode"/>
 *             &lt;enumeration value="EBCDIC"/>
 *             &lt;enumeration value="Binary"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="byte_order" default="Littlelendian">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *             &lt;enumeration value="Bigendian"/>
 *             &lt;enumeration value="Littlelendian"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="byte_size" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="8" />
 *       &lt;attribute name="float_32_mantissa" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="float_64_mantissa" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="float_32_exponent" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="float_64_exponent" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "typedef",
    "cluster"
})
@XmlRootElement(name = "layout")
public class Layout implements java.io.Serializable{

    @XmlElement(required = true)
    protected List<Typedef> typedef;
    @XmlElement(required = true)
    protected List<Cluster> cluster;
    @XmlAttribute(name = "coding", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String coding;
    @XmlAttribute(name = "byte_order")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String byteOrder;
    @XmlAttribute(name = "byte_size")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger byteSize;
    @XmlAttribute(name = "float_32_mantissa")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger float32Mantissa;
    @XmlAttribute(name = "float_64_mantissa")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger float64Mantissa;
    @XmlAttribute(name = "float_32_exponent")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger float32Exponent;
    @XmlAttribute(name = "float_64_exponent")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger float64Exponent;

    /**
     * Type definition of complex object in the layout description Gets the value of the typedef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typedef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypedef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Typedef }
     * 
     * 
     */
    public List<Typedef> getTypedef() {
        if (typedef == null) {
            typedef = new ArrayList<Typedef>();
        }
        return this.typedef;
    }

    /**
     * Gets the value of the cluster property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cluster property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCluster().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cluster }
     * 
     * 
     */
    public List<Cluster> getCluster() {
        if (cluster == null) {
            cluster = new ArrayList<Cluster>();
        }
        return this.cluster;
    }

    /**
     * Gets the value of the coding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoding() {
        return coding;
    }

    /**
     * Sets the value of the coding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoding(String value) {
        this.coding = value;
    }

    /**
     * Gets the value of the byteOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getByteOrder() {
        if (byteOrder == null) {
            return "Littlelendian";
        } else {
            return byteOrder;
        }
    }

    /**
     * Sets the value of the byteOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setByteOrder(String value) {
        this.byteOrder = value;
    }

    /**
     * Gets the value of the byteSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getByteSize() {
        if (byteSize == null) {
            return new BigInteger("8");
        } else {
            return byteSize;
        }
    }

    /**
     * Sets the value of the byteSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setByteSize(BigInteger value) {
        this.byteSize = value;
    }

    /**
     * Gets the value of the float32Mantissa property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFloat32Mantissa() {
        return float32Mantissa;
    }

    /**
     * Sets the value of the float32Mantissa property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFloat32Mantissa(BigInteger value) {
        this.float32Mantissa = value;
    }

    /**
     * Gets the value of the float64Mantissa property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFloat64Mantissa() {
        return float64Mantissa;
    }

    /**
     * Sets the value of the float64Mantissa property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFloat64Mantissa(BigInteger value) {
        this.float64Mantissa = value;
    }

    /**
     * Gets the value of the float32Exponent property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFloat32Exponent() {
        return float32Exponent;
    }

    /**
     * Sets the value of the float32Exponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFloat32Exponent(BigInteger value) {
        this.float32Exponent = value;
    }

    /**
     * Gets the value of the float64Exponent property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFloat64Exponent() {
        return float64Exponent;
    }

    /**
     * Sets the value of the float64Exponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFloat64Exponent(BigInteger value) {
        this.float64Exponent = value;
    }

}
