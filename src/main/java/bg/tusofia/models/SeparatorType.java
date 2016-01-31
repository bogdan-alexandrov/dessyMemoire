package bg.tusofia.models;

import bg.tusofia.tools.CommonTools;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * this type is used for elements denoting strings that separate or finish data elements
 * <p>
 * <p>Java class for separator_type complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="separator_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{}literal"/>
 *         &lt;element ref="{}regexp"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "separator_type", propOrder = {
        "literal",
        "regexp"
})
public class SeparatorType implements java.io.Serializable {

    protected String literal;
    protected String regexp;

    /**
     * Gets the value of the literal property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Sets the value of the literal property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLiteral(String value) {
        this.literal = value;
    }

    /**
     * Gets the value of the regexp property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRegexp() {
        return regexp;
    }

    /**
     * Sets the value of the regexp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRegexp(String value) {
        this.regexp = value;
    }

    public String getPreview() {
        if (getLiteral() != null && !getLiteral().isEmpty()) {
            return "Literal : " + CommonTools.abbreviate(getLiteral(), 10);
        }
        if (getRegexp() != null && !getRegexp().isEmpty()) {
            return "Regexp : " + CommonTools.abbreviate(getRegexp(), 10);
        }
        return null;
    }
}
