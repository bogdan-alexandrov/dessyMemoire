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
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}ID" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{}simple_item"/>
 *           &lt;element ref="{}array"/>
 *           &lt;element ref="{}structure"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" default="simple">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="simple"/>
 *             &lt;enumeration value="structured"/>
 *             &lt;enumeration value="array"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "simpleItem",
        "array",
        "structure",
        "itemChild"
})
@XmlRootElement(name = "item")
public class Item implements java.io.Serializable, Cloneable {

    @XmlElement(name = "ID")
    protected ID id;
    @XmlElement(name = "simple_item")
    protected SimpleItem simpleItem;
    protected Array array;
    protected ArrayList<Item> itemChild;
    protected Structure structure;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;

    public Item() {

    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Item(Item another) {
        this.id = another.id;
        this.simpleItem = another.simpleItem;
        this.array = another.array;
        this.itemChild = another.itemChild;
        this.structure = another.structure;
        this.name = another.name;
        this.type = another.type;
    }


    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link ID }
     */
    public ID getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link ID }
     */
    public void setID(ID value) {
        this.id = value;
    }

    /**
     * Gets the value of the simpleItem property.
     *
     * @return possible object is
     * {@link SimpleItem }
     */
    public SimpleItem getSimpleItem() {
        return simpleItem;
    }

    /**
     * Sets the value of the simpleItem property.
     *
     * @param value allowed object is
     *              {@link SimpleItem }
     */
    public void setSimpleItem(SimpleItem value) {
        this.simpleItem = value;
    }

    public List<Item> getItemChild() {
        if (itemChild == null) {
            itemChild = new ArrayList<Item>();
        }
        return this.itemChild;
    }

    /**
     * Gets the value of the array property.
     *
     * @return possible object is
     * {@link Array }
     */
    public Array getArray() {
        return array;
    }

    /**
     * Sets the value of the array property.
     *
     * @param value allowed object is
     *              {@link Array }
     */
    public void setArray(Array value) {
        this.array = value;
    }

    /**
     * Gets the value of the structure property.
     *
     * @return possible object is
     * {@link Structure }
     */
    public Structure getStructure() {
        return structure;
    }

    /**
     * Sets the value of the structure property.
     *
     * @param value allowed object is
     *              {@link Structure }
     */
    public void setStructure(Structure value) {
        this.structure = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getType() {
        if (type == null) {
            return "simple";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    public String preview() {
        if (getStructure() != null) {
            return "-> structure";
        }
        if (getArray() != null) {
            return "-> array";
        }
        if (getSimpleItem() != null) {
            return "-> simple item";
        }
        return "No Type";
    }

}
