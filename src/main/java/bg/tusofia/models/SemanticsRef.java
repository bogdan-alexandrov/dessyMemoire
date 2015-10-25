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
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{}OO_style"/>
 *         &lt;element ref="{}xQuerystyle"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ooStyleOrXQuerystyle"
})
@XmlRootElement(name = "semantics_ref")
public class SemanticsRef implements java.io.Serializable{

    @XmlElements({
        @XmlElement(name = "OO_style", type = OOStyle.class),
        @XmlElement(name = "xQuerystyle", type = XQuerystyle.class)
    })
    protected List<Object> ooStyleOrXQuerystyle;

    /**
     * Gets the value of the ooStyleOrXQuerystyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ooStyleOrXQuerystyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOOStyleOrXQuerystyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OOStyle }
     * {@link XQuerystyle }
     * 
     * 
     */
    public List<Object> getOOStyleOrXQuerystyle() {
        if (ooStyleOrXQuerystyle == null) {
            ooStyleOrXQuerystyle = new ArrayList<Object>();
        }
        return this.ooStyleOrXQuerystyle;
    }

}
