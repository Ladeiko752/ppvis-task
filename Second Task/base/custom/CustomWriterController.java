package base.custom;

import base.requirement.DocumentModel;
import base.requirement.WriterController;

import java.time.LocalDate;

public class CustomWriterController implements WriterController {
    private final String authorName;

    public CustomWriterController(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public synchronized DocumentModel createDocument(String caption, String text) {
        return new CustomDocumentModel(caption, LocalDate.now(), authorName, text);
    }

    @Override
    public synchronized void refreshDocument(DocumentModel document, String caption, String text) throws Exception {
        if (document == null) {
            throw new Exception("Не задан документ");
        }

        CustomDocumentModel doc = (CustomDocumentModel) document;
        doc.setCaption(caption);
        doc.setText(text);
    }
}
