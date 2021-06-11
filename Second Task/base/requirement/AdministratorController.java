package base.requirement;

public interface AdministratorController {
    boolean deleteDocument(DocumentModel document) throws Exception;
    FolderModel createCatalog(String catalogName) throws Exception;
    void transportDocument(DocumentModel document, FolderModel targetCatalog) throws Exception;
}
