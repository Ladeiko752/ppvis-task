package base.custom;

import base.requirement.FolderModel;
import base.requirement.DocumentModel;
import base.requirement.SecretaryController;

import java.util.List;
import java.util.function.Predicate;

public class CustomSecretaryController implements SecretaryController {
    private FolderModel folder;

    public CustomSecretaryController(FolderModel folder) throws Exception {
        if (folder == null) {
            throw new Exception("Не задан каталог");
        }
        this.folder = folder;
    }

    @Override
    public FolderModel getFolder() {
        return folder;
    }

    @Override
    public void assignFolder(FolderModel folder) {
        this.folder = folder;
    }

    @Override
    public synchronized boolean addDocument(DocumentModel document) throws Exception {
        if (document == null) {
            throw new Exception("Не задан документ");
        }

        List<DocumentModel> list = folder.getDocumentList();
        if (list.contains(document)) {
            throw new Exception("Документ не существует");
        }

        return list.add(document);
    }

    @Override
    public synchronized DocumentModel defineDocumentByAuthorName(String authorName) throws Exception {
        return defineDocument((some) -> some.getAuthorName().equals(authorName));
    }

    @Override
    public synchronized DocumentModel defineDocumentByCaption(String caption) throws Exception {
        return defineDocument((some) -> some.getCaption().equals(caption));
    }

    private DocumentModel defineDocument(Predicate<DocumentModel> predicate) throws Exception {
        List<DocumentModel> list = folder.getDocumentList();
        list.removeIf(predicate.negate());

        if (list.size() == 0) {
            throw new Exception("Документ не существует");
        }
        else {
            return list.get(0);
        }
    }
}
