package com.hillelcoren.redux_plugin;


import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.codeInsight.intention.PsiElementBaseIntentionAction;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReduxProjectAction extends PsiElementBaseIntentionAction implements IntentionAction {

    @NotNull
    public String getFamilyName() {
        return getText();
    }

    @NotNull
    public String getText() {
        return "Convert ternary operator to if statement";
    }

    public boolean isAvailable(@NotNull Project project, Editor editor, @Nullable PsiElement element) {

        // Quick sanity check
        if (element == null) return false;

        /*
        // Is this a token of type representing a "?" character?
        if (element instanceof PsiJavaToken) {
            final PsiJavaToken token = (PsiJavaToken) element;
            if (token.getTokenType() != JavaTokenType.QUEST) return false;
            // Is this token part of a fully formed conditional, i.e. a ternary?
            if (token.getParent() instanceof PsiConditionalExpression) {
                final PsiConditionalExpression conditionalExpression = (PsiConditionalExpression) token.getParent();
                if (conditionalExpression.getThenExpression() == null
                        || conditionalExpression.getElseExpression() == null) {
                    return false;
                }
                return true;    // Satisfies all criteria; call back invoke method
            }
            return false;
        }
        return false;
        */

        return true;
    }

    public void invoke(@NotNull Project project, Editor editor, PsiElement element) throws IncorrectOperationException {

        System.out.println("actionPerformed");

    }

    public boolean startInWriteAction() {return true;}


    /*
    @Override
    public void actionPerformed(AnActionEvent e) {

        System.out.println("actionPerformed");

        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();

        System.out.println("selected: " + selectedText);

    }
    */
}