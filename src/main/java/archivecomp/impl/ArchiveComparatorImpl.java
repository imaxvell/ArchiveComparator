package archivecomp.impl;

import archivecomp.api.ArchiveComparator;
import archivecomp.api.ArchiveFilesInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ArchiveComparatorImpl implements ArchiveComparator {
    private final String firstZipPath;
    private final String secondZipPath;

    private List<String> deletedFiles = new ArrayList<>();
    private final List<String> newFiles = new ArrayList<>();
    private final List<String> updatedFiles = new ArrayList<>();
    private final List<String> renamedFiles = new ArrayList<>();

    public ArchiveComparatorImpl(String firstZipPath, String secondZipPath) {
        this.firstZipPath = firstZipPath;
        this.secondZipPath = secondZipPath;
    }

    public ArchiveFilesInfo archiveReader() throws IOException {
        try (ZipInputStream zin1 = new ZipInputStream(new FileInputStream(firstZipPath));
             ZipInputStream zin2 = new ZipInputStream(new FileInputStream(secondZipPath))) {

            List<ZipEntry> firstZipEntries = new ArrayList<>();
            List<ZipEntry> secondZipEntries = new ArrayList<>();
            List<String> firstZipFiles = new ArrayList<>();
            List<String> secondZipFiles = new ArrayList<>();

            ZipEntry entryOne;
            ZipEntry entryTwo;

            while ((entryOne = zin1.getNextEntry()) != null) { //Reading files from first zip
                firstZipEntries.add(entryOne);
                firstZipFiles.add(entryOne.getName());
            }


            while ((entryTwo = zin2.getNextEntry()) != null) { //Reading files from second zip
                secondZipEntries.add(entryTwo);
                secondZipFiles.add(entryTwo.getName());
            }

            setUpdatedAndRenamedFiles(firstZipEntries, secondZipEntries); // Comparing files between zips
            setDeletedFilesNames(firstZipFiles, secondZipFiles);
            setNewFilesNames(firstZipFiles, secondZipFiles);

            ArchiveFilesInfo archiveFilesInfo = new ArchiveFilesInfo();
            archiveFilesInfo.setDeletedFiles(deletedFiles);
            archiveFilesInfo.setNewFiles(newFiles);
            archiveFilesInfo.setRenamedFiles(renamedFiles);
            archiveFilesInfo.setUpdatedFiles(updatedFiles);
            return archiveFilesInfo;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new IOException();
        }

    }

    private void setNewFilesNames(List<String> srcZip, List<String> dstZip) {
        dstZip.removeAll(updatedFiles); //Removing names of updated and renamed files to
        dstZip.removeAll(renamedFiles); //distinguish them from new files
        dstZip.removeAll(srcZip);
        newFiles.addAll(dstZip);
    }

    private void setDeletedFilesNames(List<String> srcZip, List<String> dstZip) {
        srcZip.removeAll(renamedFiles); //Removing renamed files to distinguish them from deleted files
        srcZip.removeAll(dstZip);
        deletedFiles.addAll(srcZip);
    }

    private void setUpdatedAndRenamedFiles(List<ZipEntry> srcZip, List<ZipEntry> dstZip) {
        for (ZipEntry entryOne : srcZip) { //Comparing entries in order to find which are updated and renamed
            for (ZipEntry entryTwo : dstZip) {
                if (isUpdatedFile(entryOne, entryTwo)) {
                    updatedFiles.add(entryOne.getName());
                } else if (isRenamedFile(entryOne, entryTwo)) {
                    renamedFiles.add(entryOne.getName());
                    renamedFiles.add(entryTwo.getName());
                }
            }
        }
    }

    private List<String> setUpdatedFiles() {

    }

    private static boolean isUpdatedFile(ZipEntry entryOne, ZipEntry entryTwo) {
        return entryOne.getSize() != entryTwo.getSize() && entryOne.getName().equals(entryTwo.getName());
    }

    private static boolean isRenamedFile(ZipEntry entryOne, ZipEntry entryTwo) {
        return entryOne.getSize() == entryTwo.getSize() && !entryOne.getName().equals(entryTwo.getName());
    }

    @Override
    public ArchiveFilesInfo getDTO() {
        return null;
    }

    @Override
    public List<String> getDeletedFiles() {
        return deletedFiles;
    }

    @Override
    public List<String> getNewFiles() {
        return newFiles;
    }

    @Override
    public List<String> getUpdatedFiles() {
        return updatedFiles;
    }

    @Override
    public List<String> getRenamedFiles() {
        return renamedFiles;
    }
}










