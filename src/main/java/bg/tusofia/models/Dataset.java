package bg.tusofia.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}general"/>
 *         &lt;element ref="{}semantics"/>
 *         &lt;element ref="{}layout"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "general",
    "semantics",
    "layout"
})
@XmlRootElement(name = "dataset")
public class Dataset implements java.io.Serializable{

    @XmlElement(required = true)
    protected General general;
    @XmlElement(required = true)
    protected Semantics semantics;
    @XmlElement(required = true)
    protected Layout layout;

    /**
     * Section for describing the general data about the data set as its annotation owner rights etc.
     * 
     * @return
     *     possible object is
     *     {@link General }
     *     
     */
    public General getGeneral() {
        return general;
    }

    /**
     * Sets the value of the general property.
     * 
     * @param value
     *     allowed object is
     *     {@link General }
     *     
     */
    public void setGeneral(General value) {
        this.general = value;
    }

    /**
     * Section describing the semantics ofeach  the data item
     * 
     * @return
     *     possible object is
     *     {@link Semantics }
     *     
     */
    public Semantics getSemantics() {
        return semantics;
    }

    /**
     * Sets the value of the semantics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Semantics }
     *     
     */
    public void setSemantics(Semantics value) {
        this.semantics = value;
    }

    /**
     * sectin describing the phisical layout of the data in the file(s)
     * 
     * @return
     *     possible object is
     *     {@link Layout }
     *     
     */
    public Layout getLayout() {
        return layout;
    }

    /**
     * Sets the value of the layout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Layout }
     *     
     */
    public void setLayout(Layout value) {
        this.layout = value;
    }

}
