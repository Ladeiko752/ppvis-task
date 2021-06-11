package base.test;

import base.requirement.AdministratorController;
import base.requirement.FolderModel;
import base.requirement.SecretaryController;
import base.requirement.WriterController;
import base.custom.CustomAdministratorController;
import base.custom.CustomFolderModel;
import base.custom.CustomSecretaryController;
import base.custom.CustomWriterController;

public class Test {
    private FolderModel catalog;
    private SecretaryController secretaryController;
    private WriterController writerController;
    private AdministratorController administratorController;

    public void launch() {
        catalog = new CustomFolderModel("Футболл");
        writerController = new CustomWriterController("Антон");

        try {
            secretaryController = new CustomSecretaryController(catalog);
            administratorController = new CustomAdministratorController(secretaryController);

            addDocument();
            searchDocument();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void addDocument() {
        try {
            secretaryController
                    .addDocument(writerController.createDocument("Название", "Текст"));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        try {
            secretaryController
                    .addDocument(writerController.createDocument("Название", "Текст"));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("Документы:");
        catalog.getDocumentList().forEach(System.out::println);
    }

    private void searchDocument() {
        try {
            administratorController
                    .deleteDocument(secretaryController.defineDocumentByCaption("Название"));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        try {
            administratorController
                    .deleteDocument(secretaryController.defineDocumentByAuthorName("Автор"));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("Документы:");
        catalog.getDocumentList().forEach(System.out::println);
    }
}
