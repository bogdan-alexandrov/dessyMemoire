package bg.tusofia.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Type for personal data description
 * 
 * <p>Java class for personalData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personalData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Name"/>
 *         &lt;element ref="{}persAddress"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personalData", propOrder = {
    "name",
    "persAddress"
})
@XmlSeeAlso({
    bg.tusofia.models.General.Contact.ContactPerson.class
})
public class PersonalData implements java.io.Serializable{

    @XmlElement(name = "Name", required = true)
    protected Name name;
    @XmlElement(required = true)
    protected PersAddress persAddress;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setName(Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the persAddress property.
     * 
     * @return
     *     possible object is
     *     {@link PersAddress }
     *     
     */
    public PersAddress getPersAddress() {
        return persAddress;
    }

    /**
     * Sets the value of the persAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersAddress }
     *     
     */
    public void setPersAddress(PersAddress value) {
        this.persAddress = value;
    }

}
