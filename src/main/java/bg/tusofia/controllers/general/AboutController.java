package bg.tusofia.controllers.general;

import bg.tusofia.controllers.AbstractController;
import bg.tusofia.controllers.WizardController;
import bg.tusofia.models.Dataset;
import bg.tusofia.models.General;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AboutController extends AbstractController {

    public TableView<DomainColumn> domains;
    public TextField addDomainTF;
    public Button addButton;
    public Button deleteButton;
    public TextArea keywords;
    public TextArea annotation;

    @Override
    public void updateParent() {
        General.About data = (General.About) getData();
        data.getDomain().clear();
        data.getDomain().addAll(getDomainsAsList());
        data.setKeywords(getKeywords());
        data.setAnnotation(annotation.getText());

        WizardController controller = (WizardController) getMainController();
        ((Dataset) controller.getData()).getGeneral().setAbout(data);
        controller.initialize();
    }

    @Override
    protected boolean validate() {
        return getDomainsAsList().size() > 0 && !keywords.getText().isEmpty() && !annotation.getText().isEmpty();
    }

    @Override
    protected String errorMessage() {
        String message;
        if (getDomainsAsList().size() == 0) {
            message = "Domains can't be empty";
        } else if (keywords.getText().isEmpty()) {
            message = "Keywords can't be empty";
        } else if (annotation.getText().isEmpty()) {
            message = "Annotation can't be empty";
        } else { // default message
            message = "Error";
        }
        return message;
    }

    @Override
    public void initialize() {
        //domains
        TableColumn<DomainColumn, String> domainColumn = new TableColumn<>("Domains");
        domainColumn.setCellValueFactory(new PropertyValueFactory<>("domain"));
        domains.setItems(getDomain());
        domains.getColumns().add(domainColumn);
        domains.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //...hide table header
        domains.widthProperty().addListener((ov, t, t1) -> {
            Pane header = (Pane) domains.lookup("TableHeaderRow");
            if (header != null && header.isVisible()) {
                header.setMaxHeight(0);
                header.setMinHeight(0);
                header.setPrefHeight(0);
                header.setVisible(false);
                header.setManaged(false);
            }
        });

        //keywords
        General.About about = (General.About) getData();
        if (about.getKeywords() != null) {
            keywords.setText(concatStringsWSep(about.getKeywords().getKeyword(), ", "));
        }
        //annotations
        if (about.getKeywords() != null) {
            annotation.setText(about.getAnnotation());
        }
    }

    private static String concatStringsWSep(Iterable<String> strings, String separator) {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (String s : strings) {
            sb.append(sep).append(s);
            sep = separator;
        }
        return sb.toString();
    }

    //Add button clicked

    public void addButtonClicked() {
        DomainColumn domain = new DomainColumn();
        domain.setDomain(addDomainTF.getText());
        if (!addDomainTF.getText().isEmpty()) {
            domains.getItems().add(domain);
        }
        addDomainTF.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked() {
        deleteTableRow(domains);
    }

    public ObservableList<DomainColumn> getDomain() {
        ObservableList<DomainColumn> domains = FXCollections.observableArrayList();

        General.About about = (General.About) getData();
        if (about.getDomain() != null) {
            for (String domain : about.getDomain()) {
                DomainColumn tempDomain = new DomainColumn();
                tempDomain.setDomain(domain);
                domains.add(tempDomain);
            }
        }
        return domains;
    }

    //Utility methods starts here
    private List<String> getDomainsAsList() {
        return domains.getItems().stream().map(DomainColumn::getDomain).collect(Collectors.toList());
    }

    private General.About.Keywords getKeywords() {
        General.About.Keywords keywords = new General.About.Keywords();
        keywords.getKeyword().addAll(Arrays.asList(this.keywords.getText().split("\\s*,\\s*")));
        return keywords;
    }

    public class DomainColumn {
        String domain;

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }
    }
}
