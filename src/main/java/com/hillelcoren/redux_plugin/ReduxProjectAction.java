package com.hillelcoren.redux_plugin;


import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;

public class ReduxProjectAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        System.out.println("actionPerformed");

        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();

        System.out.println("selected: " + selectedText);
        System.out.println("test: " + e.getPresentation().getText());

        /*
        DefaultActionGroup group = new DefaultActionGroup();
        //DefaultActionGroup newGroup = new DefaultActionGroup("_New", true);
        //newGroup.add(new ReduxProjectAction());
        //group.add(newGroup);
        group.addSeparator();
        group.add(new ReduxProjectAction());

        ActionManager.getInstance().createActionPopupMenu("", null);
        */

    }
}