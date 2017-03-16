package archivecomp.api;

import java.util.List;

public class ArchiveFilesInfo {

    private List<String> deletedFiles;
    private List<String> newFiles;
    private List<String> updatedFiles;
    private List<String> renamedFiles;

    public List<String> getDeletedFiles() {
        return deletedFiles;
    }

    public void setDeletedFiles(List<String> deletedFiles) {
        this.deletedFiles = deletedFiles;
    }

    public List<String> getNewFiles() {
        return newFiles;
    }

    public void setNewFiles(List<String> newFiles) {
        this.newFiles = newFiles;
    }

    public List<String> getUpdatedFiles() {
        return updatedFiles;
    }

    public void setUpdatedFiles(List<String> updatedFiles) {
        this.updatedFiles = updatedFiles;
    }

    public List<String> getRenamedFiles() {
        return renamedFiles;
    }

    public void setRenamedFiles(List<String> renamedFiles) {
        this.renamedFiles = renamedFiles;
    }
}