package archivecomp;

/**
 * MaxveLL
 * 16.03.2017.
 */
public class ArchiveBackup {
    /*package archivecomp;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;

    public class ArchiveComparatorImpl {
        static List<String> deletedFilesNames = new ArrayList<>();
        static List<String> newFilesNames = new ArrayList<>();
        static List<String> updatedFilesNames = new ArrayList<>();
        static List<String> renamedFilesNames = new ArrayList<>();

   *//* public static void main(String[] args) {
        try (ZipInputStream zin1 = new ZipInputStream(new FileInputStream("D:\\zip1.zip"));
             ZipInputStream zin2 = new ZipInputStream(new FileInputStream("D:\\zip2.zip"))) {
            List<ZipEntry> firstZipEntries = new ArrayList<>();
            List<ZipEntry> secondZipEntries = new ArrayList<>();
            List<String> stringFileNamesZipOne = new ArrayList<>();
            List<String> stringFileNamesZipTwo = new ArrayList<>();

            ZipEntry entryOne;
            ZipEntry entryTwo;

            while ((entryOne = zin1.getNextEntry()) != null) {
                firstZipEntries.add(entryOne);
                stringFileNamesZipOne.add(entryOne.getName());
            }
            System.out.println(firstZipEntries);

            while ((entryTwo = zin2.getNextEntry()) != null) {
                secondZipEntries.add(entryTwo);
                stringFileNamesZipTwo.add(entryTwo.getName());
            }
            System.out.println(secondZipEntries);
            setUpdatedAndRenamedFiles(firstZipEntries, secondZipEntries);
            setDeletedFilesNames(stringFileNamesZipOne, stringFileNamesZipTwo);
            setNewFilesNames(stringFileNamesZipOne, stringFileNamesZipTwo);
            System.out.println("Deleted files: " + deletedFilesNames);
            System.out.println("New files: " + newFilesNames);
            System.out.println("Renamed files: " + renamedFilesNames);
            System.out.println("Updated files: " + updatedFilesNames);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }*//*

        private List<String> setNewFilesNames(List<String> firstZip, List<String> secondZip) {
            secondZip.removeAll(updatedFilesNames); //Removing names of updated and renamed files to
            secondZip.removeAll(renamedFilesNames); //distinguish them from new files
            secondZip.removeAll(firstZip);
            return newFilesNames.addAll(secondZip);
        }


        private static void setDeletedFilesNames(List<String> firstZip, List<String> secondZip) {
            firstZip.removeAll(renamedFilesNames); //Removing renamed files to distinguish them from deleted files
            firstZip.removeAll(secondZip);
            deletedFilesNames.addAll(firstZip);
        }

        private static void setUpdatedAndRenamedFiles(List<ZipEntry> firstZip, List<ZipEntry> secondZip) {
            for (ZipEntry entryOne : firstZip) {
                for (ZipEntry entryTwo : secondZip) {
                    if (isUpdatedFile(entryOne, entryTwo)) {
                        updatedFilesNames.add(entryOne.getName());
                    } else if (isRenamedFile(entryOne, entryTwo)) {
                        renamedFilesNames.add(entryOne.getName());
                        renamedFilesNames.add(entryTwo.getName());
                    }
                }
            }
        }

        private static boolean isUpdatedFile(ZipEntry entryOne, ZipEntry entryTwo) {
            return entryOne.getSize() != entryTwo.getSize() && entryOne.getName().equals(entryTwo.getName());
        }

        private static boolean isRenamedFile(ZipEntry entryOne, ZipEntry entryTwo) {
            return entryOne.getSize() == entryTwo.getSize() && !entryOne.getName().equals(entryTwo.getName());
        }
    }

*/
}
