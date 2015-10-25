package bg.tusofia.tools;

import bg.tusofia.models.Dataset;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBUtilities {

    public static Dataset unmarshal(File file) {
        Dataset dataset;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Dataset.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            dataset = (Dataset) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            return null;
        }
        return dataset;
    }

    public static boolean marshall(String fileName, Dataset dataset) {
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(Dataset.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(dataset, file);
        } catch (JAXBException e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
