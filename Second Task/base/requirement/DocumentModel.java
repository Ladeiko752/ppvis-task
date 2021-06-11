package base.requirement;

import java.time.LocalDate;

public interface DocumentModel {
    String getCaption();
    LocalDate getCreationDate();
    String getAuthorName();
    String getText();
}
