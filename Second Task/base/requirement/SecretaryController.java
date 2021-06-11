package base.requirement;

public interface SecretaryController {
    FolderModel getFolder();
    void assignFolder(FolderModel folder);
    boolean addDocument(DocumentModel document) throws Exception;
    DocumentModel defineDocumentByAuthorName(String authorName) throws Exception;
    DocumentModel defineDocumentByCaption(String caption) throws Exception;
}
