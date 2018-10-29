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

        Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        editor.getSelectionModel().selectWordAtCaret(true);

        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();
        System.out.println("selected: " + selectedText);

        VirtualFile file = getFile(event, "middleware");

        try {
            String fileContents = VfsUtilCore.loadText(file);
            int index = fileContents.lastIndexOf(selectedText);

            Project project = ProjectManager.getInstance().getOpenProjects()[0];
            FileEditorManager fileEditor = FileEditorManager.getInstance(project);
            fileEditor.openFile(file, true);

            editor = fileEditor.getSelectedTextEditor();

            caretModel = editor.getCaretModel();
            caretModel.moveToOffset(index);

            editor.getScrollingModel().scrollToCaret(ScrollType.CENTER);
        } catch (Exception e) {

        }

    }
}
