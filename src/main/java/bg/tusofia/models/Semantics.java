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
 *         &lt;element ref="{}data_parameters" minOccurs="0"/>
 *         &lt;element ref="{}independent"/>
 *         &lt;element ref="{}dependent"/>
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
    "dataParameters",
    "independent",
    "dependent"
})
@XmlRootElement(name = "semantics")
public class Semantics implements java.io.Serializable{

    @XmlElement(name = "data_parameters")
    protected DataParameters dataParameters;
    @XmlElement(required = true)
    protected Independent independent;
    @XmlElement(required = true)
    protected Dependent dependent;

    /**
     * Gets the value of the dataParameters property.
     * 
     * @return
     *     possible object is
     *     {@link DataParameters }
     *     
     */
    public DataParameters getDataParameters() {
        return dataParameters;
    }

    /**
     * Sets the value of the dataParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataParameters }
     *     
     */
    public void setDataParameters(DataParameters value) {
        this.dataParameters = value;
    }

    /**
     * Gets the value of the independent property.
     * 
     * @return
     *     possible object is
     *     {@link Independent }
     *     
     */
    public Independent getIndependent() {
        return independent;
    }

    /**
     * Sets the value of the independent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Independent }
     *     
     */
    public void setIndependent(Independent value) {
        this.independent = value;
    }

    /**
     * Gets the value of the dependent property.
     * 
     * @return
     *     possible object is
     *     {@link Dependent }
     *     
     */
    public Dependent getDependent() {
        return dependent;
    }

    /**
     * Sets the value of the dependent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dependent }
     *     
     */
    public void setDependent(Dependent value) {
        this.dependent = value;
    }

}
