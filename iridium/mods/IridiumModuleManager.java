/*
 * IridiumModuleManager
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.mods;

import com.gmail.mstojcevich.iridium.Iridium;
import com.gmail.mstojcevich.iridium.events.other.EventKeypress;
import com.gmail.mstojcevich.lib.event.EventListener;
import com.gmail.mstojcevich.lib.event.HandleEvent;
import com.gmail.mstojcevich.lib.file.FileHelper;
import com.gmail.mstojcevich.lib.module.Module;
import com.gmail.mstojcevich.lib.module.ModuleManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Implementation of ModuleManager for IridiumModules
 * @author marcusant
 * @version 1
 * @since 8/24/13 12:14 AM
 */
public class IridiumModuleManager extends ModuleManager implements EventListener {
    
    /**
     * List of loaded modules
     */
    private List<IridiumModule> modules = new ArrayList<IridiumModule>();

    /**
     * List of enabled modules
     */
    public List<IridiumModule> enabledMods = new ArrayList<IridiumModule>();

    /**
     * Creates a new module manager using 
     * com.gmail.mstojcevich.iridium.mods.modules
     * as the module directory
     */
    public IridiumModuleManager() {
        this.loadModules();
        Iridium.instance.eventHandler.registerListener(this);
    }

    @HandleEvent
    public void pressKey(EventKeypress event) {
        int keyCode = event.getKeyCode();
        for (IridiumModule mod : this.modules) {
            if (keyCode == mod.getKeybind()) {
                mod.toggleMod();
            }
        }
    }
    
    /**
     * Loads modules from the default module
     * package
     */
    private void loadModules() {
        //load internals
        for (IridiumModule module : this.createIridiumModulesFromPackage
                ("com.gmail.mstojcevich.iridium.mods.modules")) {
            this.modules.add(module);
        }
        
        //load externals
        for (IridiumModule module : this.createIridiumModulesJars(
                new File("." + File.separator + "iridiumExtMods"))) {
            this.modules.add(module);
        }
        
    	System.out.println("Loaded Iridium modules");
    	System.out.println("-----------------------");
        for (IridiumModule module : this.getModules()) {
            System.out.println(module.getTitle());
        }
    	System.out.println("-----------------------");
    }

    /**
     * Creates IridiumModules for every valid module in the specified package
     * @param targetPackage Package to search for mods in
     * @return Array of created IridumModules
     */
    private IridiumModule[] createIridiumModulesFromPackage(String targetPackage) {
        List<IridiumModule> iridiumModules = new ArrayList<IridiumModule>();
        for (Module module : this.createModuleInstancesFromPackage(targetPackage)) {
            if(module instanceof IridiumModule) {
                iridiumModules.add((IridiumModule)module);
            }
        }
        return iridiumModules.toArray(new IridiumModule[iridiumModules.size()]);
    }
    
    /**
     * Creates Iridium modules from jars in a given directory
     * @param jarDirectory Directory that contains jar files
     * @return array of IridumModules
     */
    private IridiumModule[] createIridiumModulesJars(File jarDirectory) {
        if(!jarDirectory.exists())jarDirectory.mkdir();
        
        List<IridiumModule> moduleList = new ArrayList<IridiumModule>();
        
        File[] jars = FileHelper.getFilesOfTypeInDirectory(jarDirectory, "jar");
        for (File jarFile : jars) {
            for (Module module 
                    : this.createModuleInstancesFromPackageInJar(jarFile)) {
                if(module instanceof IridiumModule) {
                    moduleList.add((IridiumModule)module);
                }
            }
        }
        
        return moduleList.toArray(new IridiumModule[moduleList.size()]);
    }

    /**
     * Looks at the modpackage file in a jar to determine
     * what directory to look for Iridium modules in
     * @param jar Jar file in which to search
     * @return package directory separated by periods
     */
    private String getTargetPackageFromJar(File jar) {
        String defaultPackage = "";
        try {
            ZipFile jarZip = new ZipFile(jar);
            ZipEntry zipEntry = jarZip.getEntry("modpackage");
            if (zipEntry == null) {
                return defaultPackage;
            }
            InputStream inputStream = jarZip.getInputStream
                    (jarZip.getEntry("modpackage"));
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(inputStream));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if(currentLine.trim().length() > 0) {
                    return currentLine.trim();
                }
            }
            return defaultPackage;
        } catch (IOException e) {
            e.printStackTrace();
            return defaultPackage;
        }
    }

    @Override
    /**
     * Returns an array of the currently loaded modules
     */
    public IridiumModule[] getModules() {
        return this.modules.toArray(new IridiumModule[this.modules.size()]);
    }

}
