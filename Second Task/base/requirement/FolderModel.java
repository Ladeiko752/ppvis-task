package base.requirement;

import java.util.List;

public interface FolderModel {
    String getName();
    List<DocumentModel> getDocumentList();
    List<FolderModel> getFolderList();
}
