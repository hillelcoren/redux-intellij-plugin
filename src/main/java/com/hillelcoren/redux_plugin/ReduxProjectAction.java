package com.hillelcoren.redux_plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ScrollType;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.ContentIterator;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileAdapter;
import com.intellij.openapi.vfs.VirtualFileFilter;

import java.util.ArrayList;

abstract class ReduxProjectAction extends AnAction {


    protected VirtualFile getFile(AnActionEvent event, String type) {

        Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        editor.getSelectionModel().selectWordAtCaret(true);

        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();
        System.out.println("selected text: " + selectedText);

        Project project = ProjectManager.getInstance().getOpenProjects()[0];
        //FileEditorManager fileEditor = FileEditorManager.getInstance(project);

        VirtualFile rootFolder = project.getBaseDir();
        VirtualFile srcFolder = rootFolder.findChild("lib");

        VirtualFile[] selectedFiles = FileEditorManager.getInstance(project).getSelectedFiles();
        VirtualFile selectedFile = selectedFiles.length > 0 ? selectedFiles[0] : null;
        System.out.println("selected files: " + selectedFile.toString());

        ArrayList<VirtualFile> files = new ArrayList();

        VfsUtilCore.iterateChildrenRecursively(srcFolder, new VirtualFileFilter() {
            @Override
            public boolean accept(VirtualFile file) {
                if (selectedFile.equals(file)) {
                    return false;
                }

                if (file.getName().contains(type)) {
                    return true;
                }

                return file.isDirectory();
            }
        }, new ContentIterator() {
            @Override
            public boolean processFile(VirtualFile file) {
                if (! file.isDirectory()) {
                    //System.out.println("Process: " + file.toString());

                    try {
                        String fileContents = VfsUtilCore.loadText(file);
                        if (fileContents.contains(selectedText)) {
                            files.add(file);
                        }
                    } catch (Exception e) {

                    }
                }

                return true;
            }
        });

        return files.size() > 0 ? files.get(0) : null;
    }

    protected void handleAction(AnActionEvent event, String type) {
        Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        editor.getSelectionModel().selectWordAtCaret(true);

        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();
        System.out.println("selected: " + selectedText);

        VirtualFile file = getFile(event, type);

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