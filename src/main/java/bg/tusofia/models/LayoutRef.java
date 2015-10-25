package bg.tusofia.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{}OO_style"/>
 *           &lt;element ref="{}xQuerystyle"/>
 *         &lt;/choice>
 *         &lt;element ref="{}calculate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}description" minOccurs="0"/>
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
    "ooStyleOrXQuerystyleAndCalculate"
})
@XmlRootElement(name = "layout_ref")
public class LayoutRef implements java.io.Serializable{

    @XmlElements({
        @XmlElement(name = "OO_style", type = OOStyle.class),
        @XmlElement(name = "xQuerystyle", type = XQuerystyle.class),
        @XmlElement(name = "calculate", type = Calculate.class),
        @XmlElement(name = "description", type = Description.class)
    })
    protected List<Object> ooStyleOrXQuerystyleAndCalculate;

    /**
     * Gets the value of the ooStyleOrXQuerystyleAndCalculate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ooStyleOrXQuerystyleAndCalculate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOOStyleOrXQuerystyleAndCalculate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OOStyle }
     * {@link XQuerystyle }
     * {@link Calculate }
     * {@link Description }
     * 
     * 
     */
    public List<Object> getOOStyleOrXQuerystyleAndCalculate() {
        if (ooStyleOrXQuerystyleAndCalculate == null) {
            ooStyleOrXQuerystyleAndCalculate = new ArrayList<Object>();
        }
        return this.ooStyleOrXQuerystyleAndCalculate;
    }

}
