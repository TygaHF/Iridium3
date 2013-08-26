/*
 * ReflectionHelper
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.lib.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides several utilities for managing files
 * @author marcusant
 * @version 1
 * @since 8/24/13 2:34 AM
 */
public class FileHelper {
    
    /**
     * Returns an array of files of the specified type in the specified
     * directory.
     * @param directory Target directory
     * @param filetype Target filetype
     * @return array of files of the specified type in the specified
     * directory
     */
    public static File[] getFilesOfTypeInDirectory(File directory, 
            String filetype) {
        List<File> fileList = new ArrayList<File>();
        
        for (String filename : directory.list()) {
            if (filename.toLowerCase().endsWith("." 
                    + filetype.trim().toLowerCase())) {
                fileList.add(new File(directory.getAbsolutePath() 
                        + File.separator + filename));
            }
        }
        
        return fileList.toArray(new File[fileList.size()]);
    }

}
