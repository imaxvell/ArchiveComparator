package archivecomp.api;

import java.util.List;

/**
 *
 */
public interface ArchiveComparator {

    /**
     *
     * @return
     */
    ArchiveFilesInfo getDTO(/**/);

    List<String> getDeletedFiles(/**/);

    List<String> getNewFiles(/**/);

    List<String> getUpdatedFiles(/**/);

    List<String> getRenamedFiles(/**/);


}