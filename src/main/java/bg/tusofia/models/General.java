package bg.tusofia.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="setID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="about">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                   &lt;element name="keywords">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="annotation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="source">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="method" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="instrument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element ref="{}procedure" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="parent" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="pre_procedure" type="{}proc_type"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="parent_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="child" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="post_procedure" type="{}proc_type"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="child_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="version">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="version_no" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="ver_timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="modification_info" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="access_rights">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ownership" type="{}personalData" maxOccurs="unbounded"/>
 *                   &lt;element name="distribution_rights" type="{}personalData" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="read_rights" type="{}personalData" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="contact" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="ContactPerson">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{}personalData">
 *                           &lt;sequence minOccurs="0">
 *                             &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="faxPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="workHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="contInstr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ContactOrganisation">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element ref="{}address"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "setID",
    "about",
    "source",
    "version",
    "accessRights",
    "contact"
})
@XmlRootElement(name = "general")
public class General implements Serializable{

    @XmlElement(required = true)
    protected String setID;
    @XmlElement(required = true)
    protected About about;
    @XmlElement(required = true)
    protected Source source;
    @XmlElement(required = true)
    protected Version version;
    @XmlElement(name = "access_rights", required = true)
    protected AccessRights accessRights;
    protected Contact contact;

    /**
     * Gets the value of the setID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetID() {
        return setID;
    }

    /**
     * Sets the value of the setID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetID(String value) {
        this.setID = value;
    }

    /**
     * Gets the value of the about property.
     * 
     * @return
     *     possible object is
     *     {@link About }
     *     
     */
    public About getAbout() {
        return about;
    }

    /**
     * Sets the value of the about property.
     * 
     * @param value
     *     allowed object is
     *     {@link About }
     *     
     */
    public void setAbout(About value) {
        this.about = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link Source }
     *     
     */
    public Source getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link Source }
     *     
     */
    public void setSource(Source value) {
        this.source = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link Version }
     *     
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Version }
     *     
     */
    public void setVersion(Version value) {
        this.version = value;
    }

    /**
     * Gets the value of the accessRights property.
     * 
     * @return
     *     possible object is
     *     {@link AccessRights }
     *     
     */
    public AccessRights getAccessRights() {
        return accessRights;
    }

    /**
     * Sets the value of the accessRights property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessRights }
     *     
     */
    public void setAccessRights(AccessRights value) {
        this.accessRights = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setContact(Contact value) {
        this.contact = value;
    }


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
     *         &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *         &lt;element name="keywords">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="annotation" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "domain",
        "keywords",
        "annotation"
    })
    public static class About implements Serializable {

        @XmlElement(required = true)
        protected List<String> domain;
        @XmlElement(required = true)
        protected Keywords keywords;
        @XmlElement(required = true)
        protected String annotation;

        /**
         * Gets the value of the domain property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the domain property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDomain().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDomain() {
            if (domain == null) {
                domain = new ArrayList<String>();
            }
            return this.domain;
        }

        /**
         * Gets the value of the keywords property.
         * 
         * @return
         *     possible object is
         *     {@link Keywords }
         *     
         */
        public Keywords getKeywords() {
            return keywords;
        }

        /**
         * Sets the value of the keywords property.
         * 
         * @param value
         *     allowed object is
         *     {@link Keywords }
         *     
         */
        public void setKeywords(Keywords value) {
            this.keywords = value;
        }

        /**
         * Gets the value of the annotation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAnnotation() {
            return annotation;
        }

        /**
         * Sets the value of the annotation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAnnotation(String value) {
            this.annotation = value;
        }


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
         *         &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
            "keyword"
        })
        public static class Keywords implements Serializable{

            @XmlElement(required = true)
            protected List<String> keyword;

            /**
             * Gets the value of the keyword property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the keyword property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getKeyword().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getKeyword() {
                if (keyword == null) {
                    keyword = new ArrayList<String>();
                }
                return this.keyword;
            }

        }

    }


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
     *         &lt;element name="ownership" type="{}personalData" maxOccurs="unbounded"/>
     *         &lt;element name="distribution_rights" type="{}personalData" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="read_rights" type="{}personalData" maxOccurs="unbounded" minOccurs="0"/>
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
        "ownership",
        "distributionRights",
        "readRights"
    })
    public static class AccessRights implements Serializable {

        @XmlElement(required = true)
        protected List<PersonalData> ownership;
        @XmlElement(name = "distribution_rights")
        protected List<PersonalData> distributionRights;
        @XmlElement(name = "read_rights")
        protected List<PersonalData> readRights;

        /**
         * Gets the value of the ownership property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ownership property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOwnership().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PersonalData }
         * 
         * 
         */
        public List<PersonalData> getOwnership() {
            if (ownership == null) {
                ownership = new ArrayList<PersonalData>();
            }
            return this.ownership;
        }

        /**
         * Gets the value of the distributionRights property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the distributionRights property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDistributionRights().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PersonalData }
         * 
         * 
         */
        public List<PersonalData> getDistributionRights() {
            if (distributionRights == null) {
                distributionRights = new ArrayList<PersonalData>();
            }
            return this.distributionRights;
        }

        /**
         * Gets the value of the readRights property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the readRights property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReadRights().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PersonalData }
         * 
         * 
         */
        public List<PersonalData> getReadRights() {
            if (readRights == null) {
                readRights = new ArrayList<PersonalData>();
            }
            return this.readRights;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="ContactPerson">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{}personalData">
     *                 &lt;sequence minOccurs="0">
     *                   &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="faxPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="workHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="contInstr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ContactOrganisation">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element ref="{}address"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "contactPersonOrContactOrganisation"
    })
    public static class Contact implements Serializable{

        @XmlElements({
            @XmlElement(name = "ContactPerson", type = ContactPerson.class),
            @XmlElement(name = "ContactOrganisation", type = ContactOrganisation.class)
        })
        protected List<Object> contactPersonOrContactOrganisation;

        /**
         * Gets the value of the contactPersonOrContactOrganisation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contactPersonOrContactOrganisation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContactPersonOrContactOrganisation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ContactPerson }
         * {@link ContactOrganisation }
         * 
         * 
         */
        public List<Object> getContactPersonOrContactOrganisation() {
            if (contactPersonOrContactOrganisation == null) {
                contactPersonOrContactOrganisation = new ArrayList<Object>();
            }
            return this.contactPersonOrContactOrganisation;
        }


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
         *         &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element ref="{}address"/>
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
            "orgName",
            "country",
            "city",
            "postcode",
            "address"
        })
        public static class ContactOrganisation extends PersonalData {

            @XmlElement(required = true)
            protected String orgName;
            @XmlElement(required = true)
            protected String country;
            @XmlElement(required = true)
            protected String city;
            @XmlElement(required = true)
            protected String postcode;
            @XmlElement(required = true)
            protected String address;

            /**
             * Gets the value of the orgName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOrgName() {
                return orgName;
            }

            /**
             * Sets the value of the orgName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOrgName(String value) {
                this.orgName = value;
            }

            /**
             * Gets the value of the country property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountry() {
                return country;
            }

            /**
             * Sets the value of the country property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountry(String value) {
                this.country = value;
            }

            /**
             * Gets the value of the city property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCity() {
                return city;
            }

            /**
             * Sets the value of the city property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCity(String value) {
                this.city = value;
            }

            /**
             * Gets the value of the postcode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPostcode() {
                return postcode;
            }

            /**
             * Sets the value of the postcode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPostcode(String value) {
                this.postcode = value;
            }

            /**
             * Gets the value of the address property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress() {
                return address;
            }

            /**
             * Sets the value of the address property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress(String value) {
                this.address = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{}personalData">
         *       &lt;sequence minOccurs="0">
         *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="faxPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="workHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="contInstr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "position",
            "faxPhone",
            "workHours",
            "contInstr"
        })
        public static class ContactPerson
            extends PersonalData
        {

            protected String position;
            protected String faxPhone;
            protected String workHours;
            protected String contInstr;

            /**
             * Gets the value of the position property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPosition() {
                return position;
            }

            /**
             * Sets the value of the position property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPosition(String value) {
                this.position = value;
            }

            /**
             * Gets the value of the faxPhone property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFaxPhone() {
                return faxPhone;
            }

            /**
             * Sets the value of the faxPhone property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFaxPhone(String value) {
                this.faxPhone = value;
            }

            /**
             * Gets the value of the workHours property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWorkHours() {
                return workHours;
            }

            /**
             * Sets the value of the workHours property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWorkHours(String value) {
                this.workHours = value;
            }

            /**
             * Gets the value of the contInstr property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContInstr() {
                return contInstr;
            }

            /**
             * Sets the value of the contInstr property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContInstr(String value) {
                this.contInstr = value;
            }

        }

    }


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
     *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="method" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="instrument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element ref="{}procedure" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="parent" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="pre_procedure" type="{}proc_type"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="parent_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="child" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="post_procedure" type="{}proc_type"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="child_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "timestamp",
        "method",
        "parent",
        "child"
    })
    public static class Source implements Serializable {

        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar timestamp;
        protected Method method;
        protected Parent parent;
        protected List<Child> child;

        /**
         * Gets the value of the timestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTimestamp() {
            return timestamp;
        }

        /**
         * Sets the value of the timestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTimestamp(XMLGregorianCalendar value) {
            this.timestamp = value;
        }

        /**
         * Gets the value of the method property.
         * 
         * @return
         *     possible object is
         *     {@link Method }
         *     
         */
        public Method getMethod() {
            return method;
        }

        /**
         * Sets the value of the method property.
         * 
         * @param value
         *     allowed object is
         *     {@link Method }
         *     
         */
        public void setMethod(Method value) {
            this.method = value;
        }

        /**
         * Gets the value of the parent property.
         * 
         * @return
         *     possible object is
         *     {@link Parent }
         *     
         */
        public Parent getParent() {
            return parent;
        }

        /**
         * Sets the value of the parent property.
         * 
         * @param value
         *     allowed object is
         *     {@link Parent }
         *     
         */
        public void setParent(Parent value) {
            this.parent = value;
        }

        /**
         * Gets the value of the child property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the child property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getChild().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Child }
         * 
         * 
         */
        public List<Child> getChild() {
            if (child == null) {
                child = new ArrayList<Child>();
            }
            return this.child;
        }


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
         *         &lt;element name="post_procedure" type="{}proc_type"/>
         *       &lt;/sequence>
         *       &lt;attribute name="child_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "postProcedure"
        })
        public static class Child implements Serializable {

            @XmlElement(name = "post_procedure", required = true)
            protected ProcType postProcedure;
            @XmlAttribute(name = "child_name", required = true)
            @XmlSchemaType(name = "anyURI")
            protected String childName;

            /**
             * Gets the value of the postProcedure property.
             * 
             * @return
             *     possible object is
             *     {@link ProcType }
             *     
             */
            public ProcType getPostProcedure() {
                return postProcedure;
            }

            /**
             * Sets the value of the postProcedure property.
             * 
             * @param value
             *     allowed object is
             *     {@link ProcType }
             *     
             */
            public void setPostProcedure(ProcType value) {
                this.postProcedure = value;
            }

            /**
             * Gets the value of the childName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getChildName() {
                return childName;
            }

            /**
             * Sets the value of the childName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setChildName(String value) {
                this.childName = value;
            }

        }


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
         *         &lt;element name="instrument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element ref="{}procedure" maxOccurs="unbounded" minOccurs="0"/>
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
            "instrument",
            "procedure"
        })
        public static class Method implements Serializable {

            protected String instrument;
            protected List<ProcType> procedure;

            /**
             * Gets the value of the instrument property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInstrument() {
                return instrument;
            }

            /**
             * Sets the value of the instrument property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInstrument(String value) {
                this.instrument = value;
            }

            /**
             * The procedure(s) used to process the data obtained by the instrument Gets the value of the procedure property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the procedure property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getProcedure().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ProcType }
             * 
             * 
             */
            public List<ProcType> getProcedure() {
                if (procedure == null) {
                    procedure = new ArrayList<ProcType>();
                }
                return this.procedure;
            }

        }


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
         *         &lt;element name="pre_procedure" type="{}proc_type"/>
         *       &lt;/sequence>
         *       &lt;attribute name="parent_name" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "preProcedure"
        })
        public static class Parent implements Serializable {

            @XmlElement(name = "pre_procedure", required = true)
            protected ProcType preProcedure;
            @XmlAttribute(name = "parent_name", required = true)
            @XmlSchemaType(name = "anyURI")
            protected String parentName;

            /**
             * Gets the value of the preProcedure property.
             * 
             * @return
             *     possible object is
             *     {@link ProcType }
             *     
             */
            public ProcType getPreProcedure() {
                return preProcedure;
            }

            /**
             * Sets the value of the preProcedure property.
             * 
             * @param value
             *     allowed object is
             *     {@link ProcType }
             *     
             */
            public void setPreProcedure(ProcType value) {
                this.preProcedure = value;
            }

            /**
             * Gets the value of the parentName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getParentName() {
                return parentName;
            }

            /**
             * Sets the value of the parentName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setParentName(String value) {
                this.parentName = value;
            }

        }

    }


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
     *         &lt;element name="version_no" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="ver_timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="modification_info" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "versionNo",
        "verTimestamp",
        "modificationInfo"
    })
    public static class Version implements Serializable {

        @XmlElement(name = "version_no", required = true)
        protected BigDecimal versionNo;
        @XmlElement(name = "ver_timestamp", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar verTimestamp;
        @XmlElement(name = "modification_info")
        protected String modificationInfo;

        /**
         * Gets the value of the versionNo property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getVersionNo() {
            return versionNo;
        }

        /**
         * Sets the value of the versionNo property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setVersionNo(BigDecimal value) {
            this.versionNo = value;
        }

        /**
         * Gets the value of the verTimestamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getVerTimestamp() {
            return verTimestamp;
        }

        /**
         * Sets the value of the verTimestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setVerTimestamp(XMLGregorianCalendar value) {
            this.verTimestamp = value;
        }

        /**
         * Gets the value of the modificationInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModificationInfo() {
            return modificationInfo;
        }

        /**
         * Sets the value of the modificationInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModificationInfo(String value) {
            this.modificationInfo = value;
        }

    }

}
