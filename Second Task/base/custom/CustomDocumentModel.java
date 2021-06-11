package base.custom;

import base.requirement.DocumentModel;

import java.time.LocalDate;
import java.util.Objects;

public class CustomDocumentModel implements DocumentModel {
    private String caption;
    private final LocalDate creationDate;
    private final String authorName;
    private String text;

    public CustomDocumentModel(String caption, LocalDate creationDate, String authorName, String text) {
        this.caption = caption;
        this.creationDate = creationDate;
        this.authorName = authorName;
        this.text = text;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        CustomDocumentModel document = (CustomDocumentModel) object;
        return Objects.equals(caption, document.caption)
                && Objects.equals(creationDate, document.creationDate)
                && Objects.equals(authorName, document.authorName)
                && Objects.equals(text, document.text);
    }

    @Override
    public String toString() {
        return "Document{ " +
                "caption='" + caption + '\'' +
                ", creationDate=" + creationDate +
                ", authorName='" + authorName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
