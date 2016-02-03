package bg.tusofia.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{}literal"/>
 *         &lt;element ref="{}regexp"/>
 *         &lt;element ref="{}item"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "literal",
        "regexp",
        "item"
})
@XmlRootElement(name = "structure")
public class Structure implements java.io.Serializable {

    protected ArrayList<String> literal;
    protected String regexp;
    protected ArrayList<Item> item;

    /**
     * Gets the value of the literal property.
     *
     * @return possible object is
     * {@link String }
     */
    public List<String> getLiteral() {
        if (literal == null) {
            literal = new ArrayList<String>();
        }
        return this.literal;
    }

    /**
     * regular expression (Java syntax)
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

    /**
     * Gets the value of the item property.
     *
     * @return possible object is
     * {@link Item }
     */
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }

    public String getPreview() {
        String res;
        int previewChars = 15;
        if (getItem() != null && !getItem().isEmpty()) {
            res = "Item : ";
            res += getPreviewDescription(getItem().get(0).getName(), previewChars);
        } else if (getLiteral() != null && !getLiteral().isEmpty()) {
            res = "Literal : ";
            res += getPreviewDescription(getLiteral().get(0), previewChars);
        } else if (getRegexp() != null) {
            res = "Regexp : ";
            res += getPreviewDescription(getRegexp(), previewChars);
        } else {
            res = "Empty";
        }
        return res;
    }

    private String getPreviewDescription(String string, int previewLength) {
        if (string.length() > previewLength) {
            return string.substring(0, previewLength) + "...";
        } else {
            return string;
        }
    }
}
