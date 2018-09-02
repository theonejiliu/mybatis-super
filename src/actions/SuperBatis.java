package actions;

import com.intellij.ide.IconUtilEx;
import com.intellij.openapi.application.ApplicationInfo;
import com.intellij.openapi.application.ex.ApplicationInfoEx;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.openapi.wm.impl.ToolWindowHeadlessManagerImpl;
import com.intellij.psi.impl.cache.TodoCacheManager;
import com.intellij.psi.search.TodoAttributesUtil;
import com.intellij.remoteServer.impl.runtime.ui.DefaultRemoteServersViewContribution;
import com.intellij.remoteServer.impl.runtime.ui.RemoteServersViewContribution;
import com.intellij.remoteServer.impl.runtime.ui.ServersToolWindowContent;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.sun.java.accessibility.util.AWTEventMonitor;
import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRefContext;
import org.jdesktop.swingx.border.IconBorder;
import org.jetbrains.annotations.NotNull;
import panels.SuperPanel;

import javax.smartcardio.TerminalFactory;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

public class SuperBatis implements ToolWindowFactory {
    private SuperPanel superPanel;

    public SuperBatis() {
        Font font = new Font("Microsoft YaHei UI", Font.PLAIN, 15);
        superPanel=new SuperPanel();

    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        ServersToolWindowContent serversContent = new ServersToolWindowContent(project, new DefaultRemoteServersViewContribution(), ServersToolWindowContent.ActionGroups.SHARED_ACTION_GROUPS);
        JPanel panel = serversContent.getMainPanel();

        panel.add(superPanel);
        Content content = contentFactory.createContent(panel, (String) null, true);
        Disposer.register(content, serversContent);
        toolWindow.getContentManager().addContent(content);
        toolWindow.setIcon(TodoAttributesUtil.createDefault().getIcon());

    }
}
