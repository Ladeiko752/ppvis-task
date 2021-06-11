package base.requirement;

public interface WriterController {
    DocumentModel createDocument(String caption, String text);
    void refreshDocument(DocumentModel document, String caption, String text) throws Exception;
}
