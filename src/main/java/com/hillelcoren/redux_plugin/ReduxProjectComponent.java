package com.hillelcoren.redux_plugin;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.ContentIterator;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.indexing.FileBasedIndex;

import org.jetbrains.annotations.NotNull;

public class ReduxProjectComponent implements ProjectComponent {

    private static final String PROJECT_COMPONENT_NAME = "ReduxProjectComponent";


    @Override
    public void projectOpened() {

        System.out.println("projectOpened()...");
    }

    @Override
    public void projectClosed() {
    }

    @Override
    public void initComponent() {

        System.out.println("initComponent()...");
    }

    @Override
    public void disposeComponent() {}

    @NotNull
    @Override
    public String getComponentName() {
        return PROJECT_COMPONENT_NAME;
    }
}