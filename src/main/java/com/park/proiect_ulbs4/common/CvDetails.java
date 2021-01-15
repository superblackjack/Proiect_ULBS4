package com.park.proiect_ulbs4.common;

import java.io.Serializable;

/**
 *
 * @author Sebi
 */
public class CvDetails implements Serializable {

    private Integer id;
    private String filename;
    private String fileType;
    private byte[] fileContent;

    public CvDetails(Integer id, String filename, String fileType, byte[] fileContent) {
        this.id = id;
        this.filename = filename;
        this.fileType = fileType;
        this.fileContent = fileContent;
    }

    public Integer getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getFileType() {
        return fileType;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

}
