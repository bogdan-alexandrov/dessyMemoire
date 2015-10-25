package bg.tusofia.models;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the objects package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory implements java.io.Serializable{

    private final static QName _EndCriteria_QNAME = new QName("", "end_criteria");
    private final static QName _Address_QNAME = new QName("", "address");
    private final static QName _Keyword_QNAME = new QName("", "keyword");
    private final static QName _Procedure_QNAME = new QName("", "procedure");
    private final static QName _Separator_QNAME = new QName("", "separator");
    private final static QName _Regexp_QNAME = new QName("", "regexp");
    private final static QName _End_QNAME = new QName("", "end");
    private final static QName _Literal_QNAME = new QName("", "literal");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: objects
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createDescription() {
        return new Description();
    }

    /**
     * Create an instance of {@link Independent }
     * 
     */
    public Independent createIndependent() {
        return new Independent();
    }

    /**
     * Create an instance of {@link General }
     * 
     */
    public General createGeneral() {
        return new General();
    }

    /**
     * Create an instance of {@link General.Contact }
     * 
     */
    public General.Contact createGeneralContact() {
        return new General.Contact();
    }

    /**
     * Create an instance of {@link General.Source }
     * 
     */
    public General.Source createGeneralSource() {
        return new General.Source();
    }

    /**
     * Create an instance of {@link General.About }
     * 
     */
    public General.About createGeneralAbout() {
        return new General.About();
    }

    /**
     * Create an instance of {@link Surface }
     * 
     */
    public Surface createSurface() {
        return new Surface();
    }

    /**
     * Create an instance of {@link Idd }
     * 
     */
    public Idd createIdd() {
        return new Idd();
    }

    /**
     * Create an instance of {@link LayoutRef }
     * 
     */
    public LayoutRef createLayoutRef() {
        return new LayoutRef();
    }

    /**
     * Create an instance of {@link OOStyle }
     * 
     */
    public OOStyle createOOStyle() {
        return new OOStyle();
    }

    /**
     * Create an instance of {@link XQuerystyle }
     * 
     */
    public XQuerystyle createXQuerystyle() {
        return new XQuerystyle();
    }

    /**
     * Create an instance of {@link Calculate }
     * 
     */
    public Calculate createCalculate() {
        return new Calculate();
    }

    /**
     * Create an instance of {@link Description.Annot }
     * 
     */
    public Description.Annot createDescriptionAnnot() {
        return new Description.Annot();
    }

    /**
     * Create an instance of {@link Vertex }
     * 
     */
    public Vertex createVertex() {
        return new Vertex();
    }

    /**
     * Create an instance of {@link Constraints }
     * 
     */
    public Constraints createConstraints() {
        return new Constraints();
    }

    /**
     * Create an instance of {@link Boundaries }
     * 
     */
    public Boundaries createBoundaries() {
        return new Boundaries();
    }

    /**
     * Create an instance of {@link Edge }
     * 
     */
    public Edge createEdge() {
        return new Edge();
    }

    /**
     * Create an instance of {@link Component }
     * 
     */
    public Component createComponent() {
        return new Component();
    }

    /**
     * Create an instance of {@link SimpleCont }
     * 
     */
    public SimpleCont createSimpleCont() {
        return new SimpleCont();
    }

    /**
     * Create an instance of {@link Parameter }
     * 
     */
    public Parameter createParameter() {
        return new Parameter();
    }

    /**
     * Create an instance of {@link Vector }
     * 
     */
    public Vector createVector() {
        return new Vector();
    }

    /**
     * Create an instance of {@link Case }
     * 
     */
    public Case createCase() {
        return new Case();
    }

    /**
     * Create an instance of {@link SimpleItem }
     * 
     */
    public SimpleItem createSimpleItem() {
        return new SimpleItem();
    }

    /**
     * Create an instance of {@link ID }
     * 
     */
    public ID createID() {
        return new ID();
    }

    /**
     * Create an instance of {@link SemanticsRef }
     * 
     */
    public SemanticsRef createSemanticsRef() {
        return new SemanticsRef();
    }

    /**
     * Create an instance of {@link SeparatorType }
     * 
     */
    public SeparatorType createSeparatorType() {
        return new SeparatorType();
    }

    /**
     * Create an instance of {@link Other }
     * 
     */
    public Other createOther() {
        return new Other();
    }

    /**
     * Create an instance of {@link Dependent }
     * 
     */
    public Dependent createDependent() {
        return new Dependent();
    }

    /**
     * Create an instance of {@link FieldValue }
     * 
     */
    public FieldValue createFieldValue() {
        return new FieldValue();
    }

    /**
     * Create an instance of {@link Space }
     * 
     */
    public Space createSpace() {
        return new Space();
    }

    /**
     * Create an instance of {@link Point }
     * 
     */
    public Point createPoint() {
        return new Point();
    }

    /**
     * Create an instance of {@link Topology }
     * 
     */
    public Topology createTopology() {
        return new Topology();
    }

    /**
     * Create an instance of {@link Semantics }
     * 
     */
    public Semantics createSemantics() {
        return new Semantics();
    }

    /**
     * Create an instance of {@link DataParameters }
     * 
     */
    public DataParameters createDataParameters() {
        return new DataParameters();
    }

    /**
     * Create an instance of {@link Independent.Time }
     * 
     */
    public Independent.Time createIndependentTime() {
        return new Independent.Time();
    }

    /**
     * Create an instance of {@link Layout }
     * 
     */
    public Layout createLayout() {
        return new Layout();
    }

    /**
     * Create an instance of {@link Typedef }
     * 
     */
    public Typedef createTypedef() {
        return new Typedef();
    }

    /**
     * Create an instance of {@link Structure }
     * 
     */
    public Structure createStructure() {
        return new Structure();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link Array }
     * 
     */
    public Array createArray() {
        return new Array();
    }

    /**
     * Create an instance of {@link Index }
     * 
     */
    public Index createIndex() {
        return new Index();
    }

    /**
     * Create an instance of {@link Cluster }
     * 
     */
    public Cluster createCluster() {
        return new Cluster();
    }

    /**
     * Create an instance of {@link ProcType }
     * 
     */
    public ProcType createProcType() {
        return new ProcType();
    }

    /**
     * Create an instance of {@link General.Version }
     * 
     */
    public General.Version createGeneralVersion() {
        return new General.Version();
    }

    /**
     * Create an instance of {@link General.AccessRights }
     * 
     */
    public General.AccessRights createGeneralAccessRights() {
        return new General.AccessRights();
    }

    /**
     * Create an instance of {@link Name }
     * 
     */
    public Name createName() {
        return new Name();
    }

    /**
     * Create an instance of {@link Dataset }
     * 
     */
    public Dataset createDataset() {
        return new Dataset();
    }

    /**
     * Create an instance of {@link PersAddress }
     * 
     */
    public PersAddress createPersAddress() {
        return new PersAddress();
    }

    /**
     * Create an instance of {@link PersonalData }
     * 
     */
    public PersonalData createPersonalData() {
        return new PersonalData();
    }

    /**
     * Create an instance of {@link General.Contact.ContactPerson }
     * 
     */
    public General.Contact.ContactPerson createGeneralContactContactPerson() {
        return new General.Contact.ContactPerson();
    }

    /**
     * Create an instance of {@link General.Contact.ContactOrganisation }
     * 
     */
    public General.Contact.ContactOrganisation createGeneralContactContactOrganisation() {
        return new General.Contact.ContactOrganisation();
    }

    /**
     * Create an instance of {@link General.Source.Method }
     * 
     */
    public General.Source.Method createGeneralSourceMethod() {
        return new General.Source.Method();
    }

    /**
     * Create an instance of {@link General.Source.Parent }
     * 
     */
    public General.Source.Parent createGeneralSourceParent() {
        return new General.Source.Parent();
    }

    /**
     * Create an instance of {@link General.Source.Child }
     * 
     */
    public General.Source.Child createGeneralSourceChild() {
        return new General.Source.Child();
    }

    /**
     * Create an instance of {@link General.About.Keywords }
     * 
     */
    public General.About.Keywords createGeneralAboutKeywords() {
        return new General.About.Keywords();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeparatorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "end_criteria")
    public JAXBElement<SeparatorType> createEndCriteria(SeparatorType value) {
        return new JAXBElement<SeparatorType>(_EndCriteria_QNAME, SeparatorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "address")
    public JAXBElement<String> createAddress(String value) {
        return new JAXBElement<String>(_Address_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "keyword")
    public JAXBElement<String> createKeyword(String value) {
        return new JAXBElement<String>(_Keyword_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "procedure")
    public JAXBElement<ProcType> createProcedure(ProcType value) {
        return new JAXBElement<ProcType>(_Procedure_QNAME, ProcType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeparatorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "separator")
    public JAXBElement<SeparatorType> createSeparator(SeparatorType value) {
        return new JAXBElement<SeparatorType>(_Separator_QNAME, SeparatorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "regexp")
    public JAXBElement<String> createRegexp(String value) {
        return new JAXBElement<String>(_Regexp_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeparatorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "end")
    public JAXBElement<SeparatorType> createEnd(SeparatorType value) {
        return new JAXBElement<SeparatorType>(_End_QNAME, SeparatorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "literal")
    public JAXBElement<String> createLiteral(String value) {
        return new JAXBElement<String>(_Literal_QNAME, String.class, null, value);
    }

}
