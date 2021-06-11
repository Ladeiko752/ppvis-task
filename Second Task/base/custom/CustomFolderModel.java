package base.custom;

import base.requirement.FolderModel;
import base.requirement.DocumentModel;

import java.util.ArrayList;
import java.util.List;

public class CustomFolderModel implements FolderModel {
    private final String name;
    private final List<DocumentModel> documentList;
    private final List<FolderModel> folderList;

    public CustomFolderModel(String name) {
        this.name = name;
        this.documentList = new ArrayList<>();
        this.folderList = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<DocumentModel> getDocumentList() {
        return documentList;
    }

    @Override
    public List<FolderModel> getFolderList() {
        return folderList;
    }
}
