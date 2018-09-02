package actions;

import com.intellij.compiler.impl.generic.GenericCompilerCache;
import com.intellij.execution.ExecutionException;
import com.intellij.find.SearchInBackgroundOption;
import com.intellij.javaee.model.xml.persistence.Persistence;
import com.intellij.javaee.model.xml.persistence.PersistenceUnit;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.compiler.generic.DummyPersistentState;
import com.intellij.openapi.ide.CopyPasteManager;
import com.intellij.openapi.options.ConfigurableUi;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.persistence.roles.PersistenceClassRoleEnum;
import com.intellij.structuralsearch.plugin.ui.Configuration;
import com.intellij.util.Icons;
import com.intellij.util.PlatformIcons;
import com.sun.deploy.config.PluginServerConfig;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.beans.PersistenceDelegate;
import java.io.IOException;

public class TestAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project=e.getData(PlatformDataKeys.PROJECT);
        String title="标题";
        String msg = "2018, go";
        Messages.showMessageDialog(project,msg,title,Messages.getInformationIcon());
    }
}
