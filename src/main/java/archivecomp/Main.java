package archivecomp;

import archivecomp.api.ArchiveFilesInfo;
import archivecomp.impl.ArchiveComparatorImpl;

public class Main {


    public static void main(String[] args) throws Exception {

        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Specify paths for first and second zip respectively");
            } else if (args[0] == null || args[1] == null) {
                throw new IllegalArgumentException("One of the paths is empty, specify it");
            }



            ArchiveComparatorImpl archiveComparator = new ArchiveComparatorImpl(args[0], args[1]);
            ArchiveFilesInfo archiveFilesInfo = archiveComparator.archiveReader();
            Printer.print(archiveFilesInfo);


        } catch (Exception ex) {
            ex.getMessage();
        }




    }
}

