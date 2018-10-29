package com.hillelcoren.redux_plugin;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ScrollType;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.ArrayList;

public class ReduxProjectMiddlewareAction extends ReduxProjectAction {

    @Override
    public void update(AnActionEvent event) {

        VirtualFile file = getFile(event, "middleware");

        event.getPresentation().setEnabledAndVisible(file != null);
    }

    @Override
    public void actionPerformed(AnActionEvent event) {

        handleAction(event, "middleware");

    }
}
