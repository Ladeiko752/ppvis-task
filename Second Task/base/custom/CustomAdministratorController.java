package base.custom;

import base.requirement.AdministratorController;
import base.requirement.FolderModel;
import base.requirement.DocumentModel;
import base.requirement.SecretaryController;

public class CustomAdministratorController implements AdministratorController {
    private final FolderModel folder;
    private final SecretaryController secretaryController;

    public CustomAdministratorController(SecretaryController secretaryController) {
        this.secretaryController = secretaryController;
        this.folder = secretaryController.getFolder();
    }

    @Override
    public synchronized boolean deleteDocument(DocumentModel document) throws Exception {
        if (document == null) {
            throw new Exception("Документ не задан");
        }

        return folder.getDocumentList().remove(document);
    }

    @Override
    public synchronized FolderModel createCatalog(String catalogName) throws Exception {
        if (catalogName == null || catalogName.isEmpty()) {
            throw new Exception("Недопустимое имя каталога");
        }

        return new CustomFolderModel(catalogName);
    }

    @Override
    public synchronized void transportDocument(DocumentModel document, FolderModel targetFolder) throws Exception {
        if (targetFolder == null) {
            throw new Exception("Недопустимое перемещения документа");
        }

        deleteDocument(document);
        secretaryController.assignFolder(targetFolder);
        secretaryController.addDocument(document);
        secretaryController.assignFolder(folder);
    }
}
